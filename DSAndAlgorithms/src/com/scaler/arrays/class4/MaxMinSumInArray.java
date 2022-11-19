package com.scaler.arrays.class4;

/**
 * Find Total no. of elements greater than itself
 * 
 * {-3,-2,0,1,5,7,4,2,9,5,9} o/p -3 + 9 = 6
 * 
 * @author guruprasadchowdaryp
 *
 */
public class MaxMinSumInArray {
    
    public static int solve(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        
        int max = A[0];
        int min = A[0];
        
        for (int i = 1; i < A.length; i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }
        return min + max;
    }

    public static void main(String[] args) {
        //int[] a = { -3, -2, 0, 1, 5, 7, 4, 2, 9, 5, 9 };
        //int[] a = { 8, 8, 8, 8 };
        int[] a = {10, 11, -2, 0, 1, 5, 7, 4, 2, 9, 5, 9 };

        System.out
                .println("MaxNumbersGtrThanItself:" + MaxMinSumInArray.solve(a));
    }

}
