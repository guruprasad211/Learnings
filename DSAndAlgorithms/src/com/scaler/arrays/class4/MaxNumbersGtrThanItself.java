package com.scaler.arrays.class4;

import java.util.ArrayList;

/**
 * Find Total no. of elements greater than itself
 * 
 * {-3,-2,0,1,5,7,4,2,9,5,9} o/p 11 - 2 (Total elems - total max elements)
 * 
 * @author guruprasadchowdaryp
 *
 */
public class MaxNumbersGtrThanItself {
    
    public int solve(ArrayList<Integer> A) {
        if(A == null || A.isEmpty() || A.size() == 1) {
            return 0;
        }
        int size = A.size();
        int max = A.get(0);
        int freq = 1;
        for (int i = 1; i < size; i++) {
            if (A.get(i) >= max) {
                if (A.get(i) > max) {
                    freq = 1;
                    max = A.get(i);
                }
                else {
                    freq++;
                }
            }
        }

        return size - freq;
    }

    public static int grtrCount(int[] a) {
        int size = a.length;
        int max = a[0];
        for (int i = 1; i < size; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        int freq = 0;
        for (int i = 0; i < size; i++) {
            if (a[i] == max) {
                freq++;
            }
        }

        return size - freq;
    }

    //using 1 loop
    public static int grtrCountOneLoop(int[] a) {
        int size = a.length;
        int max = a[0];
        int freq = 1;
        for (int i = 1; i < size; i++) {
            if (a[i] >= max) {
                if (a[i] > max) {
                    freq = 1;
                    max = a[i];
                }
                else {
                    freq++;
                }
            }
        }

        return size - freq;
    }

    public static void main(String[] args) {
        //int[] a = { -3, -2, 0, 1, 5, 7, 4, 2, 9, 5, 9 };
        //int[] a = { 8, 8, 8, 8 };
        int[] a = {10, 11, -2, 0, 1, 5, 7, 4, 2, 9, 5, 9 };
        //System.out.println("MaxNumbersGtrThanItself:" + MaxNumbersGtrThanItself.grtrCount(a));

        System.out
                .println("MaxNumbersGtrThanItself:" + MaxNumbersGtrThanItself.grtrCountOneLoop(a));
    }

}
