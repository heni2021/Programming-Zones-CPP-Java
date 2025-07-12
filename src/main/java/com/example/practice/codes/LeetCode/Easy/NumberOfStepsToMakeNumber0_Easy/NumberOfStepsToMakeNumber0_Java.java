package com.example.practice.codes.LeetCode.Easy.NumberOfStepsToMakeNumber0_Easy;

import java.util.Scanner;

public class NumberOfStepsToMakeNumber0_Java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int steps = computeNumberOfSteps(n);
        System.out.println("Number of steps required - "+steps);
        sc.close();
    }

    private static int computeNumberOfSteps(int n) {
        int count = 0;
        while(n!=0){
            if(n%2 == 0){
                n/=2;
            }
            else{
                n-=1;
            }
            count++;
        }
        return count;
    }
}
