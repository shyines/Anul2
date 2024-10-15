#include <iostream>
#include "Profiler.h"


Profiler profiler;

int operation(int n) {

    Operation o = profiler.createOperation("O(N)", 10000);
    for(int i = 0;i < n; i++) {
        o.count();
        int a = 1 + 2;
    }

}

void operation2(int n) {
    int a = n;
    Operation o = profiler.createOperation("100*O(logn)", 10000);
    for(int i = 0;i < 100; i++) {
        while(a > 0) {
            a /= 2;
            o.count();
        }
    }
}

int operation3 (int n) {
    Operation o = profiler.createOperation("0.1 O(n^2)");
    for(int i = 0;i < n; i++) {
        for(int j = 0;j < n; j++) {
            if(i % 10 == 0) {
                o.count();
            }
        }
    }
}


int main() {

    for(int n = 100;n <= 10000; n += 100) {
        operation(n);
        operation2(n);
    }
    profiler.showReport();
    return 0;
}
