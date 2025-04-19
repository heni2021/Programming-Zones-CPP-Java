package com.example.practice.codes.GeeksForGeeks.Arrays.FindMinimumPositiveNumber_Medium;

import java.util.Arrays;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;
import static com.example.practice.codes.Utilities.ArrayUtilities_Java.swapElementInIntArrayAtIndexes;

public class FindMinimumPositiveInteger_Java {
    public static void main(String[] args) {
        int[] a = scanIntArray();
        int value = findSmallestMissingPositiveInteger(a);
        System.out.println("Smallest Missing integer using brute force is - "+value);

        int valueBetterApproach = findSmallestMissingPositiveIntegerBetterApproach(a);
        System.out.println("Smallest Missing integer using better approach is - "+valueBetterApproach);

        int valueOptimised = findSmallestMissingPositiveIntegerOptimisedApproach(a);
        System.out.println("Smallest Missing integer using optimised approach is - "+valueOptimised);

    }

    /***
     * Brute Force
     * Iterate the array to find the value of x starting from 1.
     * if you find the value then break and increment the value of x and reiterate the process.
     * if not found then return the value of x
     * @timeComplexity:O(x*n) where x is the missing integer
     * @spaceComplexity:O(1)
     *
     * Note it will give TLE if the missing number is a larger number.
     */
    private static int findSmallestMissingPositiveInteger(int[] a){
        int n = a.length;
        boolean isFound = false;
        int x = 1;
        while(!isFound){
            for (int i = 0; i < n; i++) {
                if(x == a[i]){
                    isFound = true;
                    break;
                }
            }
            if(isFound){
                x++;
                isFound = false;
            }
            else{
                break;
            }
        }

        return x;
    }

    /**
     * Better Approach
     * 1. Sort the array
     * 2. Ignore negative numbers and use a counter initialized with 1.
     * 3. Iterate through the array and return the first non occuring number.
     * @timeComplexity:O(nlogn)
     * @spaceComplexity:O(1)
     */

    private static int findSmallestMissingPositiveIntegerBetterApproach(int[] a){
        Arrays.sort(a);
        int x = 1;
        for (int i = 0; i < a.length; i++) {
            if(a[i] <= 0 || a[i] == x){
                continue;
            }
            else{
                if(a[i] != (x+1)){
                    return x+1;
                }
                else{
                    x++;
                }
            }
        }
        return x+1;
    }

    /***
     * Optimised Approach.
     * 1. Shift all positive elements to left and find a pivot index from where either zero or negative numbers are starting.
     * 2. Iterate a loop and negate the elements of the value corresponding to the index.
     * 3. Check for non-negative vale at an index and then return the index.
     * @timeComplexity:O(n)
     * @spaceComplexity:O(1)
     */
    private static int findSmallestMissingPositiveIntegerOptimisedApproach(int[] arr){
        int pivotIndex = shiftPositiveElementsToLeft(arr);

        for(int i = 0;i<pivotIndex;i++){
            int value = Math.abs(arr[i]);
            if(value-1 < pivotIndex && arr[value-1] > 0){
                arr[value-1] = -arr[value-1];
            }
        }

        for(int i =0;i<pivotIndex;i++){
            if(arr[i] > 0){
                return i+1;
            }
        }
        return pivotIndex+1;
    }

    private static int shiftPositiveElementsToLeft(int[] a) {
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] > 0){
                swapElementInIntArrayAtIndexes(a, i, j);
                j++;
            }
        }
        return j;
    }

}
// 1 2 3 4 5
// 2 -3 4 1 1 7
// 5 3 2 5 1
// -8 0 -1 -4 -3
// 0 -10 1 3 -20
// 120 1 2 3 4 5 6 7 8 9 10 47 29
// 1 -1 -4