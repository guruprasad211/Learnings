package com.learnbay.stacks;

public class QueueCustom {
	int[] arr;
	int front;
	int rear;
	int maxSize;
	int size;

	public QueueCustom(int maxSize) {
		this.maxSize = maxSize;
		this.front = 0;
		this.rear = -1;
		this.arr = new int[maxSize];
		size = 0;
	}

	public boolean isEmpty() {
		// return front > rear;
		return rear == -1 || front == maxSize;
	}

	public boolean isFull() {
		return rear == maxSize - 1;
	}

	public void enQueue(int data) {
		if (isFull()) {
			System.out.println("Queue is full");
			return;
		}
		this.arr[++rear] = data;
		size++;
	}

	// removes first element and return using front++
	public int deQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return 0;
		}
		int temp = this.arr[front];
		this.arr[front++] = 0;
		size--;
		return temp;
	}
	
	public int size() {
		return size;
	}

	public void print() {
		for (int i = 0; i <= rear; i++) {
			System.out.println("data:" + arr[i]);
		}
		/*
		 * for(int data : arr) { System.out.println("data:" + data); }
		 */
	}

	public void printFromBack() {
		for (int i = rear; i >= 0; i--) {
			System.out.println("data from last:" + arr[i]);
		}
		/*
		 * for(int data : arr) { System.out.println("data:" + data); }
		 */
	}

	public static void main(String[] args) {
		QueueCustom q = new QueueCustom(5);
		q.deQueue();
		System.out.println("Size of Queue:" + q.size);
		
		q.enQueue(10);
		q.enQueue(20);
		q.enQueue(5);
		q.enQueue(1);
		q.enQueue(15);
		
		System.out.println("Size of Queue:" + q.size);
		
		q.print();

		q.deQueue();
		q.deQueue();
		System.out.println("------ after dequeue 2 elements ------");
		System.out.println("Size of Queue:" + q.size);
		q.print();

		q.printFromBack();

		/*
		 * while (!q.isEmpty()) { System.out.println("deque using while:" +
		 * q.deQueue()); }
		 */
	}

}
