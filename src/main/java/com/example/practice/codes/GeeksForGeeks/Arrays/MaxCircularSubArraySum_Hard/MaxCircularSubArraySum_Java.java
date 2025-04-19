package com.example.practice.codes.GeeksForGeeks.Arrays.MaxCircularSubArraySum_Hard;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.*;

public class MaxCircularSubArraySum_Java {
    public static void main(String[] args) {
        int[] a = scanIntArray();
        int maxSumBruteForce = computeMaxSumBruteForce(a);
        System.out.println("Maximum circular subarray sum brute force: "+maxSumBruteForce);

        int maxCircularSum = computeMaxCircularSum(a);
        System.out.println("Maximum circular subarray sum - "+maxCircularSum);
    }

    /**
     * Brute Force
     * Find all possibilites and compute max sum of the circular subarray.
     * @timeComplexity:O(n^2)
     * @spaceComplexity:O(1)
     * @param a
     * @return
     */
    private static int computeMaxSumBruteForce(int[] a){
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            int currentSum = a[i];
            maxSum = Math.max(currentSum, maxSum);
            int k = (i+1 == a.length)? 0 : i+1;
            for (int j = k; j != i; j++) {
                if(i==0 && j==a.length){
                    break;
                }
                if(j==a.length){
                    j=0;
                }
                currentSum +=a[j];
                maxSum = Math.max(currentSum, maxSum);
            }
        }

        return maxSum;
    }

    /**
     * Optimised Approach
     * Find minimum sum and maximum sum in the array of a given subarray using kadane's algorithm.
     * Also compute the total sum.
     * Total sum - Minimum sum will obviously be the circular sum of the array. If total sum and minimum sum are same it means all the elements are negative and it means there is only one way to get max sum is to return maxsum obtained linerly.
     * otherwise return maximum out of maxSum and circularSum.
     * @timeComplexity:O(n)
     * @spaceComplexity:O(1)
     * @param a
     * @return
     */
    private static int computeMaxCircularSum(int[] a) {
        int totalSum = 0;
        int maxSum = a[0], minSum = a[0], circularSum;
        int currMaxSum = 0, currMinSum = 0;
        for (int i = 0; i < a.length; i++) {
            // kadane's algo to find max sum
            currMaxSum = Math.max(currMaxSum + a[i], a[i]);
            maxSum = Math.max(maxSum , currMaxSum);

            // Kadane's algo to find min sum
            currMinSum = Math.min(currMinSum+a[i], a[i]);
            minSum = Math.min(minSum, currMinSum);
            totalSum+=a[i];
        }

        circularSum = totalSum - minSum;

        if(minSum == totalSum){
            return maxSum;
        }

        return Math.max(maxSum, circularSum);
    }
}

// 8 -8 9 -9 10 -11 12
// 10 -3 -4 7 6 5 -4 -1
// -1 40 -14 7 6 5 -4 -1
// 13 7 12 0 -2 5 8
// 12 -1
// -7 32 -11 21 18 35 -26 -17 35 -12 -38 -33 32 16 44 11 -40 -21 2 27 -35 21 -37 -12 1
