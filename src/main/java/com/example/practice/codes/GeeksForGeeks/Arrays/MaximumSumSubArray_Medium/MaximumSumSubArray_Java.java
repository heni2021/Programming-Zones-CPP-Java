package com.example.practice.codes.GeeksForGeeks.Arrays.MaximumSumSubArray_Medium;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;

public class MaximumSumSubArray_Java {
    public static void main(String[] args) {
        int[] a = scanIntArray();

        int sum = findMaximumSumUsingBruteForce(a);
        System.out.println("Maximum Sum using brute force : "+sum);

        int sumUsingOptimisedApproach = findMaximumSumUsingKadanesAlgo(a);
        System.out.println("Maximum sum using kadane's Algo: "+sumUsingOptimisedApproach);
    }

    /**
     * Brute Force:
     * Explore all sub array sums and find max out of it
     * @timeComplexity:O(n^2)
     * @spaceComplexity:O(1)
     * @param a
     * @return
     */
    private static int findMaximumSumUsingBruteForce(int[] a) {
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            int currentSubArraySum = 0;
            for (int j = i; j < a.length; j++) {
                currentSubArraySum+=a[j];
                sum = Math.max(currentSubArraySum, sum);
            }
        }

        return sum;
    }

    /**
     * Optimised Approach - Kadane's Algorithm
     * According to the algorithm, negative sum can never be maximum so as soon as you get negative value then restart consifering new sub array is found
     * @timeComplexity:O(n)
     * @spaceComplexity:O(1)
     * @param a
     * @return
     */
    private static int findMaximumSumUsingKadanesAlgo(int[] a) {
        int sum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int j : a) {
            currentSum += j;
            sum = Math.max(sum, currentSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return sum;
    }
}
// 2 3 -8 7 -1 2 3
// -2 -4
// 5 4 1 7 8
//