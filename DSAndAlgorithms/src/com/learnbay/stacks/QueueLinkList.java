package com.learnbay.stacks;

import java.util.LinkedList;

public class QueueLinkList {

	LinkedList<Integer> q;
	
	public QueueLinkList() {
	 
		q=new LinkedList<>();
	}
	
	public void add(int data){
		q.add(data);
	}
	
	public int remove(){
		return q.remove();
	}
	
	public int size(){
		return q.size();
	}
	
	public boolean isEmpty() {
		return q.isEmpty();
	}
	
	public void print() {
		System.out.println("Queue Data:" + q);
	}
	
	
	
	@Override
	public String toString() {
		return "QueueLinkList [q=" + q + "]";
	}

	public static void main(String[] args) {
		QueueLinkList q = new QueueLinkList();
		q.add(10);
		q.add(20);
		q.add(30);
		
		q.print();
		
		q.remove();
		
		q.print();
		
	}
}
