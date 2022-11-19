package com.scaler.arrays.class11;

/*
 * Given an array of size N, find the majority element. The majority element is the element 
 * that appears more than floor(n/2) times.
You may assume that the array is non-empty and the majority element always exists in the array.

[2, 1, 2]
2
 */
public class MajorityElemInArray {

    /*
     * find find majority we have the following options
     *  a. Using nested for loop we can find Majority
     *  b. Using HashMap
     *  c. Using sorting
     *  d. Using freq and majority
     * 
     */
    public int majorityElement(final int[] A) {
        int size = A.length;
        int majorityElem = A[0];
        int freq = 1;
        for (int i = 1; i < size; i++) {
            if (A[i] == majorityElem) {
                freq++;
            }
            else if (freq == 0) {
                majorityElem = A[i];
                freq = 1;
            }
            else {
                freq--;
            }
        }
        return majorityElem;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
