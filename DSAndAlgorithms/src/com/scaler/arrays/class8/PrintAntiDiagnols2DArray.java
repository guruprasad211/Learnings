package com.scaler.arrays.class8;

import java.util.Arrays;

/*
 * Give a N * N square matrix A, return an array of its anti-diagonals. 
 * Look at the example for more details.
 * 
 * Input 1:
1 2 3
4 5 6
7 8 9

Output 1:
1 0 0
2 4 0
3 5 7
6 8 0
9 0 0


 */
public class PrintAntiDiagnols2DArray {

    public static int[][] diagonal(int[][] A) {
        int rowSize = A.length;
        int colSize = A[0].length;
        int numOfDiagnols = colSize + rowSize - 1;
        //System.out.println("numOfDiagnols:" + numOfDiagnols);
        int[][] res = new int[numOfDiagnols][colSize];

        //to print all the rows. Here its numOfDiagnols
        int rowIndex = 0;
        int colIndex = 0;//num of Columns

        //iterate all columns keeping row index fixed
        int i = 0;
        int j = 0;
        //this prints all diagonals upto colsize (last column to half diagonal of 2D array)
        while (colIndex < colSize) {
            //row index
            i = 0;
            j = colIndex;
            while (i <= colIndex && i < rowSize) {
                res[rowIndex][i] = A[i][j];
                i++;
                j--;
            }

            rowIndex++;
            colIndex++;
        }

        //to print rows from last colIndex column to last row except first row
        i = 0;
        while (i < rowSize) {
            i++;
            j = colSize - 1;
            //to get all columns from 0 to last
            colIndex = 0;
            int rowIndexPrint = i;
            while (rowIndexPrint < rowSize) {
                res[rowIndex][colIndex] = A[rowIndexPrint][j];
                colIndex++;
                rowIndexPrint++;
                j--;
            }

            rowIndex++;
        }
        return res;
    }

    public static int[][] diagonalUsingFor(int[][] A) {
        int rowSize = A.length;
        int colSize = A[0].length;
        int numOfDiagnols = colSize + rowSize - 1;
        //System.out.println("numOfDiagnols:" + numOfDiagnols);
        int[][] res = new int[numOfDiagnols][colSize];

        //to print all the rows. Here its numOfDiagnols
        int rowIndex = 0;
        //num of Columns

        for (int j = 0; j < colSize; j++) {
            int x = 0;
            int y = j;
            int colIndex = 0;
            while (x < rowSize && y >= 0) {
                //System.out.println("" + A[x][y]);
                res[rowIndex][colIndex] = A[x][y];
                x++;
                y--;
                colIndex++;
            }
            rowIndex++;
        }

        for (int i = 1; i < rowSize; i++) {
            int x = i;
            int y = colSize - 1;
            int colIndex = 0;
            while (x < rowSize && y >= 0) {
                //System.out.println("" + A[x][y]);
                res[rowIndex][colIndex] = A[x][y];
                x++;
                y--;
                colIndex++;
            }
            rowIndex++;
        }
        return res;
    }

    private static void print2DArray(int[][] res) {
        for (int[] r : res) {
            System.out.println(" " + Arrays.toString(r));
        }
    }

    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] res = diagonal(a);
        print2DArray(res);

        System.out.println("-------------------");
        int[][] res1 = diagonalUsingFor(a);
        print2DArray(res1);

    }

}
