#include <stdio.h>
#include <stdlib.h>


int main() {
    int n = 0;
    long long x = 0;
    long long y = 0;

    FILE *pf = fopen("level1_1.in", "r");
    FILE
    if(pf == NULL) {
        printf("file not found");
        return -1;
    }

    fscanf(pf, "%d", &n);
    for(int i = 0;i < n; i++) {
        fscanf(pf, "%d %d", &x, &y);
        fprintf
    }
    return 0;
}
