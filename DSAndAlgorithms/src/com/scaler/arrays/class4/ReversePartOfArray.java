package com.scaler.arrays.class4;

import java.util.Arrays;

public class ReversePartOfArray {
    
    public static int[] solve(int[] A, int B, int C) {
        if (A == null || A.length == 0) {
            return A;
        }

        if (B > C || B >= A.length || C >= A.length) {
            return A;
        }
        
        while (B < C) {
            int temp = A[B];
            A[B] = A[C];
            A[C] = temp;
            B++;
            C--;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] a = {2, 5, 6};
        int r[] = ReversePartOfArray.solve(a, 0, a.length-1);
        System.out.println("Reverse part Array:" + Arrays.toString(r));
    }

}
