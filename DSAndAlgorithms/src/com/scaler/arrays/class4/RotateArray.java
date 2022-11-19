package com.scaler.arrays.class4;

import java.util.Arrays;

/**
 * Given an integer array A of size N and an integer B, 
 * you have to return the same array after rotating it B times towards the right.
 * 
 * let elements be  a1 a2 a3 a4 a5
 * 
 * rotate 1 time :  a5 a1 a2 a3 a4
 *         2    :   a4 a5 a1 a2 a3
 *         3    :   a3 a4 a5 a1 a2
 *         
 *   Algo: Reverse full array   :   a5 a4 a3 a2 a1  (if we see above for r=3, its same as reverse of part arrays
 *   ie. a5 a4 a3 if we reverse 3 elements its same as above and reverse last a2 a1 to form last part)
 *   
 *  
 * @author guruprasadchowdaryp
 *
 */
public class RotateArray {

    public static int[] solve(int[] A, int B) {

        if (A == null || A.length == 0) {
            return A;
        }

        //if B > array Size it must be equal to % of A size rotations
        B = B % A.length;

        if (B == 0) {
            return A;
        }

        //Reverse full array
        reversePartArray(A, 0, A.length - 1);

        //reverse B elements again from start 0
        reversePartArray(A, 0, B - 1);

        //reverse last elements other than B elements
        reversePartArray(A, B, A.length - 1);

        return A;
    }

    public static int[] reversePartArray(int[] A, int B, int C) {
        if (A == null || A.length == 0) {
            return A;
        }

        if (B > C || B >= A.length || C >= A.length) {
            return A;
        }

        while (B < C) {
            //swap elements
            int temp = A[B];
            A[B] = A[C];
            A[C] = temp;
            B++;
            C--;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] a = { 2, 5, 6 };
        int r[] = RotateArray.solve(a, 2);
        System.out.println("Reverse part Array:" + Arrays.toString(r));
    }

}
