#include<iostream>
#include<vector>
using namespace std;
/**
 * Brute Force : Just Merge two arrays and find median.
 * @timeComplexity : O(n+m)
 * @spaceComplexity : O(n+m)
 * @param nums1 : 1st sorted array with length n
 * @param nums2 - 2nd sorted array with length m
 * @return median of merged array
 */
double findMedianOfTwoSortedArrays_BruteForce(vector<int> &nums1, vector<int> &nums2)
{
    vector<int> mergedArray;
    int i = 0, j = 0;
    while (i < nums1.size() && j < nums2.size())
    {
        if (nums1[i] <= nums2[j])
        {
            mergedArray.push_back (nums1[i]);
            i++;
        }
        else
        {
            mergedArray.push_back(nums2[j]);
            j++;
        }
    }

    while (i < nums1.size())
    {
        mergedArray.push_back(nums1[i]);
        i++;
    }

    while (j < nums2.size())
    {
        mergedArray.push_back(nums2[j]);
        j++;
    }

    if (mergedArray.size() % 2 == 0)
    {
        int first = mergedArray[mergedArray.size() / 2];
        int second = mergedArray[mergedArray.size() / 2 - 1];
        return (first + second) / 2.0;
    }
    else
    {
        return mergedArray[mergedArray.size() / 2];
    }
}
int main(){

    vector<int> nums1 = {1,2};
    vector<int> nums2 = {3,4};

    double result_BruteForce = findMedianOfTwoSortedArrays_BruteForce(nums1, nums2);
    cout << "Median of two sorted Arrays using brute force : " << result_BruteForce << endl;
    return 0;
}