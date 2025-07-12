// https://leetcode.com/problems/fizz-buzz/
package com.example.practice.codes.LeetCode.Easy.FizzBuzz_Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FizzBuzz_Java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> fizzBuzzArray = createFizzBuzzArray(n);
        System.out.println(fizzBuzzArray);
        sc.close();
    }

    private static List<String> createFizzBuzzArray(int n) {
        List<String> result = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%3 == 0 && i%5 == 0){
                result.add("FizzBuzz");
            }
            else if(i%5 == 0){
                result.add("Buzz");
            }
            else if(i%3==0){
                result.add("Fizz");
            }
            else{
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}
