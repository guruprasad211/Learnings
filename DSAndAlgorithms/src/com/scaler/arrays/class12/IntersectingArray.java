package com.scaler.arrays.class12;

/*
 You have an array A with N elements. We have two types of operation available on this array :
We can split an element B into two elements, C and D, such that B = C + D.
We can merge two elements, P and Q, to one element, R, such that R = P ^ Q i.e., XOR of P and Q.
You have to determine whether it is possible to convert array A to size 1, 
containing a single element equal to 0 after several splits and/or merge?

Input 1:

 A = [9, 17]
Input 2:

 A = [1]


Example Output
Output 1:

 Yes
Output 2:

 No


Example Explanation
Explanation 1:

 Following is one possible sequence of operations -  
 1) Merge i.e 9 XOR 17 = 24  
 2) Split 24 into two parts each of size 12  
 3) Merge i.e 12 XOR 12 = 0  
 As there is only 1 element i.e 0. So it is possible.
Explanation 2:

 There is no possible way to make it 0.

 */
public class IntersectingArray {

    /*
     * XOR of same number is 0 and XOR of 0 and different number is different number
     * Find XOR of all the elements and the last element Even means Yes else No
     */
    public static String solve(int[] A) {
        int unique = A[0];
        int size = A.length;
        for (int i = 1; i < size; i++) {
            unique = unique ^ A[i];
        }

        if (unique % 2 == 0) {
            return "Yes";
        }
        return "No";
    }

    public static void main(String[] args) {
        //int[] a = { 9, 17 };
        int[] a = { 1 };
        System.out.println(solve(a));
    }

}
