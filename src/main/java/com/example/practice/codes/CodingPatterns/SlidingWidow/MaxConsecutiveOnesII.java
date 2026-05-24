package com.example.practice.codes.CodingPatterns.SlidingWidow;

import java.util.Scanner;

import com.example.practice.codes.Utilities.ArrayUtilities_Java;

public class MaxConsecutiveOnesII {
    public static void main(String[] args) {
        int[] nums = ArrayUtilities_Java.scanIntArray();
        Scanner sc = new Scanner(System.in);
        int numberOfAllowedFlips = sc.nextInt();
        sc.close();
        int maxConsecutiveOnes = longestOnes(nums, numberOfAllowedFlips);
        System.out.println(maxConsecutiveOnes);
    }

    private static int longestOnes(int[] nums, int k) {
       int left = 0, maxLength = 0, zeroCount = 0;

        for(int right  = 0; right< nums.length;right++){
            if(nums[right] == 0){
                zeroCount++;
            }
            while(zeroCount > k){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
}
