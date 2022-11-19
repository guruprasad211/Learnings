package com.scaler.arrays.class8;

import java.util.Arrays;

/*
 * You are given two matrices A & B of equal dimensions and you have to check whether two matrices are equal or not.

NOTE: Both matrices are equal if A[i][j] == B[i][j] for all i and j in the given range.
 */
public class MatricesEqual {

    public static int solve(int[][] A, int[][] B) {
        int rowSize = A.length;
        int colSize = A[0].length;

        int rowSizeB = B.length;
        int colSizeB = B[0].length;

        if (rowSize != rowSizeB || colSize != colSizeB) {
            return 0;
        }

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (A[i][j] != B[i][j]) {
                    return 0;
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[][] a = { { 1, 2 }, { 3, 4 } };
        int[][] b = { { 1, 2 }, { 3, 4 } };
        System.out.println("" + solve(a, b));

    }

}
