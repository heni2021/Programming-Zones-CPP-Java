// https://leetcode.com/problems/richest-customer-wealth/description/
package com.example.practice.codes.LeetCode.Easy.RichestCustomerWealth_Easy;

import java.util.Scanner;

public class RichestCustomerWealth_Java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] accounts = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                accounts[i][j] = sc.nextInt();
            }
        }

        int wealthyCustomerWealth = computeWealthOfRichestCustomer(accounts);
        System.out.println("Wealth of richest customer is - "+wealthyCustomerWealth);
    }

    /**
     * Brute Force
     * Compute the sum of each row and find currentMax after it
     * @timeComplexity : O(nxm)
     * @spaceComplexity: O(1)
     */
    private static int computeWealthOfRichestCustomer(int[][] accounts) {
        int maximumMoney = Integer.MIN_VALUE;
        for (int[] account : accounts) {
            int sum = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                sum += account[j];
            }
            maximumMoney = Math.max(maximumMoney, sum);
        }

        return maximumMoney;
    }
}
