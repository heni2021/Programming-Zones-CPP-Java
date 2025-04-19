#include<iostream>
#include<vector>
#include<math.h>
using namespace std;

/**
 * Brute Force!!
 * Compute the product of all permutations of the subarrays possible and find the maximum product.
 * @timeComplexity:O(n^2)
 * @spaceComplexity:O(1)
 * @param a
 * @return
 */
int findProductSubArray(vector<int> &a){
    int maximumProduct = INT32_MIN;
    for (int i = 0; i < a.size(); i++)
    {
        int currentProduct = 1;
        for (int j = i; j < a.size(); j++)
        {
            currentProduct *= a[j];
            maximumProduct = max(currentProduct, maximumProduct);
        }
    }
    return maximumProduct;
}

/**
 * Optimised Approach
 * Compute all 3 products at each index i.e. current minimum, current maximum and the value itself.
 * We use currentMinimum to check that if we encounter any value which is -ve and upon multiplying it turns out to be positive then it should consider that subarray too.
 * @timeComplexity:O(n)
 * @spaceComplexity:O(1)
 * @param a
 * @return
 */
int findProductSubArrayOptimisedApproach(vector<int> &a){
    int maximumProduct = INT32_MIN;
    int currentMaximumProduct = 1;
    int currentMinimumProduct = 1;

    for (int i = 0; i < a.size(); i++)
    {
        int temp = max(a[i], max(a[i] * currentMaximumProduct, a[i] * currentMinimumProduct));
        currentMinimumProduct = min(a[i], min(a[i] * currentMaximumProduct, a[i] * currentMinimumProduct));
        currentMaximumProduct = temp;
        maximumProduct = max(currentMaximumProduct, max(currentMinimumProduct, maximumProduct));
    }

    return maximumProduct;
}

int main(){
    vector<int> a = {-2, 6, -3, -10, 0, 2};
    int productSubArray = findProductSubArray(a);
    cout << "Maximum Product using brute force : " << productSubArray << endl;

    int productSubArrayOptimised = findProductSubArrayOptimisedApproach(a);
    cout <<"Maximum Product using Optimised Approach " << productSubArrayOptimised << endl;
    return 0;
}

// -2 6 -3 -10 0 2
// -1 -3 -10 0 6
// 2 3 4