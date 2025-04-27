package com.example.practice.codes.GeeksForGeeks.Sorting.MergeOverlappingIntervals_Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanTwoDIntArray;

public class MergeOverlappingInterval_Java {
    public static void main(String[] args) {
        int[][] intervals = scanTwoDIntArray();

        List<int[]> mergedIntervals = mergeIntervals(intervals);
        System.out.print("Merged Intervals: [");
        for (int i = 0; i < mergedIntervals.size(); i++) {
            System.out.print(Arrays.toString(mergedIntervals.get(i)));
        }
        System.out.println("]");
    }

    /**
     * Approach :
     * 1. Perform sorting on intervals
     * 2. Compare the arr[i][1] with arr[i+1][0] if they overlaps merge them nd add them in the list and then always compare all the intervals with that only.
     * @timeComplexity:O(nlogn+n)
     * @spaceComplexity:O(n)
     * @param intervals
     * @return
     */

    private static List<int[]> mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        int k = 0; // points to the latest result.

        for (int i = 1; i < intervals.length; i++) {
           if(result.get(k)[1] >= intervals[i][0]){
               if(result.get(k)[1] <= intervals[i][1]){
                   int newInterval[] = result.get(k);
                   newInterval[1] = intervals[i][1];
                   result.remove(k);
                   result.add(newInterval);
               }
           }
           else{
               result.add(intervals[i]);
               k++;
           }

        }

        return result;
    }
}
//[[6,8],[1,9],[2,4],[4,7]]
//[[1,3], [2,4], [6,8], [9,10]]