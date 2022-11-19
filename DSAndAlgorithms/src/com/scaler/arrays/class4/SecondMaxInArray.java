package com.scaler.arrays.class4;

/**
 * Find Total no. of elements greater than itself
 * 
 * {-3,-2,0,1,5,7,4,2,9,5,9} o/p -3 + 9 = 6
 * 
 * @author guruprasadchowdaryp
 *
 */
public class SecondMaxInArray {

    public static int solve(int[] A) {
        if (A == null || A.length < 2) {
            return -1;
        }

        //maintain two max
        int max1 = A[0];
        int max2 = Integer.MIN_VALUE;

        for (int i = 1; i < A.length; i++) {
            if (A[i] > max1) {
                max2 = max1;
                max1 = A[i];
            }
            else if (A[i] != max1 && A[i] > max2) {
                max2 = A[i];
            }
        }
        return max2;
    }

    public static void main(String[] args) {
        //int[] a = { -3, -2, 0, 1, 5, 7, 4, 2, 9, 5, 9 };
        //int[] a = { 8, 8, 8, 8 };
        int[] a = { 10, -2, 0, 1, 5, 20, 7, 4, 10, 2, 9, 5, 9 };

        System.out.println("MaxNumbersGtrThanItself:" + SecondMaxInArray.solve(a));
    }

}
