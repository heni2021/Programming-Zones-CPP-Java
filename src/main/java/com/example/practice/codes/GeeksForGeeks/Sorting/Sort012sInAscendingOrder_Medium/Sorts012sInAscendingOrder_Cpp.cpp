#include<iostream>
#include<unordered_map>
#include <vector>
using namespace std;

void print_vector(vector<int> &a)
{
    for (int i = 0; i < a.size(); i++)
    {
        cout << a[i] << " ";
    }
    cout << "\n";
}
void swapElements(vector<int> &arr, int i, int j)
{
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

/**
 * Brute Force
 * Count frequencies of 0's 1's and 2's and fill the array accordingly.
 * @timeComplexity:O(n)
 * @spaceComplexity:O(1)
 * @param a
 */
void sortArrayUsingBruteForce(vector<int> &a)
{
    unordered_map<int, int> frequencyMap;
    for (int i = 0; i < a.size(); i++)
    {
       frequencyMap[a[i]]++;
    }

    for (int i = 0; i < a.size(); i++)
    {
        if (frequencyMap[0] != 0)
        {
            a[i] = 0;
            frequencyMap[0]--;
        }
        else if (frequencyMap[1] != 0)
        {
            a[i] = 1;
            frequencyMap[1]--;
        }
        else
        {
            a[i] = 2;
        }
    }
}

/**
 * Optimised Approach: Dutuch National Flag Algorithm
 * use 3 pointers: start, mid , end.
 * start - will act as the last postion before which zeros will occur
 * mid - will be the mid of the array acting as a position to occupy 1s
 * end - will be the first position after which 2s will be encountered.
 * In other word -> 0 to start-1 : 0s, start to mid-1 : 1s and mid to end-1 : 2s.
 * @timeComplexity:O(n) - 1pass
 * @spaceComplexity:O(1)
 */

 void sortArrayOptimised(vector<int> &a)
{
    int start = 0, end = a.size() - 1, mid =0;
    while (mid <= end)
    {
        if (a[mid] == 0)
        {
            swapElements(a, start, mid);
            start++;
            mid++;
        }
        else if (a[mid] == 2)
        {
            swapElements(a, mid, end);
            end--;
        }
        else
        {
            mid++;
        }
    }
}
int main(){
    vector<int> a = {0,1,2,0,1,2};

    sortArrayUsingBruteForce(a);
    cout<<"Sorted Array Using brute force : ";
    print_vector(a);
    sortArrayOptimised(a);
    cout << "Sorted Array Using optimised Approach: " ;
    print_vector(a);
    return 0;
}