package com.example.practice.codes.GeeksForGeeks.Searching.PeakElement_Basic;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;

public class PeakElement_Java {
    public static void main(String[] args) {
        int[] a = scanIntArray();
        int peakElementExists = IsPeakElementExists(a);
        System.out.println("Peak element exists - "+peakElementExists);

        int optimisedPeakElement = findPeakElementUsingBinarySearch(a);
        System.out.println("Peak element using optimised - "+optimisedPeakElement);
    }

    /**
     * Brute Force
     * Apply normal logic for comparision across the array
     * @timeComplexity:O(n)
     * @spaceComplexity:O(1)
     * @param a
     * @return
     */
    private static int IsPeakElementExists(int[] a) {
        if(a.length == 1){
            return 0;
        }
        for (int i = 0; i < a.length-1; i++) {
            if(i==0){
                if(a[i] > a[1]){
                    return i;
                }
            }
            else {
                if(a[i] > a[i-1] && a[i] > a[i+1]){
                    return i;
                }
            }
        }
        if(a[a.length-1] > a[a.length-2]){
            return a.length-1;
        }
        return 0;
    }

    /**
     * Optimised Approach : Binary Search
     * Perform binary search on the array starting from index 1 to length -1.
     * If I get a[mid] > a[mid+1] ---> guaranteed peak element is in right so shift low.
     * else peak element is in left so shift high.
     * Iterate loop while low <= high
     */

    private static int findPeakElementUsingBinarySearch(int[] arr){
        int n = arr.length;

        // If there is only one element, then it's a peak
        if (n == 1)
            return 0;

        // Check if the first element is a peak
        if (arr[0] > arr[1])
            return 0;

        // Check if the last element is a peak
        if (arr[n - 1] > arr[n - 2])
            return n - 1;

        // Search Space for binary Search
        int low = 1, high = n-2;
        while(low<=high){
            int mid = low + (high - low)/2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if(arr[mid] < arr[mid+1]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return 0;
    }
}
// 1 2 4 5 7 8 3
// 1 2 3