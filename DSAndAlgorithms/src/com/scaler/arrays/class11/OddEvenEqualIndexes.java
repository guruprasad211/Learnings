package com.scaler.arrays.class11;

import java.util.Arrays;

/*
 * Given an array, arr[] of size N, the task is to find the count of array indices such that 
 * removing an element from these indices makes the sum of even-indexed and odd-indexed array elements 
 * equal.

A=[2, 1, 6, 4]
O/P: 1
 */
public class OddEvenEqualIndexes {

    public static int solveUsingPrefixSums(int[] A) {
        int sizeA = A.length;
        int[] oddPfSums = new int[sizeA];
        int[] evenPfSums = new int[sizeA];
        oddPfSums[0] = 0;
        evenPfSums[0] = A[0];
        for (int i = 1; i < sizeA; i++) {
            if (i % 2 != 0) {
                oddPfSums[i] = oddPfSums[i - 1] + A[i];
            }
            else {
                oddPfSums[i] = oddPfSums[i - 1];
            }

            if (i % 2 == 0) {
                evenPfSums[i] = evenPfSums[i - 1] + A[i];
            }
            else {
                evenPfSums[i] = evenPfSums[i - 1];
            }
        }
        int count = 0;

        for (int i = 0; i < sizeA; i++) {
            int xEvenSum = oddPfSums[sizeA - 1] - oddPfSums[i];
            int xOddSum = evenPfSums[sizeA - 1] - evenPfSums[i];
            if (i != 0) {
                xEvenSum += evenPfSums[i - 1];
                xOddSum += oddPfSums[i - 1];
            }

            if (xEvenSum == xOddSum) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //int[] a = { 2, 1, 6, 4 };
        int[] a = { 1, 1, 1 };
        System.out.println(solveUsingPrefixSums(a));
    }

}
