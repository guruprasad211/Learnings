package com.scaler.class1;

public class FactorsOfN {

    //Brute force
    //this iterates upto N numbers O(N) times
    public static int findNoOfFactors(long n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count;
    }
    
    /*
     * if i is factor of N, the N/i is also factor of N
     * i    N/i let N be 12
     * ----------
     * 1    12
     * 2    6
     * 3    4
     * ---------i < N/i after i> N/i same factors repeated as above so do count=count+2
     * 4    3
     * 6    2
     * 12   1
     * 
     * 100
     * 
     * i    N/i
     * ------
     * 1    100
     * 2    50
     * 4    25
     * 5    20
     * 10   10
     * --------i <= N/i
     * 20   5
     * 25   4
     * 50   2
     * 100  1
     */
    public static int findNoOfFactorsOpt(long A) {
        int count = 0;
        /*for (int i = 1; i <= n/i; i++) {
            if (n % i == 0) {
                count =  n%i == i ? count+1 : count+2;
            }
        }
        */
        //i < = n/i which is i^2 <= n, i <=sqrt(n)
        double sqrt = Math.sqrt(A);
        for (int i = 1; i <=sqrt; i++) {
            if(A%i == 0) {
                //count = n%i == i ? count+1 : count+2;
                if(A/i == i ) 
                    count++;
                else   
                    count = count+2;
            }
        }
        return count;
    }
    

    public static void main(String[] args) {
        //1st func gives Exception
        //System.out.println(findNoOfFactors(9999999999l));
        System.out.println(findNoOfFactorsOpt(100));
        //works
        //System.out.println(findNoOfFactorsOpt(999999999999999999l));
    }

}
