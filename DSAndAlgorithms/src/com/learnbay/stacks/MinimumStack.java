package com.learnbay.stacks;

import java.util.Stack;

/*
 * Maintain 2 stacks, while adding an element to stack check 
 * minStack value if its less than the current value, add it to minStack else not add
 * If we pop the element which is min value then pop in min stack also
 */
public class MinimumStack {
	java.util.Stack<Integer> st = null;
	java.util.Stack<Integer> minSt = null;
	
	public MinimumStack() {
		this.st = new Stack<>();
		this.minSt = new Stack<>();
	}
	
	public void push(int data) {
		st.push(data);
		if(minSt.isEmpty() || data <= minSt.peek()) {
			minSt.push(data);
		}
	}
	
	public int pop() {
		int elem = st.pop();
		if(minSt.peek() == elem) {
			minSt.pop();
		}
		return elem;
	}

	public int getMin() {
		
		return !minSt.isEmpty() ? minSt.peek() : 0;
	}
	
	public static void main(String[] args) {
		MinimumStack obj = new MinimumStack();
		obj.push(10);
		obj.push(20);
		obj.push(5);
		obj.push(1);
		obj.push(30);
		obj.push(1);
		obj.push(100);
		System.out.println("min Value:"+obj.getMin());
		obj.pop();
		obj.pop();
		System.out.println("min Value:"+obj.getMin());
		obj.pop();
		obj.pop();
		System.out.println("min Value:"+obj.getMin());
		obj.pop();
		System.out.println("min Value:"+obj.getMin());
		obj.push(-5);
		System.out.println("min Value:"+obj.getMin());
		obj.push(-1);
		System.out.println("min Value:"+obj.getMin());
		obj.push(-6);
		System.out.println("min Value:"+obj.getMin());
	}

}
