package com.example.practice.codes.GeeksForGeeks.BuyOrSellStockMaxOneTransaction_Easy;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;

public class BuyOrSellStockMaxOneTransaction_Java {
    public static void main(String[] args) {
        int[] a = scanIntArray();
        int profitEarned = buySellStocksWithSingleTransaction(a);
        System.out.println("Profit Earned using brute force approach- "+profitEarned);

        int profitEarnedOptimised = buySellStocksWithSingleTransactionOptimised(a);
        System.out.println("Profit Earned using optimised force approach- "+profitEarnedOptimised);
    }

    /**
     * Brute Force Approach
     * Summary - Buy at low and sell at highest price and check if the current earned profit is greater than the previous or not.
     * We will compute diff and check if it is greater than currentMaxDiff.
     * if yes update currentMaxDiff
     * other wise it is not possible to buy stock at current price so update the price.
     * @timeComplexity:O(n)
     * @spaceComplexity:O(1)
     * @param a
     * @return profits
     */
    private static int buySellStocksWithSingleTransaction(int[] a) {
        int profitEarned = 0;
        int currentMaxDiff = 0;
        int i = 0, j = i+1;
        while(i<a.length && j<a.length){
            int diff = a[j] - a[i];
            if(diff > 0){
                if(diff >= currentMaxDiff){
                    currentMaxDiff = diff;
                }
                else {
                    if (currentMaxDiff >= profitEarned) {
                        profitEarned = currentMaxDiff;
                        currentMaxDiff = 0;
                    }
                }
            }
            else{
                i=j;
                if(currentMaxDiff >= profitEarned){
                    profitEarned = currentMaxDiff;
                    currentMaxDiff = 0;
                }
            }
            j++;
        }

        if(currentMaxDiff >= profitEarned){
            profitEarned = currentMaxDiff;
        }

        return profitEarned;
    }

    /***
     * Optimised and simplified approach
     * Find minimum value index and then find the maximum value which is occuring after minimum value. if not return 0 else return diff.
     * @timeComplexity:O(n)
     * @spaceComplexity:O(1)
     */
    private static int buySellStocksWithSingleTransactionOptimised(int[] prices){
        int minimumPriceIndex = 0;
        int currentMinValue = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if(currentMinValue > prices[i]){
                currentMinValue = prices[i];
                minimumPriceIndex = i;
            }
        }
        int afterMax = currentMinValue;
        for (int i = minimumPriceIndex+1; i < prices.length; i++) {
                afterMax=Math.max(afterMax, prices[i]);
        }
        return afterMax - currentMinValue;
    }
}

// 7 10 1 3 6 9 2
// 7 1 5 3 6 4
// 7 6 4 3 1