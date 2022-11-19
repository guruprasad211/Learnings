package com.scaler.arrays.class8;

import java.util.Arrays;

/*
    You are given a matrix A, you have to return another matrix which is the transpose of A.

    NOTE: Transpose of a matrix A is defined as - AT[i][j] = A[j][i] ; 
    Where 1 ≤ i ≤ col and 1 ≤ j ≤ row. The tranpose of a matrix switches the element at (i, j)th 
    index to (j, i)th index, and the element at (j, i)th index to (i, j)th index.


 */
public class TransposeColToRows {

    public static int[][] transpose(int[][] A) {
        int rowSize = A.length;
        int colSize = A[0].length;
        int[][] res = new int[colSize][rowSize];

        for (int i = 0; i < colSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                res[i][j] = A[j][i];
            }
        }
        return res;
    }

    /*
     * if its NXN we can transpose cols to rows
     */
    public static int[][] transposeInPlace(int[][] A) {
        int rowSize = A.length;
        int colSize = A[0].length;

        for (int i = 0; i < rowSize - 1; i++) {
            for (int j = i + 1; j < colSize; j++) {
                //swap
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
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
        int[][] res = transpose(a);
        print2DArray(res);

        int[][] b = { { 1, 2 }, { 1, 2 }, { 1, 2 } };
        System.out.println("-------------------");
        int[][] res1 = transpose(b);
        print2DArray(res1);

        System.out.println("-------------------");
        int[][] resSame = transposeInPlace(a);
        print2DArray(resSame);

        int[][] aa = { { 1, 2, 3, 10, 11 }, { 4, 5, 6, 12, 13 }, { 7, 8, 9, 14, 15 },
                { 27, 28, 29, 34, 35 }, { 37, 38, 39, 44, 45 } };
        System.out.println("-------***Original Array*****-------");
        print2DArray(aa);

        System.out.println("-------***in place*****-------");
        int[][] resSame1 = transposeInPlace(aa);
        print2DArray(resSame1);

        int[][] aa1 = { { 1, 2, 3, 10, 11 }, { 4, 5, 6, 12, 13 }, { 7, 8, 9, 14, 15 },
                { 27, 28, 29, 34, 35 }, { 37, 38, 39, 44, 45 } };
        
        System.out.println("--------****** not in place-------");
        int[][] resSame2 = transpose(aa1);
        print2DArray(resSame2);
    }

}
