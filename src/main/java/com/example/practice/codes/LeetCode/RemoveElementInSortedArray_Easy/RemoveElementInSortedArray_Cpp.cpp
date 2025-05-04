#include <iostream>
#include <vector>
using namespace std;

/**
 * Expected Optimised Approach.
 * i - points to the current non-duplicated index
 * j - is an iterator to find the next big number from i and then swap it.
 * @timeComplexity:O(n)
 * @spaceComplexity:O(1)
 * @param a
 * @return
 */
int removeDuplicatesUsingOptimisedApproach(vector<int> &a)
{
    int i = 0, j = 0;
    if (a.size() == 1)
    {
        return 1;
    }
    while (i < a.size() - 1)
    {
        if (a[i] == a[i + 1])
        {
            break;
        }
        i++;
    }
    while (j < a.size())
    {
        if (a[j] > a[i])
        {
            i++;
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        j++;
    }
    return i + 1;
}

int main(){
    vector<int> a = {0,0,0,1,1,2,2,3,3,4};
    int index = removeDuplicatesUsingOptimisedApproach(a);
    cout << "Invalid Index starts from : " << index << endl;
    return 0;
}