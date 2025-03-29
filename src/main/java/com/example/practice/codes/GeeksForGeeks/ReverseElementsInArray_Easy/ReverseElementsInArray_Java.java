// Link : https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/reverse-an-array
package com.example.practice.codes.GeeksForGeeks.ReverseElementsInArray_Easy;

import java.util.Arrays;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;
import static com.example.practice.codes.Utilities.ArrayUtilities_Java.swapElementInIntArrayAtIndexes;

public class ReverseElementsInArray_Java {
    public static void main(String[] args) {
        int[] arr = scanIntArray();

        reverseArrayInPlaceUsingBruteForce(arr);
        System.out.println("Reversed Array after brute force : "+ Arrays.toString(arr));
    }

    /**
     * Brute Force Approach - 2 Pointers Approach
     * Take 2 pointers one at starting and one at ending index of the array.
     * Keep swapping the elements till either both pointer crosses each other or at the same index.
     * @timeComplexity : O(n)
     * @spaceComplexity : O(1)
     * */
    public static void reverseArrayInPlaceUsingBruteForce(int[] arr){
        int startIndex = 0, endIndex = arr.length-1;
        while(startIndex<endIndex){
            swapElementInIntArrayAtIndexes(arr, startIndex, endIndex);
            startIndex++;
            endIndex--;
        }
    }
}
