#include <iostream>

enum {
    WHITE = 0,
    GREY,
    BLACK
};

struct node {
    int key;
    int adjSize;
    node *adj[4500];
    int color;
};

void dfsVisit(node *start) {
    start->color = GREY;
    for(int i = 0;i < start->adjSize; i++) {
        if(start->adj[i]->color == WHITE) {
            dfsVisit(start->adj[i]);
        }
    }
    start->color = BLACK;
}

void dfs(node *graph[], int nrOfVertices) {
    for(int i = 0; i < nrOfVertices; i++) {
        graph[i]->color = WHITE;
    }
    for(int i = 0;i < nrOfVertices; i++) {
        if(graph[i]->color == WHITE) {
            dfsVisit(graph[i]);
        }
    }
}

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
