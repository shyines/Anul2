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

    quickSort(a, 0, n - 1);

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
        showArr(h->arr, n);
    }
}

int main() {
    demoQuickSort();
    return 0;
}
