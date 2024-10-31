#include <iostream>
#include "Profiler.h"

Profiler p;

typedef struct _heap {
    int arr[10000];
    int size;
}Heap;

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


int partition (int a[], int left, int right, int pivot, Operation* asg, Operation* cmp) {
    swap (&a[right], &a[pivot]);
    asg->count(3);
    int j = left - 1;
    for(int i = left; i <= right; i++) {
        cmp->count();
        cmp->count();
        if(a[i] <= a[right]) {
            j++;
            swap(&a[i], &a[j]);
            asg->count(3);
        }
    }

    return j;
}


void quickSort (int a[], int left, int right, Operation *asg, Operation *cmp) {
    if(right <= left) {
        return;
    }
    cmp->count();
    asg->count();
    int k = partition(a, left, right, right, asg, cmp);

    quickSort(a, left, k - 1, asg, cmp);
    quickSort(a, k + 1, right, asg, cmp);
}

int getRight(int index) {
    return (2 * index) + 1;
}

int getLeft (int index) {
    return 2 * index;
}

int getParent(int index) {
    return (index - 1) / 2;
}


void maxHeapify(Heap *h, int index, Operation *asg, Operation *comp) {
    int largest = 0;
    int l = getLeft(index);
    int r = getRight(index);

    if(l <= h->size && h->arr[l] > h->arr[index]) {
        largest = l;
        asg->count();
    }
    else {
        largest = index;
        asg->count();
    }
    if(r <= h->size && h->arr[r] > h->arr[largest]) {
        largest = r;
        asg->count();
    }
    comp->count(3);

    if(largest != index) {
        asg->count(3);
        swap(&h->arr[index], &h->arr[largest]);
        maxHeapify(h, largest, asg, comp);
    }
}



void buildHeapBottomUp(Heap *h, Operation *asg, Operation *cmp) {
    for(int i = h->size / 2; i >= 0; i--) {
        maxHeapify(h, i, asg, cmp);
    }
}

void demoQuickSort () {
    int a[] = {7,12,3,19,5,14,1,8,17,10};
    int n = sizeof(a) / sizeof (int);

    std::cout << "unsorted array" << std::endl;
    showArr(a, n);

    Operation asg = p.createOperation("asgDemo1", n);
    Operation cmp = p.createOperation("cmpDemo1", n);

    quickSort(a, 0, n - 1, &asg, &cmp);

    std::cout << "sorted array" << std::endl;
    showArr(a, n);
}

void heapSortMax(Heap *h) {
    Operation heapSortAsg = p.createOperation("heapSortAsg", h->size);
    Operation heapSortCmp = p.createOperation("heapSortCmp", h->size);
    int n = h->size;
    h->size--;
    buildHeapBottomUp(h, &heapSortAsg, &heapSortCmp);
    for(int i = n - 1;i >= 1; i--) {
        heapSortAsg.count(3);
        swap(&h->arr[0], &h->arr[i]);
        h->size--;
        maxHeapify(h, 0, &heapSortAsg, &heapSortCmp);
    }
}

void demoHeapSort() {
    Heap h;
    int arr[] = {4, 1, 3, 2, 16, 9, 10, 14, 8 ,7};
    int n = sizeof(arr) / sizeof(int);

    std::cout << "unsorted array" << std::endl;
    showArr(arr, n);

    CopyArray(h.arr, arr, n);
    h.size = n;
    heapSortMax(&h);
    h.size = n;

    std::cout << "sorted array" << std::endl;
    showArr(h.arr, h.size);
}

void quickSortPerfect(int sorted) {
    int arr[10000];

    for(int i = 0;i < 5; i++) {
        for(int j = 1000;j <= 10000; j += 100) {
            Operation quickSortAsg = p.createOperation("quickSortAsg", j);
            Operation quickSortCmp = p.createOperation("quickSortCmp", j);
            FillRandomArray(arr, j, 10, 50000, false, sorted);
            quickSort(arr, 0, j - 1, &quickSortAsg, &quickSortCmp);
        }
    }
    p.divideValues("quickSortAsg", 5);
    p.divideValues("quickSortCmp", 5);

}

void quickSortVsHeapSort(int sorted) {
    int arr[10000];
    Heap h;

    for(int i = 0;i < 5; i++) {
        for(int j = 1000;j <= 10000; j += 100) {
            Operation quickSortAsg = p.createOperation("quickSortAsg", j);
            Operation quickSortCmp = p.createOperation("quickSortCmp", j);
            FillRandomArray(arr, j, 10, 50000, false, sorted);
            CopyArray(h.arr, arr, j);
            h.size = j;
            quickSort(arr, 0, j - 1, &quickSortAsg, &quickSortCmp);
            heapSortMax(&h);
        }
    }
    p.divideValues("quickSortAsg", 5);
    p.divideValues("quickSortCmp", 5);
    p.addSeries("QuickSort", "quickSortAsg", "quickSortCmp");
    p.divideValues("heapSortAsg", 5);
    p.divideValues("heapSortCmp", 5);
    p.addSeries("HeapSort", "heapSortAsg", "heapSortCmp");

    p.createGroup("Comparation", "QuickSort", "HeapSort");

}

int insertionSort(int a[], int left, int right, Operation *asg, Operation *cmp) {
    int j = 0;
    for(int i = left;i <= right; i++) {
        int aux = a[i];
        j = i - 1;
        cmp->count();
        while(j >= left && a[j] > aux) {
            asg->count();
            a[j + 1] = a[j];
            j--;
            asg->count();
        }
        asg->count();
        a[j + 1] = aux;
    }

    return 0;
}

void hybridQuickSort(int a[], int left, int right, Operation *asg, Operation *cmp, int threshHold) {
    while (left < right){
        cmp->count();
        cmp->count();
        if (right - left + 1 < threshHold){
            insertionSort(a, left, right, asg, cmp);
            break;
        }
        else{
            asg->count();
            int pivot = partition(a, left, right, right, asg, cmp);
            cmp->count();
            if (pivot - left < right - pivot)
            {
                hybridQuickSort(a, left, pivot - 1, asg, cmp, threshHold);
                left = pivot + 1;
            }
            else{
                hybridQuickSort(a, pivot + 1, right, asg, cmp, threshHold);
                right = pivot - 1;
            }
        }
    }
}


void demoQuickSortHybrid () {
    int a[] = {7,12,3,19,5,14,1,8,17,10};
    int n = sizeof(a) / sizeof (int);

    Operation asg = p.createOperation("asgDemo", n);
    Operation cmp = p.createOperation("cmpDemo", n);

    std::cout << "unsorted array" << std::endl;
    showArr(a, n);

    hybridQuickSort(a, 0, n - 1, &asg, &cmp, 8);

    std::cout << "sorted array" << std::endl;
    showArr(a, n);
}

void perf2() {
    quickSortPerfect(UNSORTED);
    p.reset("QuickSort worst case");
    quickSortPerfect(ASCENDING);
    p.reset("QuickSort vs HeapSort");
}

void perf3() {
    quickSortVsHeapSort(UNSORTED);
    p.reset("Finding ThreshHold for Hybridized QuickSort");
}



void perfAll() {
    perf2();
    perf3();

    p.showReport();
}

int main() {
    demoQuickSort();
    demoHeapSort();
    demoQuickSortHybrid();

    p.reset("Graphs");
    perfAll();
    return 0;
}
