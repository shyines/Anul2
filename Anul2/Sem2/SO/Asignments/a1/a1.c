#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

typedef struct {
    char sect_name [11];
    char sect_type;
    int sect_offset;
    int sec_size;
}Section_Header;

int parse_header(int fd, Section_Header *section_headers, int *version, int *no_of_sections, char* error_message) {
    char buff[20];
    int header_size= 0 ;
    //magic field
    read(fd, &buff, 1);
    if (buff[0] != 'w') {
        strcpy(error_message, "ERROR \n wrong magic");
        return -1;
    }
    //header size field
    read(fd, &buff, 2);
    sscanf(buff, "%d", &header_size);

    //version
    read(fd, &buff, 1);
    sscanf(buff, "%d", version);
    if (!(*version >= 94 && *version <= 209)) {
        strcpy(error_message, "ERROR \n wrong version");
        return -1;
    }

    //no_of_sections
    read(fd, &buff, 1);
    sscanf(buff, "%d", no_of_sections);

    section_headers = malloc(*no_of_sections * sizeof(Section_Header));
    if (section_headers == NULL) {
        return -2;
    }

    if (!(*no_of_sections == 2 || (*no_of_sections >= 4 && *no_of_sections <= 17))) {
        free(section_headers);
        strcpy(error_message, "wrong sect_nr");
        return -1;
    }

    for (int i = 0;i < *no_of_sections;i++) {
        read(fd, &buff, 11);
        sscanf(section_headers[i].sect_name, "%s", section_headers[i].sect_name);

        read(fd, &buff, 1);
        sscanf(buff, "%c", &section_headers[i].sect_type);

        if (!(section_headers[i].sect_type <= 46 && section_headers[i].sect_type >= 31)) {
            free(section_headers);
            strcpy(error_message, "wrong sect_types");
            return -1;
        }

        read(fd, &buff, 4);
        sscanf(buff, "%d", &section_headers[i].sect_offset);

        read(fd, &buff, 4);
        sscanf(buff, "%d", &section_headers[i].sec_size);
    }

    return 0;
}

void parse(int argc, char **argv) {
    char file_path[500];//Enough memory for file path
    int fd = 0;
    Section_Header *section_header = NULL;
    int version = 0;
    int no_of_sections = 0;
    char *error_message = NULL;

    for (int j = 0;j < argc; j++) {
        char *source_file = strstr(argv[j], "path=");
        if (source_file != NULL) {
            source_file = source_file + strlen("path="); // I find the first occurence of path, then I jump straight after "=" where the file path should be
            strcpy(file_path, source_file);
            fd = open(file_path, O_RDONLY);
            if (fd == -1) {
                puts("ERROR"
                "invalid directory path");
                return;
            }
            int res = parse_header(fd, section_header, &version, &no_of_sections, error_message);
            if (res == -2) {
                printf("malloc error");
            } else if (res == -1) {
                printf("%s", error_message);
            } else {
                printf("SUCCESS\n version=%d\nnr_sections=%d\n", version, no_of_sections);
                for (int i = 0;i < no_of_sections; i++) {
                    printf("section%d: %s %c %d", i, section_header[i].sect_name, section_header[i].sect_type, section_header[i].sect_offset);
                }
                free(section_header);
            }
        }
    }
}


int main(int argc, char **argv) {
    if (argc >= 2) {
        for (int i = 0;i < argc; i++) {
            if (strcmp(argv[i], "parse") == 0) {
                parse(argc, argv);
                break;
            }
            if (strcmp(argv[i], "list") == 0) {
                puts("list option");
                break;
            }  if (strcmp(argv[i], "variant") == 0) {
                puts("39401");
                break;
            }
        }
    }
    return 0;
}