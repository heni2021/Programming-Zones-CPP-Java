package com.example.practice.codes.GeeksForGeeks.NextPermutationInArray_Medium;

import java.util.Arrays;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.*;

public class NextPermutationInArray_Java {
    public static void main(String[] args) {
        int[] a = scanIntArray();
        findNextPermutation(a);

        System.out.println("Next lexicographically big permutation first time - " + Arrays.toString(a));
        findNextPermutationOptimised(a);
        System.out.println("Next lexicographically big permutation second time - " + Arrays.toString(a));
    }

    /**
     * Brute Force Approach
     * Find the index at which next permutation can be made it has to be from back and store the index say i by iterating from back while j <= i.
     * from (i+1)th index start traversing to find an element which is greater than the element at i but less than the last max element you found.
     * Idea is to find the element which is just greater than the element at i and not necessary the max element.
     * Then perform swap between that element and the element at index i.
     * Perform ascending sort from (i+1)th element to rest of the array.
     *
     * Edge case : If you reach -1th index then just return sorted array it means you have reached the biggest possible permutation.
     * @timeComplexity: O(nlogn)
     * @spaceComplexity: O(1)
     * */

    private static void findNextPermutation(int[] a){
        if(a.length == 1){
            return;
        }
        int i = a.length-2, j = a.length-1;
        while(i!= -1 && a[j] <= a[i]){
            i--;
            j--;
        }
        if(i == -1){
            Arrays.sort(a);
            return;
        }
        int swapIndex = i, nextMaxIndex = i+1;
        i = i+1;
        while(i<a.length){
            if(a[i] > a[swapIndex] && a[i] < a[nextMaxIndex]){
                nextMaxIndex = i;
            }
            i++;
        }
        swapElementInIntArrayAtIndexes(a, swapIndex, nextMaxIndex);
        // perform sorting from swapIndex+1 to a.length
        Arrays.sort(a, swapIndex+1, a.length);
    }

    /**
     * Optimised Approach
     * Instead of sorting we can use reversal of indexes to reduce time complexity.
     * @timeComplexity = O(n)
     * @spaceComplexity = O(1)
     * */

    private static void findNextPermutationOptimised(int[] a){
        if(a.length == 1){
            return;
        }
        int i = a.length-2;
        while(i>=0 && a[i] >= a[i+1]){
            i--;
        }
        if(i>=0){
            i = i+1;
            int j = a.length-1;
            while(i!=j && a[j] <= a[i]){
                j--;
            }
            if(i==j){
                swapElementInIntArrayAtIndexes(a, i-1, j);
            }
            else{
                swapElementInIntArrayAtIndexes(a, i, j);
            }
        }
        // perform sorting from swapIndex+1 to a.length
        reverseElementsInArray(a, i+1, a.length-1);
    }
}
