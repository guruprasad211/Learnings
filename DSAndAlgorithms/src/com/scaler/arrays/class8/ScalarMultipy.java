package com.scaler.arrays.class8;

import java.util.Arrays;

/*
 * You are given a matrix A and and an integer B, 
 * you have to perform scalar multiplication of matrix A with an integer B.

A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
B = 2 

Output 1:

[[2, 4, 6], [8, 10, 12], [14, 16, 18]]


 */
public class ScalarMultipy {

    public static int[][] solve(int[][] A, int B) {
        int rowSize = A.length;
        int colSize = A[0].length;

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                A[i][j] = A[i][j] * B;
            }
        }
        return A;
    }

    private static void print2DArray(int[][] res) {
        for (int[] r : res) {
            System.out.println(" " + Arrays.toString(r));
        }
    }

    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        //int[][] b = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };
        int[][] r = solve(a, 2);
        print2DArray(r);

    }

}
