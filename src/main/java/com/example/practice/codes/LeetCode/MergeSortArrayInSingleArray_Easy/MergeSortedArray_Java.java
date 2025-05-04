// https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
package com.example.practice.codes.LeetCode.MergeSortArrayInSingleArray_Easy;

import java.util.Arrays;
import java.util.Scanner;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;

public class MergeSortedArray_Java {
    public static void main(String[] args) {
        int[] a = scanIntArray();
        int[] b = scanIntArray();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        mergeUsingBruteForce(a, n, b, m);
        merge(a, n, b, m);

        System.out.println(Arrays.toString(a));
    }

    /**
     * Brute Force:
     * Copy b in a and then apply sort on the a.
     * @timeComplexity:O(nlogn+m)
     * @spaceComplexity:O(1)
     */
    private static void mergeUsingBruteForce(int[] a, int n, int[] b, int m){
        int k = a.length-1;
        for(int i = m-1; i>=0;i--){
            a[k]  = b[i];
            k--;
        }
        Arrays.sort(a);
    }

    /**
     * Expected Approach:
     * i will be pointing to the last valid element of a.
     * j will be pointing to last valid element of b.
     * k will be pointing to the last position where b can be accomodated in a.
     * if the value in b is greater than a then simply place the value of b at k
     * o/w shift the value of a to the k value and set the value at ith position as 0 which means b can accomodate here.
     * Edge case, if first array is null which means i<0 then simply copy b in a.
     * @timeComplexity:O(n+m)
     * @spaceComplexity:O(1)
     * @param a
     * @param n
     * @param b
     * @param m
     */
    private static void merge(int[] a, int n, int[] b, int m){
        int i =n-1, j=m-1, k =a.length-1;
        while(k>=0 && j>=0){
            if(i<0 || b[j] > a[i]){
                a[k] = b[j];
                j--;
                k--;
            }
            else{
                a[k] = a[i];
                a[i] = 0;
                k--;
                i--;
            }
        }
    }
}
