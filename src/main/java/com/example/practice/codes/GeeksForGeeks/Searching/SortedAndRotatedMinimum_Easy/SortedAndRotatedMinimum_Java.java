package com.example.practice.codes.GeeksForGeeks.Searching.SortedAndRotatedMinimum_Easy;

import java.util.Arrays;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;

public class SortedAndRotatedMinimum_Java {
    public static void main(String[] args) {
        int[] a = scanIntArray();

        int minimumUsingBruteForce = findMinimumUsingBruteForce(a);
        int minimumUsingBetterApproach = findMinimumUsingBetterApproach(a);
        int minimumUsingExpectedApproach = findMinimumUsingExpectedApproach(a);

        System.out.println("Minimum using brute force - "+minimumUsingBruteForce);
        System.out.println("Minimum using better approach - "+minimumUsingBetterApproach);
        System.out.println("Minimum using expected approach - "+minimumUsingExpectedApproach);
    }

    /**
     * Brute Force
     * 1. Sort the array
     * 2. return a[0]
     * @timeComplexity:O(nlogn)
     * @spaceComplexity:O(1)
     * @param a
     * @return
     */
    private static int findMinimumUsingBruteForce(int[] a) {
        Arrays.sort(a);
        return a[0];
    }

    /**
     * Better Approach
     * Compute minimum without sorting with standard approach
     * @timeComplexity:O(n)
     * @spaceComplexity:O(1)
     */
    private static int findMinimumUsingBetterApproach(int[] a){
        int min = Integer.MAX_VALUE;
        for (int j : a) {
            min = Math.min(j, min);
        }
        return min;
    }

    /**
     * Expected Approach
     * As we know array is sorted.
     * So no need to iterate it for whole array. Find pivot element and return it.
     * Iterate the array till a[i] < a[i+1];
     * the moment it fails return a[i]
     * @timeComplexity:O(logn)
     * @spaceComplexity:O(1)
     */
    private static int findMinimumUsingExpectedApproach(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            if(a[i] > a[i+1]){
                return a[i+1];
            }
        }
        return a[0];
    }
}
// 5 6 1 2 3 4
// 3 1 2
// 4 2 3