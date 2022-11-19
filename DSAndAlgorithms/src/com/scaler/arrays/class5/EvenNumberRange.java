package com.scaler.arrays.class5;

import java.util.Arrays;

/*
 * You are given an array A of length N and Q queries given by the 2D array B of size Q*2. 
 * Each query consists of two integers B[i][0] and B[i][1].
For every query, the task is to find the count of even numbers in the range A[B[i][0]…B[i][1]].

 */
public class EvenNumberRange {

    /*
     * Assign 1 for Even numbers and 0 for odd numbers and
     * maintain sum of prefixes to find the range of even numbers
     * 0 1 2 3 4 5 6  -  indexes
     * 2 6 5 4 3 8 7  -  elements
     * 1 1 0 1 0 1 0  -  even odd
     * 1 2 2 3 3 4 4  -  prefixes 
     * 
     * [0, 6]   pf[6]
     * [1,6]    pf[6] - pf[0]
     */
    public static int[] solve(int[] A, int[][] B) {
        int[] evenNumCount = new int[B.length];
        int[] prefixEvenSums = new int[A.length];
        prefixEvenSums[0] = A[0] % 2 == 0 ? 1 : 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                prefixEvenSums[i] = 1 + prefixEvenSums[i - 1];
            }
            else {
                prefixEvenSums[i] = prefixEvenSums[i - 1];
            }
        }

        for (int i = 0; i < B.length; i++) {
            if (B[i][0] == 0) {
                evenNumCount[i] = prefixEvenSums[B[i][1]];
            }
            else {
                evenNumCount[i] = prefixEvenSums[B[i][1]] - prefixEvenSums[B[i][0] - 1];
            }
        }

        return evenNumCount;
    }

    public static void main(String[] args) {
        int[] a = { 2, 6, 5, 4, 3, 8, 7 };
        int[][] b = { { 2, 6 }, { 4, 5 }, { 0, 4 } };

        System.out.println("even range:" + Arrays.toString(solve(a, b)));
    }

}
