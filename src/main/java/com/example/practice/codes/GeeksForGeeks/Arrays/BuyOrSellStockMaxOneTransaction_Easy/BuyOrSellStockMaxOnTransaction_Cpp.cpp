#include<iostream>
#include<vector>
#include<math.h>
using namespace std;

/**
 * Brute Force Approach
 * Summary - Buy at low and sell at highest price and check if the current earned profit is greater than the previous or not.
 * We will compute diff and check if it is greater than currentMaxDiff.
 * if yes update currentMaxDiff
 * other wise it is not possible to buy stock at current price so update the price.
 * @timeComplexity:O(n)
 * @spaceComplexity:O(1)
 * @param a
 * @return profits
 */
int buySellStocksWithSingleTransaction(vector<int> &a)
{
    int profitEarned = 0;
    int currentMaxDiff = 0;
    int i = 0, j = i + 1;
    while (i < a.size() && j < a.size())
    {
        int diff = a[j] - a[i];
        if (diff > 0)
        {
            if (diff >= currentMaxDiff)
            {
                currentMaxDiff = diff;
            }
            else
            {
                if (currentMaxDiff >= profitEarned)
                {
                    profitEarned = currentMaxDiff;
                    currentMaxDiff = 0;
                }
            }
        }
        else
        {
            i = j;
            if (currentMaxDiff >= profitEarned)
            {
                profitEarned = currentMaxDiff;
                currentMaxDiff = 0;
            }
        }
        j++;
    }

    if (currentMaxDiff >= profitEarned)
    {
        profitEarned = currentMaxDiff;
    }

    return profitEarned;
}

/***
 * Optimised and simplified approach
 * Find minimum value index and then find the maximum value which is occuring after minimum value. if not return 0 else return diff.
 * @timeComplexity:O(n)
 * @spaceComplexity:O(1)
 */
int buySellStocksWithSingleTransactionOptimised(vector<int> &prices)
{
    int minimumPriceIndex = 0;
    int currentMinValue = prices[0];
    for (int i = 0; i < prices.size(); i++)
    {
        if (currentMinValue > prices[i])
        {
            currentMinValue = prices[i];
            minimumPriceIndex = i;
        }
    }
    int afterMax = currentMinValue;
    for (int i = minimumPriceIndex + 1; i < prices.size(); i++)
    {
        afterMax = max(afterMax, prices[i]);
    }
    return afterMax - currentMinValue;
}
int main(){
    vector<int> prices = {7,10,1,3,6,9,2};
    int profitEarned = buySellStocksWithSingleTransaction(prices);
    cout << "Profit Earned using brute force approach- " << profitEarned << endl;

    int profitEarnedOptimised = buySellStocksWithSingleTransactionOptimised(prices);
    cout << "Profit Earned using optimised force approach- " << profitEarnedOptimised << endl;
    return 0;
}

// 7 10 1 3 6 9 2
// 7 1 5 3 6 4
// 7 6 4 3 1