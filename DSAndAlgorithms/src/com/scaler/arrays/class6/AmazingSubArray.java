package com.scaler.arrays.class6;

import java.util.HashMap;
import java.util.Map;

/*
 * You are given a string S, and you have to find all the amazing substrings of S.

An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).


 */
public class AmazingSubArray {

    /*
     * if vowel is found, calculate the no. of character to its right including the element
     * gives the number of substrings formed
     */
    public static int solve(String A) {
        Map<Character, Integer> vowels = new HashMap<>();
        vowels.put('a', 1);
        vowels.put('e', 1);
        vowels.put('i', 1);
        vowels.put('o', 1);
        vowels.put('u', 1);
        vowels.put('A', 1);
        vowels.put('E', 1);
        vowels.put('I', 1);
        vowels.put('O', 1);
        vowels.put('U', 1);

        char[] a = A.toCharArray();
        int size = a.length;
        int subStringsCount = 0;
        for (int i = 0; i < size; i++) {
            if (vowels.containsKey(a[i])) {
                subStringsCount = (subStringsCount + (size - i)) % 10003;
            }
        }

        return subStringsCount;
    }

    public static void main(String[] args) {
        System.out.println("Count of sub staring starting with vowels:" + solve("ABEC"));

    }

}
