#include <iostream>
#include <vector>
using namespace std;
/**
 * Brute Force
 * Point both the pointers to start of array. Then increase count of the index.
 * @timeComplexity:O(n)
 * @spaceComplexity:O(1)
 * @param a
 * @param b
 * @param k
 * @return
 */
int findElementInMergedArray(vector<int> &a, vector<int> &b, int k)
{
    int i = 0, j = 0, currentIndexFound = -1;
    while (i < a.size() && j < b.size())
    {
        if (a[i] < b[j])
        {
            currentIndexFound++;
            if (currentIndexFound == k - 1)
            {
                return a[i];
            }
            i++;
        }
        else
        {
            currentIndexFound++;
            if (currentIndexFound == k - 1)
            {
                return b[j];
            }
            j++;
        }
    }

    while (i < a.size())
    {
        currentIndexFound++;
        if (currentIndexFound == k - 1)
        {
            return a[i];
        }
        i++;
    }

    while (j < b.size())
    {
        currentIndexFound++;
        if (currentIndexFound == k - 1)
        {
            return b[j];
        }
        j++;
    }

    return -1;
}

int main(){
    vector<int> a = {2,3,6,7,9};
    vector<int> b = {1,4,8,10};
    int k;
    cin >> k;
    int value = findElementInMergedArray(a, b, k);
    cout << "The value at kth position - " << value << endl;
    return 0;
}