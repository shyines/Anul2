#include <iostream>
#include <vector>
#include <map>
#include <fstream>
#include "Profiler.h"
#include <tuple>

using namespace std;

Profiler p;
//ifstream fin ("data.in");
//ofstream fout ("data.out");


//stack overflow copied implementation of a graph, i rly wanted to learn using c++ features

struct vertex {
    typedef pair<int, vertex*> ve; //cost of the edge (int) and destination vertex
    vector<ve> adj;
    int key;
    vertex(int Key): key(Key) {};
};

class Graph {
public:
    typedef map<int, vertex *> vmap;
    vmap work;
    typedef tuple<vertex*, vertex*, int> GE;
    vector<GE> ge; //makes a vector of triplets - the from vertex, to vertex and the cost
    void addVertex(int Key);
    void addEdge(int from, int to, int cost);
    void print();
    void printEdges();
};

void Graph::addVertex (int Key) {
    vmap::iterator itr = work.find(Key);
    if (itr == work.end()) {
        vertex *v;
        v = new vertex(Key);
        work[Key] = v;
        return;
    }
    cout << "\nNodul deja exista";
}



void Graph::addEdge(int from, int to, int cost) {
    vertex *f = (work.find(from)->second); //from vertex
    vertex *t = (work.find(to)->second); //to vertex

    tuple<vertex*, vertex*, int> dummy= make_tuple(f, t, cost);
    ge.push_back(dummy);//I create and add it

    pair<int, vertex*> edge = make_pair(cost, t);
    f->adj.push_back(edge);
    pair<int, vertex*> edge2 = make_pair(cost, f);
    t->adj.push_back(edge2);
}

void Graph::print() {
    for (auto i: work) {
        cout << "Nodul: " << i.second->key << " cu nodurile de adiacenta: ";
        for (int j = 0;j < i.second->adj.size(); j++) {
            cout << i.second->adj.at(j).second->key <<" ";
        }
        cout << "\n";
    }
}


class RootedNode {
    private:
        int rank;
        int key;
        RootedNode *parent;

    public:
        explicit RootedNode (int Key);
        RootedNode *findSet(RootedNode *node);
        void unify(RootedNode *root1, RootedNode *root2);
        RootedNode *getParent();
        void setParent(RootedNode *node);
        int getRank();
        void setRank();
};

void RootedNode::setParent(RootedNode *node) {
    parent = node;
}


RootedNode *RootedNode::getParent() {
    return parent;
}

void RootedNode::setRank() {
    rank++;
}

int RootedNode::getRank() {
    return rank;
}

RootedNode::RootedNode(int Key) {
    rank = 0;
    key = Key;
    parent = nullptr;
}

RootedNode *RootedNode::findSet(RootedNode *node) {
    if (node->getParent() == nullptr) {
        findSet(node->getParent());
    }
    return node;
}

void RootedNode::unify(RootedNode *root1, RootedNode *root2) {
    if (root1->getRank() > root2->getRank()) {
        root2->setParent(root1);
    } else if (root1->getRank() == root2->getRank()){
        root1->setParent(root2);
        root2->setRank();
    } else {
        root1->setParent(root2);
    }
}
/*
struct Edge {
    int x;
    int y;
    int cost;
};
*/
/*
struct Edge {
    int x;
    int y;
    int cost;
};

rootedNode *makeSet(int x) {
    rootedNode *root = new rootedNode(0, x, nullptr);
    return root;
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
*/

void demo() {
    Graph g;
    int source[] = {1, 2, 3, 4, 5, 6, 7};
    int n = sizeof(source) / sizeof(int);
    RootedNode* roots[n];


    for (int i = 0;i < n; i++) {
        g.addVertex(source[i]);
        roots[i] = new RootedNode(source[i]);
    }

    g.addEdge(1, 3, 1);
    g.addEdge(5, 7, 1);
    g.addEdge(3, 6, 2);
    g.addEdge(7, 4, 2);
    g.addEdge(2, 4, 3);
    g.addEdge(2, 5, 3);
    g.addEdge(1, 5, 5);

    g.print();

    for ()
}


int main() {
    demo();
    return 0;
}
