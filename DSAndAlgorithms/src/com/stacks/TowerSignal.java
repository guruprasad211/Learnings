package com.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author guruprasadchowdaryp Towers are aligned in a straight horizontal
 *         line(from left to right) and each tower transmits a signal in the
 *         right to left direction. Tower A shall block the signal of Tower B if
 *         Tower A is present to the left of Tower B and Tower A is taller than
 *         Tower B. So,the range of a signal of a given tower can be defined as
 *         :
 * 
 *         {(the number of contiguous towers just to the left of the given tower
 *         whose height is less than or equal to the height of the given tower)
 *         + 1}.
 * 
 *         You need to find the range of each tower. Example: Input: 100 80 60
 *         70 60 75 85 Output: 1 1 1 2 1 4 6
 *
 * 
 */
public class TowerSignal {

	public static void approach1(int[] a, int size) {
		int res[] = new int[size];
		res[0] = 1;// for first tower signal trasmits no need condition
		for (int i = 1; i < size; i++) {
			// check the values from right to left
			// consider the same tower as it emits irrespective of height
			for (int j = i; j >= 0; j--) {
				if (a[j] <= a[i]) {
					res[i] += 1;
				} else {
					break;
				}
			}
		}
		for (int b : res) {
			System.out.println(b + " ");
		}
	}

	/**
	 * if stack's value is lesser than the current value in array, pop the elements
	 * until the condition is met (greater element found) and add the element to
	 * stack use the array index and top value to calculate the o/p
	 * 
	 * @param a
	 * @param size
	 */
	public static void usingStacks(int[] a, int size) {
		int res[] = new int[size];
		Stack<Integer> s = new Stack<Integer>();
		
		for (int i = 0; i < size; i++) {
			while (!s.isEmpty() && a[i] >= a[s.peek()]) {
				s.pop();
			}
			if(s.isEmpty()) {
				res[i] = i+1;
			}
			else {
				res[i] = i - s.peek();
			}
			s.push(i);
		}
		System.out.println(Arrays.toString(res));
	}

	public static void main(String[] args) {
		int[] a = { };//, 20, 60, 70, 70, 75, 85, 85, 110, 120,1 };
		// approach1(a, a.length);
		usingStacks(a, a.length);
		
		List<String> l = new ArrayList<>();
		l.add("a");
		l.add("b");
		l.add("c");
		l.add("ad");
		System.out.println("" +l);

	}

}
