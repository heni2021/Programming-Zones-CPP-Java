#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;
/**
 * Brute Force Approach
 * Put the frequency in a hashmap and then repopulate the array.
 *
 * @timeComplexity:O(n)
 * @spaceComplexity:O(m) where m is number of distinct values
 */
int findInvalidIndexSuchThatEachElementOccursAtMostTwice_BruteForce(vector<int> &a)
{
    unordered_map<int,int> frequencyCount;
    // compute the frequency
    for (int j : a)
    {
        frequencyCount[j]++;
    }

    int i = 0;
    for (const auto &pair : frequencyCount)
    {
        int val = pair.first;
        int count = pair.second;

        if (count >= 2)
        {
            a[i] = val;
            a[i + 1] = val;
            i = i + 2;
        }
        else
        {
            a[i] = val;
            i = i + 1;
        }
    }

    return i;
}

/**
 * Expected/ Optimised Approach
 * We assume that the first two element is correctly placed and then iterate i.
 * If I encounter an element which is same as the either of first two element then I replace it and increment the swappable counter.
 *
 * @timeComplexity:O(n)
 * @spaceComplexity:O(1)
 */
int findInvalidIndexSuchThatEachElementOccursAtMostTwice(vector<int> &a)
{
    if (a.size() <= 2)
    {
        return a.size();
    }
    int currentSwapableIndex = 2;
    for (int i = 2; i < a.size(); i++)
    {
        if (a[i] != a[currentSwapableIndex - 2])
        {
            a[currentSwapableIndex] = a[i];
            currentSwapableIndex++;
        }
    }
    return currentSwapableIndex;
}
int main(){
    vector<int> a = {1,1,1,2,2,3};
    vector<int> b = {1,1,1,2,2,3};

    int invalidIndex_bruteForce = findInvalidIndexSuchThatEachElementOccursAtMostTwice_BruteForce(a);
    cout << "Invalid index using brute force : " << invalidIndex_bruteForce << endl;

    int invalidIndex = findInvalidIndexSuchThatEachElementOccursAtMostTwice(b);
    cout << "Invalid index starts from : " << invalidIndex << endl;
}

// 1 1 1 2 2 3
// 0 0 1 1 1 1 2 3 3
