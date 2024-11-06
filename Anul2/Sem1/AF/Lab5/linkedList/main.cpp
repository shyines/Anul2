#include <iostream>
#include <queue>

std::queue <int> solution;

typedef struct _node{
    int key;
    _node *next;
}Node;


void sink(Node *h[], int k, int index) {}

void mergeKOrderedList(Node *h[], int k, int n) {
    //not really corect i think
    int heapSize = k;
    while(heapSize > 0) {
        solution.push(h[1]->key);

        if(h[1]->next != NULL) {
            Node *aux = h[1];
            h[1] = h[1]->next;
            free(aux);
        }
        else {
            Node *aux = h[1];
            h[1] = h[heapSize];
            free(aux);
            heapSize--;
        }

        sink(h, heapSize, 1);
    }

}



int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
