package com.example.practice.codes.CodingPatterns.TwoPointers;

import java.util.Arrays;

import com.example.practice.codes.Utilities.ArrayUtilities_Java;

public class MoveZeros {
    public static void main(String[] args) {
       int[] nums = ArrayUtilities_Java.scanIntArray();

       moveZeros(nums);
       System.out.println(Arrays.toString(nums));
    }

    private static void moveZeros(int[] nums){
        if(nums.length == 1){
            return;
        }

        int currentZeroPointer = 0;
        while( currentZeroPointer < nums.length && nums[currentZeroPointer] != 0){
            currentZeroPointer ++;
        }
       
        for(int i=currentZeroPointer+1;i<nums.length && currentZeroPointer < nums.length;){
            if(nums[i] != 0 && nums[currentZeroPointer] == 0){
                ArrayUtilities_Java.swapElementInIntArrayAtIndexes(nums, i, currentZeroPointer);
                currentZeroPointer++;
                i++;
            }
            else if(nums[currentZeroPointer] != 0){
                currentZeroPointer++;
            }
            else if(nums[i] == 0 ){
                i++;
            }
        }
    }
}
