package com.learnbay.stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//https://medium.com/@yeldos/algorithms-m-game-of-two-stacks-add1dbd9c890
public class TwoStacksGame {

	/*
	 * Complete the 'twoStacks' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER maxSum 2. INTEGER_ARRAY a 3. INTEGER_ARRAY b
	 */

	public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
		
		Stack<Integer> st1 = populateStack(a);
		Stack<Integer> st2 = populateStack(b);
		
		int maxScore = 0;
		int runSum = 0;
		int i = 0;//stack1 elemnts index
		int j = 0;//stack2 elemnts index
		
		while (i < st1.size() && runSum + st1.peek() <= maxSum) {
			runSum += st1.pop();
			maxScore++;
			i++;
		}
		
		runSum=0;
		while (j < st2.size() && runSum + st2.peek() <= maxSum) {
			runSum += st2.pop();
			maxScore++;
			j++;
		}
		
		return maxScore;
	}

	private static Stack<Integer> populateStack(List<Integer> h) {
		Stack<Integer> st = new Stack<>();
		for (int i = h.size() - 1; i > -1; i--) {
			st.push(h.get(i));
		}
		return st;
	}

	public static void main(String[] args) {
		Integer[] a2 = {1,2,3,4,5};
		Integer[] a3 = {6,7,8,9};
		
		System.out.println(twoStacks(10,Arrays.asList(a2),Arrays.asList(a3)));
	}

}
