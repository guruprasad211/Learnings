package com.scaler.class1;

public class SquareRoot {

    public static int perfectSqr(int A) {
        for (int i = 1; i <= A; i++) {
            if((long)i*i == A)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        
        System.out.println(perfectSqr(84630800));
    }

}
