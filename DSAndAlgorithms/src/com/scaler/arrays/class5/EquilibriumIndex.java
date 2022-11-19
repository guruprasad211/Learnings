package com.scaler.arrays.class5;

/*
 * You are given an array A of integers of size N.

Your task is to find the equilibrium index of the given array

The equilibrium index of an array is an index such that the sum of elements at lower 
indexes is equal to the sum of elements at higher indexes.

NOTE:

Array indexing starts from 0.
If there is no equilibrium index then return -1.
If there are more than one equilibrium indexes then return the minimum index.


 */
public class EquilibriumIndex {

    public int solve(int[] A) {
        long[] pfSums = new long[A.length];
        pfSums[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            pfSums[i] = pfSums[i - 1] + A[i];
        }

        //check if for first index is eq, by default left/right elements sum of 0 or last is 0
        if(pfSums[A.length-1] - A[0] == 0) {
            return 0;
        }
        int size = A.length;
        for (int i = 1; i < size; i++) {
            long sumLeft = pfSums[i - 1];
            long sumRight = pfSums[size - 1] - pfSums[i];
            if (sumLeft == sumRight) {
                return i;
            }
        }

        //check for last index
        /*if (pfSums[A.length - 2] == 0) {
            return (int) pfSums[A.length - 1];
        }*/

        return -1;
    }

    public static void main(String[] args) {

    }

}
