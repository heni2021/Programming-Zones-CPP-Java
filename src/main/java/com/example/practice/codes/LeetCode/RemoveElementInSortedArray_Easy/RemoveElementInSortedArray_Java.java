package com.example.practice.codes.LeetCode.RemoveElementInSortedArray_Easy;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;
import static com.example.practice.codes.Utilities.ArrayUtilities_Java.swapElementInIntArrayAtIndexes;

public class RemoveElementInSortedArray_Java {
    public static void main(String[] args) {
        int[] a = scanIntArray();

        int index = removeDuplicatesUsingOptimisedApproach(a);
        System.out.println("Invalid Index starts from : "+index);
    }

    /**
     * Expected Optimised Approach.
     * i - points to the current non-duplicated index
     * j - is an iterator to find the next big number from i and then swap it.
     * @timeComplexity:O(n)
     * @spaceComplexity:O(1)
     * @param a
     * @return
     */
    private static int removeDuplicatesUsingOptimisedApproach(int[] a) {
        int i=0, j =0;
        if(a.length == 1){
            return 1;
        }
        while(i<a.length-1){
            if(a[i] == a[i+1]){
                break;
            }
            i++;
        }
        while(j<a.length){
            if(a[j]>a[i]){
                i++;
                swapElementInIntArrayAtIndexes(a, i, j);
            }
            j++;
        }
        return i+1;
    }
}
// 0 0 1 1 1 2 2 3 3 4