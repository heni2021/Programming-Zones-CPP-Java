#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

/**
 * Brute force:
 * Store the sorted array with the logic of merge sort in another array and then copy it in the previous 2 arrays.
 * NOTE : This is not a valid approach as it is mentioned to use O(1) space.
 * @timeComplexity:O(n)
 * @spaceComplexity:O(n)
 * @param a
 * @param b
 */
void mergeArraysBruteForce(vector<int> &a, vector<int> &b)
{
    int i = 0, j = 0, k = 0;
    int result[a.size() + b.size()];
    int n = a.size(), m = b.size();
    while (i < n & j < m)
    {
        if (a[i] <= b[j])
        {
            result[k] = a[i];
            i++;
            k++;
        }
        else
        {
            result[k] = b[j];
            j++;
            k++;
        }
    }

    while (i < n)
    {
        result[k] = a[i];
        i++;
        k++;
    }

    while (j < m)
    {
        result[k] = b[j];
        j++;
        k++;
    }

    i = 0;
    j = 0;
    k = 0;
    while (i < n)
    {
        a[i] = result[k];
        i++;
        k++;
    }
    while (j < m)
    {
        b[j] = result[k];
        j++;
        k++;
    }
}

/**
 * Optimised approach
 * i will reverse traverse and j will traverse from start.
 * @timeComplexity:O(nlogn+mlogn)
 * @spaceComplexity:O(1)
 */
void mergeArrayWithoutExtraSpace(vector<int> &a, vector<int> &b)
{
    int n = a.size(), m = b.size();
    int i = n - 1, j = 0;
    while (i >= 0 && j < m)
    {
        if (a[i] > b[j])
        {
            int temp = a[i];
            a[i] = b[j];
            b[j] = temp;
            j++;
            i--;
        }
        else
        {
            i--;
        }
    }

    sort(a.begin(), a.end());
    sort(b.begin(), b.end());
}

void print_vector(vector<int> arr, int n)
{
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
    cout << "\n";
}

int main(){
    vector<int> a = {0,1,3,5,5,5,6,6};
    vector<int> b = {0,2,4,8};

    mergeArraysBruteForce(a, b);
    mergeArrayWithoutExtraSpace(a, b);
    print_vector(a, a.size());
    print_vector(b, b.size());
    return 0;
}

// 2 4 7 10 & 2 3
// 1 5 9 10 15 20 & 2 3 8 13
// 0 1 & 2 3
// 0 1 3 5 5 5 6 6 & 0 2 4 8