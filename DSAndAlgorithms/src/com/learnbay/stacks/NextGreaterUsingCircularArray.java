package com.learnbay.stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterUsingCircularArray {
	public int[] nextGreaterElements(int[] nums) {
		int num1Size = nums.length;
		int[] res = new int[num1Size];
		for (int i = 0; i < num1Size; i++) {
			res[i] = -1;
		}

		Stack<Integer> s = new Stack<>();

		int i = 0;
		int iterate = 0;
		while (iterate < 2 && i < num1Size) {

			while (!s.isEmpty() && nums[i] > nums[s.peek()]) {
				int popIndex = s.pop();
				res[popIndex] = nums[i];
			}
			s.push(i);
			if (i == num1Size - 1) {
				i = 0;
				iterate++;
			} else {
				i++;
			}
		}

		return res;
	}

	/**
	 * Double the size of the arrays and iterate using the modulo operator where 
	 * it checks 2 times the elements from right.
	 * Compares right elements from the left elements and remove the min elemnts in stack and 
	 * store the result of stack top which is max element to that index
	 * 
	 * @param nums
	 * @return
	 */
	public int[] nextGreaterElementsUsingReverse(int[] nums) {
		int num1Size = nums.length;
		int[] res = new int[num1Size];
		Stack<Integer> s = new Stack<>();
		for (int i = 2 * num1Size - 1; i >= 0; i--) {
			while(!s.isEmpty() && nums[s.peek()] <= nums[i % num1Size]) {
				s.pop();
			}
			
			res[i % num1Size] = s.isEmpty() ? -1 : nums[s.peek()];
			s.push(i % num1Size);
		}
		
		return res;
	}

	public static void main(String[] args) {
		NextGreaterUsingCircularArray c = new NextGreaterUsingCircularArray();
		// int[] n1 = { 1, 2, 1 };
		//int[] n1 = { 5, 4, 3, 2, 1 };
		int[] n1 = { 2, 1, 3, 2 };

		System.out.println("nextGreaterElement:" + Arrays.toString(c.nextGreaterElements(n1)));
		System.out.println("nextGreaterElement:" + Arrays.toString(c.nextGreaterElementsUsingReverse(n1)));
	}

}
