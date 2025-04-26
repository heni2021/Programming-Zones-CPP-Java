#include <iostream>
#include <algorithm>
#include <string>
#include <bits/stdc++.h>
#include <vector>
using namespace std;

bool isPalindromeString(string s, int i, int j){
    while(i < j){
        if(s[i] == s[j]){
            i++;
            j--;
        }
        else{
            return false;
        }
    }

    return true;
}

/**
 * Brute Force
 * Check for the longest palindrome starting from index 0.
 * Return the number of characters you exclude to get the longest palindrome
 * @timeComplexity:O(n^2)
 * @spaceComplexity:O(1)
 */
int computeMinCharsRequiredToMakePalindrome(string s)
{
    int excludedChar = 0;
    int start = 0, end = s.length() - 1;
    while (start < end)
    {
        if (!isPalindromeString(s, start, end))
        {
            end--;
            excludedChar++;
        }
        else
        {
            break;
        }
    }

    return excludedChar;
}

void print_vector(vector<int> &a)
{
    for (int i = 0; i < a.size(); i++)
    {
        cout << a[i] << " ";
    }
    cout << "\n";
}

vector<int> computeLPS(const string &pat)
{

    int m = pat.length();
    vector<int> lps(m, 0);

    int len = 0;
    int i = 1;
    while (i < m)
    {
        if (pat[i] == pat[len])
        {
            len++;
            lps[i] = len;
            i++;
        }
        else
        {
            if (len != 0)
            {
                len = lps[len - 1];
            }
            else
            {
                lps[i] = 0;
                i++;
            }
        }
    }

    return lps;
}
    /**
     * Optimised Approach : KMP Algorithm
     * Append reversal strings in the original string with a special characters.
     * i.e. s = s + '$' + reverse(s)
     * compute lps and the highest value in lps subtract it from length which gives the longest prefix which is also a suffix.
     * @timeComplexity:O(n)
     * @spaceComplexity:O(n)
     */
    int computeMinCharsRequiredToMakePalindromeUsingKMPAlgorithm(string s)
{
    int n = s.length();
    string rev = s;
    reverse(rev.begin(), rev.end());

    string combined = s + "$" + rev;
    vector<int> lps = computeLPS(combined);

    return n - lps.back(); // lps[combined.length() - 1]
}

int main(){
    string s;
    cin >> s;

    int charCount = computeMinCharsRequiredToMakePalindrome(s);
    cout << "Min chars required - " << charCount << endl;

    int charCountKMP = computeMinCharsRequiredToMakePalindromeUsingKMPAlgorithm(s);
    cout << "Min chars required using KMP - " << charCountKMP << endl;

    return 0;
}