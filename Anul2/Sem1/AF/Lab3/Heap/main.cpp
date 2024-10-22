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

///Bubble Sort written with the help of Geeks for Geeks website

void bubbleSortRec(int arr[], int n, Operation *bbSortRecCmp, Operation *bbSortRecAsg) {
    // Base case
    if (n == 1)
        return;

    int count = 0;
    // One pass of bubble sort. After
    // this pass, the largest element
    // is moved (or bubbled) to end.
    for (int i = 0; i < n-1; i++) {
        bbSortRecCmp->count();
        if (arr[i] > arr[i + 1]){
            bbSortRecAsg->count(3);
            swap(&arr[i], &arr[i + 1]);
            count++;
        }
    }

    // Check if any recursion happens or not
    // If any recursion is not happen then return
    if (count==0)
        return;
    // Largest element is fixed,
    // recur for remaining array
    bubbleSortRec(arr, n-1, bbSortRecCmp, bbSortRecAsg);
}

void bubbleSortRecNoOpp(int arr[], int n/*, Operation *bbSortRecCmp, Operation *bbSortRecAsg*/) {
    // Base case
    if (n == 1)
        return;

    int count = 0;
    // One pass of bubble sort. After
    // this pass, the largest element
    // is moved (or bubbled) to end.
    for (int i = 0; i < n-1; i++) {
        //bbSortRecCmp->count();
        if (arr[i] > arr[i + 1]){
            //bbSortRecAsg->count(3);
            swap(&arr[i], &arr[i + 1]);
            count++;
        }
    }

    // Check if any recursion happens or not
    // If any recursion is not happen then return
    if (count==0)
        return;
    // Largest element is fixed,
    // recur for remaining array
    bubbleSortRecNoOpp(arr, n-1/*, bbSortRecCmp, bbSortRecAsg*/);
}


