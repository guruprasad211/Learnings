package com.scaler.arrays.class5;

import java.util.Arrays;

/*
 * You are given an integer array A of length N.
You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
For each query, you have to find the sum of all elements from L to R indices in A (1 - indexed).
More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.

 */
public class RangeSumQuery {

    public static int[] solve(int[] A, int[][] B) {
        int[] resp = new int[B.length];

        for (int i = 0; i < B.length; i++) {
            int[] temp = B[i];
            int l = temp[0];//temp[0] - 1 //for 1 index based
            int r = temp[1];//temp[1] - 1 //for 1 index based
            int sum = 0;
            while (l < r) {
                sum += A[l] + A[r];
                l++;
                r--;
            }
            if (A.length != l && l == r) {
                sum += A[l];
            }
            resp[i] = sum;
        }

        return resp;
    }

    /*
     * { 5, 2, 3, 4, 6, 7, 9, 10, 12, 13 }
     * pfsums {5, 7, 10, 14, 20, 27, 36, 46, 58, 71}
     */
    public static long[] rangeSum(int[] A, int[][] B) {
        //find prefixsum to calculate range sum in optimized way
        long[] pfSums = new long[A.length];
        pfSums[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            pfSums[i] = pfSums[i-1] + A[i];
        }
        long[] rangeSums = new long[B.length];
        for (int i = 0; i < B.length; i++) {
            //if index starts from 1 else 0
            if(B[i][0] == 1) {
                rangeSums[i] = pfSums[B[i][1]-1];
            }
            else {
                rangeSums[i] = (long)pfSums[B[i][1]-1] - (long)pfSums[B[i][0]-2];
            }
        }
        
        return rangeSums;
    }
    
    /*
     * prefix sum in same array
     */
    public static int[] solve(int[] A) {
        for (int i = 1; i < A.length; i++) {
            A[i] = A[i-1] + A[i];
        }
        return A;
    }

    public static void main(String[] args) {
        //int[] a = { 5, 2, 3, 4, 6, 7, 9, 10, 12, 13 };
        //int[][] b = { { 1, 1 }, { 4, 8 } };

        /*int[] a = { 5 };
        int[][] b = { { 0, 0 } };*/
        
        int[] a = {7, 3, 1, 5, 5, 5, 1, 2, 4, 5};
        int[][] b = {{7,10}};

        //int[] r = RangeSumQuery.solve(a, b);
        //System.out.println("RangeSumQuery:" + Arrays.toString(r));
        
        //System.out.println("RangeSumQuery:" + Arrays.toString(rangeSum(a, b)));
        System.out.println("same array prefix sum:" + Arrays.toString(solve(a)));
    }

}
