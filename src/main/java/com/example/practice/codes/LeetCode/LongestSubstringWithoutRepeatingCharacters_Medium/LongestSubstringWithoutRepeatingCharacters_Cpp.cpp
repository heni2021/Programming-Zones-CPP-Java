#include <iostream>
#include <string.h>
#include <unordered_set>
#include <math.h>
using namespace std;
/**
 * Approach :
 * Add elements in a hashset till you encounter a repeating element.
 * Then once u get shorten the window size from left till either left = right or the repeating character is removed.
 * Then add the one repeating character at the right and repeat the process.
 * @timeComplexity : O(n)
 * @spaceComplexity :O(1)
 * @param input - input string
 * @return maxLength - maximum length of substring without repeating characters
 */
int findLongestSubstringWithoutRepeatingCharacters(string input)
{
    int left = 0, maxLength = 0;
    unordered_set<char> set;

    for (int right = 0; right < input.length(); right++)
    {
        while (set.count(input[right]))
        {
            set.erase(input[left]);
            left++;
        }
        set.insert(input[right]);
        maxLength = max(maxLength, right - left + 1);
    }

    return maxLength;
}
int main(){
    string input;
    cin >> input;
    int result = findLongestSubstringWithoutRepeatingCharacters(input);
    cout << "Length of Longest Substring without repeating characters - " << result << endl;
    return 0;
}