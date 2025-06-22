// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
package com.example.practice.codes.LeetCode.LongestSubstringWithoutRepeatingCharacters_Medium;

import java.util.HashSet;
import java.util.Scanner;

public class LongestSubstringWithoutRepeatingCharacters_Java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int result = findLongestSubstringWithoutRepeatingCharacters(input);
        System.out.println("Length of Longest Substring without repeating characters - "+result);
        sc.close();
    }

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
    private static int findLongestSubstringWithoutRepeatingCharacters(String input) {
        int left = 0, maxLength = 0;
        HashSet<Character> set = new HashSet<>();

        for (int right = 0; right < input.length() ; right++) {
            while(set.contains(input.charAt(right))){
                set.remove(input.charAt(left));
                left++;
            }
            set.add(input.charAt(right));
            maxLength = Math.max(maxLength, right-left+1);
        }

        return maxLength;
    }
}
