package com.scaler.arrays.class10;

import java.util.Arrays;

/*
 * Given an array of integers A and multiple values in B, 
 * which represents the number of times array A needs to be left rotated.

Find the rotated array for each value and return the result in the from of a 
matrix where ith row represents the rotated array for the ith value in B.
A = [1, 2, 3, 4, 5]
    B = [2, 3]
    
    Output 1:
 
    [ [3, 4, 5, 1, 2]
     [4, 5, 1, 2, 3] ]


 */
public class LeftRotateArray {

    public static int[][] solve(int[] A, int[] B) {
        int sizeA = A.length;
        int sizeB = B.length;
        int res[][] = new int[sizeB][sizeA];

        //reverse entire array using in place. And use this reverse array to get solution
        int l = 0;
        int r = sizeA - 1;
        while (l < r) {
            int temp = A[l];
            A[l] = A[r];
            A[r] = temp;
            l++;
            r--;
        }

        for (int i = 0; i < sizeB; i++) {
            //reverse left array
            int rTimes = B[i] > sizeA ? B[i] % sizeA : B[i];
            l = sizeA - rTimes - 1;
            int j = 0;
            int[] tempArr = new int[sizeA];
            while (l >= 0) {
                tempArr[j] = A[l--];
                j++;
            }

            l = sizeA - rTimes;
            int right = sizeA - 1;
            //reverse right array
            while (right >= l) {
                tempArr[j] = A[right];
                right--;
                j++;
            }
            res[i] = tempArr;
        }

        return res;
    }

    public static void print(int[][] r) {
        for (int[] a : r) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {

        int[] a = { 1, 2, 3, 4, 5 };
        int[] b = { 7, 3 };

        int[][] r = solve(a, b);
        print(r);
    }

}
