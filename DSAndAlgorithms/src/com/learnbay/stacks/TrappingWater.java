package com.learnbay.stacks;

import java.util.Stack;

/*Find max area of storing water
 * https://www.youtube.com/watch?v=C8UjlJZsHBw
 * 
 * width is 1 and array of elements provided
 * 
 */
public class TrappingWater {

	/*
	 * Iterative approch with o(n2)
	 * 
	 * except 1st and last tower find the max left height and max right height
	 * min(maxleft,maxright)-currentHeight
	 */
	public static int maxArea(int[] heights) {
		int size = heights.length;
		int maxArea = 0;

		// atleast 3 towers are required to store water
		if (size < 3) {
			return maxArea;
		}

		for (int i = 1; i < size - 1; i++) {
			int leftMax = Integer.MIN_VALUE;
			int rightMax = Integer.MIN_VALUE;
			for (int j = i - 1; j > -1; j--) {
				leftMax = Math.max(leftMax, heights[j]);
			}

			for (int j = i + 1; j < size; j++) {
				rightMax = Math.max(rightMax, heights[j]);
			}
			int minHeight = Math.min(leftMax, rightMax);
			if (heights[i] < minHeight)
				maxArea += (minHeight - heights[i]);
		}

		return maxArea;
	}

	/*
	 * With O(n) time and O(n) space using max height with 2 arrays one for left and
	 * one for right. Store for every element in array its max left and max right in
	 * its 2 arrays using the max variable
	 * 
	 * Compare 2 arrays min(maxleft,maxRight)-currHeight
	 * 
	 */
	public static int maxAreaUsingArea(int[] heights) {
		int size = heights.length;
		int maxArea = 0;

		// atleast 3 towers are required to store water
		if (size < 3) {
			return maxArea;
		}
		int[] leftMaxs = new int[size];
		int[] rightMaxs = new int[size];
		int leftMax = Integer.MIN_VALUE;
		int rightMax = Integer.MIN_VALUE;

		for (int i = 1; i < size - 1; i++) {
			leftMax = Math.max(leftMax, heights[i - 1]);
			leftMaxs[i] = leftMax;
		}
		// check from right of the array the max element to its right
		for (int i = size - 2; i > 0; i--) {
			rightMax = Math.max(rightMax, heights[i + 1]);
			rightMaxs[i] = rightMax;
		}

		for (int i = 1; i < size - 1; i++) {
			int minHeight = Math.min(leftMaxs[i], rightMaxs[i]);
			if (heights[i] < minHeight)
				maxArea += (minHeight - heights[i]);
		}
		return maxArea;
	}

	/*
	 * use stack to store the element until the max height is found in stack and do the calculation on it
	 * 
	 */
	public static int maxAreaUsingStacks(int[] heights) {
		int size = heights.length;
		int maxArea = 0;

		// atleast 3 towers are required to store water
		if (size < 3) {
			return maxArea;
		}
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < size; i++) {
			// iterate until stack has greater element
			while (!s.isEmpty() && heights[i] > heights[s.peek()]) {
				// pop top element and get minimum of previous previous
				int top = s.pop();
				if (s.isEmpty())
					break;

				int distance = i - s.peek() - 1;
				// minimum of top elements left and right elements
				maxArea += distance * (Math.min(heights[s.peek()], heights[i]) - heights[top]);
			}
			s.push(i);
		}
		return maxArea;
	}

	/*Otimized one
	 * Find the area using the left and right pointers and find the areas from the
	 * minimum height side(left or right) using the minimum height and current
	 * height and if any max height is found start again from the minimum height.
	 * 
	 * Stop when left < right (if right crosses left)
	 */
	public static int maxAreaFromMinHeight(int[] heights) {
		int size = heights.length;
		int maxArea = 0;

		// atleast 3 towers are required to store water
		if (size < 3) {
			return maxArea;
		}

		int leftMax = Integer.MIN_VALUE;
		int rightMax = Integer.MIN_VALUE;
		int left = 1;
		int right = size - 2;
		while (left <= right) {
			leftMax = Math.max(leftMax, heights[left - 1]);
			rightMax = Math.max(rightMax, heights[right + 1]);
			// start from left
			if (leftMax <= rightMax) {
				if (heights[left] < leftMax)
					maxArea += (leftMax - heights[left]);
				else {
					leftMax = heights[left];
				}
				left++;
			} else {
				if (heights[right] < rightMax)
					maxArea += (rightMax - heights[right]);
				else {
					rightMax = heights[right];
				}
				right--;
			}
		}

		return maxArea;
	}

	public static void main(String[] args) {
		// int[] heights = {4,2,0,6,2,3,5};
		// int[] heights = { 5, 2, 0, 6, 2, 3, 5 };
		// int[] heights = {4,2,0,2,3,5};
		// int[] heights = {1,2,3,4,5};
		// int[] heights = {40, 25, 20, 10,5};
		// int[] heights = { 40, 25, 30 };
		int[] heights = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println("MaxArea:" + TrappingWater.maxArea(heights));

		System.out.println("MaxArea:" + TrappingWater.maxAreaUsingArea(heights));

		System.out.println("MaxArea:" + TrappingWater.maxAreaFromMinHeight(heights));

		System.out.println("MaxArea:" + TrappingWater.maxAreaUsingStacks(heights));
	}

}
