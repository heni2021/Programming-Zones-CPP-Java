package com.example.practice.codes.GeeksForGeeks.MoveAllZerosToEnd_Easy;

import com.example.practice.codes.Utilities.ArrayUtilities_Java;

public class MoveAllZerosToEndInArray_Java {
    public static void main(String[] args) {
        int[] arr = ArrayUtilities_Java.scanIntArray();

        moveAllZerosToEndBruteForce(arr);

    }

    /**
     * Brute Force
     * Count number of zeros in the given array.
     * In that then we will create a new array initialized with 0.
     * Then replace all the values which are non zeros in sequence.
     *
     * @timeComplexity : O(n)
     * @spaceComplexity: O(n)
     */
    public static void moveAllZerosToEndBruteForce(int arr[]){
        int zeroCount = 0;
        for(int i=0;i<arr.length; i++){
            if(arr[i] == 0){
                zeroCount++;
            }
        }

        if(zeroCount == 0){
            System.out.println("Updated Array - "+ arr.toString());
        }
        else{
            // declare new array and then initialize it to zero
            int newArray[] = new int[arr.length];

            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = 0;
            }

            int newArrayIndex = 0;
            for(int i =0;i<arr.length;i++){
                if(arr[i] !=0){
                    newArray[newArrayIndex] = arr[i];
                    newArrayIndex++;
                }
            }

            System.out.println("Updated Array - " + newArray.toString());
        }
    }
}
