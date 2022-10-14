package com.problems;

import java.util.Arrays;
import java.util.Collections;

public class PallinArray {

	public static int palinArray(Integer[] a, int n) {
		Arrays.sort(a, Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			if (a[i] != reversNum(a[i])) {
				return 0;
			}
		}

		return 1;
	}
	
	public static int reversNum(int el) {
		int rev=0;
		while(el!=0) {
			int rem=el%10;
			rev=rev*10 + rem;
			el=el/10;
		}
		return rev;
	}

	public static void main(String[] args) {
		Integer a[] = {121,131,202};
		System.out.println(""+palinArray(a, a.length));
	}

}
