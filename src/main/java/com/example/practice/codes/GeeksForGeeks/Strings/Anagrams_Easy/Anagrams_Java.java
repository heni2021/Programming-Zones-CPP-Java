package com.example.practice.codes.GeeksForGeeks.Strings.Anagrams_Easy;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Anagrams_Java {
    public static void main(String[] args) {
        String s1, s2;
        Scanner sc = new Scanner(System.in);
        s1 = sc.nextLine();
        s2 = sc.nextLine();

        boolean isAnagramBruteForceApproach = isAnagramsUsingBruteForceApproach(s1, s2);
        System.out.println("String Are Anagrams ? : "+isAnagramBruteForceApproach);

        boolean isAnagramOptimisedApproach = isAnagramsUsingOptimisedApproach(s1, s2);
        System.out.println("String Are Anagrams ? : "+isAnagramOptimisedApproach);
        sc.close();
    }

    /**
     * Brute Force
     * Use hash map to count frequencies of the characters and then check if both hashmaps are equal or not
     * @timeComplexity:O(n+m)
     * @spaceComplexity:O(n+m)
     */
    private static boolean isAnagramsUsingBruteForceApproach(String s1, String s2){
        HashMap<Character, Integer> frequencyCount1 = new HashMap<>();
        HashMap<Character, Integer> frequencyCount2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            frequencyCount1.put(s1.charAt(i), frequencyCount1.getOrDefault(s1.charAt(i), 0 )+1);
        }

        for (int i = 0; i < s2.length(); i++) {
            frequencyCount2.put(s2.charAt(i), frequencyCount2.getOrDefault(s2.charAt(i), 0 )+1);
        }

        for(Character key : frequencyCount1.keySet()){
            if(!Objects.equals(frequencyCount2.get(key), frequencyCount1.get(key))){
                return false;
            }
        }
        return true;
    }

    /**
     * Optimised Approach
     * Use a character frequency array of length 26. Mark the index as true if you have encountered a character and while parsing second string mark it as false.
     * At end check if all indexes are false.
     * @timeComplexity:O(n+m)
     * @spaceComplexity:O(26)~O(1)
     */

    private static boolean isAnagramsUsingOptimisedApproach(String s1, String s2){
        int[] presenceArray = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            presenceArray[s1.charAt(i)-'a'] +=1;
        }

        for (int i = 0; i < s2.length(); i++) {
            presenceArray[s2.charAt(i)-'a'] -=1;
        }

        for (int i = 0; i < 26; i++) {
            if(presenceArray[i] !=0){
                return false;
            }
        }
        return true;
    }
}

// geeks skeeg
// allergy allergic
// alergy allergy
//geeks keeesg
