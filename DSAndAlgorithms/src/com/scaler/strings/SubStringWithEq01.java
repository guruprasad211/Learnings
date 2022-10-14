package com.scaler.strings;

/**
 * Given a string A, A is made up of 0's and 1's. Break A into substrings such that , 
 * all broken substrings have equal number of 1's and 0's.

Find and return maximum number of substrings in which A can be broken.

 * @author guruprasadchowdaryp
 *
 */
public class SubStringWithEq01 {

	
	/*
	 * Count zeros and ones, if both are equal its equal no. of 0's and 1's
	 */
	public static void main(String[] args) {
		//String s = "0100110101";//01,0011,01,01
		//String s = "01010110101";//01,01,01,10,10
		//String s = "011100";//01,1100
		String s = "00011011";//00011011
		
		int maxCount=0;
		int zeroCount=0;
		int oneCount=0;
		
		char[] a = s.toCharArray();
		
		for(int i=0; i < a.length; i++) {
			if(a[i] == '0') zeroCount++;
			if(a[i] == '1') oneCount++;
			
			if(zeroCount == oneCount) {
				maxCount++;
				zeroCount=0;
				oneCount=0;
			}
		}
		
		System.out.println("maxCount:" + maxCount);
	}

}
