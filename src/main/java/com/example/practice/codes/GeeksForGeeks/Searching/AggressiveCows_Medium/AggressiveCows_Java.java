package com.example.practice.codes.GeeksForGeeks.Searching.AggressiveCows_Medium;

import java.util.Scanner;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;

public class AggressiveCows_Java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = scanIntArray();
        int k = sc.nextInt();

        int minDistance = computeMinDistance(a, k);
        System.out.println("Minimum Distance Between any two of them is maximum : "+minDistance);
    }

    private static int computeMinDistance(int[] a, int k) {
        return 0;
    }
}
