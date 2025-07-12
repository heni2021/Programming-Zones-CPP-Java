#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

/**
 * Brute Force:
 * Copy b in a and then apply sort on the a.
 * @timeComplexity:O(nlogn+m)
 * @spaceComplexity:O(1)
 */
void mergeUsingBruteForce(vector<int> &a, int n, vector<int> &b, int m)
{
    int k = a.size() - 1;
    for (int i = m - 1; i >= 0; i--)
    {
        a[k] = b[i];
        k--;
    }
    sort(a.begin(), a.end());
}

/**
 * Expected Approach:
 * i will be pointing to the last valid element of a.
 * j will be pointing to last valid element of b.
 * k will be pointing to the last position where b can be accomodated in a.
 * if the value in b is greater than a then simply place the value of b at k
 * o/w shift the value of a to the k value and set the value at ith position as 0 which means b can accomodate here.
 * Edge case, if first array is null which means i<0 then simply copy b in a.
 * @timeComplexity:O(n+m)
 * @spaceComplexity:O(1)
 * @param a
 * @param n
 * @param b
 * @param m
 */
void merge(vector<int> &a, int n, vector<int> &b, int m)
{
    int i = n - 1, j = m - 1, k = a.size() - 1;
    while (k >= 0 && j >= 0)
    {
        if (i < 0 || b[j] > a[i])
        {
            a[k] = b[j];
            j--;
            k--;
        }
        else
        {
            a[k] = a[i];
            a[i] = 0;
            k--;
            i--;
        }
    }
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
    vector<int> a = {1,2,3,0,0,0};
    vector<int> b = {2,5,6};
    int n,m;
    cin >> n >> m;

    mergeUsingBruteForce(a, n, b, m);
    merge(a, n, b, m);

    print_vector(a);
    return 0;
}