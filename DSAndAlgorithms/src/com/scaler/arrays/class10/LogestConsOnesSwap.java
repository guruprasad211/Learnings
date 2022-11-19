package com.scaler.arrays.class10;

/*
 * Given a binary string A. It is allowed to do at most one swap between any 0 and 1. 
 * Find and return the length of the longest consecutive 1’s that can be achieved.


 */
public class LogestConsOnesSwap {
    /*
     * to find max cons ones by swapping with Zero and 1
     * 
     * a. Find Total ones in the String, if equal to size return size
     * b. iterate over string if 0 is found
     *      a. count 1st left to it
     *      b. count right ones
     *      c. calculate max of these left and right
     *      d. If total ones in the string is greater than max, add 1 to total
     *      
     */
    public static int solve(String A) {
        int size = A.length();
        //find total ones
        int totOnes = 0;
        for (int i = 0; i < size; i++) {
            if (A.charAt(i) == '1') {
                totOnes++;
            }
        }
        if (totOnes == 0) {
            return 0;
        }

        if (totOnes == size) {
            return totOnes;
        }

        int maxConsOnes = 0;
        for (int i = 0; i < size; i++) {
            if (A.charAt(i) == '0') {
                int leftOnes = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (A.charAt(j) == '1') {
                        leftOnes++;
                    }
                    else {
                        break;
                    }
                }

                int rightOnes = 0;
                for (int j = i + 1; j < size; j++) {
                    if (A.charAt(j) == '1') {
                        rightOnes++;
                    }
                    else {
                        break;
                    }
                }

                int leftRightTot = leftOnes + rightOnes;
                //If there are exact ones = totalOnes in Array don't add 1 else add 1 to swap 0 to 1
                //if no ones exists to swap with 0, its same as left and right sum
                if (leftRightTot < totOnes) {
                    leftRightTot += 1;
                }
                maxConsOnes = Math.max(maxConsOnes, leftRightTot);
            }
        }
        return maxConsOnes;
    }

    public static void main(String[] args) {
        System.out.println(solve("100"));
        System.out.println(solve("111000"));
        System.out.println(solve("0110110111011"));
        System.out.println(solve("111011"));
        System.out.println(solve("000000111111110"));

    }

}
