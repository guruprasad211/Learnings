package com.learnbay.stacks;

public class Stack {
	int[] arr;
	int top = -1;
	int maxSize;

	public Stack(int maxSize) {
		this.maxSize = maxSize;
		this.arr = new int[maxSize];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == maxSize -1;
	}
	
	public void push(int data) {
		if(isFull()) {
			System.out.println("Stact is full");
			throw new StackOverflowError("Stack is full");
		}
		this.arr[++top] = data;
	}
	
	//removes last element and return
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stact is empty");
			throw new StackOverflowError("Stack is empty");
		}
		
		return this.arr[top--];
	}
	
	//returns the last element
	public int peek() {
		if(isEmpty()) {
			System.out.println("Stact is empty");
			throw new StackOverflowError("Stack is empty");
		}
		return this.arr[top];
	}
	
	public void print() {
		for(int i=0; i <= top; i++) {
			System.out.println("data:" + arr[i]);
		}
		/*for(int data : arr) {
			System.out.println("data:" + data);
		}*/
	}
	

	public static void main(String[] args) {
		Stack s = new Stack(5);
		//s.pop();
		s.push(10);
		s.push(20);
		s.push(5);
		s.push(1);
		s.push(15);
		//s.push(30);
		
		s.print();
		
		s.pop();
		s.pop();
		System.out.println("------ after pop ------");
		s.print();
		
		System.out.println("---------after peek:" + s.peek());
		s.print();
	}

}
