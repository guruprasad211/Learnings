package com.scaler.arrays.class10;

import java.util.Arrays;

/*
 * Given an array of integers A, of size N.

Return the maximum size subarray of A having only non-negative elements. 
If there are more than one such subarray, return the one having the smallest starting index in A.

NOTE: It is guaranteed that an answer always exists.
 */
public class MaxPostvSubArr {

    /*
     * Find all sub arrays and find the max num of elements in that sub array and store
     * start and end indexes to find the max sub array
     */
    public static int[] solve(int[] A) {
        int size = A.length;
        int startElem = 0;
        int endElem = size;
        int max = -1;
        for (int i = 0; i < size; i++) {
            boolean negFound = false;
            for (int j = i; j < size; j++) {
                int k = i;
                //to find all sub arrays starting from i
                while (k <= j) {
                    //if -ve num found break it
                    if (A[k] < 0) {
                        negFound = true;
                        break;
                    }
                    k++;
                }
                int subArrSize = k - i + 1;
                if (subArrSize > max) {
                    startElem = i;
                    endElem = k;
                    max = subArrSize;
                }

                if (negFound) {
                    break;
                }
            } //j for loop
        }

        int[] r = new int[endElem - startElem];
        int i = 0;
        System.out.println("startElem:" + startElem + " endElem:" + endElem);
        while (startElem < endElem) {
            r[i] = A[startElem];
            startElem++;
            i++;
        }
        return r;
    }

    public static void main(String[] args) {
        //int[] a = { 1, 2, 3, 4, 5 };
        //int[] a = { 1, 2, -3, 4, 5 };
        int[] a = { 1, 2, -3, 4, 5, 6 };
        System.out.println(Arrays.toString(solve(a)));
    }

}
