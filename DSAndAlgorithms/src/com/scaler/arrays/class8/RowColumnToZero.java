package com.scaler.arrays.class8;

import java.util.Arrays;

/*
 * You are given a 2D integer matrix A, make all the elements in a row or column zero 
 * if the A[i][j] = 0. Specifically, make entire ith row and jth column zero.

Input 1:

[1,2,3,4]
[5,6,7,0]
[9,2,0,4]

Output 1:

[1,2,0,0]
[0,0,0,0]
[0,0,0,0]

Explanation 1:

A[2][4] = A[3][3] = 0, so make entire 2nd row, 3rd row, 3rd column and 4th column zero.

 */
public class RowColumnToZero {

    public static int[][] solve(int[][] A) {
        int rowSize = A.length;
        int colSize = A[0].length;

        int[][] r = copy2DArray(A);

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (A[i][j] == 0) {
                    //make row i and column j values to zero

                    int column = 0;
                    //make entire row zeros
                    while (column < colSize) {
                        r[i][column] = 0;
                        column++;
                    }

                    int row = 0;
                    //make entire row zeros
                    while (row < rowSize) {
                        r[row][j] = 0;
                        row++;
                    }
                }
            }
        }
        return r;
    }

    private static void print2DArray(int[][] res) {
        for (int[] r : res) {
            System.out.println(" " + Arrays.toString(r));
        }
    }

    private static int[][] copy2DArray(int[][] A) {
        int rowSize = A.length;
        int colSize = A[0].length;

        int[][] r = new int[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                r[i][j] = A[i][j];
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3, 4 }, { 4, 5, 6, 0 }, { 7, 8, 0, 9 } };
        int[][] r = solve(a);
        print2DArray(r);

        int[][] b = { { 97, 18, 55, 1, 50, 17, 16, 0, 22, 14 },
                { 58, 14, 75, 54, 11, 23, 54, 95, 33, 23 }, { 73, 11, 2, 80, 6, 43, 67, 82, 73, 4 },
                { 61, 22, 23, 68, 23, 73, 85, 91, 25, 7 },
                { 6, 83, 22, 81, 89, 85, 56, 43, 32, 89 }, { 0, 6, 1, 69, 86, 7, 64, 5, 90, 37 },
                { 10, 3, 11, 33, 71, 86, 6, 56, 78, 31 },
                { 16, 36, 66, 90, 17, 55, 27, 26, 99, 59 },
                { 67, 18, 65, 68, 87, 3, 28, 52, 9, 70 },
                { 41, 19, 73, 5, 52, 96, 91, 10, 52, 21 } };
        int[][] r1 = solve(b);
        print2DArray(r1);

    }

}
