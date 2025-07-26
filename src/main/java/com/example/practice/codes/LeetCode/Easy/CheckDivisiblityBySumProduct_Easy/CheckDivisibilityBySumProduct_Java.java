// https://leetcode.com/contest/weekly-contest-459/problems/check-divisibility-by-digit-sum-and-product/
package com.example.practice.codes.LeetCode.Easy.CheckDivisiblityBySumProduct_Easy;

import java.util.Scanner;

public class CheckDivisibilityBySumProduct_Java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean isDivisible = checkDivisibilityByN(n);
        System.out.println("Number is divisible by");
    }

    /**
     * Approach :
     * Extract the digit at tens place by performing its modulo with 10.
     * Then divide the digit by 10 remove the used digit.
     * Then check divisibility
     * @timeComplexity : O(N)
     * @spaceComplexity : O(1)
     * @param n
     * @return
     */
    private static boolean checkDivisibilityByN(int n) {
        int currentNValue = n;
        int sum = 0, product = 1;
        while(n!=0){
            int digit = n%10;
            sum+=digit;
            product*=digit;
            n/=10;
        }

        return currentNValue%(sum+product) == 0;
    }
}