int bubbleSort(int a[], int n) {
    Operation compBubbleSort = p.createOperation("compBubbleSort", n);
    Operation asgBubbleSort = p.createOperation("asgBubbleSort", n);
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

int bubbleSortNoOpp(int a[], int n) {
    //Operation compBubbleSort = p.createOperation("compBubbleSort", n);
    //Operation asgBubbleSort = p.createOperation("asgBubbleSort", n);
    bool sorted = false;
    int i = 0;
    do {
        sorted = true;
        for(int j = 0;j < n - i - 1; j++) {
            //compBubbleSort.count();
            if(a[j] > a[j + 1]) {
                //asgBubbleSort.count(3);
                swap(&a[j], &a[j + 1]);
                sorted = false;
            }
        }
        i++;
    }while (!sorted);

    return 0;
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

int getParent(int index) {
    return (index - 1) / 2;
}

void maxHeapify(Heap *h, int index, Operation *asg, Operation *comp) {
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
    comp->count(2);

    if(largest != index) {
        asg->count(3);
        swap(&h->arr[index], &h->arr[largest]);
        maxHeapify(h, largest, asg, comp);
    }
}

void buildHeapBottomUp(Heap *h) {
    Operation bottomUpAsg = p.createOperation("bottomUpAsg", h->size);
    Operation bottomUpComp = p.createOperation("bottomUpComp", h->size);
    for(int i = h->size / 2; i >= 0; i--) {
        maxHeapify(h, i, &bottomUpAsg, &bottomUpComp);
    }
}

void insertKey(Heap *h, int index, int key, Operation *asg, Operation *comp) {
    if(key < h->arr[index]) {
        std::cout << "new key is smaller than current key";
        return; // stop execution if the new key is smaller
    }
    asg->count();
    h->arr[index] = key;
    int parent = getParent(index);

    while(index > 0 && h->arr[parent] < h->arr[index]) {
        comp->count();
        asg->count(3);
        swap(&h->arr[index], &h->arr[parent]);
        index = parent;
        parent = getParent(index);  // recalculate parent after swap
    }
}


void buildHeapTopDown(Heap *h, int arr[], int n) {
    Operation topDownAsg = p.createOperation("topDownAsg", n);
    Operation topDownComp = p.createOperation("topDownComp", n);
    for(int i = 0; i < n; i++) {
        h->arr[h->size] = INT_MIN;  // Insert a dummy value
        insertKey(h, h->size, arr[i], &topDownAsg, &topDownComp);
        h->size++;
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

    CopyArray(h.arr, arr, n);
    h.size = n;
    buildHeapBottomUp(&h);
    showArr(h.arr, h.size);

    h.size = 0;
    buildHeapTopDown(&h, arr, n);
    showArr(h.arr, h.size);


}

void demoBbSort() {
    int arr[] = {4, 1, 3, 2, 16, 9, 10, 14, 8 ,7};
    int n = sizeof(arr) / sizeof(int);
    int arr2[] = {4, 1, 3, 2, 16, 9, 10, 14, 8 ,7};
    Operation bbSortRecAsg = p.createOperation("bbSortRecAsg", n);
    Operation bbSortRecCmp = p.createOperation("bbSortRecCmp", n);


    std::cout << "before bbsort alg (not recursive)"<< std::endl;
    showArr(arr, n);
    bubbleSort(arr, n);
    std::cout << "sorted: " << std::endl;
    showArr(arr, n);

    std::cout << "before bbsort alg (recursive)" << std::endl;
    showArr(arr2, n);
    bubbleSortRec(arr2, n, &bbSortRecCmp, &bbSortRecAsg);
    std::cout << "sorted: " << std::endl;
    showArr(arr2, n);
}



void perf() {
    int src[10000];
    Heap h;
    for(int i = 0;i < 5; i++) {
        for(int j = 100;j <= 10000; j += 100) {
            FillRandomArray(src, j);
            CopyArray(h.arr, src, j);
            h.size = j;
            buildHeapBottomUp(&h);

            h.size = 0;
            buildHeapTopDown(&h, src, j);
        }
    }

    p.divideValues("topDownAsg", 5);
    p.divideValues("topDownComp", 5);

    p.divideValues("bottomUpAsg", 5);
    p.divideValues("bottomUpComp", 5);
}

void perf2 () {
    int src[10000];
    int dest[10000];

    for(int i = 0;i < 5; i++) {
        for(int j = 100;j <= 10000; j += 100) {
            FillRandomArray(src, j);
            CopyArray(dest, src, j);
            Operation bbSortRecAsg = p.createOperation("bbSortRecAsg", j);
            Operation bbSortRecCmp = p.createOperation("bbSortRecCmp", j);
            bubbleSort(src, j);
            bubbleSortRec(dest, j, &bbSortRecCmp, &bbSortRecAsg);
        }
    }

    p.divideValues("compBubbleSort", 5);
    p.divideValues("asgBubbleSort", 5);
    p.divideValues("bbSortRecAsg", 5);
    p.divideValues("bbSortRecCmp", 5);
    p.createGroup("BubbleSort", "compBubbleSort", "asgBubbleSort", "bbSortRecAsg","bbSortRecCmp");
}

void perfTime() {
    int src[10000];
    int dest[10000];

    for(int j = 100;j <= 10000; j += 100) {
        p.startTimer("BubbleSortRecTimer", j);
        for(int test=0; test<100; ++test) {
            FillRandomArray(src, j);
            bubbleSortRecNoOpp(src, j);
        }
        p.stopTimer("BubbleSortRecTimer", j);

        p.startTimer("BubbleSortTimer", j);
        for(int test=0; test<100; ++test) {
            FillRandomArray(src, j);
            bubbleSortNoOpp(src, j);
        }
        p.stopTimer("BubbleSortTimer", j);
    }
}

void perfAll() {
    perf();
    p.reset("BubbleSort VS BubbleSortRec");
    perf2();
    p.reset("BubbleSort VS BubbleSortRec (TIME)");
    perfTime();

    p.showReport();
}
int main() {

    ///demos
    demo();
    demoBbSort();

    //Perf
    perfAll();
    return 0;
}
