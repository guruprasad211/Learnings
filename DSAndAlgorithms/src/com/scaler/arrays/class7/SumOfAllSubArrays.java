package com.scaler.arrays.class7;

/*
 * You are given an integer array A of length N.
You have to find the sum of all subarray sums of A.
More formally, a subarray is defined as a contiguous part of an array which we can obtain by deleting zero or more elements from either end of the array.
A subarray sum denotes the sum of all the elements of that subarray.

Input 1:
A = [1, 2, 3]

Explanation 1:
The different subarrays for the given array are: [1], [2], [3], [1, 2], [2, 3], [1, 2, 3].
Their sums are: 1 + 2 + 3 + 3 + 5 + 6 = 20

 */
public class SumOfAllSubArrays {

    /*
     * if sum of subArray is equal to max sum return, as it will be the max sum in the array
     * if sum os less than the maxsum, assign the max to maxSum and iterate all the subarrays to find max sum
     * 
     * indexes: 
     * 0,1,2,0-1,1-2,0-2
     */
    //TC: O(N^3)    SC: O(1)
    public static long subarraySum(int[] A) {
        int size = A.length;
        long sum = 0;
        for (int s = 0; s < size; s++) {
            for (int e = s; e < size; e++) {
                for (int i = s; i <= e; i++) {
                    sum += A[i];
                }
            }
        }
        return sum;
    }

    /*
     * as range of sums is used we can calculate it using prefix sums
     * 
     */
    //TC: O(N^2)    SC: O(N) as prefix sum is used
    public static long subarraySumUsingPrefixSum(int[] A) {
        int size = A.length;
        int[] pfSums = new int[A.length];
        pfSums[0] = A[0];
        for (int i = 1; i < size; i++) {
            pfSums[i] = pfSums[i - 1] + A[i];
        }
        long sum = 0;
        for (int s = 0; s < size; s++) {
            for (int e = s; e < size; e++) {
                sum += (s == 0 ? pfSums[e] : (pfSums[e] - pfSums[s - 1]));
            }
        }
        return sum;
    }

    //TC: O(N^2)    SC: O(1)
    /*
     * Add the sums while iterating the array using 2 sums one for the subarray
     *  starting index to end and the full array
     *  
     *  inexes 0 1 2    0+0-1+0-2+1+1-2+2
     * 
     */
    public static long subarraySumUsingCarryForward(int[] A) {
        int size = A.length;
        long totalsum = 0;
        for (int s = 0; s < size; s++) {
            long sum = 0;
            for (int e = s; e < size; e++) {
                sum += A[e];
                totalsum += sum;
            }
        }
        return totalsum;
    }

    public static long subarraySumUsingElemOccurence(int[] A) {
        int size = A.length;
        long totalsum = 0l;
        for (int s = 0; s < size; s++) {
            long freq = (long) (s + 1) * (size - s);
            totalsum += freq * A[s];
        }
        return totalsum;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };

        //System.out.println("" + subarraySum(a));
        //System.out.println("" + subarraySumUsingPrefixSum(a));
        //System.out.println("" + subarraySumUsingCarryForward(a));
        System.out.println("" + subarraySumUsingElemOccurence(a));

    }

}
