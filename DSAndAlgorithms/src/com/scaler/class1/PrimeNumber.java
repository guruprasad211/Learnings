package com.scaler.class1;

public class PrimeNumber {

    //Number is prime is its divided by 1 and itself or if a number has 2 factors its prime
    public static int countPrimes(Long A) {
        int count=0;
        for (int i = 1; i <= A; i++) {
            if(isPrimeFactor(i))
                count++;
        }
        return count;
    }
    
    //if more than 2 factors found for a number its not prime
    public static boolean isPrimeFactor(long A) {
        int count = 0;
        boolean flag = true;
        
        if(A == 1) return false;
        
        double sqrt = Math.sqrt(A);
        for (int i = 1; i <=sqrt; i++) {
            if(A%i == 0) {
                if(A/i == i ) 
                    count++;
                else   
                    count += 2;
                if(count > 2)
                    return false;
            }
        }
        return flag;
    }
    
    public static void main(String[] args) {
       System.out.println(countPrimes(19l));

    }

}
