package com.example.practice.codes.GeeksForGeeks.Arrays.MinimizeHeightsII_Medium;

import java.util.Arrays;
import java.util.Scanner;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;

public class MinimizeHeightsII_Java {
    public static void main(String[] args) {
        int[] a = scanIntArray();
        int k;
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();

        int height = getMinimumHeightDifferencBruteForce(a, k);
        System.out.println("Height diff - "+height);
        sc.close();
    }

    /**
     * Brute Force / Optimised
     * Firstly compute the current diff before modifying the array as we want minimum we will not change if the modified array is giving me larger difference
     * then try checking for each element if you get a number smaller than a[0]+k and larger than a[n-1]-k.
     *
     * check if the diff is minimum or not.
     * @timeComplexity:O(n)
     * @spaceCOmplexity:O(1)
     * @param a
     * @param k
     * @return
     */
    private static int getMinimumHeightDifferencBruteForce(int[] a, int k){
        Arrays.sort(a);
        int ans = a[a.length - 1] - a[0];
        for (int i = 1; i < a.length; i++) {
            if(a[i] - k < 0){
                continue;
            }

            // finding if I can get the height smaller than the first modified element
            int minHeight = Math.min(a[0]+k, a[i]-k);

            // finding ig I can get the height larger than subtracting k from largest.
            int maxHeight = Math.max(a[a.length-1]-k, a[i-1]+k);
            ans = Math.min(ans, maxHeight - minHeight);
        }
        return ans;
    }
}
// 1 5 8 10 : 2
// 3 9 12 16 20 : 3
// 1 1 4 6 6 8 9 10 : 7
// 2 4 3 9 9 10 9 7 1 2 : 4
//3 9 12 16 20 : 3