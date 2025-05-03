package com.example.practice.codes.GeeksForGeeks.Searching.NumberOfOccurences_Easy;

import java.util.HashMap;
import java.util.Scanner;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;

public class NumberOfOccurences_Java {
    public static void main(String[] args) {
        int[] a = scanIntArray();
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int occurenceBruteForce = countNumberOfOccurencesUsingBruteForce(a, target);
        System.out.println("Number of occurences of "+target+" is "+occurenceBruteForce);
        int occurenceOptimisedApproach = countNumberOfOccurencesUsingOptimisedApproach(a, target);
        System.out.println("Number of occurences of "+target+" is "+occurenceOptimisedApproach);
        sc.close();
    }

    /**
     * Brute Force:
     * Count the frequency of each element in array and then return the frequency of the given element.
     * @timeComplexity:O(n)
     * @spaceComplexity:O(1)
     * @param a
     * @param target
     * @return
     */
    private static int countNumberOfOccurencesUsingBruteForce(int[] a, int target) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            counts.put(a[i], counts.getOrDefault(a[i], 0)+1);
        }
        return counts.get(target);
    }

    /**
     * Optimised Approach:
     * As it is a sorted array all the occurences of target will be consecutive.
     * So We will count them and then return only that value.
     * @timeComplexity:O(n)
     * @spaceComplexity:O(1)
     */
    private static int countNumberOfOccurencesUsingOptimisedApproach(int[] a, int target) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] == target){
                count++;
            }
        }

        return count;
    }
}

// 1 1 2 2 2 2 3