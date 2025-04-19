#include<iostream>
#include<vector>
#include<math.h>
#include<algorithm>
using namespace std;

void swapElements(vector<int> &arr, int i, int j)
{
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

int shiftPositiveElementsToLeft(vector<int> &a)
{
    int j = 0;
    for (int i = 0; i < a.size(); i++)
    {
        if (a[i] > 0)
        {
            swapElements(a, i, j);
            j++;
        }
    }
    return j;
}

/***
 * Brute Force
 * Iterate the array to find the value of x starting from 1.
 * if you find the value then break and increment the value of x and reiterate the process.
 * if not found then return the value of x
 * @timeComplexity:O(x*n) where x is the missing integer
 * @spaceComplexity:O(1)
 *
 * Note it will give TLE if the missing number is a larger number.
 */
int findSmallestMissingPositiveInteger(vector<int>  &a)
{
    int n = a.size();
    bool isFound = false;
    int x = 1;
    while (!isFound)
    {
        for (int i = 0; i < n; i++)
        {
            if (x == a[i])
            {
                isFound = true;
                break;
            }
        }
        if (isFound)
        {
            x++;
            isFound = false;
        }
        else
        {
            break;
        }
    }

    return x;
}

/**
 * Better Approach
 * 1. Sort the array
 * 2. Ignore negative numbers and use a counter initialized with 1.
 * 3. Iterate through the array and return the first non occuring number.
 * @timeComplexity:O(nlogn)
 * @spaceComplexity:O(1)
 */
int findSmallestMissingPositiveIntegerBetterApproach(vector<int> &a)
{
    sort(a.begin(), a.end());
    int x = 1;
    for (int i = 0; i < a.size(); i++)
    {
        if (a[i] <= 0 || a[i] == x)
        {
            continue;
        }
        else
        {
            if (a[i] != (x + 1))
            {
                return x + 1;
            }
            else
            {
                x++;
            }
        }
    }
    return x + 1;
}

/***
 * Optimised Approach.
 * 1. Shift all positive elements to left and find a pivot index from where either zero or negative numbers are starting.
 * 2. Iterate a loop and negate the elements of the value corresponding to the index.
 * 3. Check for non-negative vale at an index and then return the index.
 * @timeComplexity:O(n)
 * @spaceComplexity:O(1)
 */
int findSmallestMissingPositiveIntegerOptimisedApproach(vector<int> &arr)
{
    int pivotIndex = shiftPositiveElementsToLeft(arr);

    for (int i = 0; i < pivotIndex; i++)
    {
        int value = abs(arr[i]);
        if (value - 1 < pivotIndex && arr[value - 1] > 0)
        {
            arr[value - 1] = -arr[value - 1];
        }
    }

    for (int i = 0; i < pivotIndex; i++)
    {
        if (arr[i] > 0)
        {
            return i + 1;
        }
    }
    return pivotIndex + 1;
}
int main(){
    vector<int> a = {1, -1, -4};
    int value = findSmallestMissingPositiveInteger(a);
    cout << "Smallest Missing integer using brute force is - " << value << endl;

    int valueBetterApproach = findSmallestMissingPositiveIntegerBetterApproach(a);
    cout << "Smallest Missing integer using better approach is - " << valueBetterApproach << endl;

    int valueOptimised = findSmallestMissingPositiveIntegerOptimisedApproach(a);
    cout << "Smallest Missing integer using optimised approach is - " << valueOptimised << endl;
    return 0;
}
// 1 2 3 4 5
// 2 -3 4 1 1 7
// 5 3 2 5 1
// -8 0 -1 -4 -3
// 0 -10 1 3 -20
// 120 1 2 3 4 5 6 7 8 9 10 47 29
// 1 -1 -4