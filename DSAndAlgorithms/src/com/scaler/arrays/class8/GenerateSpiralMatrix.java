package com.scaler.arrays.class8;

import java.util.Arrays;

public class GenerateSpiralMatrix {

    public static int[][] generateMatrix(int A) {
        int[][] r = new int[A][A];
        int i = 0;
        int j = 0;
        int number = 1;
        while (A > 0) {
            //System.out.println("");
            //System.out.println("i:" + i + " j:" + j + " N:" + A);
            //i=0, j=n-2
            for (int k = 1; k < A; k++) {
                r[i][j] = number++;
                j++;
            }

            //i=0 to n-2, j=4
            for (int k = 1; k < A; k++) {
                r[i][j] = number++;
                i++;
            }

            //for i=n-1, j= 4 to 1
            for (int k = 1; k < A; k++) {
                r[i][j] = number++;
                j--;
            }

            //i=4 to 1, j=0
            for (int k = 1; k < A; k++) {
                r[i][j] = number++;
                i--;
            }

            A -= 2;

            //System.out.println("");
            //System.out.println("i:" + i + " j:" + j + " N:" + A);

            if (A == -1) {
                r[i][j] = number++;
            }
            else {
                i++;
                j++;
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
        //print2DArray(generateMatrix(1));
        print2DArray(generateMatrix(5));
    }

}
