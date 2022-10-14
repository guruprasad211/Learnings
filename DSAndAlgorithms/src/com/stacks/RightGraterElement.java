package com.stacks;

import java.util.Arrays;
import java.util.Stack;

/*
 * push array indexes to stack if stacks element is less than the arrays element
 * if its greater than pop all the elements of stack until the max element found in stack
 * and assign back to result array with all the indexes. 
 * after full iteration if stack is Not empty assign the value -1 to all the elements in stack
 */
public class RightGraterElement {
	
	public static void findNextGreaterElem(int[] a, int size) {
		int[] r = new int[size];
		Stack<Integer> s = new Stack<>();
		for(int i=0;i<size;i++) {
			while(!s.isEmpty() && a[i] > a[s.peek()]) {
				r[s.peek()] = a[i];
				s.pop();
			}
			s.push(i);
		}
		while(!s.isEmpty()) {
			r[s.peek()] = -1;
			s.pop();
		}
		System.out.println(Arrays.toString(r));
	}
	
	public static void main(String[] args) {
		//int[] a = {4,3,2,1,5};
		int[] a = {4,5,2,25,30,10,8,20};
		findNextGreaterElem(a, a.length);
	}

}
