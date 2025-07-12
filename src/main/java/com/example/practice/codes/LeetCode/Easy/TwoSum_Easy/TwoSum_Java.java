// https://leetcode.com/problems/two-sum/description/
package com.example.practice.codes.LeetCode.Easy.TwoSum_Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;

public class TwoSum_Java {
    public static void main(String[] args) {
        int[] nums = scanIntArray();
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int[] resultIndices_BruteForce = findTargetSumIndices_BruteForce(nums, target);
        System.out.println(Arrays.toString(resultIndices_BruteForce));

        int[] resultIndices_OptimisedApproach = findTargetSumIndices_OptimisedApproach(nums, target);
        System.out.println(Arrays.toString(resultIndices_OptimisedApproach));
        sc.close();
    }

    /**
     * Brute Force Approach
     * Check for each and every possible solution for the sum to become target across the length
     *
     * @param nums   - Input Array
     * @param target - Expected sum
     * @return result[]
     * @timeComplexity : O(n^2)
     * @spaceComplexity : O(1)
     */
    private static int[] findTargetSumIndices_BruteForce(int[] nums, int target) {
        int[] result = new int[2];
        outer:
        for (int i = 0; i < nums.length; i++) {
            int currentSum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (currentSum + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break outer;
                }
            }
        }

        return result;
    }

    /**
     * Better Approach
     * Store indices of each element in a hashmap.
     * Then iterate through the array and subtract number from the target and check that remaining number exists in the array or not?
     *
     * @timeComplexity : O(n)
     * @spaceComplexity : O(1)
     */
    private static int[] findTargetSumIndices_OptimisedApproach(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> indicesMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indicesMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int remainingSum = target-nums[i];
            if(indicesMap.get(remainingSum) != null && indicesMap.get(remainingSum) != i){
                result[0] = i;
                result[1] =  indicesMap.get(remainingSum);
                break;
            }
        }

        return result;
    }
}