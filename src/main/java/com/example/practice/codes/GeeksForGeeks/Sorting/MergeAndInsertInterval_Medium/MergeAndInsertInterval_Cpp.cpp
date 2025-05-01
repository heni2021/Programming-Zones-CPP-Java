#include <iostream>
#include <math.h>
#include <vector>
using namespace std;

/**
 * Approach:
 * Add all the intervals which are ending with the value lesser than the new interval starting range.
 * Add all non overlapping intervals and keep updating newInterval values.
 * Then add all remaining intervals.
 * @timeComplexity:O(n)
 * @spaceComplexity:O(n)
 * @param intervals
 * @param newInterval
 * @return
 */
vector<vector<int>> mergeAndInsertIntervals(vector<vector<int>> intervals, vector<int> newInterval)
{
    vector<vector<int>> result;
    int n = intervals.size();
    int i = 0;
    while (i < n && intervals[i][1] < newInterval[0])
    {
        result.push_back(intervals[i]);
        i++;
    }

    while (i < n && intervals[i][0] <= newInterval[1])
    {
        newInterval[0] = min(intervals[i][0], newInterval[0]);
        newInterval[1] = max(intervals[i][1], newInterval[1]);
        i++;
    }
    result.push_back(newInterval);

    while (i < n)
    {
        result.push_back(intervals[i]);
        i++;
    }
    return result;
}

int main(){
    vector<vector<int>> intervals = {{1,3},{4,5},{6,7},{8,10}};
    vector<int> newInterval = {5,7};
    vector<vector<int>> result = mergeAndInsertIntervals(intervals, newInterval);
    cout << "Merged Intervals: [";
    for (int i = 0; i < result.size(); i++)
    {
        cout << "[" << result[i][0] << ", " << result[i][1] << "]";
    }
    cout << "]" << endl;
    return 0;
}