#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

// Utility function to scan an integer array
vector<int> scanIntArray()
{
    int n;
    cin >> n;
    vector<int> nums(n);
    for (int i = 0; i < n; ++i)
    {
        cin >> nums[i];
    }
    return nums;
}

/**
 * Brute Force Approach
 * Check for each and every possible solution for the sum to become target across the length
 *
 * @param nums   - Input Array
 * @param target - Expected sum
 * @return result[]
 * @timeComplexity : O(n^2)
 * @spaceComplexity : O(1)
 */
vector<int> findTargetSumIndices_BruteForce(vector<int> &nums, int target)
{
    vector<int> result(2);
    for (int i = 0; i < nums.size(); ++i)
    {
        for (int j = i + 1; j < nums.size(); ++j)
        {
            if (nums[i] + nums[j] == target)
            {
                result[0] = i;
                result[1] = j;
                return result;
            }
        }
    }
    return result;
}

/**
 * Better Approach
 * Store indices of each element in a hashmap.
 * Then iterate through the array and subtract number from the target and check that remaining number exists in the array or not?
 *
 * @timeComplexity : O(n)
 * @spaceComplexity : O(1)
 */
vector<int> findTargetSumIndices_OptimisedApproach(vector<int> &nums, int target)
{
    vector<int> result(2);
    unordered_map<int, int> indicesMap;

    for (int i = 0; i < nums.size(); ++i)
    {
        int remaining = target - nums[i];
        if (indicesMap.count(remaining) && indicesMap[remaining] != i)
        {
            result[0] = indicesMap[remaining];
            result[1] = i;
            return result;
        }
        indicesMap[nums[i]] = i;
    }

    return result;
}

int main()
{
    cout << "Enter size of array followed by elements: ";
    vector<int> nums = scanIntArray();

    int target;
    cout << "Enter target: ";
    cin >> target;

    vector<int> resultBrute = findTargetSumIndices_BruteForce(nums, target);
    cout << "Brute Force Result: [" << resultBrute[0] << ", " << resultBrute[1] << "]" << endl;

    vector<int> resultOptimised = findTargetSumIndices_OptimisedApproach(nums, target);
    cout << "Optimized Result: [" << resultOptimised[0] << ", " << resultOptimised[1] << "]" << endl;

    return 0;
}
