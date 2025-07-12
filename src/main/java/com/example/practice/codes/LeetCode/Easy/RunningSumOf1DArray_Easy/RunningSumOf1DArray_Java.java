// https://leetcode.com/problems/running-sum-of-1d-array/description/
package com.example.practice.codes.LeetCode.Easy.RunningSumOf1DArray_Easy;

import java.util.Arrays;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;

// More like prefix sum of an array.
public class RunningSumOf1DArray_Java {
    public static void main(String[] args) {
        int[] nums = scanIntArray();
        int[] runningSum = computeRunningSumOfNums(nums);
        System.out.println(Arrays.toString(runningSum));
    }

    /**
    * Brute Force approach
    * At each index compute the sum till that index and store it.
    * @timeComplexity : O(n)
    * @spaceComplexity : O(n)
     */
    private static int[] computeRunningSumOfNums(int[] nums) {
        int[] resultSum = new int[nums.length];
        resultSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            resultSum[i] = resultSum[i-1] + nums[i];
        }
        return resultSum;
    }
}
