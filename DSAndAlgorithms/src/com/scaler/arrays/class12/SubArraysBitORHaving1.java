package com.scaler.arrays.class12;

/*
 * Given an array B of length A with elements 1 or 0. Find the number of subarrays 
 * such that the bitwise OR of all the elements present in the subarray is 1.
The first argument is a single integer A.
The second argument is an integer array B.

Input 1:
 A = 3
B = [1, 0, 1]
Input 2:
 A = 2
B = [1, 0]

Example Output
Output 1:
5
Output2:
2

 */
public class SubArraysBitORHaving1 {
    /*
     * TC:O(N^3) Time limit Exceeded
     */
    public static long solve(int A, int[] B) {
        long count = 0;
        for (int i = 0; i < A; i++) {
            for (int j = i; j < A; j++) {
                for (int k = i; k <= j; k++) {
                    if (B[k] == 1) {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
    
    /*
     * to find all subarrays having 1 as o/p, atleast 1 element in subarray
     * must be 1. to Find in O(N^2) all subarrays.
     * 
     * 0 1 1 0
     * 
     *O/p: 0 1, 0 1 1, 0 1 1 0,     from 0 index
     *     1, 1 1, 1 1 0            from 1 index
     *     1,1 0                    from 2 index
     * 
     * a. Interate over Array
     * b. if 0 is found, find next 1 and count all the element from 1 index to size of the array (size - i)
     * c. if 1 is fount count right elements (size - i)
     */
    public long solveOpt(int A, int[] B) {
        long count=0;
        for(int i=0;i<A;i++){
            if(B[i] == 0){
                //find next 1
                for(int j=i;j<A;j++){
                    if(B[j] == 1){
                        count += (A-j);
                        break;
                    }
                }
            }
            if(B[i] == 1){
                count += (A-i);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //int[] a = { 0, 0, 0, 1, 1, 0, 1 };
        int[] a = { 1, 0, 0, 1, 1, 0, 1 };
        System.out.println(solve(a.length, a));

    }

}
