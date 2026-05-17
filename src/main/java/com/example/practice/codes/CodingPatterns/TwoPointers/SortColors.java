package com.example.practice.codes.CodingPatterns.TwoPointers;

import java.util.Arrays;

import com.example.practice.codes.Utilities.ArrayUtilities_Java;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = ArrayUtilities_Java.scanIntArray();
        // sortInPlace(nums);
        sortInPlaceUsingTwoPointers(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * Counting Sort
     * @param nums
     */
    private static void sortInPlace(int[] nums) {
       int zeroCount = 0, oneCount = 0, twoCount = 0;
       for(int value : nums){
        if(value == 0){
            zeroCount++;
        } else if(value == 1){
            oneCount++;
        } else{
            twoCount++;
        }
       }

       int i = 0;
       while(zeroCount!=0){
        nums[i] = 0;
        i++;
        zeroCount--;
       }

       while(oneCount!=0){
        nums[i] = 1;
        i++;
        oneCount--;
       }

       while(twoCount!=0){
        nums[i] = 2;
        i++;
        twoCount--;
       }
    }

    /**
     * Dutuch National Flag Algorithm
     */
    private static void sortInPlaceUsingTwoPointers(int[] nums){
        int low = 0, mid = 0, high = nums.length-1;

        while(mid <= high){
            if(nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                mid++;
                low++;
            } else if(nums[mid] == 1){
                mid++;
            } else{
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }
}
