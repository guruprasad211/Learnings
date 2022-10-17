package com.sample;

import java.util.Random;

/**
 * Insertion sort:
 * 
 * 3 1 8 6 2
 * 
 * if element from the left of the current element is higher move to the right by
 * copying the current element to temp variable else replace the current element
 * 
 * @author guruprasadchowdaryp
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		int[] a = new int[10];
		for(int i=0;i<10;i++) {
			a[i] = new Random().nextInt(100);
		}
		for(int i=1;i<a.length;i++) {
			int currentVal=a[i];
			int left=i-1;
			while(left>=0 && a[left] > currentVal) {
				a[left+1] = a[left];
				left--;
			}
			a[left + 1] = currentVal;
		}
		for(int e : a) 
			System.out.print(e + " ");
		
	}

}
