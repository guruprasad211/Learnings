package com.scaler.arrays.class9;

/*
*Given an array of size N, find the subarray of size K with the least average.

First argument contains an array A of integers of size N.
Second argument contains integer k.

Return the index of the first element of the subarray of size k that has least average.
Array indexing starts from 0.

Input 1:
A=[3, 7, 90, 20, 10, 50, 40]
B=3
Input 2:

A=[3, 7, 5, 20, -10, 0, 12]
B=2

Output 1:
3
Output 2:
4

Example Explanation

Explanation 1:
    Subarray between indexes 3 and 5
    The subarray {20, 10, 50} has the least average 
    among all subarrays of size 3.
Explanation 2:

     Subarray between [4, 5] has minimum average
     
     
 */
public class MinimumSwaps {

    public static int solve(int[] A, int B) {
        int size = A.length;
        //to store index of least avg
        int ans = -1;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < size - B + 1; i++) {
            int s = i;
            int e = B + i;
            //sliding window concept is used
            /*
             * 0 1 2 3 4 5 6
             * B = 3 
             */
            int sum = 0;
            while (s < e) {
                sum += A[s];
                s++;
            }

            if (sum < minVal) {
                ans = i;
                minVal = sum;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 3, 7, 90, 20, 10, 50, 40 };
        System.out.println(solve(A, 3));

        int[] B = { 3, 7, 5, 20, -10, 0, 12 };
        System.out.println(solve(B, 2));
    }

}
