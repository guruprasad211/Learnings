package com.scaler.arrays.class8;

import java.util.Arrays;

/*
 * 
 */
public class RowWiseSums2DArray {

    public static int[] solve(int[][] A) {
        int rowSize = A.length;
        int colSize = A[0].length;
        int[] r = new int[rowSize];

        for (int j = 0; j < rowSize; j++) {
            int rowSum = 0;
            for (int k = 0; k < colSize; k++) {
                rowSum += A[j][k];
            }
            r[j] = rowSum;
        }
        return r;
    }

    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };

        System.out.println("" + Arrays.toString(solve(a)));

    }

}
