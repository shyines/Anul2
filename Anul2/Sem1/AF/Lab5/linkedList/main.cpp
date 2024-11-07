#include <iostream>
#include <list>
#include <queue>
#include <stdlib.h>
#include <bits/fs_fwd.h>
#include "Profiler.h"

std::queue <int> solution;
Profiler p;

typedef struct _node{
    int key;
    _node *next;
}Node;


int getLeftChild(int index) {
    return index * 2;
}

int getRightChild(int index) {
    return (index * 2) + 1;
}

Node* newNode(int key) {
    Node *node = new Node;

    node->key = key;
    node->next = NULL;

    return node;
}

void showList(Node *h) {
    Node *p = h;

    while(p != NULL) {
        std::cout << p->key << " ";
        p = p->next;
    }

    std::cout << std::endl;
}

void addLast(Node* h, int key) {
    Node *p = h;
    Node *toAdd = newNode(key);
    while(p->next != NULL) {
        p = p->next;
    }
    p->next = toAdd;
}

void sink(Node *h[], int k, int index, Operation *asg, Operation *cmp) {
    int min = index;
    int leftChild = getLeftChild(index);
    int rightChild = getRightChild(index);

    if(leftChild <= k && h[index]->key > h[leftChild]->key) {
        min = leftChild;
        asg->count();
    }
    if(rightChild <= k && h[min]->key > h[rightChild]->key) {
        min = rightChild;
        asg->count();
    }
    cmp->count(2);

    if(min != index) {
        asg->count(3);
        Node *aux = h[index];
        h[index] = h[min];
        h[min] = aux;
        sink(h, k, min, asg, cmp);
    }
    cmp->count();
}

void buildMinHeapList(Node *h[], int n, Operation *asg, Operation *cmp) {
    for(int i = n / 2;i >= 1; i--) {
        sink(h, n, i, asg, cmp);
    }
}

void showHeap(Node *h[], int n) {
    for(int i = 1;i <= n; i++) {
        std::cout << h[i]->key << " ";
    }
    std::cout << std::endl;
}

void deleList(Node *r) {
    if (r == NULL) {
        return;
    }

    deleList(r->next);

    delete r;
}


void freeLists(Node **h[], int k) {
    for(int i = 0;i < k; i++) {
        deleList(*h[i]);
    }
}

void mergeKOrderedList(Node *h[], int k, int n, Operation *asg, Operation *cmp) {
    buildMinHeapList(h, k, asg, cmp);
    //not really corect i think
    int heapSize = k;
    while(heapSize > 0) {
        solution.push(h[1]->key);
        asg->count();
        cmp->count();
        if(h[1]->next != NULL) {
            Node *aux = h[1];
            h[1] = h[1]->next;
            delete aux;
            asg->count(3);
        }
        else {
            Node *aux = h[1];
            h[1] = h[heapSize];
            delete aux;
            heapSize--;
            asg->count(3);
        }

        sink(h, heapSize, 1, asg, cmp);
    }
}

void demo() {
    Node *h[10000];
    int k = 4;
    int n = 20;
    int copyN = n;
    int key = 0;
    int size = 0;
    int source[10000];

    Operation asg = p.createOperation("asg", n);
    Operation cmp = p.createOperation("cmp", n);

    for(int i = 1;i <= k; i++) {
        if(i == k) {
            size = n;
        } else {
            size = 1 + (rand() % n);
        }
        FillRandomArray(source, size, 10, 50000, false, ASCENDING);
        h[i] = newNode(source[0]);
        for(int j = 1;j <= size; j++) {
            addLast(h[i], source[j]);
        }
        n -= size;
    }
    mergeKOrderedList(h, k, copyN, &asg, &cmp);
}




void perf() {
    Node *h[102];
    int k = 0;
    int size = 0;
    int source[10000];

    for(int i = 0;i < 3; i++) {
        switch (i) {
            case 0: {
                k = 5;
                for(int j = 100; j <= 10000; j+=100) {
                    Operation mergeAsgFive = p.createOperation("mergeAsgFive", j);
                    Operation mergeCmpFive = p.createOperation("mergeCmpFive", j);
                    int n = j;
                    for(int m = 1;m <= k; m++) {
                        if(m == k) {
                            size = n;
                        } else {
                            size = 1 + (rand() % n);
                        }
                        FillRandomArray(source, size, 10, 50000, false, ASCENDING);
                        h[m] = newNode(source[0]);
                        for(int q = 1;q <= size; q++) {
                            addLast(h[m], source[q]);
                        }
                        n -= size;
                    }
                    mergeKOrderedList(h, k, j, &mergeAsgFive, &mergeCmpFive);
                }
                p.addSeries("Five", "mergeAsgFive", "mergeCmpFive");
                break;
            }
            case 1: {
                k = 10;
                for(int j = 100; j <= 10000; j+=100) {
                    Operation mergeAsgTen = p.createOperation("mergeAsgTen", j);
                    Operation mergeCmpTen = p.createOperation("mergeCmpTen", j);
                    int n = j;
                    for(int m = 1;m <= k; m++) {
                        if(m == k) {
                            size = n;
                        } else {
                            size = 1 + (rand() % n);
                        }
                        FillRandomArray(source, size, 10, 50000, false, ASCENDING);
                        h[m] = newNode(source[0]);
                        for(int q = 1;q <= size; q++) {
                            addLast(h[m], source[q]);
                        }
                        n -= size;
                    }
                    mergeKOrderedList(h, k, j, &mergeAsgTen, &mergeCmpTen);
                }
                p.addSeries("Ten", "mergeAsgTen", "mergeCmpTen");
                break;
            }
            case 2: {
                k = 100;
                for(int j = 100; j <= 10000; j+=100) {
                    Operation mergeAsgHund = p.createOperation("mergeAsgHund", j);
                    Operation mergeCmpHund = p.createOperation("mergeCmpHund", j);
                    int n = j;
                    for(int m = 1;m <= k; m++) {
                        if(m == k) {
                            size = n;
                        } else {
                            size = 1 + (rand() % n);
                        }
                        FillRandomArray(source, size, 10, 50000, false, ASCENDING);
                        h[m] = newNode(source[0]);
                        for(int q = 1;q <= size; q++) {
                            addLast(h[m], source[q]);
                        }
                        n -= size;
                    }
                    mergeKOrderedList(h, k, j, &mergeAsgHund, &mergeCmpHund);
                }
                p.addSeries("Hund", "mergeAsgHund", "mergeCmpHund");
                break;
            }
            default:
                break;
        }
    }
    p.createGroup("Comparations", "Five", "Ten", "Hund");
}

void perfall() {
    demo();
    p.reset("Avg Case");
    perf();
    p.showReport();
}

int main() {
    perfall();
    return 0;
}
