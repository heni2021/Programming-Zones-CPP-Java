package com.example.practice.codes.CodingPatterns.SlidingWidow;

import java.util.Scanner;

import com.example.practice.codes.Utilities.ArrayUtilities_Java;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = ArrayUtilities_Java.scanIntArray();
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();

        int length = minSubArrayLen(nums, target);
        System.out.println(length);

        sc.close();
    }

    private static int minSubArrayLen(int[] nums, int target) {
        int minLength = Integer.MAX_VALUE;

        int currentSum = 0;
        int i=0;
        for(int j=0;j<nums.length;j++){
            currentSum+=nums[j];

            while(currentSum >= target){
                minLength = Math.min(minLength, j-i+1);
                currentSum-=nums[i];
                i++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
