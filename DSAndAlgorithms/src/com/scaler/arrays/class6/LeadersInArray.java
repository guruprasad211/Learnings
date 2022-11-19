package com.scaler.arrays.class6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an integer array A containing N distinct integers, you have to find all the leaders in array A.

An element is a leader if it is strictly greater than all the elements to its right side.

NOTE:The rightmost element is always a leader.

Return an integer array denoting all the leader elements of the array.

NOTE: Ordering in the output doesn't matter.

Element is a leader if all the elements to its right is less than the current element
A = [16, 17, 4, 3, 5, 2]
o/P = [17, 5, 2]
 */
public class LeadersInArray {

    //Brute force. TC: O(N^2), SPC: O(1)
    public static int[] solve(int[] A) {
        int size = A.length;
        List<Integer> leaders = new ArrayList<>();
        leaders.add(A[size - 1]);
        for (int i = 0; i < size - 1; i++) {
            boolean isLeader = true;
            for (int j = i + 1; j < size; j++) {
                //if cur elem is less than the right elem its not a leader
                if (A[i] < A[j]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader)
                leaders.add(A[i]);
        }

        return leaders.stream().mapToInt(e -> e).toArray();
    }
    
    /*
     * 16, 17, 4, 3, 5, 2   
     * 
     * ITERATE FROM RIGHT AND STORE MAX ELEMENT TO RIGHT, if elem to right is greater its leader
     * TC: O(N), SPC: O(1)
     */
    public static int[] solveOPT(int[] A) {
        int size = A.length;
        List<Integer> leaders = new ArrayList<>();
        leaders.add(A[size - 1]);
        int maxRight=A[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            if (A[i] > maxRight) {
                maxRight = A[i];
                leaders.add(A[i]);
            }
        }

        return leaders.stream().mapToInt(e -> e).toArray();
    }

    public static void main(String[] args) {
        int[] a = { 16, 17, 4, 3, 5, 2 };
        System.out.println(" leaders:" + Arrays.toString((solve(a))));
        System.out.println(" leaders:" + Arrays.toString((solveOPT(a))));

    }

}
