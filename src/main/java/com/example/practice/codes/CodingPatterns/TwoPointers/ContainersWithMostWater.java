package com.example.practice.codes.CodingPatterns.TwoPointers;

import com.example.practice.codes.Utilities.ArrayUtilities_Java;

public class ContainersWithMostWater {
    public static void main(String[] args) {
        int[] nums = ArrayUtilities_Java.scanIntArray();
        int maxArea = computeMaxArea(nums);
        System.out.println(maxArea);
    }

    private static int computeMaxArea(int[] nums) {
        int i = 0, j = nums.length-1;
        int area = 0;
        while(i<j){
            int currentArea = Math.min(nums[i], nums[j]) * (j-i);
            area = Math.max(area, currentArea);
            if(nums[i] <= nums[j]){
                i++;
            } else{
                j--;
            }
        }

        return area;
    }
}
