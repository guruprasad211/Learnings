package com.problems;

public class Practice2 {
	
	static void productOfRemElements(int[] arr, int n) {
		int[] o=new int[n];
		for(int i=0;i<n;i++) {
			int product=1;
			for(int j=0;j<n;j++) {
				if(i!=j) {
					product*=arr[j];
				}
			}
			o[i]=product;
		}
		for(int a : o) {
			System.out.print(a +" ");
		}
	}
	
	
	public static void main(String[] args) {
		int[] el={10, 3, 5, 6, 2};
		productOfRemElements(el,el.length);
	}

}
