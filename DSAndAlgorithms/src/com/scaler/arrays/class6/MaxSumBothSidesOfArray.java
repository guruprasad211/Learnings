package com.scaler.arrays.class6;

import java.util.Arrays;

/*
 * You are given an integer array A of size N.

You have to pick B elements in total. Some (possibly 0) elements from left end of array A 
and some (possibly 0) from the right end of array A to get the maximum sum.

Find and return this maximum possible sum.



 */
public class MaxSumBothSidesOfArray {

    /*
     * B=3
     * 
     * l    r
     * -----------
     * 0    3
     * 1    2
     * 2    1
     * 3    0
     * 
     * 
     */
    public static int solveUsingPrefix(int[] A, int B) {
        int size = A.length;
        if (size == 1) {
            return A[0];
        }

        if (B > size) {
            return 0;
        }

        int[] prfSums = new int[size];

        prfSums[0] = A[0];
        for (int i = 1; i < size; i++) {
            prfSums[i] = prfSums[i - 1] + A[i];
        }
        int ans = Integer.MIN_VALUE;
        for (int l = 0; l <= B; l++) {
            int r = B - l;//right index
            //last B elements
            int rIndx = size - r;
            int leftSum = 0;
            int rightSum = 0;

            if (l != 0) {
                leftSum = prfSums[l - 1];
            }

            if (r != 0) {
                rightSum = prfSums[size - 1] - prfSums[rIndx - 1];
            }
            ans = Math.max(ans, rightSum + leftSum);
        }

        return ans;
    }

    /*
     * calculate prefix sum and suffix sums in 2 arrays
     * 
     * iterate till B=-1
     * take 2 variables l=-1 and right = size - B
     * 
     * check the elements and store the max by incrementing l and right (Until size)
     * 
     */
    public static int solve(int[] A, int B) {
        int size = A.length;
        if (size == 1) {
            return A[0];
        }

        if (B > size) {
            return 0;
        }

        int[] firstPrefixSums = new int[size];
        //store all the sums from last with 0 index
        int[] lastSuffixSums = new int[size];

        int lastIndex = size - 1;
        firstPrefixSums[0] = A[0];
        lastSuffixSums[lastIndex] = A[lastIndex];
        for (int i = 1; i < size; i++) {
            firstPrefixSums[i] = firstPrefixSums[i - 1] + A[i];
            lastSuffixSums[lastIndex - i] = lastSuffixSums[lastIndex - i + 1] + A[lastIndex - i];
        }
        //System.out.println("firstPrefixSums:" + Arrays.toString(firstPrefixSums)
        //      + "firstSuffixSums:" + Arrays.toString(lastSuffixSums));

        if (B == size) {
            return firstPrefixSums[lastIndex];
        }

        int max = Integer.MIN_VALUE;
        int leftIndex = -1;
        int rightIndex = size - B;
        //B = B - 1;//for zero index based
        while (B >= 0) {
            //right max
            if (leftIndex == -1) {
                max = Math.max(max, lastSuffixSums[rightIndex]);
            }
            //left max
            if (rightIndex == size) {
                max = Math.max(max, firstPrefixSums[leftIndex]);
            }
            if (leftIndex != -1 && rightIndex != size) {
                max = Math.max(max, firstPrefixSums[leftIndex] + lastSuffixSums[rightIndex]);
            }
            leftIndex++;
            rightIndex++;
            B--;
        }

        return max;
    }

    /*
     * 1 2 3 4 5
     * B=3
     * 
     * first find sum of last 3 elements
     * 
     * l=0,1,2 r=2,3,4
     */
    public static int solveUsingSliding(int[] A, int B) {
        int size = A.length;
        if (size == 1) {
            return A[0];
        }

        if (B > size) {
            return 0;
        }

        int rightBSum = 0;
        //stores last B elements index
        int rIndx = size - B;
        for (int i = rIndx; i < size; i++) {
            rightBSum += A[i];
        }
        int ans = rightBSum;
        int rightSum = rightBSum;
        int leftSum = 0;
        for (int l = 0; l < B; l++) {
            //subtract 
            if (rIndx < size) {
                rightSum -= A[rIndx];
            }
            else {
                rightSum = 0;
            }
            leftSum += A[l];
            ans = Math.max(ans, rightSum + leftSum);
            rIndx++;
        }

        return ans;
    }

    public static void main(String[] args) {
        //int[] a = { 5, -2, 3, 1, 2 };
        //int[] a = { 1, 2, 3 };
        int[] a = { 2, 3, 4, 3, 4, 4, 1 };
        int B = 6;
        //System.out.println("MaxSumBothSidesOfArray:" + solve(a, 2));
        System.out.println("MaxSumBothSidesOfArray:" + solveUsingPrefix(a, B));
        System.out.println("MaxSumBothSidesOfArray:" + solve(a, B));
        System.out.println("MaxSumBothSidesOfArray:" + solveUsingSliding(a, B));
    }

}
