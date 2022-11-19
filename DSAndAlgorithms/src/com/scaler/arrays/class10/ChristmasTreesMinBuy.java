package com.scaler.arrays.class10;

import java.util.Arrays;

/*
 *You are given an array A consisting of heights of Christmas trees and an array B of the same size consisting of the cost of each of the trees (Bi is the cost of tree Ai, where 1 ≤ i ≤ size(A)), and you are supposed to choose 3 trees (let's say, indices p, q, and r), such that Ap < Aq < Ar, where p < q < r.
The cost of these trees is Bp + Bq + Br.

You are to choose 3 trees such that their total cost is minimum. Return that cost.

If it is not possible to choose 3 such trees return -1.


A = [1, 6, 4, 2, 6, 9]
 B = [2, 5, 7, 3, 2, 7]
 
 We can choose the trees with indices 1, 4 and 5, and the cost is 2 + 3 + 2 = 7. 
 This is the minimum cost that we can get.
 */
public class ChristmasTreesMinBuy {

    /*
     * Find all sub arrays and find the max num of elements in that sub array and store
     * start and end indexes to find the max sub array
     */
    public static int solve(int[] A, int[] B) {
        int size = A.length;
        int minPrice = Integer.MAX_VALUE;
        for (int j = 1; j < size; j++) {
            //find left min numb
            int l = Integer.MAX_VALUE;
            for (int i = j - 1; i >= 0; i--) {
                if (A[i] < A[j]) {
                    l = Math.min(l, B[i]);
                }
            }

            //find left min numb
            int r = Integer.MAX_VALUE;
            for (int k = j + 1; k < size; k++) {
                if (A[k] > A[j]) {
                    r = Math.min(r, B[k]);
                }
            }

            if (l < Integer.MAX_VALUE && r < Integer.MAX_VALUE) {
                minPrice = Math.min(minPrice, l + r + B[j]);
            }
        }
        return Integer.MAX_VALUE == minPrice ? -1 : minPrice;
    }

    public static void main(String[] args) {
        int[] a = { 1, 3, 5 };
        int[] b = { 1, 2, 3 };
        System.out.println(solve(a, b));

        int[] aa = { 1, 6, 4, 2, 6, 9 };
        int[] bb = { 2, 5, 7, 3, 2, 7 };

        System.out.println(solve(aa, bb));
    }

}
