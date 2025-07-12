// https://leetcode.com/problems/median-of-two-sorted-arrays/description/
package com.example.practice.codes.LeetCode.Hard.MedianOfTwoSortedArrays_Hard;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;

public class MedianOfTwoSortedArrays_Java {
    public static void main(String[] args) {
        int[] nums1 = scanIntArray();
        int[] nums2 = scanIntArray();

        double result_BruteForce = findMedianOfTwoSortedArrays_BruteForce(nums1, nums2);
        System.out.println("Median of two sorted Arrays using brute force : "+result_BruteForce);
    }

    /**
     * Brute Force : Just Merge two arrays and find median.
     * @timeComplexity : O(n+m)
     * @spaceComplexity : O(n+m)
     * @param nums1 : 1st sorted array with length n
     * @param nums2 - 2nd sorted array with length m
     * @return median of merged array
     */
    private static double findMedianOfTwoSortedArrays_BruteForce(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];
        int i=0, j= 0;
        int k = 0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] <= nums2[j]){
                mergedArray[k] = nums1[i];
                i++;
            }
            else{
                mergedArray[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i<nums1.length){
            mergedArray[k] = nums1[i];
            i++;
            k++;
        }

        while(j<nums2.length){
            mergedArray[k] = nums2[j];
            j++;
            k++;
        }

        if(mergedArray.length%2 == 0){
            int first = mergedArray[mergedArray.length/2];
            int second = mergedArray[mergedArray.length/2-1];
            return (first + second) /2.0;
        }
        else{
            return mergedArray[mergedArray.length/2];
        }
    }
}
