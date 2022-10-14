package com.arrays;

import java.util.Arrays;

/**
 * nteger array nums sorted in non-decreasing order, return an array of the squares of each number 
 * sorted in non-decreasing order.
 * 
 * Input: nums = [-4,-1,0,3,10]
 * 
	Output: [0,1,9,16,100]
	
	Input: nums = [-7,-3,2,3,11]
	Output: [4,9,9,49,121]
	
	As it has -ve nums, so we have to move left side which ever is greater to right side
	of the array, as -ve numbers largest will be at left
 *
 */

public class SquareSortedArray {

	public static void main(String[] args) {
		int[] a = {-15,-12,-7,-3,2,3,11,12};
		
		int len = a.length;
		int left=0;
		int right = len -1;
		int index = len -1;
		
		int[] output = new int[len];
				
		while(left <= right) {
			if(Math.abs(a[left]) > Math.abs(a[right])) {
				output[index] = a[left] * a[left];
				left++;
			}else {
				output[index] = a[right] * a[right];
				right--;
			}
			index--;
		}
		
		System.out.println("o/p:" + Arrays.toString(output));
	}

}
