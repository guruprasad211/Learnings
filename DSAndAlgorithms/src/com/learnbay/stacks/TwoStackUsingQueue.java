package com.learnbay.stacks;

public class TwoStackUsingQueue {
	static int size = 6;
	static int[] stack = new int[size];
	static int mid = size/2;
	static int top1 = -1;
	static int top2 = mid - 1;

	static void push1(int val)
	{
	    if(top1 == mid-1) {
	    	return;
	    }
	    if(top1 < mid) {
	    	stack[++top1] = val;
	    }
	}

	static void push2(int val)
	{
		if(top2 == size - 1) {
			return;
		}
		if(top2 < size) {
	    	stack[++top2] = val;
	    }
	}

	static int pop1()
	{
	    if(top1 == -1) {
	    	return -1;
	    }
	    return stack[top1--];
	    
	}

	static int pop2()
	{
		if(top2 == mid - 1) {
	    	return -1;
	    }
	    return stack[top2--];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
