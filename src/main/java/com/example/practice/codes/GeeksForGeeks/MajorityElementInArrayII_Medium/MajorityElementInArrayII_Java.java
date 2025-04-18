package com.example.practice.codes.GeeksForGeeks.MajorityElementInArrayII_Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.example.practice.codes.Utilities.ArrayUtilities_Java.scanIntArray;

public class MajorityElementInArrayII_Java {
    public static void main(String[] args) {
        int[] a = scanIntArray();
        List<Integer> result =fetchElementsHavingFrequencyGreaterThanNBy3(a);
        System.out.println("Elements with highest votes are  - "+result);

        List<Integer> resultBetterApproach = fetchElementsHavingFrequencyGreaterThanNBy3BetterApproach(a);
        System.out.println("Elements with highest votes using better approach are  - "+resultBetterApproach);

        List<Integer> resultOptimisedApproach = fetchElementsHavingFrequencyGreaterThanNBy3OptimisedApproach(a);
        System.out.println("Elements with highest votes using optimised approach are  - "+resultOptimisedApproach);
    }

    /**
     * Brute Force
     * 1. Count Frequency of Each element in a HashMap
     * 2. Fetch the elements with frequency greater than n/3 and put them in a list
     * @timeComplexity : O(n)
     * @spaceComplexity : O(n)
     * */

    private static List<Integer> fetchElementsHavingFrequencyGreaterThanNBy3(int[] a){
        HashMap<Integer, Integer> frequencyCount = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            frequencyCount.put(a[i], frequencyCount.getOrDefault(a[i], 0)+1);
        }
        int expectedFrequency = a.length/3;
        for(Integer key : frequencyCount.keySet()){
            if(frequencyCount.get(key)> expectedFrequency){
                result.add(key);
            }
        }
        return result;
    }

    /**
     * Better Approach
     * Sort the array
     * Without using hashmap count the frequency and add them in list if its greater than n/3
     * @timeComplexity : O(nlogn)
     * @spaceComplexity : O(1)
     * */
    private static List<Integer> fetchElementsHavingFrequencyGreaterThanNBy3BetterApproach(int[] a){
        Arrays.sort(a);
        int count = 1;
        int n = a.length;
        int exp = n/3;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.length-1; i++) {
            if(a[i] == a[i+1]){
                count++;
            }
            else{
                if(count>exp){
                    result.add(a[i]);
                }
                count = 1;
            }
        }
        if(count>exp){
            result.add(a[a.length-1]);
        }
        return result;
    }

    /**
     * Optimised Approach : Moore's Algorithm
     * Find 2 potential candidates for the result. As per observation only 2 possible candidates.
     * Then iterate to the array and check for other candidates too.
     * Then get the actual count and check if it is greater than n/3 or not.
     * @timeComplexity : O(n)
     * @spaceComplexity : O(1)
     * */
    private static List<Integer> fetchElementsHavingFrequencyGreaterThanNBy3OptimisedApproach(int[] a){

        List<Integer> result = new ArrayList<>();
        int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 1;
        for(int num : a){
            if(num == candidate1){
                count1++;
            }
            else if(num == candidate2){
                count2++;
            }
            else if(count1 == 0){
                candidate1 = num;
                count1++;
            }
            else if(count2 == 0){
                candidate2 = num;
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0; count2 = 0;
        for(int num : a){
            if(num == candidate1){
                count1++;
            }
            else if(num == candidate2){
                count2++;
            }
        }

        if(count1 > a.length/3){
            result.add(candidate1);
        }
        if(count2 > a.length/3){
            result.add(candidate2);
        }
        return result;
    }

}

// 2 1 5 5 5 5 6 6 6 6 6
// 1 2 3 4 5
// 1 3
// 6 6 6 6 6 2 1 5 5 5 5