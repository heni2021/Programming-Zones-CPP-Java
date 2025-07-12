// https://leetcode.com/problems/running-sum-of-1d-array/description/
#include<iostream>
#include<vector>
using namespace std;
/**
 * Brute Force approach
 * At each index compute the sum till that index and store it.
 * @timeComplexity : O(n)
 * @spaceComplexity : O(n)
 */
vector<int> computeRunningSumOfNums(vector<int> &nums){
    vector<int> result;
    result.push_back(nums[0]);
    for(int i=1;i<nums.size(); i++){
        result.push_back(result[i-1]+nums[i]);
    }
    return result;
}

void print_vector(vector<int> &a)
{
    for (int i = 0; i < a.size(); i++)
    {
        cout << a[i] << " ";
    }
    cout << "\n";
}
int main(){
    vector<int> nums = {1,2,3,4};
    vector<int> resultSum = computeRunningSumOfNums(nums);
    print_vector(resultSum);
    return 0;
}