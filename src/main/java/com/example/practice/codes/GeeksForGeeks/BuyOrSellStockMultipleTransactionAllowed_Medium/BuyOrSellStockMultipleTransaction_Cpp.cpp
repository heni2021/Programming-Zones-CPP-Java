#include<iostream>
#include<vector>
using namespace std;

/**
 * Brute Force
 * Buy at low and sell at max price to book more profit.
 * buy at the price
 * i  - pointing at price which we can buy stock
 * j - for iteratins
 * compute the diff and check if the profits are increased or not.
 * if they are decreased then add the diff in profit and change i to j and increment j.
 *
 * @timeComplexity:O(n)
 * @spaceComplexity:O(1)
 * */
int buySellStocks(vector<int> &a)
{
    if (a.size() == 1)
    {
        return 0;
    }
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
                profitEarned += currentMaxDiff;
                currentMaxDiff = 0;
                i = j;
            }
            j++;
        }
        else
        {
            i = j;
            j++;
            profitEarned += currentMaxDiff;
            currentMaxDiff = 0;
        }
    }
    if (currentMaxDiff > 0)
    {
        profitEarned += currentMaxDiff;
    }
    return profitEarned;
}

/***
 * Optimised Approach - Simplified Version
 * Add all the differences between the adjacent prices
 * @timeComplexity:O(n)
 * @spaceComplexity:O(1)
 */
int buyOrSellStocksOptimisedApproach(vector<int> &a)
{
    int profitEarned = 0;
    for (int i = 1; i < a.size(); i++)
    {
        if (a[i] > a[i - 1])
        {
            profitEarned += (a[i] - a[i - 1]);
        }
    }
    return profitEarned;
}

int main(){
    vector<int> prices = {100, 180, 260, 310, 40, 535, 695};
    int profitEarned = buySellStocks(prices);
    cout << "Profit Earned using brute force approach- " << profitEarned << endl;

    int profitEarnedOptimised = buyOrSellStocksOptimisedApproach(prices);
    cout << "Profit Earned using optimised force approach- " << profitEarnedOptimised << endl;
    return 0;
}

// 100 180 260 310 40 535 695
// 4 2 2 2 4