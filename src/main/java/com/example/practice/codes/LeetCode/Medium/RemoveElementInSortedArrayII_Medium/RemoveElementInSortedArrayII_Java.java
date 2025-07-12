package com.example.practice.codes.LeetCode.Medium.RemoveElementInSortedArrayII_Medium;

import java.util.Arrays;
import java.util.HashMap;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;

public class RemoveElementInSortedArrayII_Java {
    public static void main(String[] args) {
        int[] a = scanIntArray();
        int[] b = Arrays.copyOf(a, a.length);

        int invalidIndex_bruteForce = findInvalidIndexSuchThatEachElementOccursAtMostTwice_BruteForce(a);
        System.out.println("Invalid index using brute force : "+invalidIndex_bruteForce);

        int invalidIndex = findInvalidIndexSuchThatEachElementOccursAtMostTwice(b);
        System.out.println("Invalid index starts from : " + invalidIndex);
    }

    /**
     * Brute Force Approach
     * Put the frequency in a hashmap and then repopulate the array.
     *
     * @timeComplexity:O(n)
     * @spaceComplexity:O(m) where m is number of distinct values
     */
    private static int findInvalidIndexSuchThatEachElementOccursAtMostTwice_BruteForce(int[] a) {
        HashMap<Integer, Integer> frequencyCount = new HashMap<>();
        // compute the frequency
        for (int j : a) {
            frequencyCount.put(j, frequencyCount.getOrDefault(j, 0) + 1);
        }

        int i = 0;
        for (int val : frequencyCount.keySet()) {
            if (frequencyCount.get(val) >= 2) {
                a[i] = val;
                a[i + 1] = val;
                i = i + 2;
            } else {
                a[i] = val;
                i = i + 1;
            }
        }
        return i;
    }

    /**
     * Expected/ Optimised Approach
     * We assume that the first two element is correctly placed and then iterate i.
     * If I encounter an element which is same as the either of first two element then I replace it and increment the swappable counter.
     *
     * @timeComplexity:O(n)
     * @spaceComplexity:O(1)
     */
    private static int findInvalidIndexSuchThatEachElementOccursAtMostTwice(int[] a) {
        if (a.length <= 2) {
            return a.length;
        }
        int currentSwapableIndex = 2;
        for (int i = 2; i < a.length; i++) {
            if (a[i] != a[currentSwapableIndex - 2]) {
                a[currentSwapableIndex] = a[i];
                currentSwapableIndex++;
            }
        }
        return currentSwapableIndex;
    }
}
// 1 1 1 2 2 3
// 0 0 1 1 1 1 2 3 3
