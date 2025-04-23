package com.example.practice.codes.GeeksForGeeks.Strings.SearchPatternsUsingKMP_Medium;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchPatternsUsingKMP_Java {
    public static void main(String[] args) {
        String txt, pat;
        Scanner sc = new Scanner(System.in);
        txt = sc.nextLine();
        pat = sc.nextLine();

        ArrayList<Integer> patternIndexes = findAllOccurrenceOfPatternInText(txt, pat);
        System.out.println("Pattern occurs at - "+patternIndexes);

        sc.close();
    }

    /**
     * As it is mentioned in the problem statement itself that use KMP so no chances to look for other approaches as
     * in pattern matching KMP rules.
     * @timeComplexity:O(n+m)
     * @spaceComplexity:O(m)
     * @param txt
     * @param pat
     * @return
     */

    private static ArrayList<Integer> findAllOccurrenceOfPatternInText(String txt, String pat) {
        ArrayList<Integer> patternIndexes = new ArrayList<>();

        int[] lps = createLPS(pat);
        int j = 0;
        for (int i = 0; i < txt.length();) {
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
                if(j == pat.length() && i!=txt.length()){
                    patternIndexes.add(i-pat.length());
                    j=lps[j-1];
                    i--;
                }
            }
             if(i<txt.length() && txt.charAt(i)  != pat.charAt(j)){
                if(j!=0){
                    j = lps[j-1];
                }
                else{
                    i++;
                }
            }
        }
        if(j == pat.length()){
            if(!patternIndexes.contains(txt.length()-pat.length())){
                patternIndexes.add(txt.length()-pat.length());
            }
        }
        return patternIndexes;
    }

    private static int[] createLPS( String pat) {
        int i=1, patLength =0;
        int[] lps = new int[pat.length()];

        while(i<pat.length()){
            if(pat.charAt(patLength) == pat.charAt(i)){
                patLength++;
                lps[i]= patLength;
                i++;
            }
            else{
                if(patLength!=0){
                    patLength = lps[patLength-1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}

// abcab ab
// aabaacaadaabaaba aaba