package com.learnbay.stacks;

import java.util.Stack;

public class ReverseStackUsingRecursion {
	
	public static void reverseStack(java.util.Stack<Integer> s) {
		if(s.isEmpty()) {
			return;
		}
		int data = s.pop();
		//50
		//40
		//30
		//20
		//10 returns 1st from Stack
		reverseStack(s);
		//stack is empty when it reaches here
		insertAtBottom(s, data);
		
		
	}
	
	/*
	 * maintain function stack values in reverse order
	 * keep last element in bottom of the stack
	 * 
	 * 10 s.isEmpty	push 10
	 * 20 !s.isEmpty pop 10 push 20
	 * 30 !s.isEmpty pop 20 push 30
	 * 40	!s.isEmpty pop 30 push 40
	 * 50 !s.isEmpty pop 40 push 50
	 */
	private static void insertAtBottom(Stack<Integer> s, int data) {
		if(s.isEmpty()) {
			s.push(data);
			return;
		}
		//pop elemnt and keep in call stack, 
		//keep ele to put at bottom of the stack in stack 
		int topEle = s.pop();
		insertAtBottom(s, data);
		s.push(topEle);
	}


	public static void main(String[] args) {
		java.util.Stack<Integer> s = new java.util.Stack<>();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		
		System.out.println(s);
		
		ReverseStackUsingRecursion.reverseStack(s);
		
		System.out.println(s);
	}

}
