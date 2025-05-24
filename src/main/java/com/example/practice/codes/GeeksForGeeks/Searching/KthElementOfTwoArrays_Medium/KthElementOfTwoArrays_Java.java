package com.example.practice.codes.GeeksForGeeks.Searching.KthElementOfTwoArrays_Medium;

import java.util.Scanner;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;

public class KthElementOfTwoArrays_Java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = scanIntArray();
        int[] b = scanIntArray();
        int k = sc.nextInt();

        int value =  findElementInMergedArray(a,b,k);
        System.out.println("The value at kth position - "+value);
    }

    /**
     * Brute Force
     * Point both the pointers to start of array. Then increase count of the index.
     * @timeComplexity:O(n)
     * @spaceComplexity:O(1)
     * @param a
     * @param b
     * @param k
     * @return
     */
    private static int findElementInMergedArray(int[] a, int[] b, int k) {
        int i = 0, j = 0, currentIndexFound = -1;
        while(i<a.length && j<b.length){
            if(a[i] < b[j]){
                currentIndexFound++;
                if(currentIndexFound == k-1){
                    return a[i];
                }
                i++;
            }
            else{
                currentIndexFound++;
                if(currentIndexFound == k-1){
                    return b[j];
                }
                j++;
            }
        }

        while(i<a.length){
            currentIndexFound++;
            if(currentIndexFound == k-1){
                return a[i];
            }
            i++;
        }

        while(j<b.length){
            currentIndexFound++;
            if(currentIndexFound == k-1){
                return b[j];
            }
            j++;
        }

        return -1;
    }
}
