#include <iostream>
#include <vector>
#include <math.h>
#include <algorithm>
using namespace std;

/**
 * Brute Force
 * 1. Sort the array
 * 2. return a[0]
 * @timeComplexity:O(nlogn)
 * @spaceComplexity:O(1)
 * @param a
 * @return
 */
int findMinimumUsingBruteForce(vector<int> &a)
{
    sort(a.begin(), a.end());
    return a[0];
}

/**
 * Better Approach
 * Compute minimum without sorting with standard approach
 * @timeComplexity:O(n)
 * @spaceComplexity:O(1)
 */
int findMinimumUsingBetterApproach(vector<int> &a)
{
    int minValue = INT32_MAX;
    for (int j : a)
    {
        minValue = min(j, minValue);
    }
    return minValue;
}

/**
 * Expected Approach
 * As we know array is sorted.
 * So no need to iterate it for whole array. Find pivot element and return it.
 * Iterate the array till a[i] < a[i+1];
 * the moment it fails return a[i]
 * @timeComplexity:O(logn)
 * @spaceComplexity:O(1)
 */
int findMinimumUsingExpectedApproach(vector<int> &a)
{
    for (int i = 0; i < a.size() - 1; i++)
    {
        if (a[i] > a[i + 1])
        {
            return a[i + 1];
        }
    }
    return a[0];
}

int main(){
    vector<int> a = {1,2,3,4,5};

    int minimumUsingBruteForce = findMinimumUsingBruteForce(a);
    int minimumUsingBetterApproach = findMinimumUsingBetterApproach(a);
    int minimumUsingExpectedApproach = findMinimumUsingExpectedApproach(a);

    cout << "Minimum using brute force - " << minimumUsingBruteForce << endl;
    cout << "Minimum using better approach - " << minimumUsingBetterApproach << endl;
    cout << "Minimum using expected approach - " << minimumUsingExpectedApproach << endl;
    return 0;
}
// 5 6 1 2 3 4
// 3 1 2
// 4 2 3
// 1 2 3 4 5
// 5 4 3 2 1