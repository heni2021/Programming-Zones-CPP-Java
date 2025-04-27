#include <iostream>
#include <vector>
using namespace std;

int mergeAndCountInversion(vector<int> &a, int left, int right, int mid)
{
    int n1 = mid - left + 1;
    int n2 = right - mid;

    int leftArray[n1];
    int rightArray[n2];

    for (int i = 0; i < n1; i++)
    {
        leftArray[i] = a[i + left];
    }

    for (int i = 0; i < n2; i++)
    {
        rightArray[i] = a[mid + i + 1];
    }

    int result = 0;

    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2)
    {
        if (leftArray[i] <= rightArray[j])
            a[k++] = leftArray[i++];
        else
        {
            a[k++] = rightArray[j++];
            result += (n1 - i);
        }
    }

    // Merge remaining elements
    while (i < n1)
        a[k++] = leftArray[i++];
    while (j < n2)
        a[k++] = rightArray[j++];

    return result;
}

int countInversion(vector<int> &a, int l, int r)
{
    int res = 0;
    if (l < r)
    {
        int m = (r + l) / 2;

        // Recursively count inversions
        // in the left and right halves
        res += countInversion(a, l, m);
        res += countInversion(a, m + 1, r);

        // Count inversions such that greater element is in
        // the left half and smaller in the right half
        res += mergeAndCountInversion(a, l, r, m);
    }
    return res;
}

/**
 * Brute Force:
 * Iterate through all possibilities and compute the count.
 * @timeComplexity:O(n^2)
 * @spaceComplexity:O(1)
 */
int computeInversionsUsingBruteForce(vector<int> &a)
{
    int count = 0;
    for (int i = 0; i < a.size(); i++)
    {
        for (int j = i + 1; j < a.size(); j++)
        {
            if (a[i] > a[j])
            {
                count++;
            }
        }
    }
    return count;
}

/**
 * Optimised Approach
 * Apply the formula of divide and rule and while merging count the inversions i.e. check if the value on LHS is greater than RHS then as both values are sorted in that terms all the value from jth element will be greater so inversion will be n1-j.
 * @timeComplexity:O(n)
 * @spaceComplexity:O(n)
 */
int computeInversionDivdeAndConquerApproach(vector<int> &a)
{
    return countInversion(a, 0, a.size() - 1);
}

int main(){
    vector<int> a = {2,4,1,3,5};
    int inversionsUsingBruteForce = computeInversionsUsingBruteForce(a);
    cout << "Number of inversions - " << inversionsUsingBruteForce << endl;

    int inversionsUsingDivideAndConquer = computeInversionDivdeAndConquerApproach(a);
    cout << "Number of inversions using Divide And Conquer - " << inversionsUsingDivideAndConquer << endl;

    return 0;
}
// 2 4 1 3 5
// 1 2 3 4 5
// 5 4 3 2 1
// 10 10 10