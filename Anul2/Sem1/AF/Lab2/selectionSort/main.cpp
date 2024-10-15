#include <iostream>
#include "Profiler.h"

Profiler profiler;

void swap(int *a, int *b) {
    int aux = *a;
    *a = *b;
    *b = aux;
}


void selectionSort(int a[], int n) {
    Operation compSelectionSort = profiler.createOperation("compSelectionSort", n);
    Operation asgSel = profiler.createOperation("asgSel", n);
    for(int i = 0;i < n; i++) {
        int aux = i;
        for(int j = i + 1;j < n; j++) {
            compSelectionSort.count();
            if(a[j] < a[i]) {
                aux = j;
            }
        }
        if(aux != i) {
            asgSel.count(3);
            swap(&a[i], &a[aux]);
        }
    }
}

void bubbleSort(int a[], int n) {
    Operation compBubbleSort = profiler.createOperation("compBubbleSort", n);
    Operation asgBubbleSort = profiler.createOperation("asgBubbleSort", n);
    bool sorted = false;
    int i = 0;
    do {
        sorted = true;
        for(int j = 0;j < n - i; j++) {
            compBubbleSort.count();
            if(a[j] > a[j + 1]) {
                asgBubbleSort.count(3);
                swap(&a[j], &a[j + 1]);
                sorted = false;
            }
        }
        i++;
    }while (!sorted);
}

void insertionSort(int a[], int n) {
    int j = 0;
    for(int i = 1;i < n; i++) {
        int aux = a[i];
        for(j = i - 1;j >= 0; j--) {
            if(a[i] > a[j]) {
                break;
            }
            a[j + 1] = a[j];
        }
        a[j] = aux;
    }
}


void showArr(int a[], int n) {
    for(int i = 0;i < n; i++) {
        std::cout << a[i] << " ";
    }
    std::cout << std::endl;
}
int main() {
    /*
    int arr[10000];
    int brr[10000];
    int crr[10000];
    for(int j = 0;j < 5; j++) {
        for (int i = 100; i < 10000; i += 100) {
            FillRandomArray(arr, 10000, -50000, 50000);
            selectionSort(arr, i);
        }
    }
    profiler.divideValues("compSelectionSort", 5);
    profiler.divideValues("asgSel", 5);
    profiler.addSeries("selectionSort", "compSelectionSort", "asgSel");
    profiler.showReport();
     */
    int arr[5];
    FillRandomArray(arr, 5, 10, 24);
    int n = sizeof(arr) / sizeof(int);
    insertionSort(arr, n);
    showArr(arr, n);
    return 0;
}
