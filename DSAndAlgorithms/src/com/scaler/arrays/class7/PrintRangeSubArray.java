package com.scaler.arrays.class7;

import java.util.Arrays;

public class PrintRangeSubArray {

    public static int[] solve(int[] A, int B, int C) {
        int[] range = new int[C - B + 1];
        int j = 0;
        for (int i = B; i <= C; i++) {
            range[j] = A[i];
            j++;
        }
        return range;
    }

    public static void main(String[] args) {
        //int[] a = { 1, 2, 3 };
        int[] a = { 4, 3, 2, 6};

        //System.out.println(Arrays.toString(solve(a, 0, 1)));
        System.out.println(Arrays.toString(solve(a, 1, 3)));

    }

}
