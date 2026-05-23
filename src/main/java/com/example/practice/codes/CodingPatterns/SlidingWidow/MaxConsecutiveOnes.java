package com.example.practice.codes.CodingPatterns.SlidingWidow;

import com.example.practice.codes.Utilities.ArrayUtilities_Java;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = ArrayUtilities_Java.scanIntArray();

        int maxConsecutiveOnes = findMaxConsecutiveOnes(nums);
        System.out.println(maxConsecutiveOnes);
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentCount++;
            } else {
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 0;
            }
        }
        maxCount = Math.max(maxCount, currentCount);

        return maxCount;
    }
}
