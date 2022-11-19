package com.scaler.arrays.class10;

/*
 * There are A people standing in a circle. Person 1 kills their immediate clockwise neighbour 
 * and pass the knife to the next person standing in circle. This process continues till 
 * there is only 1 person remaining. Find the last person standing in the circle.

 */
public class JosephusCircleProblem {
    /*
     * As per notes and discussions
     * a. if N = 2^N, then 1st person will save always
     * b. If its not 2^N, find the nearest 2^N <=N
     *      N-2^N = X (gives People got killed)
     *      
     *      to find the person alive use formulae 2X+1
     *      
     */
    public static int solve(int A) {
        //find sqrt of N, if its perfect square the 1 will be saved
        int i = 1;
        while (i < A) {
            i = i * 2;
        }
        //if i/p is equal to powers of 2
        if (A == i) {
            return 1;
        }
        
        //if i/p is not powers of 2 i crosses i/p so
        int nearestPowerOf2 = i / 2;
        //System.out.println("nearestPowerOf2:" + nearestPowerOf2);
        int personsKilled = A - nearestPowerOf2;
        return 2 * personsKilled + 1;
    }

    public static void main(String[] args) {
        System.out.println(solve(100));
        System.out.println(solve(4));
        System.out.println(solve(5));

    }

}
