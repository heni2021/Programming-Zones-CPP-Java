package com.example.practice.codes.GeeksForGeeks.Arrays.RotateArray_Medium;

import java.util.Arrays;
import java.util.Scanner;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.reverseElementsInArray;
import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;

public class RotateElementsInArray_Java {
    public static void main(String[] args) {
        int[] a = scanIntArray();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of d  - ");
        int d = sc.nextInt();
        rotateArrayByBruteForce(a, d);
        System.out.println("Rotated Array using brute force - "+ Arrays.toString(a));

        rotateArrayByBetterApproach(a,d);
        System.out.println("Rotated Array using better approach force - "+ Arrays.toString(a));

        rotateArrayByOptimisedApproach(a,d);
        System.out.println("Rotated Array using optimised approach force - "+ Arrays.toString(a));

        sc.close();
    }

    /**
     * Brute Force Approach
     * if the value of d is equal to the length of array then we need not to rotate. We can directly return the input array.
     * We can use three nested loops outer loop will be for the number of rotations.
     * Inner loops will perform the rotation operations and return the array.
     * @timeComplexity : O(n^2)
     * @spaceComplexity : O(n)
     * This may give TLE in larger inputs!!
     * */
    private static void rotateArrayByBruteForce(int[] a, int d) {
        if(d== a.length || a.length == 1){
            return;
        }
        int[] arr = new int[a.length];
        for(int i=0;i<d;i++){
            // copy the array in another array
            System.arraycopy(a, 0, arr, 0, a.length);

            // rotate the array by storing the value in first index and then shifting other values to left.
            for(int j=0;j<a.length-1;j++){
                a[j] = arr[j+1];
            }
            a[a.length-1] = arr[0];

            System.out.println("Array after rotation - "+(i+1)+" is : "+Arrays.toString(a));
        }
    }

    /**
     * Better Approach.
     * The value of d will be the value we obtain upon performing modulo operation as if d is greater than the length of array no sense of doing repetitive operations
     * We will copy the entire array into another array and then copy the value of i+d%n into the old array
     * @timeComplexity: O(n)
     * @spaceComplexity: O(n)
     * */
    private static void rotateArrayByBetterApproach(int[] a, int d) {
        d = d%a.length;
        if(d==0 || a.length == 1){
            return;
        }
        int[] arr = new int[a.length];
        System.arraycopy(a, 0, arr, 0, a.length);

        for (int i = 0; i < a.length; i++) {
            a[i] = arr[(i+d)%a.length];
        }
    }

    /**
     * Optimised Approach
     * Reverse the elements from 0 to d-1 index
     * Reverse elements from d to n-1 index
     * then reverse entire array.
     * @timeComplexity: O(n)
     * @spaceComplexity: O(1)
     * */
    private static void rotateArrayByOptimisedApproach(int[] a, int d) {
        reverseElementsInArray(a, 0, d-1);
        reverseElementsInArray(a, d, a.length-1);
        reverseElementsInArray(a, 0, a.length-1);
    }
}
