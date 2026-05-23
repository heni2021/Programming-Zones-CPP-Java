package com.example.practice.codes.CodingPatterns.SlidingWidow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.example.practice.codes.Utilities.ArrayUtilities_Java;

public class MaximumSubArraySum {
    public static void main(String[] args) {
         int[] nums = ArrayUtilities_Java.scanIntArray();
         Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        long maxSum = computeMaximumSubArraysum(nums, k);
        System.out.println(maxSum);

         sc.close();
    }

    private static long computeMaximumSubArraysum(int[] nums, int k) {
        long maxSum = 0, currentSum = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            currentSum += nums[windowEnd];
            freq.put(nums[windowEnd], freq.getOrDefault(nums[windowEnd], 0) + 1);

            if (windowEnd - windowStart + 1 > k) {
                currentSum -= nums[windowStart];
                freq.put(nums[windowStart], freq.get(nums[windowStart]) - 1);
                if (freq.get(nums[windowStart]) == 0) {
                    freq.remove(nums[windowStart]);
                }
                windowStart++;
            }

            if (windowEnd - windowStart + 1 == k && freq.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }
}
