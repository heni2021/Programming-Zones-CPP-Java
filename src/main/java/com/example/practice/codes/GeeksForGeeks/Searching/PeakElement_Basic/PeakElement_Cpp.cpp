#include <iostream>
#include <vector>
using namespace std;

/**
 * Brute Force
 * Apply normal logic for comparision across the array
 * @timeComplexity:O(n)
 * @spaceComplexity:O(1)
 * @param a
 * @return
 */
int IsPeakElementExists(vector<int> &a)
{
    if (a.size() == 1)
    {
        return 0;
    }
    for (int i = 0; i < a.size() - 1; i++)
    {
        if (i == 0)
        {
            if (a[i] > a[1])
            {
                return i;
            }
        }
        else
        {
            if (a[i] > a[i - 1] && a[i] > a[i + 1])
            {
                return i;
            }
        }
    }
    if (a[a.size() - 1] > a[a.size() - 2])
    {
        return a.size() - 1;
    }
    return 0;
}

/**
 * Optimised Approach : Binary Search
 * Perform binary search on the array starting from index 1 to length -1.
 * If I get a[mid] > a[mid+1] ---> guaranteed peak element is in right so shift low.
 * else peak element is in left so shift high.
 * Iterate loop while low <= high
 * @timeComplexity:O(logn)
 * @spaceComplexity:O(1)
 */
int findPeakElementUsingBinarySearch(vector<int> &arr)
{
    int n = arr.size();

    // If there is only one element, then it's a peak
    if (n == 1)
        return 0;

    // Check if the first element is a peak
    if (arr[0] > arr[1])
        return 0;

    // Check if the last element is a peak
    if (arr[n - 1] > arr[n - 2])
        return n - 1;

    // Search Space for binary Search
    int low = 1, high = n - 2;
    while (low <= high)
    {
        int mid = low + (high - low) / 2;
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
        {
            return mid;
        }
        if (arr[mid] < arr[mid + 1])
        {
            low = mid + 1;
        }
        else
        {
            high = mid - 1;
        }
    }
    return 0;
}
int main(){
    vector<int> a = {1,2,3};
    int peakElementExists = IsPeakElementExists(a);
    cout << "Peak element exists - " << peakElementExists << endl;

    int optimisedPeakElement = findPeakElementUsingBinarySearch(a);
    cout << "Peak element using optimised - " << optimisedPeakElement << endl;
    return 0;
}