#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void print_array(int arr[], int n)
{
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
    cout << "\n";
}

void print_vector(vector<int> &a){
    for (int i = 0; i < a.size(); i++)
    {
        cout << a[i] << " ";
    }
    cout << "\n";
}

void swapElements(vector<int> &arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

void reverseElementsInArray(vector<int> &arr, int startIndex, int endIndex)
{
    while (startIndex < endIndex)
    {
       swapElements(arr, startIndex++, endIndex--);
    }
}

/**
 * Brute Force Approach
 * Find the index at which next permutation can be made it has to be from back and store the index say i by iterating from back while j <= i.
 * from (i+1)th index start traversing to find an element which is greater than the element at i but less than the last max element you found.
 * Idea is to find the element which is just greater than the element at i and not necessary the max element.
 * Then perform swap between that element and the element at index i.
 * Perform ascending sort from (i+1)th element to rest of the array.
 *
 * Edge case : If you reach -1th index then just return sorted array it means you have reached the biggest possible permutation.
 * @timeComplexity: O(nlogn)
 * @spaceComplexity: O(1)
 * */
void findNextPermutation(vector<int> &arr){
    if(arr.size() == 1){
        return;
    }
    int i = arr.size()-2, j = arr.size()-1;

    while(i!=-1 && arr[j] <= arr[i]){
        i--;
        j--;
    }
    if(i==-1){
        std::sort(arr.begin(),arr.end());
        return;
    }

    int swapIndex = i, nextMaxIndex = i+1;
    i=i+1;
    while(i<arr.size()){
        if(arr[i] > arr[swapIndex] && arr[i] < arr[nextMaxIndex]){
            nextMaxIndex = i;
        }
        i++;
    }

    swapElements(arr, swapIndex, nextMaxIndex);
    std:sort(arr.begin()+swapIndex+1, arr.end());
}

/**
 * Optimised Approach
 * Instead of sorting we can use reversal of indexes to reduce time complexity.
 * @timeComplexity = O(n)
 * @spaceComplexity = O(1)
 * */

void findNextPermutationOptimised(vector<int> &a)
{
    if (a.size() == 1)
    {
        return;
    }
    int i = a.size() - 2;
    while (i >= 0 && a[i] >= a[i + 1])
    {
        i--;
    }
    if (i >= 0)
    {
        i = i + 1;
        int j = a.size() - 1;
        while (i != j && a[j] <= a[i])
        {
            j--;
        }
        if (i == j)
        {
            swapElements(a, i - 1, j);
        }
        else
        {
            swapElements(a, i, j);
        }
    }
    // perform sorting from swapIndex+1 to a.length
    reverseElementsInArray(a, i + 1, a.size() - 1);
}

int main() {
    vector<int> a = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    cout << "Next Permutation 1st - ";
    findNextPermutation(a);
    print_vector(a);

    cout << "Next Permutation 2nd - ";
    findNextPermutationOptimised(a);
    print_vector(a);

    return 0;
}