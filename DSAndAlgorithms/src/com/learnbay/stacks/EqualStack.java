package com.learnbay.stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Best approach to find equal stacks is find sum of all elements in stack and 
 * populate the stack in reverse order of the list as LIFO
 * 
 * reduce the height of the stacks until all the heights are equal
 * 
 * @author guruprasadchowdaryp
 *
 */
public class EqualStack {

	/*
	 * Complete the 'equalStacks' function below.
	 * 
	 * Return when the stack sizes are equal.
	 * 
	 * Add the cumulative sums in stack, check all the stacks height if any stacks peek is max return that 
	 * from stack until equal height is found
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER_ARRAY h1 2. INTEGER_ARRAY h2 3. INTEGER_ARRAY h3
	 */

	public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
		Stack<Integer> st1 = populateStacksWithPrevSums(h1);
		Stack<Integer> st2 = populateStacksWithPrevSums(h2);
		Stack<Integer> st3 = populateStacksWithPrevSums(h3);
		
		while(!(st1.peek().equals(st2.peek()) && st2.peek().equals(st3.peek()))) {
			int st1H = st1.peek();
			int st2H = st2.peek();
			int st3H = st3.peek();
			//Find max stack element and pop it from the cylinder until its equal in all 3 stacks
			if(st1H >= st2H && st1H >= st3H) {
				st1.pop();
			}else if(st2H >= st1H && st2H >= st3H) {
				st2.pop();
			}else if(st3H >= st1H && st3H >= st2H) {
				st3.pop();
			}
		} 
		
		return st1.peek();
	}
	
	private static Stack<Integer> populateStacksWithPrevSums(List<Integer> h){
		Stack<Integer> st = new Stack<>();
		for(int i = h.size()-1; i > -1; i--) {
			if(st.isEmpty()) {
				st.push(h.get(i));
			}else {
				st.push(h.get(i) + st.peek());
			}
		}
		return st;
	}
	
	public static int equalStacksUsingTotalSum(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
		Stack<Integer> st1 = populateStack(h1);
		Stack<Integer> st2 = populateStack(h2);
		Stack<Integer> st3 = populateStack(h3);
		int stTotal1 = sumOfElems(h1);
		int stTotal2 = sumOfElems(h2);
		int stTotal3 = sumOfElems(h3);
		
		while(true) {
			//find min sum of heights
			int minHeight = min(stTotal1, stTotal2, stTotal3);
			if(minHeight == 0) return 0;
			
			if(minHeight < stTotal1)
				stTotal1 -= st1.pop();
			else if(minHeight < stTotal2)
				stTotal2 -= st2.pop();
			else if(minHeight < stTotal3)
				stTotal3 -= st3.pop();
			
			if(stTotal1 == stTotal2 && stTotal2  == stTotal3)
				return stTotal1;
		} 
	}
	
	private static int min(int stTotal1, int stTotal2, int stTotal3) {
		int min = Integer.MAX_VALUE;
		if(stTotal1 < stTotal2) {
			min =stTotal1;
		}
		if(stTotal2 < stTotal3) {
			min =stTotal2;
		}
		if(stTotal3 < stTotal1) {
			min =stTotal3;
		}
		return min;
	}

	private static Stack<Integer> populateStack(List<Integer> h){
		Stack<Integer> st = new Stack<>();
		for(int i = h.size()-1; i > -1; i--) {
			st.push(h.get(i));
		}
		return st;
	}
	private static int sumOfElems(List<Integer> h){
		int sum=0;
		for(int i = 0; i < h.size(); i++) {
			sum += h.get(i);
		}
		return sum;
	}

	public static void main(String[] args) {
		/*Integer[] a1 = {3, 2, 1,1,1};
		Integer[] a2 = {4,3,2};
		Integer[] a3 = {1,1,4,1};*/
		Integer[] a1 = {1,2,1,1};
		Integer[] a2 = {1,1,2};
		Integer[] a3 = {1,1};
		
		/*int eqHeight = equalStacks(Arrays.asList(a1),Arrays.asList(a2),Arrays.asList(a3));
		System.out.println("height:" + eqHeight);*/
		
		int eqHeight = equalStacksUsingTotalSum(Arrays.asList(a1),Arrays.asList(a2),Arrays.asList(a3));
		System.out.println("height:" + eqHeight);
	}

}
