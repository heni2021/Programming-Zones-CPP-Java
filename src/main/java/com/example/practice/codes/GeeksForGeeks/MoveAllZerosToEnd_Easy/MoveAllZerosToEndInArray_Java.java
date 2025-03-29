// Link - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/move-all-zeroes-to-end-of-array0751
package com.example.practice.codes.GeeksForGeeks.MoveAllZerosToEnd_Easy;

import java.util.Arrays;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;
import static com.example.practice.codes.Utilities.ArrayUtilities_Java.swapElementInIntArrayAtIndexes;

public class MoveAllZerosToEndInArray_Java {
    public static void main(String[] args) {
        int[] arr = scanIntArray();

        moveAllZerosToEndBruteForce(arr);
        moveAllZerosToEndBetterApproach(arr);
        int[] result = moveAllZerosToEndOptimisedApproach(arr);
        System.out.println("Final Result from optimised - " + Arrays.toString(result));
        moveZerosToEndTwoPointersOptimised(arr);
        System.out.println("Final Result from optimised 2 pointers - " + Arrays.toString(arr));

    }

    /**
     * Brute Force
     * Count number of zeros in the given array.
     * In that then we will create a copy of the old array and then intialize the old array with 0.
     * Then replace all the values which are non zeros in sequence.
     * NOTE : You can't submit this solution on GFG as they don't allow importing Arrays lib.
     * @timeComplexity : O(n)
     * @spaceComplexity: O(n)
     */
    public static void moveAllZerosToEndBruteForce(int[] arr){
        int zeroCount = 0;
        for (int j : arr) {
            if (j == 0) {
                zeroCount++;
            }
        }

        if(zeroCount == 0 || zeroCount == arr.length){
            System.out.println("Updated Array using brute force - "+ Arrays.toString(arr));
        }
        else{
            // declare new array and then initialize it to zero
            int[] newArray = Arrays.copyOf(arr, arr.length);

            Arrays.fill(arr, 0);

            int newArrayIndex = 0;
            for (int j : newArray) {
                if (j != 0) {
                    arr[newArrayIndex] = j;
                    newArrayIndex++;
                }
            }

            System.out.println("Updated Array using brute force- " + Arrays.toString(arr));
        }
    }

    /***
     * Better Approach
     * use 2 pointer approach { i, j }
     * Iterate i till you get the first zero. then initialize j with the next element i.e., i+1 and run it till the first non-zero element
     * then swap it and repeat the process.
     * NOTE: Still this may give TLE in longer arrays.
     * @timeComplexity : O(n)
     * @spaceComplexit : O(1)
     */

    public static void moveAllZerosToEndBetterApproach(int[] arr){
        if(arr.length == 1){
            System.out.println("Updated Array using better approach- " + Arrays.toString(arr));
            return;
        }
        int j;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                j = i+1;
                while(j<arr.length && arr[j] == 0){
                    j++;
                }
                if(j!=arr.length) {
                    swapElementInIntArrayAtIndexes(arr, i, j);
                }
            }
        }

        System.out.println("Result Array - "+Arrays.toString(arr));
    }

    /**
     * Optimised Approach - Divide and Conquer
     * Divide the array in half and perform the swap operation we did in better approach code and then
     * while returning merge the operated arrays.
     * NOTE: This doesn't do it in place
     * @timeComplexity : O(logn)
     * @spaceComplexity : O(n)
     * */

    public static int[] moveAllZerosToEndOptimisedApproach(int[] arr){
        if(arr.length <=1){
            return arr;
        }

        // divide array
        int mid = arr.length/2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[arr.length-mid];
        System.arraycopy(arr, 0, leftArray, 0, leftArray.length);
        System.arraycopy(arr, mid, rightArray, 0, rightArray.length);

        int[] leftPartition = moveAllZerosToEndOptimisedApproach(leftArray);
        int[] rightPartition = moveAllZerosToEndOptimisedApproach(rightArray);
        return pushZerosToEnd(leftPartition, rightPartition);
    }

    public static int[] pushZerosToEnd(int[] left, int[] right){
        int[] processedArray = new int[left.length+right.length];
        int leftIndx = 0, rightIndx = 0, k=0;

        // Merging them while maintaining order
        while(leftIndx<left.length && rightIndx<right.length){
            if(left[leftIndx] !=0){
                processedArray[k] = left[leftIndx];
                leftIndx++;
                k++;
            }
            else if(right[rightIndx] !=0){
                processedArray[k] = right[rightIndx];
                rightIndx++;
                k++;
            }
            else{
                processedArray[k] = left[leftIndx];
                leftIndx++;
                k++;
            }
        }

        while(leftIndx<left.length && k<processedArray.length){
            processedArray[k] = left[leftIndx];
            leftIndx++;
            k++;
        }

        while(rightIndx<right.length && k<processedArray.length){
            processedArray[k] = right[rightIndx];
            rightIndx++;
            k++;
        }
        return processedArray;
    }

    /***
     * Optimised Inplace Approach
     * 2 pointer approach with one pointer always pointing to index of the first zero and iterate over another pointer.
     * Perform Swap everytime you encounter non-zero value for the iterating pointer
     *
     * @timeComplexity: O(n)
     * @spaceComplexity: O(1)
     */

    public static void moveZerosToEndTwoPointersOptimised(int[] arr){
        if(arr.length == 1){
            return;
        }

        int zeroPointer = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] != 0){
                swapElementInIntArrayAtIndexes(arr, i, zeroPointer);
                zeroPointer++;
            }
        }
    }

}
