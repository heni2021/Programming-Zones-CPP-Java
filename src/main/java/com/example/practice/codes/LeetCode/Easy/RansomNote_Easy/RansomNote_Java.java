// https://leetcode.com/problems/ransom-note/description/
package com.example.practice.codes.LeetCode.Easy.RansomNote_Easy;

import java.util.Arrays;
import java.util.Scanner;

public class RansomNote_Java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ransomeNote = sc.next();
        String magazine = sc.next();

        boolean isPossible = checkIfPossibleToMakeRansomeNoteFromMagazine(ransomeNote, magazine);
        System.out.println("Can we make ransomeNote from magazine ? - " + isPossible);
    }

    /**
     * Brute Force:
     * Count the occurrence of every character in the ransomeNote and then when you encounter the same character in magazine then deduct the occurrence by 1.
     * At the end parse the entire array and check if all the value of character is 0 or not.
     * If any value is non-zero then return false else true.
     *
     * @param ransomeNote
     * @param magazine
     * @return
     * @timeComplexity : O(n)
     * @spaceComplexity : O(26) ~ constant
     */
    private static boolean checkIfPossibleToMakeRansomeNoteFromMagazine(String ransomeNote, String magazine) {
        int[] characters = new int[26];
        boolean[] isVisited = new boolean[26];
        Arrays.fill(characters, 0);
        Arrays.fill(isVisited, false);

        for (int i = 0; i < ransomeNote.length(); i++) {
            characters[ransomeNote.charAt(i) - 'a']++;
            isVisited[ransomeNote.charAt(i) - 'a'] = true;
        }

        for (int i = 0; i < magazine.length(); i++) {
            if (isVisited[magazine.charAt(i) - 'a']) {
                characters[magazine.charAt(i) - 'a']--;
            }
        }

        for (int character : characters) {
            if (character > 0) { // greater than zero because there are still less character occurring for the given characters.
                return false;
            }
        }
        return true;
    }
}
