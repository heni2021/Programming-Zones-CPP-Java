package com.example.practice.codes.GeeksForGeeks.Strings.NonRepeatingCharacter_Easy;

import java.util.Arrays;
import java.util.Scanner;

public class NonRepeatingCharacters_Java {
    public static void main(String[] args) {
        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();

        char nonRepeatingBruteForce = findNonRepeatingUsingBruteForce(s);
        System.out.println("First Non Repeating character using brute force : "+nonRepeatingBruteForce);

        char nonRepeatingBetterApproach = findNonRepeatingUsingBetterApproach(s);
        System.out.println("First Non Repeating character using better approach : "+nonRepeatingBetterApproach);

        char nonRepeatingOptimisedApproach = findNonRepeatingUsingOptimisedApproach(s);
        System.out.println("First Non Repeating character using Optimised approach : "+nonRepeatingOptimisedApproach);

        sc.close();
    }

    /**
     * Brute Force
     * Iterate through 2 loops and find whether the current element is there or not.
     * @timeComplexity:O(n^2)
     * @spaceComplexity:O(1)
     */
    private static char findNonRepeatingUsingBruteForce(String s){
        boolean isFound;
        for (int i = 0; i < s.length(); i++) {
            isFound = false;
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j) && i!=j){
                    isFound = true;
                    break;
                }
            }
            if(!isFound){
                return s.charAt(i);
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
    private static char findNonRepeatingUsingBetterApproach(String s){
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if(frequency[s.charAt(i)-'a'] == 1){
                return s.charAt(i);
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
    private static char findNonRepeatingUsingOptimisedApproach(String s){
        int[] occuringIndex = new int[26];
        Arrays.fill(occuringIndex, -1);
        for (int i = 0; i < s.length(); i++) {
            if(occuringIndex[s.charAt(i)-'a'] == -1){
                occuringIndex[s.charAt(i)-'a'] = i;
            }
            else if(occuringIndex[s.charAt(i)-'a'] >= 0){
                occuringIndex[s.charAt(i)-'a'] = -2;
            }
        }

        int minIndex = Integer.MAX_VALUE;
        char minChar = '$';

        for (int i = 0; i < 26; i++) {
            if(occuringIndex[i] >= 0 && minIndex > occuringIndex[i]){
                minIndex = occuringIndex[i];
                minChar = s.charAt(occuringIndex[i]);
            }
        }

        return minChar;
    }
}
