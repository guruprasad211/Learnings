package com.problems;

public class Replace0To5 {

	public static void main(String[] args) {
		System.out.println(""+Solution.convertFive(1004));
		
		System.out.println(String.valueOf(1004).replace('0', '5'));
	}
}

class Solution{
	public static int convertFive(int n){
		int temp=0;
		while(n > 0) {
			if(n%10==0) {
				temp = temp*10+5;
			}else {
				temp = temp*10 + (n%10);
			}
			
			n=n/10;
		}
		return reverse(temp);
    }

	private static int reverse(int n) {
		int rev=0;
		while(n > 0) {
			int rem=n%10;
			rev = rev*10 + rem;
			n=n/10;
		}
		return rev;
	}
}
