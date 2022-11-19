package com.scaler.arrays.class7;

/*
 * You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
But the sum must not exceed B.

Problem Constraints
1 <= A <= 103
1 <= B <= 109
1 <= C[i] <= 106

Input Format
The first argument is the integer A.
The second argument is the integer B.
The third argument is the integer array C.

Output Format
Return a single integer which denotes the maximum sum.

Example Input
Input 1:
A = 5
B = 12
C = [2, 1, 3, 4, 5]
Input 2:

A = 3
B = 1
C = [2, 2, 2]

Example Output
Output 1:
12
Output 2:
0

Example Explanation
Explanation 1:
We can select {3,4,5} which sums up to 12 which is the maximum possible sum.
Explanation 2:

All elements are greater than B, which means we cannot select any subarray.
Hence, the answer is 0.

 */
public class MaxSumSubArray {

    /*
     * if sum of subArray is equal to max sum return, as it will be the max sum in the array
     * if sum os less than the maxsum, assign the max to maxSum and iterate all the subarrays to find max sum
     * 
     */
    public static int maxSubarray(int A, int B, int[] C) {
        int maxSum = 0;
        for (int s = 0; s < A; s++) {
            int sum = 0;
            for (int e = s; e < A; e++) {
                sum += C[e];
                if (sum == B) {
                    return sum;
                }
                //if sum is less then given sum
                if (sum < B) {
                    maxSum = Math.max(maxSum, sum);
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        //int[] a = { 2, 2, 2 };
        //int[] a = { 2, 1, 3, 4, 5 };
        int[] a = { 4 };

        //System.out.println(solve(a.length, 1, a));
        //System.out.println(""+maxSubarray(a.length, 12, a));
        System.out.println("" + maxSubarray(a.length, 75, a));

    }

}
