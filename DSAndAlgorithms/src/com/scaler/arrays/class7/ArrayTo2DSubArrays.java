package com.scaler.arrays.class7;

import java.util.Arrays;

/*You are given an array A of N integers.
Return a 2D array consisting of all the subarrays of the array

Problem Constraints
1 <= N <= 100
1 <= A[i] <= 105

A = [1, 2, 3]

Output 1:
[[1], [1, 2], [1, 2, 3], [2], [2, 3], [3]]

*/
public class ArrayTo2DSubArrays {

    //TC: O(N^3)    SC: O(1)
    public static int[][] solve(int[] A) {
        int size = A.length;
        int totalSubArrays = size * (size + 1) / 2;
        int[][] twoDArray = new int[totalSubArrays][size];
        
        
        for (int s = 0; s < size; s++) {
            for (int e = 0; e < size; e++) {
                for (int i = s; i <= e; i++) {
                    twoDArray[s][i] = A[i];
                }
            }
        }
        return twoDArray;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };

        //System.out.println("" + subarraySum(a));
        //System.out.println("" + subarraySumUsingPrefixSum(a));
        //System.out.println("" + subarraySumUsingCarryForward(a));
        for (int[] r : solve(a)) {
            System.out.println("" + Arrays.toString(r));
        }

    }

}
