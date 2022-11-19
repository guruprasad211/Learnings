package com.scaler.arrays.class8;

import java.util.Arrays;

/*
 * You are given two matrices A & B of same size, you have to return another matrix 
 * which is the sum of A and B.

Problem Constraints

1 <= A.size(), B.size() <= 1000

1 <= A[i].size(), B[i].size() <= 1000

1 <= A[i][j], B[i][j] <= 1000

 */
public class MatricesSum {

    public static int[][] solve(int[][] A, int[][] B) {
        int rowSize = A.length;
        int colSize = A[0].length;

        int rowSizeB = B.length;
        int colSizeB = B[0].length;

        if (rowSize != rowSizeB || colSize != colSizeB) {
            return null;
        }

        int[][] r = new int[rowSize][colSize];
        for (int i = 0; i < colSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                r[j][i] = A[j][i] + B[j][i];
            }
        }
        return r;
    }

    private static void print2DArray(int[][] res) {
        for (int[] r : res) {
            System.out.println(" " + Arrays.toString(r));
        }
    }

    public static void main(String[] args) {
        /*int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] b = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };
        int[][] r = solve(a, b);
        print2DArray(r);*/

        int[][] a = { { 1 }, { 4 }, { 5 }, { 6 }, { 7 }, { 8 }, { 9 } };
        int[][] b = { { 1 }, { 4 }, { 5 }, { 6 }, { 7 }, { 8 }, { 9 } };
        int[][] r = solve(a, b);
        print2DArray(r);

    }

}
