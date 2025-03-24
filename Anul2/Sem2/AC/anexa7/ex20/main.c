#include <stdio.h>
#include <stdlib.h>
#include <limits.h>


/**
Să se determine cea mai mică valoare pozitivă dintr-un șir de N elemente, care
începe în memorie de la adresa 8. N se citește din memorie de la adresa 4.
Rezultatul se va scrie în memorie la adresa 0.
 */

int main(void) {
    int *a;
    int n;
    int min = INT_MAX;
    scanf("%d", &n);
    a = malloc(n * sizeof(int));

    for (int i = 0;i < n; i++) {
        scanf("%d", &a[i]);
    }

    for (int i = 0;i < n; i++) {
        if (a[i] > 0 && a[i] < min) {
            min = a[i];
        }
    }

    free(a);

    printf("%d", min);
    return 0;
}
