#include <iostream>
#include <stdio.h>
using namespace std;
/*
1
0 1
1 0 1
0 1 0 1
1 0 1 0 1
*/
int main(){
    int n;
    cin >> n;
    int val;
    for(int i=0;i<n;i++){
        if(i%2==0){
            val = 1;
        }
        else{
            val = 0;
        }
        for(int j=0;j<=i;j++){
            cout << val << " ";
            if(val == 1){
                val = 0;
            }
            else{
                val = 1;
            }
        }
        cout << endl;
    }
    return 0;
}