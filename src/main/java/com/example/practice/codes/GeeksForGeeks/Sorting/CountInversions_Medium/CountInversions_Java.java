package com.example.practice.codes.GeeksForGeeks.Sorting.CountInversions_Medium;

import java.util.Arrays;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;

public class CountInversions_Java {
    public static void main(String[] args) {
        int[] a = scanIntArray();
        int inversionsUsingBruteForce = computeInversionsUsingBruteForce(a);
        System.out.println("Number of inversions - "+inversionsUsingBruteForce);

        int inversionsUsingDivideAndConquer = computeInversionDivdeAndConquerApproach(a);
        System.out.println("Number of inversions using Divide And Conquer - "+inversionsUsingDivideAndConquer);

    }

    /**
     * Brute Force:
     * Iterate through all possibilities and compute the count.
     * @timeComplexity:O(n^2)
     * @spaceComplexity:O(1)
     */
    private static int computeInversionsUsingBruteForce(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(a[i] > a[j]){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Optimised Approach
     * Apply the formula of divide and rule and while merging count the inversions i.e. check if the value on LHS is greater than RHS then as both values are sorted in that terms all the value from jth element will be greater so inversion will be n1-j.
     * @timeComplexity:O(n)
     * @spaceComplexity:O(n)
     */
    private static int computeInversionDivdeAndConquerApproach(int[] a){
        return countInversion(a, 0, a.length-1);
    }

    private static int countInversion(int[] a, int l, int r){
        int res = 0;
        if (l < r) {
            int m = (r + l) / 2;

            // Recursively count inversions
            // in the left and right halves
            res += countInversion(a, l, m);
            res += countInversion(a, m + 1, r);

            // Count inversions such that greater element is in
            // the left half and smaller in the right half
            res += mergeAndCountInversion(a, l, r,m);
        }
        return res;
    }

    private static int mergeAndCountInversion(int[] a, int left, int right, int mid) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = a[i + left];
        }

        for (int i = 0; i < n2; i++) {
            rightArray[i] = a[mid+i+1];
        }

        int result = 0;

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j])
                a[k++] = leftArray[i++];
            else {
                a[k++] = rightArray[j++];
                result += (n1 - i);
            }
        }

        // Merge remaining elements
        while (i < n1)
            a[k++] = leftArray[i++];
        while (j < n2)
            a[k++] = rightArray[j++];

        return result;
    }

}
// 2 4 1 3 5
// 1 2 3 4 5
// 5 4 3 2 1
// 10 10 10