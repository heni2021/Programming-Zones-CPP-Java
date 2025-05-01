package com.example.practice.codes.GeeksForGeeks.Sorting.MinimumIntervalToRemoveToMakeNonOverlapping_Medium;

import java.util.Arrays;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanTwoDIntArray;

public class MinimumIntervalsToRemoveToMakeNonOverlappingIntervals_Java {
    public static void main(String[] args) {
        int[][] intervals = scanTwoDIntArray();
        
        int removeIntervals = removeMinimumIntervals(intervals);
        System.out.println("Minimum required intervals to remove is - "+removeIntervals);
    }

    /**
     * Approach
     * Simplest thing we can do is to sort the intervals then pick the current highest end of the interval.
     * if the start of next is less than current end it means remove current and increment count.
     * @timeComplexity:O(nlogn)
     * @spaceComplexity:O(1)
     * @param intervals
     * @return
     */

    private static int removeMinimumIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end)
                count++;
            else
                end = intervals[i][1];
        }

        // return the count
        return count;
    }
}
// [[1, 2], [2, 3], [3, 4], [1, 3]]
// [[1, 3], [1, 3], [1, 3]]
// [[1, 2], [5, 10], [18, 35], [40, 45]]