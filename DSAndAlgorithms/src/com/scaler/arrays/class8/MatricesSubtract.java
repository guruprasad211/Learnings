package com.scaler.arrays.class8;

import java.util.Arrays;

/*
 * You are given two integer matrices A and B having same size(Both having same number of rows (N) 
 * and columns (M). You have to subtract matrix B from A and return the resultant matrix. (i.e. 
 * return the matrix A - B).

 */
public class MatricesSubtract {

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
                r[j][i] = A[j][i] - B[j][i];
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
        int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] b = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };
        int[][] r = solve(a, b);
        print2DArray(r);

        int[][] a1 = { { 1 }, { 4 }, { 5 }, { 6 }, { 7 }, { 8 }, { 9 } };
        int[][] b1 = { { 1 }, { 4 }, { 5 }, { 6 }, { 7 }, { 8 }, { 9 } };
        int[][] r1 = solve(a1, b1);
        print2DArray(r1);

    }

}
