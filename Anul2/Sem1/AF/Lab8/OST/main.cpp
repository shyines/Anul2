#include <iostream>
struct Bst {
    int key;
    int size;
    Bst *left;
    Bst *right;
};

Bst *createNode(int key, int size) {
    Bst *node = new Bst;
    node->key = key;
    node->size = size;
    node->left = node->right = nullptr;

    return node;
}

Bst *createBst(int left, int right, int a[]) {
    if(right < left) {
        return nullptr;
    }
    int mid = (left + right) / 2;


    Bst*node = createNode(a[mid], right - left + 1);
    node->left = createBst(left, mid - 1, a);
    node->right = createBst(mid + 1, right, a);

    return node;
}

void prettyPrint(Bst *root, int tabs) {
    if(root == nullptr) {
        return;
    }
    for(int i = 0;i < tabs; i++) {
        std::cout << "\t";
    }
    std::cout << root->key << "\n";
    prettyPrint(root->left, tabs + 1);
    prettyPrint(root->right, tabs + 1);
}

Bst *osSelect(Bst *root, int i, bool delCase, Bst *&parent) {
    int r = 1;
    if(root->left != nullptr){
        if(delCase) {
            r = root->left->size + 1;
            root->size--;
        }else {
            r = root->left->size + 1;
        }
    }
    if(r == i) {
        return root;
    }
    if(r > i) {
        parent = root;
        return osSelect(root->left, i, delCase, parent);
    } else {
        parent = root;
        return osSelect(root->right, i - r, delCase, parent);
    }
}

void osDelete(Bst **root, int i) {
    Bst *parent = nullptr;
    Bst *toDelete = osSelect(*root, i, false, parent);

    if(toDelete->right == nullptr && toDelete->left == nullptr) {
        if(parent->right == toDelete) {
            delete toDelete;
            parent->right = nullptr;
        }else {
            delete toDelete;
            parent->left = nullptr;
        }
        parent = nullptr;
        osSelect(*root, i, true, parent);
        return;
    }

    if(toDelete->right != nullptr && toDelete->left == nullptr) {
        Bst *dummy = toDelete;
        toDelete = toDelete->right;
        if(parent->right == dummy) {
            parent->right = toDelete;
        }else {
            parent->left = toDelete;
        }
        delete dummy;
        parent = nullptr;
        osSelect(*root, i, true, parent);
        return;
    }

    if(toDelete->left != nullptr && toDelete->right == nullptr) {
        Bst *dummy = toDelete;
        toDelete = toDelete->left;
        if(parent->right == dummy) {
            parent->right = toDelete;//////////REFACEM LEGATURILE
        }else {
            parent->left = toDelete;
        }
        delete dummy;
        parent = nullptr;
        osSelect(*root, i, true, parent);
        return; //////////sa nu intre pe un alt if
    }

    if(toDelete->left != nullptr && toDelete->right != nullptr) {
        Bst *succParent = nullptr;
        Bst *suc = osSelect(*root, i + 1, false, succParent);
        if(succParent->left == suc) {
            succParent->left = suc->right;
        }else {
            toDelete->right = suc->right;////////////REFACEM LEGATURILE
        }
        toDelete->key = suc->key;

        delete suc;
        parent = nullptr;
        osSelect(*root, i, true, parent);
    }
}

void demo() {

    int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int n = sizeof(a) / sizeof(int);
    Bst *tree = createBst(0, n - 1, a);
    prettyPrint(tree, 0);
    std::cout << "os Selecting 3 random keys from the previously built tree \n";
    for(int i = 0;i < 3; i++) {
        int j = 0;
        do {
            j = rand() % n;
        }while(n == 0);

        Bst *dummyParent = nullptr;
        Bst *node = osSelect(tree, j, false, dummyParent);
        std::cout << "deleteing key: "<<node->key << std::endl;
        osDelete(&tree, 2);
        prettyPrint(tree, 0);
        std::cout << std::endl;
        n--;
    }
}
int main() {
    srand(time(nullptr));
    demo();
    return 0;
}

