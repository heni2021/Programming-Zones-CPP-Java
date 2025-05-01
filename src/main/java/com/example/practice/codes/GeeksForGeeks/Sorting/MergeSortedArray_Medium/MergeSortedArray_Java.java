package com.example.practice.codes.GeeksForGeeks.Sorting.MergeSortedArray_Medium;

import java.util.Arrays;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;
import static com.example.practice.codes.Utilities.ArrayUtilities_Java.swapElementInIntArrayAtIndexes;

public class MergeSortedArray_Java {
    public static void main(String[] args) {
        int[] a = scanIntArray();
        int[] b = scanIntArray();

//        mergeArraysBruteForce(a,b);
        mergeArrayWithoutExtraSpace(a,b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    /**
     * Brute force:
     * Store the sorted array with the logic of merge sort in another array and then copy it in the previous 2 arrays.
     * NOTE : This is not a valid approach as it is mentioned to use O(1) space.
     * @timeComplexity:O(n)
     * @spaceComplexity:O(n)
     * @param a
     * @param b
     */

    private static void mergeArraysBruteForce(int[] a, int[] b) {
        int i = 0, j= 0, k=0;
        int[] result = new int[a.length+ b.length];
        int n = a.length,m  = b.length;
        while(i<n & j<m){
            if(a[i] <= b[j]){
                result[k] = a[i];
                i++;
                k++;
            }
            else{
                result[k] = b[j];
                j++;
                k++;
            }
        }

        while(i<n){
            result[k] = a[i];
            i++;
            k++;
        }

        while (j<m){
            result[k] = b[j];
            j++;
            k++;
        }

        i=0;
        j=0;
        k=0;
        while (i<n){
            a[i] = result[k];
            i++;
            k++;
        }
        while(j<m){
            b[j] = result[k];
            j++;
            k++;
        }

    }

    /**
     * Optimised approach
     * i will reverse traverse and j will traverse from start.
     * @timeComplexity:O(nlogn+mlogn)
     * @spaceComplexity:O(1)
     */
    private static void mergeArrayWithoutExtraSpace(int[] a, int[] b){
        int n = a.length, m = b.length;
        int i=n-1,j=0;
        while(i>=0 && j<m){
            if(a[i] > b[j]){
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;
                j++;
                i--;
            }
            else{
                i--;
            }
        }

        Arrays.sort(a);
        Arrays.sort(b);
    }
}
// 2 4 7 10 & 2 3
// 1 5 9 10 15 20 & 2 3 8 13
// 0 1 & 2 3
// 0 1 3 5 5 5 6 6 & 0 2 4 8