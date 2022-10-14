package com.problems;

public class ReverseString {

	public static void main(String[] args) {
		String s="learnbay1";
		String r="";
		//first approach
		for(int i=s.length();i>0;i--) {
			r+=s.charAt(i-1);
		}
		System.out.println("Rever String:"+r);
		
		//2nd approach use swap of first and last and go on
		char[] arr= s.toCharArray();
		
		int right=arr.length-1;
		for(int left=0;left<arr.length;left++) {
			if(left>right) {
				break;
			}
			//swap positions
			char temp=arr[right];
			arr[right]=arr[left];
			arr[left]=temp;
			right--;
			
		}
		String swap="";
		for(char c: arr) {
			swap+=c;
		}
		System.out.println("reverse string by swap:"+swap);
		
	}
}
