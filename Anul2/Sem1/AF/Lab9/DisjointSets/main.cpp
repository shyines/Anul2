#include <iostream>

struct Node {
    int rank;
    int key;
}parent[1005];

struct Edge {
    int x;
    int y;
    int cost;
};

void makeSet(int x) {
    parent[x].rank = 1;
    parent[x].key = x;
}

void unify(int x, int y) {
    if(parent[x].rank == parent[y].rank) {
        parent[x].key = parent[y].key;
        parent[y].rank++;
    }else if(parent[x].rank < parent[y].rank) {
        parent[x].key = parent[y].key;
    }else {
        parent[y].key = parent[x].key;
    }
}

int findSet(int x) {
    if(parent[x].key == x) {
        return x;
    }
    parent[x].key = findSet(parent[x].key);

}


int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
