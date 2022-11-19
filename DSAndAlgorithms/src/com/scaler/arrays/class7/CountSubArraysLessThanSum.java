package com.scaler.arrays.class7;

/*
 * Given an array A of N non-negative numbers and a non-negative number B,
you need to find the number of subarrays in A with a sum less than B.
We may assume that there is no overflow.

 */
public class CountSubArraysLessThanSum {

    public static int solve(int[] A, int B) {
        int size = A.length;
        int subArrayCounts = 0;
        for (int s = 0; s < size; s++) {
            for (int e = s; e < size; e++) {
                int sum = 0;
                //Forms Subarray
                for (int i = s; i <= e; i++) {
                    sum += A[i];
                }
                if (sum < B) {
                    subArrayCounts++;
                }
            }
        }
        return subArrayCounts;
    }

    public static void main(String[] args) {
        int[] a = { 2, 5, 6 };

        System.out.println("" + solve(a, 10));

    }

}
