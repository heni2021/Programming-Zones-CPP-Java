package com.example.practice.codes.Patterns.InvertedHalfPyramidWithNumbers;

import java.util.Scanner;
/*
12345
1234
123
12
1
 */
public class InvertedHalfPyramidWithNumbers_Java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=n;i>0;i--){
            for(int j=0;j<i;j++){
                System.out.print(j+1);
            }
            System.out.println();
        }
        sc.close();
    }
}
