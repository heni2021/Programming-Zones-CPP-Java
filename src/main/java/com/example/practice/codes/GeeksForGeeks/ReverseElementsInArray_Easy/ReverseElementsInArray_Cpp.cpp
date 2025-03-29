// Link : https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/reverse-an-array
#include <iostream>
using namespace std;

/**
 * Brute Force Approach - 2 Pointers Approach
 * Take 2 pointers one at starting and one at ending index of the array.
 * Keep swapping the elements till either both pointer crosses each other or at the same index.
 * @timeComplexity : O(n)
 * @spaceComplexity : O(1)
 * */
void reverseArrayInPlaceUsingBruteForce(int arr[] , int n){
    int i=0, j=n-1;
    while (i<j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
    }
}

void print_array(int arr[], int n)
{
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
    cout << "\n";
}

int main(){
    int n;
    cin >> n;
    int arr[n];
    for(int i=0;i<n;i++){
        cin >> arr[i];
    }

    reverseArrayInPlaceUsingBruteForce(arr, n);
    cout<< "Reversed Array : ";
    print_array(arr, n);

    return 0;
}