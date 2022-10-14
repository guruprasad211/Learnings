package com.learnbay.stacks;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

	/*iterate until max element is found in an array to the left of the element
	 * 
	 * i/P: 100, 50, 60, 20, 30, 50, 70, 110, 80 
	 * O/p: [1, 1, 2, 1, 2, 3, 6, 8, 1]
	 */
	public static int[] findStockSpan(int[] stocks) {
		int n = stocks.length;
		int[] r = new int[n];

		for (int i = 0; i < n; i++) {
			for (int j = i; j > -1; j--) {
				if (stocks[j] <= stocks[i]) {
					r[i] += 1;
				} else {
					break;
				}
			}
		}
		return r;
	}

	/*
	 * Store all index values to stack in descending order.
	 * If stack value is greater than the current value dont pop
	 * 
	 * i/P: 100, 50, 60, 20, 30, 50, 70, 110, 80 
	 * O/p: [1, 1, 2, 1, 2, 3, 6, 8, 1]
	 */
	public static int[] findStockSpanUsingStack(int[] stocks) {
		int n = stocks.length;
		int[] r = new int[n];
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!s.isEmpty() && stocks[s.peek()] <= stocks[i]) {
				s.pop();
			}
			
			if (s.isEmpty()) {
				r[i] = i + 1;
			} else {
				r[i] = i - s.peek();
			}
			s.push(i);
		}
		return r;
	}

	public static void main(String[] args) {
		int[] a = { 100, 50, 60, 20, 30, 50, 70, 110, 80 };
		System.out.println("res:" + Arrays.toString(findStockSpan(a)));
		
		System.out.println("res using stack:" + Arrays.toString(findStockSpanUsingStack(a)));
	}

}
