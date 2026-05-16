package com.example.practice.codes.CodingPatterns.TwoPointers;

import java.util.Arrays;
import java.util.Scanner;

import com.example.practice.codes.Utilities.ArrayUtilities_Java;

public class TwoSumII {
    public static void main(String[] args) {
       int[] nums = ArrayUtilities_Java.scanIntArray();
       Scanner sc = new Scanner(System.in);
       int target = sc.nextInt();
       int[] elements = twoSum(nums, target);
       System.out.println(Arrays.toString(elements));
       sc.close();
    }

    /**
     * Place one pointer at start of array and another at end of array.
     * if currentSum > target ---> decrement end point
     * else if currentsum < target ---> increment start pointer
     * else return both current start and end indices.
     * @param nums : array
     * @param target : targetted sum
     * @return array of indices.
     * time Complexity : O(n)
     * space complexity : O(1)
    */
    private static int[] twoSum(int[] nums, int target) {
        int i = 0, j= nums.length-1;
        int[] result = new int[2];
        while (i<j){
            int sum = nums[i] + nums[j];
            if(sum > target){
                j--;
            } else if(sum < target){
                i++;
            } else {
                result[0] = i;
                result[1] = j;
                break;
            }
        }
        return result;
    }
}
