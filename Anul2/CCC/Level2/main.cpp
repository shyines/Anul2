#include <iostream>

using namespace std;
int a[20][20];

void showMatrix (int a[][20], int y, int x) {
    for(int i=1; i<=y; i++)
    {
        for(int j=1; j<=x; j++)
            cout<<a[i][j]<<" ";
        cout<<"\n";
    }

    cout << endl;
}


int main()
{
    int x = 7;
    int y = 7;
    int id = 6;

    for(int j = 1; j<= x; j+=2) {
        for (int k = 1; k <= y / 4; k++) {
            for (int z = 1; z <= 3; z++) {
                a[4 * (k - 1) + z][j] = 1;
                a[4 * (k - 1) + 4][j] = 0;
            }
            id--;
            showMatrix(a, y, x);
        }
    }

    int mod = y%4;
    if(mod == 2)
    {
        for(int k=1; k<= x/4 ; k++)
        {
            for(int z = 1; z<=3; z++)
            {
                a[y][4*(k-1)+z] = 1;
                a[y][4*(k-1)+4] = 0;
            }
            id--;
            showMatrix(a, y, x);
        }
    }
    if(mod == 3)
    {
        for(int j = 1; j<=x; j+=2)
        {
            for(int k=1; k<= x/4 ; k+=2)
            {
                for(int z = 1; z<=3; z++)
                {
                    a[y-z][4*(k-1)+z] = 1;
                    a[y-z][4*(k-1)+4] = 0;
                }
                id--;
                showMatrix(a, y, x);
            }
        }
    }

    showMatrix(a, y, x);
    return 0;
}