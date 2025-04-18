package com.example.practice.codes.GeeksForGeeks.BuyOrSellStockMultipleTransactionAllowed_Medium;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;

public class BuyOrSellStockMultipleTransaction_Java {
    public static void main(String[] args) {
        int[] a = scanIntArray();
        int profitEarned = buySellStocks(a);
        System.out.println("Profit Earned using brute force approach- "+profitEarned);

        int profitEarnedOptimised = buyOrSellStocksOptimisedApproach(a);
        System.out.println("Profit Earned using optimised force approach- "+profitEarnedOptimised);

    }

    /**
     * Brute Force
     * Buy at low and sell at max price to book more profit.
     * buy at the price
     * i  - pointing at price which we can buy stock
     * j - for iteratins
     * compute the diff and check if the profits are increased or not.
     * if they are decreased then add the diff in profit and change i to j and increment j.
     *
     * @timeComplexity:O(n)
     * @spaceComplexity:O(1)
     * */
    private static int buySellStocks(int[] a) {
        if(a.length == 1){
            return 0;
        }
        int profitEarned = 0;
        int currentMaxDiff = 0;
        int i = 0, j= i+1;
        while(i<a.length && j<a.length){
            int diff = a[j] - a[i];
            if(diff > 0){
                if(diff >= currentMaxDiff){
                    currentMaxDiff = diff;
                }
                else{
                    profitEarned+=currentMaxDiff;
                    currentMaxDiff = 0;
                    i=j;
                }
                j++;
            }
            else{
                i=j;
                j++;
                profitEarned+=currentMaxDiff;
                currentMaxDiff = 0;
            }
        }
        if(currentMaxDiff>0){
            profitEarned+=currentMaxDiff;
        }
        return profitEarned;
    }

    /***
     * Optimised Approach - Simplified Version
     * Add all the differences between the adjacent prices
     * @timeComplexity:O(n)
     * @spaceComplexity:O(1)
     */
    private static int buyOrSellStocksOptimisedApproach(int[] a){
        int profitEarned = 0;
        for(int i=1;i<a.length;i++){
         if(a[i]> a[i-1]){
             profitEarned+=(a[i]-a[i-1]);
         }
        }
        return profitEarned;
    }

}

// 100 180 260 310 40 535 695
// 4 2 2 2 4
