#include <iostream>
#include <vector>
using namespace std;

void reverseElementsInArray(vector<int> &arr, int startIndex, int endIndex){
    while(startIndex < endIndex){
        int temp = arr[startIndex];
        arr[startIndex] = arr[endIndex];
        arr[endIndex] = temp;
        startIndex++;
        endIndex--;
    }
}

/**
 * Brute Force Approach
 * if the value of d is equal to the length of array then we need not to rotate. We can directly return the input array.
 * We can use three nested loops outer loop will be for the number of rotations.
 * Inner loops will perform the rotation operations and return the array.
 * @timeComplexity : O(n^2)
 * @spaceComplexity : O(n)
 * This may give TLE in larger inputs!!
 * */
void rotateArrayByBruteForce(vector<int> &arr, int d){
    if(d == arr.size() || arr.size() == 1){
        return;
    }

    int newArray[arr.size()];
    for(int i=0;i<d;i++){
        for(int j=0;j<arr.size();j++){
            newArray[j] = arr[j];
        }

        for(int j=0;j<arr.size()-1;j++){
            arr[j] = newArray[j+1];
        }
        arr[arr.size()-1] = newArray[0];
    }
}

/**
 * Better Approach.
 * The value of d will be the value we obtain upon performing modulo operation as if d is greater than the length of array no sense of doing repetitive operations
 * We will copy the entire array into another array and then copy the value of i+d%n into the old array
 * @timeComplexity: O(n)
 * @spaceComplexity: O(n)
 * */
void rotateArrayByBetterApproach(vector<int> &arr, int d)
{
    d = d % arr.size();
    if (d == 0 || arr.size() == 1)
    {
        return;
    }
    int newArray[arr.size()];
    for(int i=0;i<arr.size();i++){
        newArray[i] = arr[i];
    }

    for (int i = 0; i < arr.size(); i++)
    {
        arr[i] = newArray[(i + d) % arr.size()];
    }
}

/**
 * Optimised Approach
 * Reverse the elements from 0 to d-1 index
 * Reverse elements from d to n-1 index
 * then reverse entire array.
 * @timeComplexity: O(n)
 * @spaceComplexity: O(1)
 * */
void rotateArrayByOptimisedApproach(vector<int> &arr, int d)
{
    reverseElementsInArray(arr, 0, d-1);
    reverseElementsInArray(arr, d, arr.size()- 1);
    reverseElementsInArray(arr, 0, arr.size() - 1);
}


void print_array(vector<int> &arr){
    for (int i = 0; i < arr.size(); i++)
    {
        cout << arr[i] << " ";
    }
    cout << "\n";
}

int main()
{
    int d;
    vector<int> arr = {1,2,3,4,5};

    cin >> d;

    cout << "Rotated Array using Brute Force : ";
    rotateArrayByBruteForce(arr, d);
    print_array(arr);

    vector<int> arr2 = {1,2,3,4,5,6,7,8,9};
    cout << "Rotated Array using Better Approach : ";
    rotateArrayByBetterApproach(arr2, d);
    print_array(arr2);

    vector<int> arr3 = {10,11,12,13,14,15,16,17,18};
    cout << "Rotated Array using Optimised Approach : ";
    rotateArrayByOptimisedApproach(arr3, d);
    print_array(arr3);

    return 0;
}