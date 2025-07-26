// https://leetcode.com/problems/ransom-note/description/
#include <string.h>
#include <iostream>
using namespace std;

/**
 * Brute Force:
 * Count the occurrence of every character in the ransomeNote and then when you encounter the same character in magazine then deduct the occurrence by 1.
 * At the end parse the entire array and check if all the value of character is 0 or not.
 * If any value is non-zero then return false else true.
 *
 * @param ransomeNote
 * @param magazine
 * @return
 * @timeComplexity : O(n)
 * @spaceComplexity : O(26) ~ constant
 */
bool checkIfPossibleToMakeRansomeNoteFromMagazine(string ransomeNote, string magazine)
{
    int characters[26] = {0};
    bool isVisited[26] = {false};
   
    for (int i = 0; i < ransomeNote.size(); i++)
    {
        characters[ransomeNote[i] - 'a']++;
        isVisited[ransomeNote[i] - 'a'] = true;
    }

    for (int i = 0; i < magazine.length(); i++)
    {
        if (isVisited[magazine[i] - 'a'])
        {
            characters[magazine[i] - 'a']--;
        }
    }

    for (int character : characters)
    {
        if (character > 0)
        { // greater than zero because there are still less character occurring for the given characters.
            return false;
        }
    }
    return true;
}

int main() {
    string ransomNote, magazine;
    cin >> ransomNote >> magazine;
    bool isPossible = checkIfPossibleToMakeRansomeNoteFromMagazine(ransomNote, magazine);
    cout << "Can we make ransomeNote from magazine ? - " << isPossible << endl;
    return 0;
}