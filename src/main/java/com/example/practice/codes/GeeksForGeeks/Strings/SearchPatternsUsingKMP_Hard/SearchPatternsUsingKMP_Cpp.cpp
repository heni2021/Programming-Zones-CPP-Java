#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

vector<int> createLPS(const string &pat)
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
 * As it is mentioned in the problem statement itself that use KMP so no chances to look for other approaches as
 * in pattern matching KMP rules.
 * @timeComplexity:O(n+m)
 * @spaceComplexity:O(m)
 * @param txt
 * @param pat
 * @return
 */
vector<int> findAllOccurrenceOfPatternInText(const string &txt, const string &pat)
{
    vector<int> patternIndexes;
    vector<int> lps = createLPS(pat);

    int i = 0, j = 0;
    while (i < txt.length())
    {
        if (txt[i] == pat[j])
        {
            i++;
            j++;
            if (j == pat.length() && i != txt.length())
            {
                patternIndexes.push_back(i - pat.length());
                j = lps[j - 1];
                i--; // to recheck the current character in the next loop
            }
        }

        if (i < txt.length() && txt[i] != pat[j])
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

    if (j == pat.length())
    {
        int lastIndex = txt.length() - pat.length();
        if (std::find(patternIndexes.begin(), patternIndexes.end(), lastIndex) == patternIndexes.end())
        {
            patternIndexes.push_back(lastIndex);
        }
    }

    return patternIndexes;
}

int main()
{
    string txt, pat;
    cout << "Enter text: ";
    getline(cin, txt);
    cout << "Enter pattern: ";
    getline(cin, pat);

    vector<int> patternIndexes = findAllOccurrenceOfPatternInText(txt, pat);

    cout << "Pattern occurs at - [";
    for (size_t i = 0; i < patternIndexes.size(); ++i)
    {
        cout << patternIndexes[i];
        if (i != patternIndexes.size() - 1)
            cout << ", ";
    }
    cout << "]" << endl;

    return 0;
}

// abcab ab
// aabaacaadaabaaba aaba