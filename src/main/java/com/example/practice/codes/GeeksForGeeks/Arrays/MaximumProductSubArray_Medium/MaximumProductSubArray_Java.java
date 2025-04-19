package com.example.practice.codes.GeeksForGeeks.Arrays.MaximumProductSubArray_Medium;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.*;

public class MaximumProductSubArray_Java {
    public static void main(String[] args) {
        int[] a = scanIntArray();
        int productSubArray = findProductSubArray(a);
        System.out.println("Maximum Product using brute force : "+productSubArray);

        int productSubArrayOptimised = findProductSubArrayOptimisedApproach(a);
        System.out.println("Maximum Product using Optimised Approach " +productSubArrayOptimised);
    }

    /**
     * Brute Force!!
     * Compute the product of all permutations of the subarrays possible and find the maximum product.
     * @timeComplexity:O(n^2)
     * @spaceComplexity:O(1)
     * @param a
     * @return
     */
    private static int findProductSubArray(int[] a) {
        int maximumProduct = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            int currentProduct = 1;
            for (int j = i; j < a.length; j++) {
                currentProduct*=a[j];
                maximumProduct = Math.max(currentProduct, maximumProduct);
            }
        }
        return maximumProduct;
    }

    /**
     * Optimised Approach
     * Compute all 3 products at each index i.e. current minimum, current maximum and the value itself.
     * We use currentMinimum to check that if we encounter any value which is -ve and upon multiplying it turns out to be positive then it should consider that subarray too.
     * @timeComplexity:O(n)
     * @spaceComplexity:O(1)
     * @param a
     * @return
     */

    private static int findProductSubArrayOptimisedApproach(int[] a){
        int maximumProduct = Integer.MIN_VALUE;
        int currentMaximumProduct = 1;
        int currentMinimumProduct = 1;

        for (int i = 0; i < a.length; i++) {
            int temp = maxNumberOfThree(a[i], a[i]*currentMaximumProduct, a[i]*currentMinimumProduct);
            currentMinimumProduct = minNumberOfThree(a[i], a[i]*currentMaximumProduct, a[i]*currentMinimumProduct);
            currentMaximumProduct = temp;
            maximumProduct = maxNumberOfThree(currentMaximumProduct, currentMinimumProduct, maximumProduct);
        }

        return maximumProduct;
    }
}

// -2 6 -3 -10 0 2
// -1 -3 -10 0 6
// 2 3 4