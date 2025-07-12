#include <iostream>
#include <math.h>
#include <vector>
using namespace std;

/**
 * Brute Force
 * Compute the sum of each row and find currentMax after it
 * @timeComplexity : O(nxm)
 * @spaceComplexity: O(1)
 */
int computeWealthOfRichestCustomer(vector<vector<int>> &accounts)
{
    int maximumMoney = INT32_MIN;
    for (vector<int> account : accounts)
    {
        int sum = 0;
        for (int j = 0; j < accounts[0].size(); j++)
        {
            sum += account[j];
        }
        maximumMoney = max(maximumMoney, sum);
    }

    return maximumMoney;
}
int main()
{
    vector<vector<int>> accounts = {{1,2,3},{3,2,1}};
    int money = computeWealthOfRichestCustomer(accounts);
    cout << "Wealth of richest customer is - " << money << endl;

    return 0;
}