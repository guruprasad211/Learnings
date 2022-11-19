package com.scaler.arrays.class12;

/*
 * Given a decimal number A and base B.
You are required to change the decimal number A into the corresponding value in base B and return that.

Input:
A = 4
B = 3
Output:
11

 */
public class DecimalToBase {

    /*
     * append reminder to string
     */
    public static int DecimalToAnyBase(int A, int B) {
        String s = "";
        int temp = A;
        while (temp > 0) {
            int rem = temp % B;
            temp = temp / B;
            s = rem + s;
        }
        return Integer.parseInt("".equals(s) ? "0" : s);
    }

    public static void main(String[] args) {
        System.out.println(DecimalToAnyBase(4, 3));
    }

}
