package com.scaler.arrays.class5;

import java.util.Arrays;

public class ProductArrayExceptSelf {

    public static int[] solve(int[] A) {
        int[] prods = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i != j) {
                    prods[i] = prods[i] == 0 ? A[j] : prods[i] * A[j];
                }
            }
        }
        return prods;
    }

    /*
     * maintain 2 arrays one with prefix products and the other with sufix products
     * 
     * At any point in time calculate product of that element prefix[i-1] * suffix[i+1]
     */
    public static int[] solveUsingPrefixSuffixProducts(int[] A) {
        int size = A.length;
        int[] prods = new int[size];

        int[] prefix = new int[size];
        int[] suffix = new int[size];

        prefix[0] = A[0];
        
        for (int i = 1; i < size; i++) {
            prefix[i] = prefix[i-1] * A[i];
        }
        
        suffix[size - 1] = A[size - 1];
        for (int i = size - 2; i >=0; i--) {
            suffix[i] = suffix[i+1] * A[i];
        }

        prods[0] = suffix[1];
        if (size > 1) {
            prods[size - 1] = prefix[size - 2];
        }

        for (int i = 1; i < size - 1; i++) {
            prods[i] = prefix[i - 1] * suffix[i + 1];

        }
        return prods;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4 };
        //System.out.println("Prod Array:" + Arrays.toString(solve(a)));

        System.out.println("Prod Array:" + Arrays.toString(solveUsingPrefixSuffixProducts(a)));
    }

}
