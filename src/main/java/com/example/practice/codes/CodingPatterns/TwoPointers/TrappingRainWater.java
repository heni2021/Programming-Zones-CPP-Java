package com.example.practice.codes.CodingPatterns.TwoPointers;

import com.example.practice.codes.Utilities.ArrayUtilities_Java;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] nums = ArrayUtilities_Java.scanIntArray();
        int maxWaterUnits = trappingWater(nums);

        System.out.println(maxWaterUnits);
    }

    private static int trappingWater(int[] nums) {
        int left = 0, right = nums.length-1;
        int leftMaxHeight = nums[left], rightMaxHeight = nums[right];
        int water = 0;
        while(left < right){
            if(leftMaxHeight < rightMaxHeight){
                left++;
                leftMaxHeight = Math.max(leftMaxHeight, nums[left]);
                water+= leftMaxHeight - nums[left];
            } else{
                right --;
                rightMaxHeight = Math.max(rightMaxHeight, nums[right]);
                water+=rightMaxHeight-nums[right];
            }
        }

        return water;
    }
}
