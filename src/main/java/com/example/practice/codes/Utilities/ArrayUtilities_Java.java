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

    public static int maxNumberOfFour(int a, int b, int c, int d){
            return Math.max(a, Math.max(b,Math.max(c, d)));
        }

    public static int minNumberOfThree(int a, int b, int c){
        return Math.min(a, Math.min(b,c));
    }

    public static String reverseString(String s){
        int i =0, j = s.length()-1;
        char[] c = s.toCharArray();
        while(i<j){
            swapCharsAtIndexes(c, i, j);
            i++;
            j--;
        }

        return new String(c);
    }

    public static void swapCharsAtIndexes(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static boolean isPalindromeString(String s, int start, int end){
        while(start<end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end --;
        }
        return true;
    }
}
