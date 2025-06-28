#include <iostream>
#include <stdio.h>
using namespace std;
/*
12345
1234
123
12
1
*/
int main(){
    int n;
    cin >> n;
    for(int i=n;i>0;i--){
        for(int j=0;j<i;j++){
            cout << j+1;
        }
        cout << endl;
    }
    return 0;
}