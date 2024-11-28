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
    prettyPrint(root->right, tabs + 1);
    std::cout << root->key << "\n";
    prettyPrint(root->left, tabs + 1);
}

Bst *osSelect(Bst *root, int i) {
    int r = 0;
    if(root->left == nullptr) {
        r = root->size;
    }else {
        r = root->left->size + 1;
    }
    if(r == i) {
        return root;
    }
    if(r > i) {
        return osSelect(root->left, i);
    }
        return osSelect(root->right, i - r);
}

void demo() {

    int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int n = sizeof(a) / sizeof(int);

    Bst *tree = createBst(1, n, a);
    prettyPrint(tree, 0);
    std::cout << "os Selecting 3 random keys from the previously built tree \n";
    for(int i = 0;i < 3; i++) {
        int j;
        j = rand() % n;
        Bst *node = osSelect(tree, j);
        std::cout <<j<<"th key number " << i + 1 << ": ";
        std::cout << node->key << std::endl;
    }
}
int main() {
    srand(time(nullptr));
    demo();
    return 0;
}

