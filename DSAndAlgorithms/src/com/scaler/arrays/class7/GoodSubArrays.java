package com.scaler.arrays.class7;

/*
 * Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
Your task is to find the count of good subarrays in A.

 */
public class GoodSubArrays {

    public static int solve(int[] A, int B) {
        int size = A.length;
        int subArrayCounts = 0;
        for (int s = 0; s < size; s++) {
            for (int e = s; e < size; e++) {
                int sum = 0;
                //Forms Subarray
                for (int i = s; i <= e; i++) {
                    sum += A[i];
                }
                
                if ((e + 1) % 2 == 0 && sum < B) {
                    System.out.println("even sum:" + sum + " e:"+ (e+1));
                    subArrayCounts++;
                }
                if ((e + 1) % 2 != 0 && sum > B) {
                    System.out.println("odd sum:" + sum + " e:"+ (e+1));
                    subArrayCounts++;
                }
            }
        }
        return subArrayCounts;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        //int[] a = { 13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9 };

        System.out.println("" + solve(a, 4));
        //System.out.println("" + solve(a, 65));

    }

}
