package com.scaler.arrays.class8;

import java.util.Arrays;

/*
You are given a n x n 2D matrix A representing an image.
Rotate the image by 90 degrees (clockwise).
You need to do this in place.
Note: If you end up using an additional array, you will only receive partial score.

I/p:    1 2
        3 4
        
O/P     3 1 
        4 2

 */
public class RotateMatrix {

    /*
     * To rotate t0 90 degree the final o/p looks like below
     * 1. transpose cols to rows
     * 2. reverse rows
     */
    public static void rotate90Degrees(int[][] A) {
        int rowSize = A.length;
        int colSize = A[0].length;

        //transpose cols to rows
        for (int i = 0; i < rowSize - 1; i++) {
            for (int j = i + 1; j < colSize; j++) {
                //swap
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }

        //Reverse rows
        for (int i = 0; i < rowSize; i++) {
            int left = 0;
            int right = colSize - 1;

            while (left < right) {
                //swap 2 pointers
                int temp = A[i][left];
                A[i][left] = A[i][right];
                A[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    private static void print2DArray(int[][] res) {
        for (int[] r : res) {
            System.out.println(" " + Arrays.toString(r));
        }
    }

    public static void main(String[] args) {
        int[][] a = { { 1, 2 }, { 3, 4 } };
        rotate90Degrees(a);
        print2DArray(a);

        int[][] b = { { 1 } };
        System.out.println("-------------------");
        rotate90Degrees(b);
        print2DArray(a);

    }

}
