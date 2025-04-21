#include<iostream>
using namespace std;

/**
 * Brute Force
 * Check at each index if the given string is obtaining after creating substr from the 1st string or not.
 * This will give TLE
 * @timeComplexity:O(n^2)
 * @spaceComplexity:O(n)
 * @param s1
 * @param s2
 * @return
 */
bool checkIfStringsAreRotatedUsingBruteForce(string s1, string s2)
{
    for (int i = 0; i < s1.length(); i++)
    {
        string part1 = s1.substr(0, i);
        string part2 = s1.substr(i);

        if (s2 == part2 + part1)
        {
            return true;
        }
    }

    return false;
}

/**
 * Better Approach
 * m - number of occurences of first character
 * Instead of doing for all the substrings we can do for only those substrings which are starting from the first character of second string.
 * @timeComplexity:O(nxm)
 * @spaceComplexity:O(n)
 */
bool checkIfStringsAreRotatedUsingBetterApproach(string s1, string s2)
{
    for (int i = 0; i < s1.length(); i++)
    {
        if (s1[i] == s2[0])
        {
            string part1 = s1.substr(0, i);
            string part2 = s1.substr(i);

            if (s2 ==  part2 + part1)
            {
                return true;
            }
        }
    }

    return false;
}

/**
 * Optimised Approach
 * Create a new string with s1+s1.
 * Implement KMP Algorithm on the string for the pattern s2.
 * @timeComplexity:O(n+m)
 * @spaceComplexity:O(n)
 */
bool checkIfStringsAreRotatedOptimisedApproach(string s1, string s2)
{
    int lps[s2.length()];
    lps[0] = 0;
    int j = 0, k = j + 1;
    while (j < s2.length() && k < s2.length())
    {
        if (s2[j] == s2[k])
        {
            j++;
            lps[k] = j;
            k++;
        }
        else
        {
            if (j != 0)
            {
                j = lps[j - 1];
            }
            else
            {
                lps[k] = 0;
                k++;
            }
        }
    }

    s1 = s1 + s1;
    j = 0;
    int i = 0;

    while (i < s1.length())
    {
        if (s1[i] == s2[j])
        {
            j++;
            i++;
        }
        if (j == s2.length())
        {
            return true;
        }
        else if (i < s1.length() && s1[i] != s2[j])
        {
            if (j != 0)
            {
                j = lps[j - 1];
            }
            else
            {
                i++;
            }
        }
    }
    return false;
}

int main(){
    string s1, s2;
    cin >> s1 >> s2;

    bool isRotatedUsingBruteForce = checkIfStringsAreRotatedUsingBruteForce(s1, s2);
    cout << "Is Strings Rotated? " << isRotatedUsingBruteForce << endl;

    bool isRotatedUsingBetterApproach = checkIfStringsAreRotatedUsingBetterApproach(s1, s2);
    cout << "Is Strings Rotated? " << isRotatedUsingBetterApproach << endl;

    bool isRotatedUsingOptimisedApproach = checkIfStringsAreRotatedOptimisedApproach(s1, s2);
    cout << "Is Strings Rotated? " << isRotatedUsingOptimisedApproach << endl;

    return 0;
}
 // ncwuvtaxcygwghcvrfpwfdlhyrszzcqxkdfmcvwscytvdnmmmdnkranafryefhhuoccpcukyfesucuanxjtupwsluadxrmujbgdmkyvmjcbpcgfhpcrwrqkeoryrdivyxvjzhxwjvrbrlgipoyxhgzjamrvhqzhguuwuapqi mmdnkranafryefhhuoccpcukyfesucuanxjtupwsluadxrmujbgdmkyvmjcbpcgfhpcrwrqkeoryrdivyxvjzhxwjvrbrlgipoyxhgzjamrvhqzhguuwuapqincwuvtaxcygwghcvrfpwfdlhyrszzcqxkdfmcvwscytvdnm