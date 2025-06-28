#include<iostream>
#include<stdio.h>
using namespace std;
/*
1
12
123
1234
12345
*/
int main(){
    int n;
    cin >> n;
    for(int i=0;i<n;i++){
        for(int j=0;j<=i;j++){
            cout << j+1;
        }
        cout << endl;
    }
    return 0;
}