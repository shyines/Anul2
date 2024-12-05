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
    //tuple<vertex*, vertex*, int> dummy2 = make_tuple(t, f, cost);
    ge.push_back(dummy);//I create and add it
    //ge.push_back(dummy2);

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
/*
class disjSet {

    //Adresa la un nod, parintele sau, avem un vector de date - incapsulare buna (primul e nodul, al doilea e parintele si dupa rankul)
    int key;
    int parentKey;
    int rank;

public:
    void makeSet(int x);

};

void disjSet::makeSet(int x) {
    key = x;
    parentKey = key;
    rank = 0;
}

*/

/*
struct Edge {
    int x;
    int y;
    int cost;
};
*/
struct disjSets {
    int key;
    int parentKey;
    int rank;
}parent[100005];


void makeSet(int x) {
    parent[x].key = x;
    parent[x].parentKey = parent[x].key;
    parent[x].rank = 0;
}

void unify(int x, int y, vector<int>& roots) {
    if(parent[x].rank == parent[y].rank) {
        roots.erase(find(roots.begin(), roots.end(), parent[x].parentKey));
        parent[x].parentKey = parent[y].parentKey;
        parent[y].rank++;
    }else if(parent[x].rank < parent[y].rank) {
        roots.erase(find(roots.begin(), roots.end(), parent[x].parentKey));
        parent[x].parentKey = parent[y].parentKey;
    }else {
        roots.erase(find(roots.begin(), roots.end(), parent[y].parentKey));
        parent[y].parentKey = parent[x].parentKey;
    }
}
int findSet(int x) {
    if (parent[x].parentKey != x) {
        parent[x].parentKey = findSet(parent[x].parentKey);
    }
    return parent[x].parentKey;
}


void demo() {
    Graph g;
    int source[] = {1, 2, 3, 4, 5, 6, 7};
    int n = sizeof(source) / sizeof(int);
    vector<int>roots;

    for (int i = 0;i < n; i++) {
        g.addVertex(source[i]);
        makeSet(source[i]);
        roots.push_back(source[i]);
    }
    cout << "exericitiul 1: make set pe toate elementele iar apoi unify pe 5 elemente\n";

    cout << "inainte de unify avem: \n";
    for (int i = 0;i < roots.size(); i++) {
        int special = findSet(roots.at(i));
        cout << "setul: " << special << " cu nodurile din padure: ";
        for (int j = 0;j < n; j++) {
            if (findSet(parent[source[j]].parentKey) == special)
                cout << parent[source[j]].key << " ";
        }
        cout << endl;
    }

    unify(parent[source[1]].parentKey, parent[source[2]].parentKey, roots);
    unify(parent[source[0]].parentKey, parent[source[2]].parentKey, roots);
    unify(parent[source[4]].parentKey, parent[source[6]].parentKey, roots);
    unify(parent[source[4]].parentKey, parent[source[2]].parentKey, roots);
    cout << "\ndupa unify: \n";

    for (int i = 0;i < roots.size(); i++) {
        int special = findSet(roots.at(i));
        cout << "setul: " << special << " cu nodurile din padure: ";
        for (int j = 0;j < n; j++) {
            if (findSet(parent[source[j]].key) == special)
                cout << parent[source[j]].key << " ";
        }
        cout << endl;
    }

    cout << endl;
    g.addEdge(1, 3, 1);
    g.addEdge(5, 7, 1);
    g.addEdge(3, 6, 2);
    g.addEdge(7, 4, 2);
    g.addEdge(2, 4, 3);
    g.addEdge(2, 5, 3);
    g.addEdge(1, 5, 5);
}

bool compareEdges(const tuple<int, int, int>& a, const tuple<int, int, int>& b) {
    return std::get<2>(a) < std::get<2>(b);  // Sort by the third element (weight)
}


void kruskalDemo() {
    Graph g;
    int source[] = {1, 2, 3, 4, 5, 6, 7};
    int n = sizeof(source) / sizeof(int);
    int m = n;
    vector<int>roots;

    for (int i = 0;i < n; i++) {
        g.addVertex(source[i]);
        makeSet(source[i]);
        roots.push_back(source[i]);
    }

    g.addEdge(source[0], source[2], 1);
    g.addEdge(source[4], source[6], 1);
    g.addEdge(source[2], source[5], 2);
    g.addEdge(source[6], source[3], 2);
    g.addEdge(source[1], source[3], 3);
    g.addEdge(source[1], source[4], 3);
    g.addEdge(source[0], source[4], 5);

    sort(g.ge.begin(), g.ge.end(), [](const auto& a, const auto& b) {
        return std::get<2>(a) < std::get<2>(b);
    });
    for (auto& i : g.ge) {
        if (findSet(std::get<0>(i)->key) != findSet(std::get<1>(i)->key)) {
            unify(std::get<0>(i)->key, std::get<1>(i)->key, roots);
        }
    }

    for (int i = 0;i < roots.size(); i++) {
        int special = findSet(roots.at(i));
        cout << "setul: " << special << " cu nodurile din padure: ";
        for (int j = 0;j < n; j++) {
            if (findSet(parent[source[j]].key) == special)
                cout << parent[source[j]].key << " ";
        }
        cout << endl;
    }

}
int main() {
    demo();
    cout << "Kruskal demo" << endl;
    memset(parent, 0, 10005);
    kruskalDemo();
    return 0;
}
