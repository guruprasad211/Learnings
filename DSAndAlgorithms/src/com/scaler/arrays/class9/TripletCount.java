package com.scaler.arrays.class9;

/*
 * You are given an array A of N elements. Find the number of triplets i,j and k 
 * such that i<j<k and A[i]<A[j]<A[k]
For Input 1: [1, 2, 4, 3]
The triplets that satisfy the conditions are [1, 2, 3] and [1, 2, 4].
For Input 2: [2, 1, 2, 3]
 
The triplet that satisfy the conditions is [1, 2, 3].

 */
public class TripletCount {

    public static int solveBruteForce(int[] A) {
        int size = A.length;

        //Count no. of subarrays

        int count = 0;
        //TC: O(N^3), SC: O(1)
        for (int i = 0; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    if (A[i] < A[j] && A[j] < A[k]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    /*
     * For every middle element find its lesser number count to its left
     * and more number count to its right. To get the result multiply the both lesser * more counts
     * 
     * 1 2 4 3
     * 
     * start from j=1 index and check for all j's
     * i will be left indexes and k will be of right indexes
     * 
     * TC: O(N^2), SC: O(1)
     */
    public static int solve(int[] A) {
        int size = A.length;

        //Count no. of subarrays
        int count = 0;
        for (int j = 1; j < size - 1; j++) {
            int i = 0;
            int k = j + 1;
            int lessCount = 0;
            int moreCount = 0;
            while (i < j) {
                if (A[i] < A[j]) {
                    lessCount++;
                }
                i++;
            }

            while (k < size) {
                if (A[k] > A[j]) {
                    moreCount++;
                }
                k++;
            }

            count += lessCount * moreCount;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 4, 3 };
        System.out.println("BruteForce:" + solveBruteForce(A));
        System.out.println(solve(A));

        int[] B = { 2, 1, 2, 3 };
        System.out.println("BruteForce:" + solveBruteForce(B));
        System.out.println(solve(B));
    }

}
