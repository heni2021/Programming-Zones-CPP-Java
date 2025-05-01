#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

/**
 * Approach
 * Simplest thing we can do is to sort the intervals then pick the current highest end of the interval.
 * if the start of next is less than current end it means remove current and increment count.
 * @timeComplexity:O(nlogn)
 * @spaceComplexity:O(1)
 * @param intervals
 * @return
 */
int removeMinimumIntervals(vector<vector<int>> &intervals)
{
    sort(intervals.begin(), intervals.end(), [](const vector<int> &a, const vector<int> &b)
         {return a[1] < b[1]; });

    int count = 0;
    int end = intervals[0][1];
    for (int i = 1; i < intervals.size(); i++)
    {
        if (intervals[i][0] < end)
            count++;
        else
            end = intervals[i][1];
    }

    // return the count
    return count;
}

int main(){
   vector<vector<int>> intervals = {{1,3}, {1,3}, {1,3}};

    int removeIntervals = removeMinimumIntervals(intervals);
    cout << "Minimum required intervals to remove is - " << removeIntervals << endl;
    return 0;
}

// [[1, 2], [2, 3], [3, 4], [1, 3]]
// [[1, 3], [1, 3], [1, 3]]
// [[1, 2], [5, 10], [18, 35], [40, 45]]