package com.scaler.arrays.class8;

public class PrintBoundaries {

    public static void printBoundsClockWise(int[][] a) {
        int i = 0;
        int j = 0;

        //i=0, j=n-2
        for (int k = 1; k < a.length; k++) {
            System.out.print(a[i][j] + " ");
            j++;
        }

        //i=0 to n-2, j=4
        for (int k = 1; k < a.length; k++) {
            System.out.print(a[i][j] + " ");
            i++;
        }

        //for i=n-1, j= 4 to 1
        for (int k = 1; k < a.length; k++) {
            System.out.print(a[i][j] + " ");
            j--;
        }

        //i=4 to 1, j=0
        for (int k = 1; k < a.length; k++) {
            System.out.print(a[i][j] + " ");
            i--;
        }
    }

    public static void printBoundsClockWiseInSpiral(int[][] a) {
        int N = a.length;

        int i = 0;
        int j = 0;

        while (N > 0) {
            System.out.println("");
            System.out.println("i:" + i + " j:" + j + " N:" + N);
            //i=0, j=n-2
            for (int k = 1; k < N; k++) {
                System.out.print(a[i][j] + " ");
                j++;
            }

            //i=0 to n-2, j=4
            for (int k = 1; k < N; k++) {
                System.out.print(a[i][j] + " ");
                i++;
            }

            //for i=n-1, j= 4 to 1
            for (int k = 1; k < N; k++) {
                System.out.print(a[i][j] + " ");
                j--;
            }

            //i=4 to 1, j=0
            for (int k = 1; k < N; k++) {
                System.out.print(a[i][j] + " ");
                i--;
            }

            N -= 2;

            System.out.println("");
            System.out.println("i:" + i + " j:" + j + " N:" + N);

            if (N == -1) {
                System.out.println(a[i][j]);
            }
            else {
                i++;
                j++;
            }
        }

    }

    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3, 10, 11 }, { 4, 5, 6, 12, 13 }, { 7, 8, 9, 14, 15 },
                { 20, 21, 22, 23, 24 }, { 25, 26, 27, 28, 29 } };
        printBoundsClockWise(a);
        System.out.println("----------------------");
        System.out.println("Printing the matrices in spiral");
        printBoundsClockWiseInSpiral(a);
    }

}
