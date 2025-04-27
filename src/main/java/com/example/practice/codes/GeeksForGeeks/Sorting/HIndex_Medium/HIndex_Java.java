package com.example.practice.codes.GeeksForGeeks.Sorting.HIndex_Medium;

import java.util.Arrays;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;

public class HIndex_Java {
    public static void main(String[] args) {
        int[] citations = scanIntArray();

        int hIndexUsingBruteForce = computeHIndexUsingBruteForce(citations);
        System.out.println("H-Index using brute force - "+hIndexUsingBruteForce);
    }

    /**
     * Optimised Approach
     * 1. Compute maximum number of the citations.
     * 2. Then declare a frequency array of length maximumNumber+1.
     * 3. Then iterate through back array and compute the sum and check if the number is greater than or equal to the index value.
     * @timeComplexity:O(n)
     * @spaceComplexity:O(n)
     * @param citations
     * @return
     */

    private static int computeHIndexUsingBruteForce(int[] citations) {
        int maxNumber = 0;
        // Find maximum number
        for (int i = 0; i < citations.length; i++) {
            maxNumber = Math.max(maxNumber, citations[i]);
        }

        // Fill the frequency array
        int[] frequency = new int[maxNumber+1];
        Arrays.fill(frequency, 0);
        for (int i = 0; i < citations.length; i++) {
            frequency[citations[i]]++;
        }

        // Compute H-Index.
        int currentSum = 0;
        for (int i = frequency.length-1; i >=0 ; i--) {
            currentSum+=frequency[i];
            if(currentSum >= i){
                return i;
            }
        }
        return 0;
    }
}
// 3 0 5 3 0
// 5 1 2 4 1
// 0 0