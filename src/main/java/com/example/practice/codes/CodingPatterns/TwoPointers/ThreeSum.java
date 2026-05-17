package com.example.practice.codes.CodingPatterns.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.practice.codes.Utilities.ArrayUtilities_Java;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = ArrayUtilities_Java.scanIntArray();
        List<List<Integer>> elements = computeThreeSum(nums);
        System.out.println(elements);
    }

    private static List<List<Integer>> computeThreeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0;i<nums.length-2;i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i+1, k = nums.length-1;
            while(j<k){
                if(nums[i] + nums[j] + nums[k] == 0){
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j<k && nums[j] == nums[j+1]) {
                        j++;
                    }

                    while(j<k && nums[k] == nums[k-1]){
                        k--;
                    }
                    j++;
                    k--;
                } else if(nums[i] + nums[j] + nums[k] < 0){
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }


}
