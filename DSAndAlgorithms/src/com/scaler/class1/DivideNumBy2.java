package com.scaler.class1;

public class DivideNumBy2 {

    /*
     * What is the number of times we need to divide N by 2 till it reaches 1
     * 1    
     * 2    1 times
     * 4    2   1   - 2 (2^2)
     * 8    4 2 1   - 3 (2^3)
     * 9    4 2 1   - 3 (2^3) 
     * 
     * Time Complexity floor(logN)
     * 
     */
    public static int maxNumOfTimes(int A) {
        int i = 1;
        int ans = 0;
        //iterate over the multiple of 2 until the nearest number found which is <=A
        while (2 * i <= A) {
            ans++;
            i = i * 2;
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(maxNumOfTimes(9));
    }

}
