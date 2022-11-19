package com.scaler.arrays.class4;

import java.util.Arrays;

public class ReverseArray {

    public static int[] solve(int[] A) {
        if (A == null || A.length == 0 || A.length == 1) {
            return A;
        }

        int l = 0;
        int r = A.length - 1;

        while (l < r) {
            int temp = A[l];
            A[l] = A[r];
            A[r] = temp;
            l++;
            r--;
        }
        return A;
    }

    public static void main(String[] args) {
        //int[] a = { 2, 5, 6 };
        int[] a = { 2, 5, 6, 9, 6, 2, 10, 1 };
        int r[] = ReverseArray.solve(a);
        System.out.println("Reverse part Array:" + Arrays.toString(r));
    }

}
