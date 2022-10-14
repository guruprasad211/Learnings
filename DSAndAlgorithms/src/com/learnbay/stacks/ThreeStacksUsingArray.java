package com.learnbay.stacks;

import java.util.EmptyStackException;

/*
 * Divide the array into 3 equal parts by using
 * we use notation [ to inclusive of start and ) exclusive of start position
 * 1st stack can store from [0 to n/3)
 * 2ns stack from 			[n/3 to 2n/3)
 * 3rd stack from 			2n/3 to n)
 * 
 * top of the index is calculated using the stackCapacity and no of elements stored in stack
 */
public class ThreeStacksUsingArray {
	private int noOfStacks = 3;
	private int stackCapacity;//each stack can hold
	private int[] stackElements;
	// stores the sizes of the elements inserted in stack up to stackCapacity
	private int[] sizes;

	/*
	 * size is for single stack so create array with 3 times size
	 */
	public ThreeStacksUsingArray(int stackSize) {
		this.stackElements = new int[noOfStacks * stackSize];
		this.stackCapacity = stackSize;
		this.sizes = new int[noOfStacks];
	}

	public void push(int stackNum, int data) {

		if (validateStackNum(stackNum)) {
			System.err.println("Invalid stack number, it must have 0/1/2");
			return;
		}
		if (isStackFull(stackNum)) {
			System.err.println("Stack num " + stackNum + " is full");
			return;
		}
		sizes[stackNum]++;
		stackElements[indexOfTop(stackNum)]=data;
	}
	
	//top starts from 0, increase the size of the stack before inserting the data to stack array as the array starts from 0
	private int indexOfTop(int stackNum) {
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size - 1;
	}

	public int pop(int stackNum) {

		if (validateStackNum(stackNum)) {
			System.err.println("Invalid stack number, it must have 1/2/3");
			return -1;
		}
		if (isStackEmpty(stackNum)) {
			System.err.println("Stack num " + stackNum + " is full");
			throw new EmptyStackException();
		}
		int top = indexOfTop(stackNum);
		int data = stackElements[top];
		stackElements[top] = 0;
		sizes[stackNum]--;
		return data;
	}
	
	private boolean validateStackNum(int stackNum) {
		
		return stackNum < 0 || stackNum > 2;
	}

	public int peek(int stackNum) {
		if (stackNum < 1 || stackNum > 3) {
			System.err.println("Invalid stack number, it must have 1/2/3");
			return -1;
		}
		if (isStackEmpty(stackNum)) {
			System.err.println("Stack num " + stackNum + " is full");
			throw new EmptyStackException();
		}
		return stackElements[indexOfTop(stackNum)];
	}
	
	private boolean isStackEmpty(int stackNum) {
		return this.sizes[stackNum] == 0;
	}

	private boolean isStackFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}

	public static void main(String[] args) {
		ThreeStacksUsingArray t = new ThreeStacksUsingArray(2);

		t.push(0, 1);
		t.push(1, 10);
		t.push(2, 20);
		
		t.push(0, 2);
		t.push(1, 11);
		t.push(2, 21);
		
		t.push(0, 3);
		t.push(1, 12);
		t.push(2, 22);
		
		System.out.println("Pop el:" + t.pop(0));
		System.out.println("Pop el:" + t.pop(1));
		System.out.println("Pop el:" + t.pop(2));
	}

}
