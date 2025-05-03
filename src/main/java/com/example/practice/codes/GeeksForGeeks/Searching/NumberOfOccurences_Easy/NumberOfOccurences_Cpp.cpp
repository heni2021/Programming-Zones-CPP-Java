#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

/**
 * Brute Force:
 * Count the frequency of each element in array and then return the frequency of the given element.
 * @timeComplexity:O(n)
 * @spaceComplexity:O(1)
 * @param a
 * @param target
 * @return
 */
int countNumberOfOccurencesUsingBruteForce(vector<int> &a, int target)
{
    unordered_map<int, int> count;
    for (int i = 0; i < a.size(); i++)
    {
        count[a[i]]++;
    }
    return count.at(target);
}

/**
 * Optimised Approach:
 * As it is a sorted array all the occurences of target will be consecutive.
 * So We will count them and then return only that value.
 * @timeComplexity:O(n)
 * @spaceComplexity:O(1)
 */
int countNumberOfOccurencesUsingOptimisedApproach(vector<int> &a, int target)
{
    int count = 0;
    for (int i = 0; i < a.size(); i++)
    {
        if (a[i] == target)
        {
            count++;
        }
    }

    return count;
}

int main(){
    vector<int> a = {1,1,2,2,2,2,3};
    int target;
    cin >> target;
    int occurenceBruteForce = countNumberOfOccurencesUsingBruteForce(a, target);
    cout << "Number of occurences of " << target << " is " <<  occurenceBruteForce << endl;
    int occurenceOptimisedApproach = countNumberOfOccurencesUsingOptimisedApproach(a, target);
    cout << "Number of occurences of " << target << " is " << occurenceOptimisedApproach << endl;
    return 0;
}
// 1 1 2 2 2 2 3