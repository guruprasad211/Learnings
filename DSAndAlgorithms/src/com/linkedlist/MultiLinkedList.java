package com.linkedlist;

class MultiNode {
	int data;
	MultiNode right;
	MultiNode left;

	public MultiNode(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "MultiNode [data=" + data + ", right=" + right + ", left=" + left + "]";
	}

}

public class MultiLinkedList {
	MultiNode head;

	public MultiNode sortMultiNodes() {
		if (this.head == null || (this.head.left == null && this.head.right == null)) {
			return null;
		}
		MultiNode current = this.head;
		MultiNode rightNode = this.head.right;
		
		//It points to head node
		MultiNode resHead = new MultiNode(0);
		
		//Prev is used to maintain the last inserted reference
		MultiNode prev = resHead;
		while (current != null) {
			MultiNode next = current.left;
			prev.right = current;
			prev.left=null;
			prev = current;
			current = next;
			//current reaches null if left nodes are null
			//so repeat for right nodes
			if (current == null && rightNode !=null) {
				current = rightNode;
				rightNode = current.right;
			}
		}

		return resHead.right;
	}

	public static void main(String[] args) {
		MultiLinkedList list = new MultiLinkedList();
		MultiNode head = new MultiNode(5);
		head.left = new MultiNode(7);
		head.left.left = new MultiNode(10);

		head.right = new MultiNode(20);
		head.right.left = new MultiNode(25);
		head.right.left.left = new MultiNode(30);

		head.right.right = new MultiNode(50);
		head.right.right.left = new MultiNode(55);
		head.right.right.left.left = new MultiNode(100);

		list.head = head;
		System.out.println(head);

		MultiNode resHead = list.sortMultiNodes();
		System.out.println(resHead);
	}

}
