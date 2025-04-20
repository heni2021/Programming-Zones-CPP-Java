#include<iostream>
#include<math.h>
using namespace std;

/**
 * Brute Force
 * Iterate through 2 loops and find whether the current element is there or not.
 * @timeComplexity:O(n^2)
 * @spaceComplexity:O(1)
 */
char findNonRepeatingUsingBruteForce(string s)
{
    bool isFound;
    for (int i = 0; i < s.length(); i++)
    {
        isFound = false;
        for (int j = 0; j < s.length(); j++)
        {
            if (s[i] == s[j] && i != j)
            {
                isFound = true;
                break;
            }
        }
        if (!isFound)
        {
            return s[i];
        }
    }
    return '$';
}

/**
 * Better Approach
 * Find the frequency of each element and store it in an array of 26 length.
 * check the first element whose frequency is one and if noone then return $.
 * @timeComplexity:O(n)
 * @spaceComplexity:O(26)~O(1):constant
 */
char findNonRepeatingUsingBetterApproach(string s)
{
    int frequency[26] = {0};
    for (int i = 0; i < s.length(); i++)
    {
        frequency[s[i] - 'a']++;
    }

    for (int i = 0; i < s.length(); i++)
    {
        if (frequency[s[i] - 'a'] == 1)
        {
            return s[i];
        }
    }
    return '$';
}

/**
 * Optimised Approach
 * Create a frequency array then store the first occuring index of each char.
 * If a char is repeating then reset the index to -2.
 * At last iterate to frequency array to check if you have any positive minimum integer or not.
 * @timeComplexity:O(n)
 * @spaceComplexity:O(26)~O(1):constant
 */
char findNonRepeatingUsingOptimisedApproach(string s)
{
    int occuringIndex[26];
    for (int i = 0; i < 26; i++)
    {
        occuringIndex[i] = -1;
    }
    
    for (int i = 0; i < s.length(); i++)
    {
        if (occuringIndex[s[i] - 'a'] == -1)
        {
            occuringIndex[s[i] - 'a'] = i;
        }
        else if (occuringIndex[s[i] - 'a'] >= 0)
        {
            occuringIndex[s[i] - 'a'] = -2;
        }
    }

    int minIndex = INT32_MAX;
    char minChar = '$';

    for (int i = 0; i < 26; i++)
    {
        if (occuringIndex[i] >= 0 && minIndex > occuringIndex[i])
        {
            minIndex = occuringIndex[i];
            minChar = s[minIndex];
        }
    }

    return minChar;
}

int main(){
    string s;
    cin >> s;

    char nonRepeatingBruteForce = findNonRepeatingUsingBruteForce(s);
    cout << "First Non Repeating character using brute force : " << nonRepeatingBruteForce << endl;

    char nonRepeatingBetterApproach = findNonRepeatingUsingBetterApproach(s);
    cout << "First Non Repeating character using better approach : " << nonRepeatingBetterApproach << endl;

    char nonRepeatingOptimisedApproach = findNonRepeatingUsingOptimisedApproach(s);
    cout << "First Non Repeating character using Optimised approach : " << nonRepeatingOptimisedApproach << endl;
    return 0;
}