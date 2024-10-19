#include <iostream>
///All that is here is Min Heap
#include "Profiler.h"
Profiler p;


typedef struct _heap {
    int arr[10000];
    int size;
}Heap;

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

void buildMinHeap(int a[], int n) {
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
///End of min Heap



int getRight(int index) {
    return (2 * index) + 1;
}

int getLeft (int index) {
    return 2 * index;
}

int getParrent(int index) {
    return index/2;
}

void maxHeapify(Heap *h, int index) {
    int largest = 0;
    int l = getLeft(index);
    int r = getRight(index);

    if(l <= h->size && h->arr[l] > h->arr[index]) {
        largest = l;
    }
    else
        largest = index;

    if(r <= h->size && h->arr[r] > h->arr[largest]) {
        largest = r;
    }

    if(largest != index) {
        swap(&h->arr[index], &h->arr[largest]);
        maxHeapify(h, largest);
    }
}

void buildHeapBottomUp(Heap *h) {
    for(int i = h->size / 2; i >= 0; i--) {
        maxHeapify(h, i);
    }
}

void insertKey(Heap *h, int index, int key) {
    if(key < h->arr[index]) {
        std::cout << "new key is smaller than current key";
    }

    h->arr[index] = key;
    int parent = getParrent(index);

    while(index > 0 && h->arr[parent] < h->arr[index]) {
        swap(&h->arr[index], &h->arr[parent]);
        index = parent;
    }
}


void buildHeapTopDown(Heap *h, int arr[], int n) {
    for(int i = 0;i < n; i++) {
        h->size++;
        h->arr[h->size] = INT_MIN;
        insertKey(h, h->size, arr[i]);
    }
}

void showArr(int arr[], int n) {
    for(int i = 0;i < n; i++) {
        std::cout << arr[i] << " ";
    }
    std::cout << std::endl;
}


///demo function that is called from main to test out algorithms of building a heap
void demo() {
    Heap h;
    int arr[] = {4, 1, 3, 2, 16, 9, 10, 14, 8 ,7};
    int n = sizeof(arr) / sizeof(int);

    h.size = 0;
    buildHeapTopDown(&h, arr, n);
    showArr(h.arr, h.size);

    CopyArray(h.arr, arr, n);
    h.size = n;
    buildHeapBottomUp(&h);
    showArr(h.arr, h.size);
}

void perfAll() {

}


int main() {
    ///demo
    demo();
    return 0;
}
