package com.scaler.class1;

/*
 * Perfect number is a positive integer which is equal to the sum of its proper positive divisors.

A proper divisor of a natural number is the divisor that is strictly less than the number.

 */
public class PrimeNumbers {

    public static int perfectNum(int A) {
        int sum=0;
        for (int i = 1; i < A; i++) {
            if(A % i == 0)
                sum += i;
        }
        if(sum == A)
            return 1;
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(perfectNum(6));
    }

}
