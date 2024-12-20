#include <iostream>
#include <list>
#include <string.h>
#include <vector>
#include "Profiler.h"
#include <stack>
Profiler p;
enum {
    WHITE = 0,
    GREY,
    BLACK
};

struct node {
    int key;
    //int adjSize;
    std::vector<node*>adj;
    int color;
    int index;
    int comp;
    bool onStack;
    int lowLink;
};

int index = 0;
std::stack <node*> stack;
int nrComponents;
std::list<node*>list;

void strongConnect(std::vector<node*> &graph, node* node) {
    node->index = node->lowLink = index;
    index = index + 1;
    stack.push(node);
    node->onStack = true;
    for(auto it: node->adj) {
        if(it->index == -1) {
            strongConnect(graph, it);
            node->lowLink = std::min(node->lowLink, it->lowLink);
        }else if (it->onStack) {
            node->lowLink = std::min(node->lowLink, it->index);
        }
    }

    if(node->lowLink == node->index) {
        nrComponents++;
        struct node *v;
        do {
            v = stack.top();
            stack.pop();
            v->onStack = false;
            v->comp = nrComponents;
        }while(v != node);
    }
}

void tarjan(std::vector<node*> &graph) {
    index = 0;
    while(!stack.empty())
    {
        stack.pop();
    }
    nrComponents = 0;

    for(auto it: graph) {
        it->index = -1;
        it->lowLink = -1;
        it->onStack = false;
        it->comp = 0;
    }

    for(auto it: graph) {
        if(it->index == -1) {
            strongConnect(graph, it);
        }
    }
}

void printScc(std::vector<node*> &graph) {
    for(int i = 1;i <= nrComponents; i++) {
        std::cout << "Component nr " << i << "\n";
        for(auto it: graph) {
            if(it->comp == i) {
                std::cout << " " << it->key;
            }
        }
        std::cout << std::endl;
    }
}

void dfsVisit(node *start, Operation *op) {
    start->color = GREY;
    if (op != nullptr) {
        op->count();
    }
    for(int i = 0;i < start->adj.size(); i++) {
        if (op != nullptr) {
            op->count();
        }
        if(start->adj[i]->color == WHITE) {
            dfsVisit(start->adj[i], op);
        }
    }
    if (op != nullptr) {
        op->count();
    }
    start->color = BLACK;
    if (op == nullptr) {
        list.emplace_front(start);
    }
}

void dfs(std::vector<node*> &graph, int nrOfVertices, Operation *op) {
    for(int i = 0; i < nrOfVertices; i++) {
        graph[i]->color = WHITE;
    }
    for(int i = 0;i < nrOfVertices; i++) {
        if (op != nullptr) {
            op->count();
        }
        if(graph[i]->color == WHITE) {
            dfsVisit(graph[i], op);
        }
    }
}


void addVertice(int from, int to, std::vector<node*> &graph) {
    graph[from]->adj.push_back(graph[to]);
    //graph[to]->adj.push_back(graph[from]);
}

void showGraph(std::vector<node*> &graph, int numOfVertexes) {
    for (node* it: graph) {
        std::cout << it->key << ": ";
        for (node* jt: it->adj) {
            std::cout << jt->key <<" ";
        }
        std::cout << std::endl;
    }
}

void showList() {
    for (auto it: list) {
        std::cout << it->key <<" ";
    }
}
void dfsDemo() {
    int vertexes[] ={0, 1, 2, 3, 4, 5};
    int numOfVertexes = sizeof(vertexes) / sizeof(int);
    std::vector<node*>graph;
    for (int i = 0;i < numOfVertexes; i++) {
        node* vertex = new node(vertexes[i]);
        graph.push_back(vertex);
    }
    addVertice(vertexes[5], vertexes[2], graph);
    addVertice(vertexes[2], vertexes[3], graph);
    addVertice(vertexes[3], vertexes[1], graph);
    addVertice(vertexes[4], vertexes[1], graph);
    addVertice(vertexes[4], vertexes[0], graph);

    showGraph(graph, numOfVertexes);
    dfs(graph, numOfVertexes, nullptr);
    showList();
    tarjan(graph);
    printScc(graph);
}

void performance() {
    Profiler p("dfs");
    int numOfVertexes = 100;
    for (int i = 1000;i <= 4500; i+= 100) {
        std::vector<node*>graph;
        for (int i = 0;i < numOfVertexes; i++) {
            node* vertex = new node(i);
            graph.push_back(vertex);
        }
        Operation op = p.createOperation("dfs->edges", i);
        for (int j = 0;j < i; j++) {
            int dest = rand() % graph.size();
            int start = rand() % graph.size();
            bool ok = false;
            for (auto nodes: graph[start]->adj) {
                if (graph[start] == nodes) {
                    ok = true;
                    break;
                }
            }
            while (ok) {
                ok = false;
                dest = rand() % graph.size();
                start = rand() % graph.size();
                for (auto nodes: graph[start]->adj) {
                    if (graph[dest] == nodes) {
                        ok = true;
                        break;
                    }
                }
            }
            addVertice(start, dest, graph);
        }
        dfs(graph, static_cast<int>(graph.size()), &op);
    }

    for (int i = 100; i <= 200; i+=10) {
        Operation op = p.createOperation("dfs-vertices", i);
        std::vector<node*>graph1;
        for (int j = 0;j < i; j++) {
            node* vertex = new node(j);
            graph1.push_back(vertex);
        }
        for (int n = 0;n < 4500; n++) {
            int dest = rand() % graph1.size();
            int start = rand() % graph1.size();
            bool ok = false;
            for (auto nodes: graph1[start]->adj) {
                if (graph1[start] == nodes) {
                    ok = true;
                    break;
                }
            }
            while (ok) {
                ok = false;
                dest = rand() % graph1.size();
                start = rand() % graph1.size();
                for (auto nodes: graph1[start]->adj) {
                    if (graph1[dest] == nodes) {
                        ok = true;
                        break;
                    }
                }
            }
            addVertice(start, dest, graph1);
        }
        dfs(graph1, static_cast<int>(graph1.size()), &op);
    }
    p.showReport();
}

int main(){
    dfsDemo();
    performance();
    return 0;
}
