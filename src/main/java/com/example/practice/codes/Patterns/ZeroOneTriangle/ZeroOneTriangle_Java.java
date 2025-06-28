package com.example.practice.codes.Patterns.ZeroOneTriangle;

import java.util.Scanner;
/*
1
0 1
1 0 1
0 1 0 1
1 0 1 0 1
 */
public class ZeroOneTriangle_Java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int val;
        for(int i=0;i<n;i++){
            if(i%2==0){
                val = 1;
            }
            else{
                val = 0;
            }
            for(int j=0;j<=i;j++){
                System.out.print(val+" ");
                if(val == 1){
                    val = 0;
                }
                else{
                    val = 1;
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
