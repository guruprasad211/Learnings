package com.learnbay.stacks;

import java.util.EmptyStackException;

/*
 * Uses 2 queues to store the actual values in one queus and the other for storing the actual queues back to it
 * LIFO use case to achieve, use Q1 while pushing Q1 add to Q2
 */
public class StackUsing2Queues {

	QueueLinkList q = null;

	public StackUsing2Queues() {
		this.q = new QueueLinkList();
	}

	public void push(int data) {
		if (q.isEmpty()) {
			q.add(data);
			return;
		}
		// if Queue is not empty, empty the queue to tempQ and again copy back
		QueueLinkList tempQ = new QueueLinkList();
		while (!q.isEmpty()) {
			int temp = q.remove();
			if (temp != 0)
				tempQ.add(temp);
		}
		q.add(data);
		while (!tempQ.isEmpty()) {
			int temp = tempQ.remove();
			if (temp != 0)
				q.add(temp);
		}
	}

	public int pop() {
		if (q.isEmpty()) {
			throw new EmptyStackException();
		}
		return q.remove();
	}
	
	public void print() {
		q.print();
	}

	public static void main(String[] args) {
		StackUsing2Queues st = new StackUsing2Queues();
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		
		st.print();
		
		st.pop();
		st.pop();
		st.push(150);
		st.print();
	}

}
