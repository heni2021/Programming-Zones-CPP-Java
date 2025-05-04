// https://leetcode.com/problems/remove-element/description/?source=submission-noac
package com.example.practice.codes.LeetCode.RemoveElement_Easy;

import java.util.Arrays;
import java.util.Scanner;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;
import static com.example.practice.codes.Utilities.ArrayUtilities_Java.swapElementInIntArrayAtIndexes;

public class RemoveElement_Java {
    public static void main(String[] args) {
        int[] a = scanIntArray();
        int val;
        Scanner sc = new Scanner(System.in);
        val = sc.nextInt();

        int k = getIndexUsingBruteForce(a, val);
        System.out.println("Invalid Index starts from - "+k);
        k = getIndexUsingOptimisedApproach(a, val);
        System.out.println("Invalid Index starts from - "+k);
    }

    /**
     * Brute Force
     * Sort the array
     * Perform swap using 2 pointers placed at starting and end of the array respectively.
     * Re-iterate the array from back and return invalid index.
     * @timeComplexity:O(nlogn+n)
     * @spaceComplexity:O(1)
     * @param a
     * @param val
     * @return
     */
    private static int getIndexUsingBruteForce(int[] a, int val) {
        Arrays.sort(a);
        int i=0,j=a.length-1;
        while(i<j){
            if(a[i] == val){
                swapElementInIntArrayAtIndexes(a, i,j);
                j--;
            }
            i++;
        }

        j = a.length-1;
        while(a[j] == val){
            j--;
        }
        return j+1;
    }

    /**
     * Optimised/Expected Approach:
     * i- located at first position of occurence of value.
     * j - first position from last which is not equal to value.
     * perform swapping till i!=j.
     * Check if value at i = val return i else return i+1
     * @timeComplexity:O(n)
     * @spaceComplexity:O(1)
     */
    private static int getIndexUsingOptimisedApproach(int[] a, int val) {
        if(a.length==0){
            return 0;
        }
        int i = 0, j = a.length-1;
        while(i<a.length && a[i]!=val){
            i++;
        }
        while(j>=0 && a[j]==val){
            j--;
        }
        while(i<j){
            if(a[i] == val && a[j] != val){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j--;
                i++;
            }
            else if(a[j] == val){
                j--;
            }
            else {
                i++;
            }
        }

        if(i<a.length && a[i] == val){
            return i;
        }
        else{
            return i+1;
        }
    }

}
