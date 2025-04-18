#include<iostream>
#include<vector>
#include<math.h>
using namespace std;

/**
 * Brute Force:
 * Explore all sub array sums and find max out of it
 * @timeComplexity:O(n^2)
 * @spaceComplexity:O(1)
 * @param a
 * @return
 */
int findMaximumSumUsingBruteForce(vector<int> &a){
    int sum = INT32_MIN;
    for (int i = 0; i < a.size(); i++)
    {
        int currentSubArraySum = 0;
        for (int j = i; j < a.size(); j++)
        {
            currentSubArraySum += a[j];
            sum = max(currentSubArraySum, sum);
        }
    }

    return sum;
}

/**
 * Optimised Approach - Kadane's Algorithm
 * According to the algorithm, negative sum can never be maximum so as soon as you get negative value then restart consifering new sub array is found
 * @timeComplexity:O(n)
 * @spaceComplexity:O(1)
 * @param a
 * @return
 */
int findMaximumSumUsingKadanesAlgo(vector<int> &a){
    int sum = INT32_MIN;
    int currentSum = 0;
    for (int j : a)
    {
        currentSum += j;
        sum = max(sum, currentSum);
        if (currentSum < 0)
        {
            currentSum = 0;
        }
    }
    return sum;
} 

int main()
{
    vector<int> a = {2, 3, -8, 7, -1, 2, 3};
    int sum = findMaximumSumUsingBruteForce(a);
    cout << "Maximum Sum using brute force : " << sum << endl;

    int sumUsingOptimisedApproach = findMaximumSumUsingKadanesAlgo(a);
    cout << "Maximum sum using kadane's Algo: "  << sumUsingOptimisedApproach << endl;
    return 0;
}

// 2 3 -8 7 -1 2 3
// -2 -4
// 5 4 1 7 8