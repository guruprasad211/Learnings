package com.scaler.arrays.class6;

/*
 * You are given an integer array A.

Decide whether it is possible to divide the array into one or more subarrays of even length
 such that the first and last element of all sub arrays will be even.

Return "YES" if it is possible; otherwise, return "NO" (without quotes).


 */
public class EvenSubArray {
    /*
     * Check if any odd num exists in array and start and end of the array elems must be even
     * If all elems are even and if size is odd its not valid
     */
    public static String solve(int[] A) {
        int size = A.length;
        if (size == 0 || size == 1) {
            return "NO";
        }
        boolean firstElemEven = A[0] % 2 == 0;
        boolean lastElemEven = A[size - 1] % 2 == 0;
        boolean evenSize = size % 2 == 0;

        for (int i = 0; i < size; i++) {
            if (A[i] % 2 != 0 && (!lastElemEven || !firstElemEven)) {
                return "NO";
            }
        }
        //All elemnts are even, but size is odd
        if (!evenSize) {
            return "NO";
        }
        return "YES";
    }

    /*
     * n-1 must be even
     * 0th element must be even
     * size must be even
     */
    public static String solveOpt(int[] A) {
        int size = A.length;
        if (size == 0 || size == 1) {
            return "NO";
        }
        boolean firstElemEven = A[0] % 2 == 0;
        boolean lastElemEven = A[size - 1] % 2 == 0;
        boolean evenSize = size % 2 == 0;
        if (firstElemEven && lastElemEven && evenSize) {
            return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) {
        //int[] a = {2, 4,6,8};
        int[] a = { 2, 4, 6, 7, 8 };
        System.out.println("Even:" + solve(a));

    }

}
