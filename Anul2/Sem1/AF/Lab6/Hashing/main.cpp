#include <iostream>
#include <string.h>
#include <random>
#include "profiler.h"

Profiler p;

//////////Nu Merge cum as fi dorit, chiar nu stiu ce are

typedef struct {
    int id;
    char name[30];
}Entry;

void initEntry(Entry arr[], int n) {
    for(int i = 0;i < n; i++) {
        arr[i].id = -1;
    }
}



int quadProbing(int id, int i, int m) {
    if(id < 0)
        id += 10;
    //k + i + i*i mod m
    return (id + i + (i * i)) % m;
}

int insertEntry(Entry arr[], Entry toInsert, int n) {
    int index = 0;

    for(int i = 0;i < n; i++) {
        index = quadProbing(toInsert.id, i, n);
        if(arr[index].id == -1) {
            arr[index].id = toInsert.id;
            strcpy(arr[index].name, toInsert.name);
            return index;
        }
    }

    return -1;
}

void searchKey(Entry arr[], Entry toSearch, int n, double *acc) {
    int index = 0;
    for(int i = 0;i < n; i++) {
        *acc += 1;
        index = quadProbing(toSearch.id, i, n);

        if(arr[index].id == -1) {
            break;
        }
        if(arr[index].id == toSearch.id && (strcmp(arr[index].name, toSearch.name) == 0)) {
            return;
        }
    }
}


void showEntry(Entry arr[], int n) {
    for(int i = 0;i < n; i++) {
        std::cout << arr[i].id << " pozitia " << i << std::endl;
    }
    std::cout << std::endl;
}


void demo() {
    Entry e[10];
    int arr[] = {7, 14, 18, 10, 19, 1, 20, 17, 9, 3};
    int n = sizeof(arr) / sizeof(int);
    Entry dummy;

    initEntry(e, n);

    for(int i = 0;i < n; i++) {
        dummy.id = arr[i];
        strcpy(dummy.name, "lmao");
        insertEntry(e, dummy, n);
    }

    showEntry(e, n);

    ///Search Test
    for(int i = 0 ;i < n; i++) {
        double acc = 0;
        dummy.id = arr[i];
        strcpy(dummy.name, "lmao");
        searchKey(e, dummy, n, &acc);
    }

}

void perfTwo() {
    Entry arr[10007];
    int m = 10007;
    double fillingFactors[5] = {0.8f, 0.85f, 0.9f, 0.95f, 0.99f};
    int size = sizeof(fillingFactors) / sizeof(double);
    int numOfElToInsert = 0;
    std::cout << "--------------------------------------------------------------------------------------------------------------------"<<std::endl;
    std::cout << "Filling factor        Avg Effort(Found)       MaxEffort(Found)        AvgEffort(NotFound)        MaxEffort(NotFound)" << std::endl;
    for(int i = 0;i < size; i++) {

        int maximumFound = -1;
        double acc = 0;
        int accTotalFound = 0;

        int maximumNotFound = -1;
        int accTotalNotFound = 0;

        double dummyVal = fillingFactors[i] * static_cast<double>(m);

        numOfElToInsert = static_cast<int>(dummyVal);
        int source[2 * numOfElToInsert];

        initEntry(arr, m);
        FillRandomArray(source, 2 * numOfElToInsert, 10, 50000, true);

        Entry goodEntries[numOfElToInsert];
        Entry badEntries[1502];

        int count = 0;
        int count2 = 0;
        int ok = -1;
        while(count < numOfElToInsert && count2 < 1500) {
            Entry e;
            do {
                e.id = source[rand() % (2 * numOfElToInsert)];
                strcpy(e.name, "found");
                ok = insertEntry(arr, e, m);
                if(ok != -1) {
                    goodEntries[count++] = e;
                }
            }while(ok != -1);
            badEntries[count2++] = e;
        }


        for(int l = 0; l < 1500; l++) {
            acc = 0;
            int index = rand() % numOfElToInsert;

            Entry toSearch;
            toSearch.id = goodEntries[index].id;
            strcpy(toSearch.name, "found");

            searchKey(arr, toSearch, m, &acc);
            accTotalFound += static_cast<int>(acc);
            if(acc >= maximumFound) {
                maximumFound = static_cast<int>(acc);
            }
        }

        for(int l = 0; l < count2; l++) {
            acc = 0;
            Entry toSearchBad = badEntries[l];

            searchKey(arr, toSearchBad, m, &acc);
            accTotalNotFound += static_cast<int>(acc);
            if(acc >= maximumNotFound) {
                maximumNotFound = static_cast<int>(acc);
            }
        }

        double avgFound = static_cast<double>(accTotalFound) / m;
        double avgNotFound = static_cast<double>(accTotalNotFound) / m;
        std::cout << fillingFactors[i] <<"\t\t\t"<<
            avgFound << "\t\t\t" <<
            maximumFound << "\t\t\t"<<
                avgNotFound <<"\t\t\t" <<
                    maximumNotFound
        << std::endl;
    }
}

int main()
{
    srand(time(nullptr));
    demo();
    perfTwo();
    return 0;
}
