#include <iostream>
#include <list>
#include <fstream>
#include <vector>

typedef struct node2 {
    int key;
    std::list<node2> childs;
}Node2;
//*R2, R2_const[500];

typedef struct node3 {
    int key;
    node3 *left;//copilul
    node3 *right;//fratele
}Node3;
//node3 *R3

typedef struct _tree {
    int key;
    _tree *leftChild;
    _tree *rightChild;
    _tree *parent;
}Btree;

Btree *createNode() {
    Btree *node = new Btree;

    node->key = 0;
    node->rightChild = nullptr;
    node->leftChild = nullptr;
    node->parent = nullptr;

    return node;
}

Btree* buildTree(int arr[], int *index) {
    Btree *root = createNode();
    if(arr[*index] == 0) {
        return nullptr;
    } else {
        root->key = arr[*index];

        *index = *index + 1;
        root->leftChild = buildTree(arr, index);
        if(root->leftChild != nullptr) {
            root->leftChild->parent = root;
        }
        *index = *index + 1;
        root->rightChild = buildTree(arr, index);
        if(root->rightChild != nullptr) {
            root->rightChild->parent = root;
        }
    }

    return root;
}

void inOrder(Btree *root) {
    if(root != nullptr) {
        inOrder(root->leftChild);
        if(root->parent != nullptr) {
            std::cout << root->key << " parrent: " << root->parent->key << " ";
        }
        inOrder(root->rightChild);
    }
}

void postOrder(Btree *root) {
    if(root != nullptr) {
        postOrder(root->leftChild);
        postOrder(root->rightChild);
        if(root->parent != nullptr) {
            std::cout << root->key << " parrent: " << root->parent->key <<" ";
        }
    }
}

void preOrder(Btree *root) {
    if(root != nullptr) {
        if(root->parent != nullptr) {
            std::cout << root->key << " parrent: " << root->parent->key << " ";
        }
        preOrder(root->leftChild);
        preOrder(root->rightChild);
    }
}
/*
void interativeTreePrint(Btree *root) {
    Btree *node = root;
    int d = 1;
    do {
        if (d == 1) {
            if (node->leftChild != nullptr) {
                node = node->leftChild;
            } else {
                d = 2;
            }
        }

        if(d == 2) {
            if(node->rightChild != nullptr) {
                node = node->rightChild;
                d = 1;
            }
            else {
                d = 3;
            }
        }

    }while()
}
*/
void demoShowBTree() {
    int arr[] = {1 ,7 ,2 ,0 ,5 ,0 ,0 ,
                 0 ,9 ,3 ,0 ,0 ,4 ,0 ,
                 6 ,0 ,0};
    int index = 0;
    Btree *tree = buildTree(arr, &index);

    inOrder(tree);
    std::cout << std::endl;
    preOrder(tree);
    std::cout << std::endl;
    postOrder(tree);
    std::cout << std::endl;
}

void prettyPrintR1(int parent[], int n, int tabs, int indexParent) {

    for(int i = 0;i < tabs; i++) {
        std::cout << "\t";
    }
    std::cout << indexParent << "\n";

    for(int i = 1;i <= n; i++) {
        if(parent[i] == indexParent) {
            prettyPrintR1(parent, n, tabs + 1, i);
        }
    }
}

void prettyPrintR2(Node2 *R2, int tabs) {
    for(int i = 0;i < tabs; i++) {
        std::cout << "\t";
    }
    std::cout << R2->key << "\n";

    for(auto i: R2->childs) {
        prettyPrintR2(&i, tabs + 1);
    }
}

void prettyPrintR3(Node3 *R3, int tabs) {
    if(R3 != nullptr) {
        for(int i = 0;i < tabs; i++) {
            std::cout << "\t";
        }
        std::cout << R3->key << "\n";

        prettyPrintR3(R3->left, tabs + 1);
        prettyPrintR3(R3->right, tabs);
    }
}



int main() {
    demoShowBTree();
    return 0;
}
