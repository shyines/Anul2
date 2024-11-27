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

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
