package com.scaler.arrays.class4;

/*
 * Given an integer array A of size N. In one second, you can increase the value of one element by 1.

Find the minimum time in seconds to make all elements of the array equal.

{5,2,7,9,10}    to make all elements equal we have to find max element 
and count all the number to add to itself to make number equal
 */
public class TimeToEquality {

    /*
     * Find max element in the array, and to make it equal add all the sums having max-elements
     */
    public static int solve(int[] A) {
        int sum = 0;
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        for (int i = 0; i < A.length; i++) {
            sum += max - A[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = { 5, 2, 7, 9, 10 };
        System.out.println("minimum Time:" + solve(a));
    }

}
