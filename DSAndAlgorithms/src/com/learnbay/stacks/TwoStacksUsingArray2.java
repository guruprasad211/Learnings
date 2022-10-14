package com.learnbay.stacks;

/*
 * If 1st stack is full (ie half of the stack, then it throws stack full),
 * iF stack2 is empty and stack1 is full add to stack2
 */
public class TwoStacksUsingArray2 {
	static int size = 6;
	static int[] stack = new int[size];
	static int top1 = -1;
	static int top2 = size;

	static void push1(int val)
	{
		//top1 cvan reach upto top2 -1 as elements can be added in stack2 if stack1 is full
		//until stack2 is full
	    if(top1 == top2 - 1) {
	    	return;
	    }else {
	    	stack[++top1] = val;
	    }
	}
	//top2 can go till top1 if stack1 is empty
	static void push2(int val)
	{
		if(top1 == top2 - 1) {
	    	return;
	    }else {
	    	stack[--top2] = val;
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
		if(top2 == size) {
	    	return -1;
	    }
	    return stack[top2++];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
