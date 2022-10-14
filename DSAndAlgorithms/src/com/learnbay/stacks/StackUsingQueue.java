package com.learnbay.stacks;

import java.util.NoSuchElementException;

/*
 * Using single queue we can make stack, by adding elements to the 
 * queue and dequeing all the elements from the queue and add back to the queue again
 * upto the size-1. As the newly added one will go to rear and it will be the first element in queue
 * 
 */
public class StackUsingQueue {
	QueueLinkList q = null;
	
	public StackUsingQueue() {
		this.q = new QueueLinkList();
	}

	public void push(int data) {
		if(q.isEmpty())
			q.add(data);
		else {
			q.add(data);
			//upto the last before element add to queue
			for(int i=0; i < q.size()-1;i++) {
				int d=q.remove();
				q.add(d);
			}
		}
	}
	
	public int pop() {
		if(q.isEmpty())
			throw new NoSuchElementException();
		
		return q.remove();
	}
	public int size() {
		return q.size();
	}
	public void print() {
		System.out.println("Data:"+q);
	}
	
	public static void main(String[] args) {
		StackUsingQueue s = new StackUsingQueue();
		System.out.println("size:"+s.size());
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		System.out.println("size:"+s.size());
		
		s.print();
	}

}
