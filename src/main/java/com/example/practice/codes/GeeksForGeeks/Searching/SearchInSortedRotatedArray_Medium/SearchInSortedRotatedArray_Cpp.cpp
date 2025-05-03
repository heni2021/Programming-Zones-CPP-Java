#include <iostream>
#include <vector>
using namespace std;

/**
 * Brute force
 * Do searching using normal standaradized approach
 * @timeComplexity:O(n)
 * @spaceComplexity:O(1)
 * @param a
 * @param key
 * @return
 */
int findIndexOfTargetElementUsingBruteForce(vector<int>  &a, int key)
{
    for (int i = 0; i < a.size(); i++)
    {
        if (a[i] == key)
        {
            return i;
        }
    }
    return -1;
}

/**
 * Expected Approach:
 * find pivot index and compare it with it
 * if a[i] > key then the key will occur after that else it is in first half of the array
 * @timeComplexity:O(logn)
 * @spaceComplexity:O(1)
 * @param a
 * @param key
 * @return
 */
int findIndexOfTargetElementUsingExpectedApproach(vector<int> &a, int key)
{
    int pivotIndex = 0;
    for (int i = 0; i < a.size() - 1; i++)
    {
        if (a[i] > a[i + 1])
        {
            pivotIndex = i + 1;
            break;
        }
    }

    if (key >= a[pivotIndex] && key <= a[a.size() - 1])
    {
        for (int i = pivotIndex; i < a.size(); i++)
        {
            if (a[i] == key)
            {
                return i;
            }
        }
    }
    else if (key <= a[pivotIndex - 1] && key >= a[0])
    {
        for (int i = 0; i < pivotIndex; i++)
        {
            if (a[i] == key)
            {
                return i;
            }
        }
    }
    return -1;
}

int main(){
    vector<int> a = {1,2,3,4,5};
    int key;
    cin >> key;
    int targetIndexBruteForce = findIndexOfTargetElementUsingBruteForce(a, key);
    int targetIndexUsingExpectedApproach = findIndexOfTargetElementUsingExpectedApproach(a, key);

    cout << "Index using brute force - " << targetIndexBruteForce << endl;
    cout << "Index using expected approach - " << targetIndexUsingExpectedApproach << endl;
    return 0;
}
// 5 6 7 8 9 10 1 2 3
//  1 2 3 4 5
//  12 13 1 2 3 4 5 6 7 8 9 10 11
