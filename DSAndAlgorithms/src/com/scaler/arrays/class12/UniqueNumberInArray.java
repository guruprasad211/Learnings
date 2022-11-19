package com.scaler.arrays.class12;

/*
 Given an array of integers A, every element appears twice except for one. 
 Find that integer that occurs once.

NOTE: Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?

Input Format
The first and only argument of input contains an integer array A.

Output Format
Return a single integer denoting the single element.

Example Input
Input 1:
 A = [1, 2, 2, 3, 1]
Input 2:
 A = [1, 2, 2]

Example Output
Output 1:
 3
Output 2:
 1
 */
public class UniqueNumberInArray {

    /*
     * XOR of same number is 0 and XOR of 0 and different number is different number
     */
    public static int singleNumber(final int[] A) {
        int unique = A[0];
        int size = A.length;
        for (int i = 1; i < size; i++) {
            unique = unique ^ A[i];
        }
        return unique;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 2, 3, 1 };
        System.out.println(singleNumber(a));
    }

}
