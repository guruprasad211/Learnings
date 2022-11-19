package com.scaler.arrays.class6;

/*
 * A wire connects N light bulbs.

Each bulb has a switch associated with it; however, due to faulty wiring, 
a switch also changes the state of all the bulbs to the right of the current bulb.

Given an initial state of all bulbs, find the minimum number of switches you have 
to press to turn on all the bulbs.

You can press the same switch multiple times.

Note: 0 represents the bulb is off and 1 represents the bulb is on

Sol:) If the bulb is off (0), if we on the bulb then state of the switches to its right changes

    0 1 0 1 -> 1 0 1 0  -> 1 1 0 1 -> 1 1 1 0 -> 1 1 1 1
 */
public class BulbsSwitches {
    //brute force
    public static int bulbsBruteForce(int[] A) {
        int size = A.length;
        if (size == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < size; i++) {
            //if zero found toggle all the bulbs to its right and increment the count
            if (A[i] == 0) {
                count++;
                for (int j = i + 1; j < size; j++) {
                    A[j] = 1 - A[j];
                }
            }
        }
        return count;
    }

    /*
     * 0 1 1 0 1
     * 1 0 0 1 0 c = 1 (untouched bulbs from 1 to 4 changes its state)
     * 1 1 1 0 1 c=2 (untouched bulbs from 3 to 4 not changed its state)
     * 1 1 1 1 0 c=3
     * 1 1 1 1 1 c=4
     */
    /*
     * state of a bulb is dependent upon count.
     * if count is Even -> state will be similar
     * if count is odd -> state is toggled (if i/p element is 1, the actual state of the bulb is off,
     * which means the previous bulb is even so state changed to ON means next 1lement which is 1 will be off
     * )
     */
    public static int bulbs(int[] A) {
        int size = A.length;
        if (size == 0) {
            return 0;
        }

        int count = 0;
        /*
         int curr = 0;
         for (int i = 0; i < size; i++) {
            if (count % 2 == 0) {
                curr = A[i];
            }
            else if (count % 2 == 1) {
                curr = 1 - A[i];
            }
        
            if (curr == 0) {
                count++;
            }
        }*/

        for (int i = 0; i < size; i++) {
            //if count is even and current bulb state is off we have to switch on
            if (A[i] == 0 && count % 2 == 0) {
                count++;
            }
            //odd counts untouched bulbs state is changed
            //if count is odd and current bulb state is 1 means actual state is off, so switch on
            else if (A[i] == 1 && count % 2 == 1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        //int[] a = { 0, 1, 0, 1 };
        //int[] a = { 1, 1, 1, 1 };
        //int[] a = { 1, 1, 0, 1 };
        //int[] a = { 0, 1, 0, 1 };
        int[] a = { 1, 0, 0 };
        //int[] a = { 0, 1, 1, 0, 1 };

        System.out.println(bulbs(a));
        System.out.println(bulbsBruteForce(a));

    }

}
