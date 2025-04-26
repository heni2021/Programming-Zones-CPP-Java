package com.example.practice.codes.GeeksForGeeks.Sorting.Sort012sInAscendingOrder_Medium;

import java.util.Arrays;
import java.util.HashMap;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;
import static com.example.practice.codes.Utilities.ArrayUtilities_Java.swapElementInIntArrayAtIndexes;

public class Sorts012sInAscendingOrder_Java {
    public static void main(String[] args) {
        int[] a = scanIntArray();

//        sortArrayUsingBruteForce(a);
//        System.out.println("Sorted Array Using brute force : "+ Arrays.toString(a));
        sortArrayOptimised(a);
        System.out.println("Sorted Array Using optimised Approach: "+ Arrays.toString(a));
    }

    /**
     * Brute Force
     * Count frequencies of 0's 1's and 2's and fill the array accordingly.
     * @timeComplext:O(n)
     * @spaceComplexity:O(1)
     * @param a
     */
    private static void sortArrayUsingBruteForce(int[] a) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            frequencyMap.put(a[i], frequencyMap.getOrDefault(a[i], 0)+1);
        }

        for (int i = 0; i < a.length; i++) {
            if(frequencyMap.get(0)!=null && frequencyMap.get(0)!=0){
                a[i] = 0;
                frequencyMap.put(0, frequencyMap.get(0)-1);
            }
            else if(frequencyMap.get(1)!=null && frequencyMap.get(1)!=0){
                a[i] = 1;
                frequencyMap.put(1, frequencyMap.get(1)-1);
            }
            else{
                a[i] = 2;
            }
        }
    }

    /**
     * Optimised Approach: Dutuch National Flag Algorithm
     * use 3 pointers: start, mid , end.
     * start - will act as the last postion before which zeros will occur
     * mid - will be the mid of the array acting as a position to occupy 1s
     * end - will be the first position after which 2s will be encountered.
     * In other word -> 0 to start-1 : 0s, start to mid-1 : 1s and mid to end-1 : 2s.
     * @timeComplexity:O(n) - 1pass
     * @spaceComplexity:O(1)
     */

    private static void sortArrayOptimised(int[] a){
        int start = 0, end = a.length-1, mid = a.length/2;
        while(a[start]==0){
            start++;
        }
        while(a[end] == 2){
            end--;
        }

        while(mid<=end){
            if(a[mid] == 0){
                swapElementInIntArrayAtIndexes(a, start, mid);
                start++;
                mid++;
            }
            else if(a[mid] == 2){
                swapElementInIntArrayAtIndexes(a, mid, end);
                end--;
            }
            else if(a[mid] == 1){
                mid++;
            }
        }
    }
}
// 0 1 2 0 1 2
// 0 1 1 0 1 2 1 2 0 0 0 1
// 1
// 2
// 2 0 0