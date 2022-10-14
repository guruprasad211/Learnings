package com.problems;

public class PrintAltElemnts {

	public static void main(String[] args) {
		int el[] = {10,20,30,40,50};
		for(int i=0;i<el.length;i++) {
			if(i%2!=0) {
				System.out.println("Alt elements:" + el[i]);
			}
		}
	}

}
