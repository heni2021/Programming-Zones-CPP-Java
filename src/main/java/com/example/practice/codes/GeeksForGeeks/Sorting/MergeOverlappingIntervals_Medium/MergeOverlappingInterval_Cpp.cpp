#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

vector<vector<int>> mergeIntervals(vector<vector<int>> &intervals)
{
    sort(intervals.begin(), intervals.end(), [](const vector<int> &a, const vector<int> &b)
         {
        if (a[0] != b[0])
            return a[0] < b[0];
        else
            return a[1] < b[1]; });

    vector<vector<int>> result;
    result.push_back(intervals[0]);
    int k = 0; // points to the latest result

    for (int i = 1; i < intervals.size(); ++i)
    {
        if (result[k][1] >= intervals[i][0])
        {
            if (result[k][1] <= intervals[i][1])
            {
                result[k][1] = intervals[i][1];
            }
            // No need to remove and re-add like Java; directly modify in C++
        }
        else
        {
            result.push_back(intervals[i]);
            k++;
        }
    }

    return result;
}

int main(){
    vector<vector<int>> intervals = {{6,8},{1,9},{2,4},{4,7}};

    vector<vector<int>> mergedIntervals = mergeIntervals(intervals);
    cout << "Merged Intervals: [";
    for (int i = 0; i < mergedIntervals.size(); i++)
    {
        cout << "[" << mergedIntervals[i][0] << ", " << mergedIntervals[i][1] << "]";
    }
    cout << "]" << endl;

    return 0;
}
//[[6,8],[1,9],[2,4],[4,7]]
//[[1,3], [2,4], [6,8], [9,10]]