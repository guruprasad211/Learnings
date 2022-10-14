package com.learnbay.stacks;

public class ReverseQueueUsingRecursion {
	
	public static void reverseQueue(QueueLinkList q) {
		if(q.isEmpty()) {
			return;
		}
		int data = q.remove();
		reverseQueue(q);
		q.add(data);
	}
	
	
	public static void main(String[] args) {
		QueueLinkList q = new QueueLinkList();
		q.add(10);
		q.add(20);
		q.add(30);
		q.add(40);
		q.add(50);
		
		q.print();
		
		ReverseQueueUsingRecursion.reverseQueue(q);
		
		q.print();
	}

}
