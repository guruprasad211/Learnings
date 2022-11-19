package com.scaler.class1;

public class MangoShakes {

    /*
     * Given two integers A and B. A represents the count of mangoes and B 
     * represent the count of slices of mangoes. Mango can be cut into three slices of mangoes.
     *  A glass of mango shake can be formed by two slices of mangoes.
    
        Find the maximum number of glasses of mango shakes you can make with A mangoes 
        and B slices of mangoes initially.
     */
    public static int maxShakes(int A, int B) {

        return (3 * A + B) / 2;
    }

    public static void main(String[] args) {

        //System.out.println(maxShakes(19,0));
        System.out.println(maxShakes(7, 1));
    }

}
