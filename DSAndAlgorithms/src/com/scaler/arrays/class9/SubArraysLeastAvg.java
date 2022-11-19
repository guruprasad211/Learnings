package com.scaler.arrays.class9;

/*
 * Given an array of integers A and an integer B, find and return the minimum number of swaps 
 * required to bring all the numbers less than or equal to B together.

Note: It is possible to swap any two elements, not necessarily consecutive.

A = [1, 12, 10, 3, 14, 10, 5]
 After swapping  12 and 3, A => [1, 3, 10, 12, 14, 10, 5].
 After swapping  the first occurence of 10 and 5, A => [1, 3, 5, 12, 14, 10, 10].
 Now, all elements less than or equal to 8 are together.
Explanation 2:

 A = [5, 17, 100, 11]
 After swapping 100 and 11, A => [5, 17, 11, 100].
 Now, all elements less than or equal to 20 are together.
 */
public class SubArraysLeastAvg {

    public static int solve(int[] A, int B) {
        int size = A.length;

        //Count no. of elemets <=size
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (A[i] <= B) {
                count++;
            }
        }

        if (count == 0 || count == 1) {
            return 0;
        }

        //count bad elements which are >B in first sub array
        int bad = 0;
        for (int i = 0; i < count; i++) {
            if (A[i] > B) {
                bad++;
            }
        }
        int s = 1;
        int e = count;
        int ans = bad;
        //sliding window concept is used
        /*
         */
        while (e < size) {

            if (A[s - 1] > B) {
                bad--;
            }
            if (A[e] > B) {
                bad++;
            }
            if (bad < ans) {
                ans = bad;
            }
            s++;
            e++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 1, 12, 10, 3, 14, 10, 5 };
        System.out.println(solve(A, 8));

        int[] B = { 5, 17, 100, 11 };
        System.out.println(solve(B, 20));
    }

}
