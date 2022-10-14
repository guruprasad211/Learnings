package com.problems;

import java.util.Arrays;
import java.util.Collections;

public class NthLarget {

	public static void main(String[] args) {
		
		Integer a[] = {10,5,20,19,18,30,40};
		Arrays.sort(a);
		int max=3;
		System.out.println("3rd largest:"+a[a.length-max]);
		Arrays.sort(a,Collections.reverseOrder());
		System.out.println("3rd largest using descen:"+a[max-1]);
		System.out.println("kth largest by find3rdLargest:"+find3rdLargest(a, a.length));
	}

	private static int find3rdLargest(Integer[] a, int n) {
		if(n<3) {
			return -1;
		}
		int first=a[0];
		int second=Integer.MIN_VALUE;
		int third=Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++) {
			if(a[i] > first) {
				third=second;
				second=first;
				first=a[i];
			}else if(a[i] > second && a[i] < first) {
				third=second;
				second=a[i];
			}else if(a[i] > third && a[i] < second) {
				third=a[i];
			}
		}
		System.out.println("third:"+third);
		return third;
	}

}
