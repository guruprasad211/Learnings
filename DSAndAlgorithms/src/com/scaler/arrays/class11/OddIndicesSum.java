package com.scaler.arrays.class11;

import java.util.Arrays;

/*
 * You are given an array A of length N and Q queries given by the 2D array B of size Q*2. Each query consists of two integers B[i][0] and B[i][1].
For every query, the task is to calculate the sum of all odd indices in the range A[B[i][0]…B[i][1]].

Note : Use 0-based indexing

A = [1, 2, 3, 4, 5]
B = [   [0,2] 
        [1,4]   ]
        
O/P: [2, 6]
 */
public class OddIndicesSum {
    public static int[] solve(int[] A, int[][] B) {
        int sizeB = B.length;
        int[] res = new int[sizeB];
        for (int i = 0; i < sizeB; i++) {
            int l = B[i][0];
            int r = B[i][1];
            int sum = 0;
            while (l <= r) {
                if (l % 2 != 0) {
                    sum += A[l];
                }

                l++;
            }
            res[i] = sum;
        }
        return res;
    }

    public static int[] solveUsingPrefixSums(int[] A, int[][] B) {
        int sizeA = A.length;
        int sizeB = B.length;
        int[] pfSums = new int[sizeA];
        int[] res = new int[sizeB];
        pfSums[0] = 0;
        for (int i = 1; i < sizeA; i++) {
            if (i % 2 != 0) {
                pfSums[i] = pfSums[i - 1] + A[i];
            }
            else {
                pfSums[i] = pfSums[i - 1];
            }
        }
        for (int i = 0; i < sizeB; i++) {
            if (B[i][0] == 0) {
                res[i] = pfSums[B[i][1]];
            }
            else {
                res[i] = pfSums[B[i][1]] - pfSums[B[i][0] - 1];
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        int[][] b = { { 0, 2 }, { 1, 4 } };
        System.out.println(Arrays.toString(solve(a, b)));
        System.out.println(Arrays.toString(solveUsingPrefixSums(a, b)));
    }

}
