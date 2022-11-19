package com.scaler.arrays.class9;

public class SubArrayHavingSum {

    public static int solve(int[] A, int B, int C) {
        int size = A.length;

        //calculate sum of first sub Array range from 0 to B-1
        int sum = 0;
        for (int i = 0; i < B; i++) {
            sum += A[i];
        }

        if (sum == C) {
            return 1;
        }
        int s = 1;
        int e = B;
        //sliding window concept is used
        /*
         * In 1st step sum of 1st B elements is found
         * from second step onwards s moves one step forward and e moves one step to right
         * so add e element to sum and subtract s-1
         */
        while (e < size) {
            sum = sum + A[e] - A[s - 1];
            if (sum == C) {
                return 1;
            }
            s++;
            e++;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] A = { 4, 3, 2, 6 };
        System.out.println(solve(A, 2, 5));
        
        int[] B = {4, 2, 2};
        System.out.println(solve(B, 2, 8));
    }

}
