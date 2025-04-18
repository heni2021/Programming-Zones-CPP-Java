#include<iostream>
#include<vector>
#include<math.h>
#include<algorithm>
using namespace std;

/**
 * Brute Force / Optimised
 * Firstly compute the current diff before modifying the array as we want minimum we will not change if the modified array is giving me larger difference
 * then try checking for each element if you get a number smaller than a[0]+k and larger than a[n-1]-k.
 *
 * check if the diff is minimum or not.
 * @timeComplexity:O(n)
 * @spaceCOmplexity:O(1)
 * @param a
 * @param k
 * @return
 */
int getMinimumHeightDifferencBruteForce (vector<int> &a, int k) {
    sort(a.begin(), a.end());
    int ans = a[a.size() - 1] - a[0];
    for (int i = 1; i < a.size(); i++)
    {
        if (a[i] - k < 0)
        {
            continue;
        }

        // finding if I can get the height smaller than the first modified element
        int minHeight = min(a[0] + k, a[i] - k);

        // finding ig I can get the height larger than subtracting k from largest.
        int maxHeight = max(a[a.size() - 1] - k, a[i - 1] + k);
        ans = min(ans, maxHeight - minHeight);
    }
    return ans;
}

int main()
{
    vector<int> a = {1,5,8,10};
    int k;
    cin >> k;
    int height = getMinimumHeightDifferencBruteForce(a, k);
    cout << "Height diff - "  << height << endl;
    return 0;
}

// 1 5 8 10 : 2
// 3 9 12 16 20 : 3
// 1 1 4 6 6 8 9 10 : 7
// 2 4 3 9 9 10 9 7 1 2 : 4
// 3 9 12 16 20 : 3