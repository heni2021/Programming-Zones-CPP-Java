package com.example.practice.codes.GeeksForGeeks.Strings.MinCharsToMakePalindrome_Hard;

import java.util.Scanner;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.isPalindromeString;

public class MinCharsToMakePalindrome_Java {
    public static void main(String[] args) {
        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();

        int charCount = computeMinCharsRequiredToMakePalindrome(s);
        System.out.println("Min chars required - "+charCount);

        int charCountKMP = computeMinCharsRequiredToMakePalindromeUsingKMPAlgorithm(s);
        System.out.println("Min chars required using KMP - "+charCountKMP);

        sc.close();
    }

    /**
     * Brute Force
     * Check for the longest palindrome starting from index 0.
     * Return the number of characters you exclude to get the longest palindrome
     * @timeComplexity:O(n^2)
     * @spaceComplexity:O(1)
     */

    private static int computeMinCharsRequiredToMakePalindrome(String s) {
        int excludedChar = 0;
        int start = 0, end = s.length()-1;
        while(start < end){
            if(!isPalindromeString(s, start, end)){
                end--;
                excludedChar++;
            }
            else{
                break;
            }
        }

        return excludedChar;
    }


    /**
     * Optimised Approach : KMP Algorithm
     * Append reversal strings in the original string with a special characters.
     * i.e. s = s + '$' + reverse(s)
     * compute lps and the highest value in lps subtract it from length which gives the longest prefix which is also a suffix.
     * @timeComplexity:O(n)
     * @spaceComplexity:O(n)
     */
    private static int computeMinCharsRequiredToMakePalindromeUsingKMPAlgorithm(String s){
        StringBuilder sb = new StringBuilder(s);
        int n = s.length();
        sb.reverse();
        s = s + "$"+ sb.toString();
        int[] lps = computeLPS(s);
        return n - lps[s.length()-1];
    }

    private static int[] computeLPS(String s) {
        int[] lps = new int[s.length()];
        int patLen = 0, i = patLen+1;

        while(i<s.length()){
            if(s.charAt(i) == s.charAt(patLen)){
                patLen++;
                lps[i] = patLen;
                i++;
            }
            else{
                if(patLen != 0){
                    patLen = lps[patLen-1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
