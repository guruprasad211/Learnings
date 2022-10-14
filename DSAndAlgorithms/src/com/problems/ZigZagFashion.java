package com.problems;

/**
 * Given an array rearrange elements of array in zigzag fashion
	I/P - 4,3,7,8,6,2,1
	O/P - 3,7,4,8,2,6,1
	a1<a2>a3<a4>a5.
 * @author guruprasadchowdaryp
 *
 */
public class ZigZagFashion {

	public static void main(String[] args) {
		int[] a = {4,3,7,8,6,2,1};
		int n= a.length;
		for(int i=0;i<n-1;i++) {
			//even index elem must be smaller than odd index
			if(i%2==0) {
				if(a[i] > a[i+1]) {
					swap(a, i, i+1);
				}
			}
			else {
				if(a[i] < a[i+1]){
					swap(a, i, i+1);
				}
			}
		}
		for(int j:a) {
			System.out.print(j + ",");
		}
	}

	private static void swap(int[] a, int i, int j) {
		int tmp=a[i+1];
		a[i+1]=a[i];
		a[i]=tmp;
	}

}
