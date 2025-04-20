#include<iostream>
#include <unordered_map>
using namespace std;

/**
 * Brute Force
 * Use hash map to count frequencies of the characters and then check if both hashmaps are equal or not
 * @timeComplexity:O(n+m)
 * @spaceComplexity:O(n+m)
 */
bool isAnagramsUsingBruteForceApproach(string s1, string s2)
{
    unordered_map<char, int> frequencyCount1;
    unordered_map<char, int> frequencyCount2;

    for (int i = 0; i < s1.length(); i++)
    {
        frequencyCount1[s1[i]]++;
    }

    for (int i = 0; i < s2.length(); i++)
    {
        frequencyCount2[s2[i]]++;
    }

    for (const auto& pair: frequencyCount1)
    {
        if (pair.second != frequencyCount2.at(pair.first))
        {
            return false;
        }
    }
    return true;
}

/**
 * Optimised Approach
 * Use a character frequency array of length 26. Mark the index as true if you have encountered a character and while parsing second string mark it as false.
 * At end check if all indexes are false.
 * @timeComplexity:O(n+m)
 * @spaceComplexity:O(26)~O(1)
 */
bool isAnagramsUsingOptimisedApproach(string s1, string s2)
{
    int presenceArray[26] = {0};
    for (int i = 0; i < s1.length(); i++)
    {
        presenceArray[s1[i] - 'a'] += 1;
    }

    for (int i = 0; i < s2.length(); i++)
    {
        presenceArray[s2[i] - 'a'] -= 1;
    }

    for (int i = 0; i < 26; i++)
    {
        if (presenceArray[i] != 0)
        {
            return false;
        }
    }
    return true;
}
int main(){
    string s1, s2;

    cin >> s1;
    cin >> s2;
    bool isAnagramBruteForceApproach = isAnagramsUsingBruteForceApproach(s1, s2);
    cout << "String Are Anagrams ? : " << isAnagramBruteForceApproach<< endl;

    bool isAnagramOptimisedApproach = isAnagramsUsingOptimisedApproach(s1, s2);
    cout << "String Are Anagrams ? : " << isAnagramOptimisedApproach << endl;
    return 0;
}

// geeks skeeg
// allergy allergic
// alergy allergy
// geeks keeesg
