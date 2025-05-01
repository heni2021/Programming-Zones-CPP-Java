package com.example.practice.codes.GeeksForGeeks.Sorting.MergeAndInsertInterval_Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;
import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanTwoDIntArray;

public class MergeAndInsertInterval_Java {
    public static void main(String[] args) {
        int[][] intervals = scanTwoDIntArray();
        int[] insertInterval = scanIntArray();

        ArrayList<int[]> mergedIntervals = mergeAndInsertIntervals(intervals,insertInterval);
        System.out.print("Merged Intervals: [");
        for (int i = 0; i < mergedIntervals.size(); i++) {
            System.out.print(Arrays.toString(mergedIntervals.get(i)));
        }
        System.out.println("]");
    }

    /**
     * Approach:
     * Add all the intervals which are ending with the value lesser than the new interval starting range.
     * Add all non overlapping intervals and keep updating newInterval values.
     * Then add all remaining intervals.
     * @timeComplexity:O(n)
     * @spaceComplexity:O(n)
     * @param intervals
     * @param newInterval
     * @return
     */

    private static ArrayList<int[]> mergeAndInsertIntervals(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        while(i < n && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result.add(newInterval);

        while(i<n){
            result.add(intervals[i]);
            i++;
        }
        return result;
    }
}
