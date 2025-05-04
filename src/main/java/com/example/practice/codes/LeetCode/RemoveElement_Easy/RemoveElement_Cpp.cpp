#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

/**
 * Brute Force
 * Sort the array
 * Perform swap using 2 pointers placed at starting and end of the array respectively.
 * Re-iterate the array from back and return invalid index.
 * @timeComplexity:O(nlogn+n)
 * @spaceComplexity:O(1)
 * @param a
 * @param val
 * @return
 */
int getIndexUsingBruteForce(vector<int>&a, int val)
{
    sort(a.begin(), a.end());
    int i = 0, j = a.size() - 1;
    while (i < j)
    {
        if (a[i] == val)
        {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            j--;
        }
        i++;
    }

    j = a.size() - 1;
    while (a[j] == val)
    {
        j--;
    }
    return j + 1;
}

/**
 * Optimised/Expected Approach:
 * i- located at first position of occurence of value.
 * j - first position from last which is not equal to value.
 * perform swapping till i!=j.
 * Check if value at i = val return i else return i+1
 * @timeComplexity:O(n)
 * @spaceComplexity:O(1)
 */
int getIndexUsingOptimisedApproach(vector<int>&a, int val)
{
    if (a.size() == 0)
    {
        return 0;
    }
    int i = 0, j = a.size() - 1;
    while (i < a.size() && a[i] != val)
    {
        i++;
    }
    while (j >= 0 && a[j] == val)
    {
        j--;
    }
    while (i < j)
    {
        if (a[i] == val && a[j] != val)
        {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            j--;
            i++;
        }
        else if (a[j] == val)
        {
            j--;
        }
        else
        {
            i++;
        }
    }

    if (i < a.size() && a[i] == val)
    {
        return i;
    }
    else
    {
        return i + 1;
    }
}

int main(){
    vector<int> a = {1,2,3,4};
    int val;
    cin >> val;

    int k = getIndexUsingBruteForce(a, val);
    cout << "Invalid Index starts from - " << k << endl;
    k = getIndexUsingOptimisedApproach(a, val);
    cout << "Invalid Index starts from - " << k << endl;
    return 0;
}