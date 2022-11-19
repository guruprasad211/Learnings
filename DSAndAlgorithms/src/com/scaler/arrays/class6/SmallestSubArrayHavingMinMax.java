package com.scaler.arrays.class6;

/*
 * Given an array A, find the size of the smallest subarray such that it contains 
 * at least one occurrence of the maximum value of the array
 *   and at least one occurrence of the minimum value of the array.
 *   
 *   Return the length of the smallest subarray which has at least one occurrence of 
 *   minimum and maximum element of the array

A = [1, 3]  O/P 2
A = [2]     O/P 1
 */
public class SmallestSubArrayHavingMinMax {
    /*
     * first find min and elements
     * TC: O(n^2), SC:O(1)
     */
    public static int solve(int[] A) {
        int size = A.length;
        int max = A[0];
        int min = A[0];

        if (size == 1 && max == min) {
            return 1;
        }
        //find max and min
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
            else if (A[i] < min) {
                min = A[i];
            }
        }

        //System.out.println("max:" + max + " min:" + min);

        if (max == min) {
            return 1;
        }

        /*   iterate over and find min or max elem, if found 
         *   find next max or min and count elements and store smallest sub array
         *   
         *   sub array can be starts with min/max and ends with max/min
        */
        int ans = size;//max subArray is length of array
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == min) {
                for (int j = i + 1; j < A.length; j++) {
                    if (A[j] == max) {
                        ans = Math.min(ans, j - i + 1);
                    }
                }
            }

            if (A[i] == max) {
                for (int j = i + 1; j < A.length; j++) {
                    if (A[j] == min) {
                        ans = Math.min(ans, j - i + 1);
                    }
                }
            }
            //it will be the leaset sub Array if 2 elems found
            if (ans == 2) {
                return 2;
            }
        }
        return ans;
    }

    /*
     * Maintain minIndex and maxIndex, and assign -1
     * if its not -1 means it has indexes for min and max,
     * calculate no. of elements in b/w 2 if its not -1
     * 
     * TC:O(N)
     */
    public static int solveOpt(int[] A) {
        int size = A.length;
        int max = A[0];
        int min = A[0];

        if (size == 1 && max == min) {
            return 1;
        }
        //find max and min
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
            else if (A[i] < min) {
                min = A[i];
            }
        }

        //System.out.println("max:" + max + " min:" + min);

        if (max == min) {
            return 1;
        }

        /*   iterate over and find min or max elem, if found 
         *   find next max or min and count elements and store smallest sub array
         *   
         *   sub array can be starts with min/max and ends with max/min
         */

        int ans = size;//max subArray is length of array
        int maxIndex = -1;
        int minIndex = -1;
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] == min) {
                minIndex = i;
                if(maxIndex != -1) {
                    ans = Math.min(ans, Math.abs(maxIndex - minIndex) + 1);
                }
            }

            if (A[i] == max) {
                maxIndex = i;
                if(minIndex != -1) {
                    ans = Math.min(ans, Math.abs(maxIndex - minIndex) + 1);
                }
            }
            //it will be the least sub Array if 2 elems found
            if (ans == 2) {
                return 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //int[] a = { 1, 6, 2, 5, 7, 8, 7, 8, 1, 4 };
        //int[] a = { 1, 2, 5, 6, 2, 5, 7, 8, 7, 8, 3, 5, 4, 1, 4 };
        int[] a = { 8, 8, 8, 8 };
        System.out.println("min subArray:" + solve(a));
        System.out.println("min subArray:" + solveOpt(a));
    }

}
