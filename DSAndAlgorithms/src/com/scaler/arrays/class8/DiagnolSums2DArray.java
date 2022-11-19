package com.scaler.arrays.class8;

/*
 * You are given a N X N integer matrix. You have to find the sum of all the main diagonal elements of A.
Main diagonal of a matrix A is a collection of elements A[i, j] such that i = j.

            00 01 02
            10 11 12
            20 21 22
 */
public class DiagnolSums2DArray {

    /*
     * where i==j diagonals (00,11,22)
     */
    public static int solve(int[][] A) {
        int rowSize = A.length;

        int i = 0;
        int totalSum = 0;
        while (i < rowSize) {
            totalSum += A[i][i];
            i++;
        }
        return totalSum;
    }

    /*
     * where i!=j diagonals (02,11,20)
     */
    public static int diagnolSumNotEqIndex(int[][] A) {
        int rowSize = A.length;

        int i = 0;
        int j = rowSize - 1;
        int totalSum = 0;
        while (i < rowSize && j >= 0) {
            totalSum += A[i][j];
            i++;
            j--;
        }
        return totalSum;
    }

    public static void main(String[] args) {
        int[][] a = { { 2, 2, 3 }, { 2, 2, 3 } };

        System.out.println("" + solve(a));
        System.out.println("" + diagnolSumNotEqIndex(a));

    }

}
