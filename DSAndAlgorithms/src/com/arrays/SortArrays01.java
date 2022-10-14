package com.arrays;

import java.util.Arrays;

public class SortArrays01 {
	
	/*
	 * Iterate from left until 1 is found and iterate from right until 0 is found
	 * and replace both
	 */
	public static void sort(int[] a) {
		int left = 0;
		int right = a.length - 1;
		while (left < right) {
			if (a[left] == 1 && a[right] == 0) {
				a[left] = 0;
				a[right] = 1;
			}
			if (a[left] == 0)
				left++;
			if (a[right] == 1)
				right--;
		}
	}

	public static void main(String[] args) {
		// int[] a = {0,1,0};
		// int[] a = {0,1,0,1};
		// int[] a = {0,0,1,1};
		// int[] a = {0,0,1,1,1,0,0};
		int[] a = { 0, 1, 0, 1, 1, 1};

		sort(a);
		System.out.println(Arrays.toString(a));

	}

}
