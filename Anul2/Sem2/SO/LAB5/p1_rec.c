#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <dirent.h>
#include <sys/stat.h>
#include <unistd.h>

int listRec(const char *path)
{
    DIR *dir = NULL;
    struct dirent *entry = NULL;
    char fullPath[512];
    struct stat statbuf;
    int size = 0;

    dir = opendir(path);
    if(dir == NULL) {
        perror("Could not open directory");
        return -1;
    }
    while((entry = readdir(dir)) != NULL) {
        if(strcmp(entry->d_name, ".") != 0 && strcmp(entry->d_name, "..") != 0) {
            snprintf(fullPath, 512, "%s/%s", path, entry->d_name);
            if(lstat(fullPath, &statbuf) == 0) {
                printf("%s\n", fullPath);
                if(S_ISDIR(statbuf.st_mode)) {
                    size = size + listRec(fullPath);
                }
                else {
                    size += statbuf.st_size;
                }
            }
        }
    }
    closedir(dir);
    return size;
}

int main(int argc, char **argv)
{
    if(argc != 2) {
        fprintf(stderr, "Usage: %s <dir_name>\n", argv[0]);
        return 1;
    }
    printf("%d", listRec(argv[1]));
    return 0;
}
