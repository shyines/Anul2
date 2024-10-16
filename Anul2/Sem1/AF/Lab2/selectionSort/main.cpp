#include <iostream>
#include "Profiler.h"




Profiler profiler;

void swap(int *a, int *b) {
    int aux = *a;
    *a = *b;
    *b = aux;
}

void showArr(int a[], int n) {
    for(int i = 0;i < n; i++) {
        std::cout << a[i] << " ";
    }
    std::cout << std::endl;
}

int selectionSort(int a[], int n) {
    Operation compSelectionSort = profiler.createOperation("compSelectionSort", n);
    Operation asgSelectionSort = profiler.createOperation("asgSelectionSort", n);
    for(int i = 0;i < n - 1; i++) {
        int aux = i;
        for(int j = i + 1;j < n; j++) {
            compSelectionSort.count();
            if(a[j] < a[aux]) {
                aux = j;
            }
        }
        if(aux != i) {
            asgSelectionSort.count(3);
            swap(&a[i], &a[aux]);
        }
    }

    return 0;
}

int bubbleSort(int a[], int n) {
    Operation compBubbleSort = profiler.createOperation("compBubbleSort", n);
    Operation asgBubbleSort = profiler.createOperation("asgBubbleSort", n);
    bool sorted = false;
    int i = 0;
    do {
        sorted = true;
        for(int j = 0;j < n - i - 1; j++) {
            compBubbleSort.count();
            if(a[j] > a[j + 1]) {
                asgBubbleSort.count(3);
                swap(&a[j], &a[j + 1]);
                sorted = false;
            }
        }
        i++;
    }while (!sorted);

    return 0;
}

int insertionSort(int a[], int n) {
    Operation compInsertionSort = profiler.createOperation("compInsertionSort", n);
    Operation asgInsertionSort = profiler.createOperation("asgInsertionSort", n);
    int j = 0;
    for(int i = 1;i < n; i++) {
        int aux = a[i];
        j = i - 1;
        compInsertionSort.count();
        while(j >= 0 && a[j] > aux) {
            asgInsertionSort.count();
            a[j + 1] = a[j];
            j--;
        }
        asgInsertionSort.count();
        a[j + 1] = aux;
    }

    return 0;
}




void demo() {
    int arr1[] = {5, 1, 4, 20, 16};
    int n1 = sizeof(arr1) / sizeof(int);

    int arr2[] = {5, 1, 4, 20, 16};
    int n2 = sizeof(arr2) / sizeof(int);

    int arr3[] = {5, 1, 4, 20, 16};
    int n3 = sizeof(arr3) / sizeof(int);

    std::cout <<"Bubble Sort Algorithm on the arr: ";
    showArr(arr1, n1);
    bubbleSort(arr1, n1);
    showArr(arr1, n1);

    std::cout <<"Selection sort algorithm on the arr: ";
    showArr(arr2, n2);
    selectionSort(arr2, n2);
    showArr(arr2, n2);

    std::cout <<"Insertion Sort Algorithm on the arr: ";
    showArr(arr3, n3);
    insertionSort(arr3, n3);
    showArr(arr3, n3);
}



void sortingAlgortihm (int (*sort[])(int arr[], int n), int sorted) {
    int src[10000];
    int dest[10000];

    for(int i = 0 ;i < 5; i++) {
        for(int j = 100;j <= 10000; j += 100) {
            FillRandomArray(src, j, 10, 50000, false, sorted);
            for(int k = 0;k < 3; k++) {
                CopyArray(dest, src, j);
                sort[k](dest, j);
            }
        }
    }

    profiler.divideValues("compSelectionSort", 5);
    profiler.divideValues("asgSelectionSort", 5);

    profiler.divideValues("compInsertionSort", 5);
    profiler.divideValues("asgInsertionSort", 5);

    profiler.divideValues("compBubbleSort", 5);
    profiler.divideValues("asgBubbleSort", 5);
    profiler.createGroup("BubbleSort", "compBubbleSort", "asgBubbleSort");
}

void perf_all (int (*sort[])(int arr[], int n)) {
    sortingAlgortihm(sort, UNSORTED);
    profiler.reset("Best Case");
    sortingAlgortihm(sort, ASCENDING);
    profiler.reset("Worst Case");
    sortingAlgortihm(sort, DESCENDING);

    profiler.showReport();
}

int main() {
    int (*fArr[3])(int arr[], int n) {
        insertionSort, selectionSort, bubbleSort
    };

    std::cout << "Demos direct sorting methods: " << std::endl;
    std::cout << std::endl;
    demo();
    perf_all(fArr);
    return 0;
}
