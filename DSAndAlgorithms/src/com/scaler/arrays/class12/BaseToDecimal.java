package com.scaler.arrays.class12;

/*
 * You are given a number A. You are also given a base B. A is a number on base B.
You are required to convert the number A into its corresponding value in decimal number system.
Input 1:
A = 1010    O/P: 10
B = 2
Input 2:
A = 22 
B = 3       O/P: 8

 */
public class BaseToDecimal {
    public int solve(int A, int B) {
        int num = A;
        int rightIndex = 0;
        int decimal = 0;
        while (num > 0) {
            //rem gives numbers from right
            int rem = num % 10;
            //gives left part number
            num = num / 10;
            decimal += rem * Math.pow(B, rightIndex);
            rightIndex++;
        }
        return decimal;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
