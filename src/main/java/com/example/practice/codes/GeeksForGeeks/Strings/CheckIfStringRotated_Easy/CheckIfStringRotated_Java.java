package com.example.practice.codes.GeeksForGeeks.Strings.CheckIfStringRotated_Easy;

import java.util.Scanner;

public class CheckIfStringRotated_Java {
    public static void main(String[] args) {
        String s1, s2;
        Scanner sc = new Scanner(System.in);
        s1 = sc.nextLine();
        s2 = sc.nextLine();

        boolean isRotatedUsingBruteForce = checkIfStringsAreRotatedUsingBruteForce(s1, s2);
        System.out.println("Is Strings Rotated? "+isRotatedUsingBruteForce);

        boolean isRotatedUsingBetterApproach = checkIfStringsAreRotatedUsingBetterApproach(s1, s2);
        System.out.println("Is Strings Rotated? "+isRotatedUsingBetterApproach);

        boolean isRotatedUsingOptimisedApproach = checkIfStringsAreRotatedOptimisedApproach(s1, s2);
        System.out.println("Is Strings Rotated? "+isRotatedUsingOptimisedApproach);

        sc.close();
    }

    /**
     * Brute Force
     * Check at each index if the given string is obtaining after creating substring from the 1st string or not.
     * This will give TLE
     * @timeComplexity:O(n^2)
     * @spaceComplexity:O(n)
     * @param s1
     * @param s2
     * @return
     */
    private static boolean checkIfStringsAreRotatedUsingBruteForce(String s1, String s2){
        for (int i = 0; i < s1.length(); i++) {
            String part1 = s1.substring(0, i);
            String part2 = s1.substring(i);

            if(s2.equals(part2+part1)){
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
    private static boolean checkIfStringsAreRotatedUsingBetterApproach(String s1, String s2){
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) == s2.charAt(0)) {
                String part1 = s1.substring(0, i);
                String part2 = s1.substring(i);

                if (s2.equals(part2 + part1)) {
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
    private static boolean checkIfStringsAreRotatedOptimisedApproach(String s1, String s2){
        int[] lps = new int[s2.length()];
        int j = 0, k = j+1;
        while(j<s2.length() && k<s2.length()){
            if(s2.charAt(j) == s2.charAt(k)){
                j++;
                lps[k] = j;
                k++;
            }
            else{
                if(j!=0){
                    j = lps[j-1];
                }
                else{
                    lps[k] = 0;
                    k++;
                }
            }
        }

        s1 = s1+s1;
        j = 0;
        int i=0;

        while(i<s1.length()){
            if(s1.charAt(i) == s2.charAt(j)){
                j++;
                i++;
            }
            if(j==s2.length()){
                return true;
            }
            else if(i<s1.length() && s1.charAt(i) != s2.charAt(j)){
                if(j!=0){
                    j = lps[j-1];
                }
                else{
                    i++;
                }
            }
        }
        return false;
    }

}
