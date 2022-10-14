package com.learnbay.stacks;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestRectangle {

	/*
	 * This fails when the number of builds are increasing Sol: Sort the building
	 * and find the no. of building to the right of the index and that is the total
	 * width of the building and height is the current element
	 * 
	 */
	public static long largestRectangle(List<Integer> h) {
		if (h == null) {
			return 0;
		}
		if (h.size() == 1) {
			return h.get(0);
		}
		Collections.sort(h);
		int maxRec = 0;
		int totalBuildings = h.size();
		for (int i = 0; i < totalBuildings; i++) {
			int length = totalBuildings - i;
			if (maxRec < length * h.get(i)) {
				maxRec = length * h.get(i);
			}
		}

		return maxRec;
	}

	public static long largestRectangle1(List<Integer> h) {
		if (h == null) {
			return 0;
		}
		if (h.size() == 1) {
			return h.get(0);
		}
		int maxRec = 0;
		int totalBuildings = h.size();
		for (int i = 0; i < totalBuildings; i++) {
			int leftMinIdex = findPrevMin(h, h.get(i), i - 1);
			int rightMinIdex = findNextMin(h, h.get(i), i + 1);
			int width = rightMinIdex + leftMinIdex + 1;
			int area = width * h.get(i);

			System.out.println("ele:" + h.get(i) + " leftMinIdex:" + leftMinIdex + " rightMinIdex:" + rightMinIdex
					+ " width:" + width + " area:" + area);
			if (maxRec < area) {
				maxRec = area;
			}
		}

		return maxRec;
	}

	private static int findPrevMin(List<Integer> h, int ele, int left) {
		int count = 0;
		if (left <= 0) {
			return count;
		}
		while (left > -1) {
			if (h.get(left) < ele) {
				return count;
			}
			count++;
			left--;
		}
		return count;
	}

	private static int findNextMin(List<Integer> h, int ele, int right) {
		int count = 0;
		if (right >= h.size()) {
			return count;
		}
		while (right < h.size()) {
			if (h.get(right) < ele) {
				return count;
			}
			count++;
			right++;
		}
		return count;
	}

	public static long largestRectangleUsingStack(List<Integer> h) {
		int maxArea = Integer.MIN_VALUE;
		int curArea = 0;
		java.util.Stack<Integer> s = new java.util.Stack<>();
		for (int i = 0; i < h.size(); i++) {
			while (!s.isEmpty() && h.get(s.peek()) > h.get(i)) {
				int popped = s.pop();
				if (s.isEmpty()) {
					curArea = h.get(popped) * i;
				} else {
					// it gives middle piller area to current element and the next largest ele
					curArea = h.get(popped) * (i - (s.peek() + 1));
				}
				maxArea = Math.max(curArea, maxArea);
			}
			s.push(i);
		}

		while (!s.isEmpty()) {
			int poopped = s.pop();
			if (s.isEmpty()) {
				curArea = h.get(poopped) * h.size();
			} else {
				curArea = h.get(poopped) * (h.size() - (s.peek() + 1));
				// it gives middle piller area to current element and the next largest ele
			}
			maxArea = Math.max(maxArea, curArea);
		}

		return maxArea;
	}

	public static void main(String[] args) {
		 //List<Integer> h = Arrays.asList(11, 11, 10, 10, 10);
		// List<Integer> h = Arrays.asList(2, 1, 5, 6, 2, 3, 1);
		//List<Integer> h = Arrays.asList(4, 4, 4, 4);
		// System.out.println("max height:" + largestRectangle(h));

		//System.out.println("max area:" + largestRectangle1(h));
		//List<Integer> h = Arrays.asList(1,2,3,4,5);
		List<Integer> h = Arrays.asList(1,3,2,4,2);
		System.out.println("max area:" + largestRectangleUsingStack(h));
	}

}
