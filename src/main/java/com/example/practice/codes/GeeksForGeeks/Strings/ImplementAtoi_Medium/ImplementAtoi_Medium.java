package com.example.practice.codes.GeeksForGeeks.Strings.ImplementAtoi_Medium;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ImplementAtoi_Medium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int num = implementAtoi(input);
        System.out.println("Number is - "+num);

        sc.close();
    }

    /**
     * Approach:
     * 1. Ignore all leading or trailing whitespaces.
     * 2. Set a flag for negative numbers to identify whether the string is having a valid negative number or not.
     * 3. Once numbers are encountered and after that any other char other number is found then break and return the formed number.
     * 4. To ignore leading zeros initialize the result with 0.
     * 5. As by default int follow circular patter on overflow, whenever while forming the number it becomes negative then based on the negative flag return INT_MIN or INT_MAX value.
     * @timeComplexity:O(n)
     * @spaceComplexity:O(1)
     * @param input
     * @return num
     */
    private static int implementAtoi(String input) {
        int num = 0;
        boolean isNegative = false;
        boolean isDigitStarted = false;
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '-' && !isNegative && !isDigitStarted){
                isNegative = true;
            }
            else if(input.charAt(i) == '1'){
                num = num*10 + 1;
                isDigitStarted = true;
            }
            else if(input.charAt(i) == '2'){
                num = num*10 + 2;
                isDigitStarted = true;
            }
            else if(input.charAt(i) == '3'){
                num = num*10 + 3;
                isDigitStarted = true;
            }
            else if(input.charAt(i) == '4'){
                num = num*10 + 4;
                isDigitStarted = true;
            }
            else if(input.charAt(i) == '5'){
                num = num*10 + 5;
                isDigitStarted = true;
            }
            else if(input.charAt(i) == '6'){
                num = num*10 + 6;
                isDigitStarted = true;
            }
            else if(input.charAt(i) == '7'){
                num = num*10 + 7;
                isDigitStarted = true;
            }
            else if(input.charAt(i) == '8'){
                num = num*10 + 8;
                isDigitStarted = true;
            }
            else if(input.charAt(i) == '9') {
                num = num * 10 + 9;
                isDigitStarted = true;
            }
            else if(input.charAt(i) == '0'){
                num*=10;
                isDigitStarted = true;
            }
            else if(input.charAt(i) != ' '){
                break;
            }
            if(num < 0){
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return isNegative ? num * -1 : num;
    }
}
// "   -123"
// "325-"
// "    -"
// "000345"
// " --678"