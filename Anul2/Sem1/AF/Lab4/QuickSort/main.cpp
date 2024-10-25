#include <iostream>

void showArr (int a[], int n) {
    for(int i = 0;i < n; i++) {
        std::cout << a[i] << " ";
    }
    std::cout << std::endl;
}

void swap (int *a, int *b) {
    int aux = *a;
    *a = *b;
    *b = aux;
}

int partition (int a[], int left, int right, int pivot) {
    swap (&a[right], &a[pivot]);
    int j = left - 1;
    for(int i = left; i <= right; i++) {
        if(a[i] <= a[right]) {
            j++;
            swap(&a[i], &a[j]);
        }
    }

    return j;
}


void quickSort (int a[], int left, int right) {
    if(right <= left) {
        return;
    }
    int k = partition(a, left, right, right);

    quickSort(a, left, k - 1);
    quickSort(a, k + 1, right);
}

void demo () {
    int a[] = {7,12,3,19,5,14,1,8,17,10};
    int n = sizeof(a) / sizeof (int);

    std::cout << "unsorted array" << std::endl;
    showArr(a, n);

    quickSort(a, 0, n - 1);

    std::cout << "sorted array" << std::endl;
    showArr(a, n);
}


int main() {
    demo();
    return 0;
}
