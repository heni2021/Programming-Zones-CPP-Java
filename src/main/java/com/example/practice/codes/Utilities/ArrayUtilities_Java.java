package com.example.practice.codes.Utilities;

import java.util.Scanner;

public class ArrayUtilities_Java {
    public static int[] scanIntArray(){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n = ");
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void swapElementInIntArrayAtIndexes(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverseElementsInArray(int[] arr, int startIndex, int endIndex){
        while(startIndex < endIndex){
            swapElementInIntArrayAtIndexes(arr, startIndex++, endIndex--);
        }
    }

    public static int maxNumberOfThree(int a, int b, int c){
        return Math.max(a, Math.max(b,c));
    }

    public static int minNumberOfThree(int a, int b, int c){
        return Math.min(a, Math.min(b,c));
    }
}
