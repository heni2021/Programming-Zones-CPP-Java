package com.example.practice.codes.Patterns.InvertedHalfPyramid;

import java.util.Scanner;

/*
 *********
 ********
 *******
 ******
 *****
 ****
 ***
 **
 *
 */
public class InvertedHalfPyramid_Java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}
