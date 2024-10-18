#include <iostream>

void swap(int *a, int *b) {
    int aux = *b;
    *b = *a;
    *a = aux;
}


void swim (int a[], int n, int index) {
    while(index > 1 && a[index] < a[index/2]) {
        swap(&a[index], &a[index/2]);
        index /= 2;
    }
}

void makeHeapSw(int a[], int n) {
    for(int i = 2;i <= n; i++) {
        swim(a, n, i);
    }
}

void sink (int a[], int n, int index) {
    int childIndex = 2 * index;
    while(2 * index < n) {

        if(a[childIndex] > a[childIndex + 1]) {
            childIndex = childIndex + 1;
        }
        if(a[childIndex] < a[index]) {
            swap(&a[index], &a[childIndex]);
            index = childIndex;
        }
        else
            break;
    }
}

void buildHeap(int a[], int n) {
    for(int i = n / 2;i >= 1; i++) {
        swim(a, n, i);
    }
}

void heapSort(int a[], int n) {
    while(n > 1) {
        std::cout << a[1] << " ";
        swap(&a[1], &a[n]);
        n--;
        sink(a, n, 1);
    }
    std::cout << a[1] << " ";
}

void demo() {
    int a[] = {6, 2, 4, 2, 1};
    int n = sizeof(a) / sizeof(int);
    buildHeap(a, n);
    for(int i = 0;i < n; i++) {
        std::cout << a[i] << " ";
    }
    std::cout << std::endl;
}


int main() {
    ///demo
    demo();
    return 0;
}
