// Link - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/move-all-zeroes-to-end-of-array0751
#include <iostream>
#include <stdio.h>
#include <algorithm>
#include <string.h>
using namespace std;

/**
 * Brute Force
 * Count number of zeros in the given array.
 * In that then we will create a copy of the old array and then intialize the old array with 0.
 * Then replace all the values which are non zeros in sequence.
 * NOTE : You can't submit this solution on GFG as they don't allow importing Arrays lib.
 * @timeComplexity : O(n)
 * @spaceComplexity: O(n)
 */
void moveAllZerosToEndBruteForce (int arr[], int n){
    int zeroCount = 0;
    for(int i=0;i<n; i++){
        if(arr[i] == 0){
            zeroCount++;
        }
    }

    if(zeroCount ==0 || zeroCount == n){
        return;
    }

    int newArray[n];
    std::copy(arr, arr+n, newArray);

    for(int i=0;i<n;i++){
        arr[i] = 0;
    }

    int newArrayIndex = 0;
    for(int i=0;i<n;i++){
        if(newArray[i] !=0){
            arr[newArrayIndex] = newArray[i];
            newArrayIndex++;
        }
    }
}

/***
 * Better Approach
 * use 2 pointer approach { i, j }
 * Iterate i till you get the first zero. then initialize j with the next element i.e., i+1 and run it till the first non-zero element
 * then swap it and repeat the process.
 * NOTE: Still this may give TLE in longer arrays.
 * @timeComplexity : O(n)
 * @spaceComplexit : O(1)
 */

void moveAllZerosToEndBetterApproach(int arr[], int n){
    if (n == 1)
    {
        return;
    }
    int j;
    for (int i = 0; i < n; i++)
    {
        if (arr[i] == 0)
        {
            j = i + 1;
            while (j < n && arr[j] == 0)
            {
                j++;
            }
            if (j != n)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}

/**
 * Optimised Approach - Divide and Conquer
 * Divide the array in half and perform the swap operation we did in better approach code and then
 * while returning merge the operated arrays.
 * NOTE: This doesn't do it in place
 * @timeComplexity : O(logn)
 * @spaceComplexity : O(n)
 * */
int *pushZerosToEnd(int left[], int right[], int leftSize, int rightSize)
{
    int *processedArray = new int[leftSize + rightSize];
    int leftIndx = 0, rightIndx = 0, k = 0;

    // Merging while maintaining order
    while (leftIndx < leftSize && rightIndx < rightSize)
    {
        if (left[leftIndx] != 0)
        {
            processedArray[k++] = left[leftIndx++];
        }
        else if (right[rightIndx] != 0)
        {
            processedArray[k++] = right[rightIndx++];
        }
        else
        {
            processedArray[k++] = left[leftIndx++];
        }
    }

    // Copy remaining elements
    while (leftIndx < leftSize)
    {
        processedArray[k++] = left[leftIndx++];
    }
    while (rightIndx < rightSize)
    {
        processedArray[k++] = right[rightIndx++];
    }

    return processedArray;
}

// Recursive function to move all zeros to the end
int *moveAllZerosToEndOptimisedApproach(int arr[], int size)
{
    if (size <= 1)
    {
        return arr;
    }

    // Divide array
    int mid = size / 2;
    int *leftArray = new int[mid];
    int *rightArray = new int[size - mid];

    memcpy(leftArray, arr, mid * sizeof(int));                 // Copy first half
    memcpy(rightArray, arr + mid, (size - mid) * sizeof(int)); // Copy second half

    // Recursive calls
    int *leftPartition = moveAllZerosToEndOptimisedApproach(leftArray, mid);
    int *rightPartition = moveAllZerosToEndOptimisedApproach(rightArray, size - mid);

    int *result = pushZerosToEnd(leftPartition, rightPartition, mid, size - mid);

    // Free allocated memory
    delete[] leftArray;
    delete[] rightArray;

    return result;
}

/***
 * Optimised Inplace Approach
 * 2 pointer approach with one pointer always pointing to index of the first zero and iterate over another pointer.
 * Perform Swap everytime you encounter non-zero value for the iterating pointer
 *
 * @timeComplexity: O(n)
 * @spaceComplexity: O(1)
 */

void moveZerosToEndTwoPointersOptimised(int arr[], int n){
    if(n==1){
        return;
    }

    int zeroPointer = 0;
    for(int i=0;i<n;i++){
        if(arr[i]!=0){
            int temp = arr[i];
            arr[i] = arr[zeroPointer];
            arr[zeroPointer] = temp;
            zeroPointer++;
        }
    }
}

void print_array(int arr[], int n)
{
    for(int i=0;i<n; i++){
        cout << arr[i] << " ";
    }
    cout << "\n";
}

int main()
{
    int n;
    cout << "Enter n = ";
    cin >> n;
    int arr[n];

    for(int i=0;i<n;i++){
        cin >> arr[i];
    }

    moveAllZerosToEndBruteForce(arr, n);
    cout << "Output For Brute Force " ;
    print_array(arr, n);

    moveAllZerosToEndBetterApproach(arr, n);
    cout << "Output For Better Approach :  ";
    print_array(arr, n);

    int* result = moveAllZerosToEndOptimisedApproach(arr, n);
    cout << "Output For Optimised without inplace Approach :  ";
    print_array(result, n);

    moveZerosToEndTwoPointersOptimised(arr, n);
    cout << "Output For Optimised Inplace 2 pointer Approach : ";
    print_array(arr, n);

    return 0;
}