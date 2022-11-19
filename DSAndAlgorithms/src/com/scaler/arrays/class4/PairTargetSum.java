package com.scaler.arrays.class4;

/**
 * Given an array A and an integer B. A pair(i, j) in the array is a good pair
 *  if i != j and (A[i] + A[j] == B). Check if any good pair exist or not.
 *  
 *  A = [1,2,3,4]
 *  B = 7   O/P : 1
 *  
 * @author guruprasadchowdaryp
 *
 */
public class PairTargetSum {

    //optimized as it looks like O(N^2) but it runs half of the array
    //indexes - 0 1 2 3 -> 0 1, 0 2, 0 3, 1 2, 1 3, 2 3. 
    //All other elemrnts sum is same in reverse order of indexes and i!=j
    public static int solve(int[] A, int B) {
        
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i; j < A.length; j++) {
                
            }
        }
        int size = A.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (A[i] + A[j] == B) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4 };
        System.out.println("Sum target:" + PairTargetSum.solve(a, 7));
    }

}
