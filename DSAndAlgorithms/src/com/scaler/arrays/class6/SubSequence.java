package com.scaler.arrays.class6;

/*
 * You have given a string A having Uppercase English letters.
You have to find how many times subsequence "AG" is there in the given string.

NOTE: Return the answer modulo 10^9 + 7 as the answer can be very large
 */
public class SubSequence {

    //Brute force. TC: O(N*N), SC: O(1)
    public static int solve(String A) {
        char[] c = A.toCharArray();
        int size = c.length;
        int count = 0;
        for (int i = 0; i < size - 1; i++) {
            if (c[i] == 'A') {
                for (int j = i + 1; j < c.length; j++) {
                    if (c[j] == 'G') {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /*Optimized
     * 
     * ans = 0
     * count =0
     * A B C G A G
     * 
     * if A is found increment count
     * if G is found ans=ans+c
     * 
     * Ex:AAAAGGGG (c=1,2,3,4   then ans=4,4+4,8+4,12+4)
     * 
     */
    //1st approach starting from left. TC: O(N), SC: O(1)
    public static int solveOpt(String A) {
        char[] c = A.toCharArray();
        int size = c.length;
        int count = 0;
        double ans = 0;

        double m = Math.pow(10d, 9d) + 7;
        for (int i = 0; i < size; i++) {
            if (c[i] == 'A') {
                count++;
            }

            if (c[i] == 'G') {
                ans = (ans+count)%m;
            }
        }
        
        return (int)ans;
    }
    
    //2nd approach starting from right. T: O(N), S: O(1)
    public static int solveOptRight(String A) {
        char[] c = A.toCharArray();
        int size = c.length;
        int count = 0;
        double ans = 0;

        double m = Math.pow(10d, 9d) + 7;
        for (int i = size-1; i >= 0; i--) {
            if (c[i] == 'G') {
                count++;
            }

            if (c[i] == 'A') {
                ans = (ans+count)%m;
            }
        }
        
        return (int)ans;
    }

    public static void main(String[] args) {
        System.out.println("Count of seubseq:" + solve("ABCGAG"));
        System.out.println("Count of seubseq:" + solveOpt("ABCGAG"));
        System.out.println("Count of seubseq:" + solveOptRight("ABCGAG"));

    }

}
