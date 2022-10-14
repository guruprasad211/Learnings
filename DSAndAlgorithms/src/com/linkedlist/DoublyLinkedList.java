package com.linkedlist;

class DoublyLinkedListNode {
	int data;
	DoublyLinkedListNode prev;
	DoublyLinkedListNode next;

	public DoublyLinkedListNode(int data) {
		this.data = data;
	}

}

public class DoublyLinkedList {
	DoublyLinkedListNode head;
	DoublyLinkedListNode last;

	public void insertFirst(int data) {
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

		if (head == null) {
			head = newNode;
			last = newNode;
		} else {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
	}

	/*
	 * If we dont maintain last node in memory iterate over the list and get last
	 * node and insert the node last = head while(last.next !=null) { last
	 * =last.next; } last.next = newNode; newNode.prev = last;
	 */
	public void insertAtLast(int data) {
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
		if (head == null) {
			head = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			newNode.prev = last;
			last = newNode;
		}
	}

	public void print() {
		DoublyLinkedListNode temp = head;
		System.out.println("Forward Traversal");
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public void printBackward() {
		DoublyLinkedListNode temp = last;
		System.out.println("Backward Traversal");
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.prev;
		}
	}

	public boolean findData(int data) {
		DoublyLinkedListNode temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			if (temp.data == data)
				return true;
			temp = temp.next;
		}
		return false;
	}

	void deleteAnother(int key) {
		if (head == null)
			return;

		DoublyLinkedListNode temp = head;

		while (temp != null && temp.data != key) {
			temp = temp.next;
		}

		if (temp == null)
			System.out.println("Key Not Found");
		else if (temp == head) {
			head = head.next;
			head.prev = null;
		} else if (temp.next == null)
			temp.prev.next = null;
		else {
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
		}
	}

	/*
	 * If only one node in the list, first, last and middle to delete, handle all
	 * the scenarios
	 */
	public void delete(int data) {
		if (head == null) {
			return;
		}
		DoublyLinkedListNode current = head;
		while (current != null) {
			if (current.data == data) {
				// only one node
				if (current.next == null && current.prev == null) {
					head = null;
					last = null;
				} // first node
				else if (current.prev == null) {
					current.next.prev = null;
					head = current.next;
					current.next = null;
				} // last node
				else if (current.next == null) {
					// last before node
					current.prev.next = null;
					last = current.prev;
					current.prev = null;
				} // if middle node
				else {
					current.prev.next = current.next;
					current.prev = null;
					current.next = null;

				}
			} else {
				System.out.println("Key Not Found");
			}
			current = current.next;
		}
	}

	// we get 3 options to insert the data in sorted list, insertBefore,
	// insertBetween and insertLast
	public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
		if (llist == null) {
			llist = newNode;
			return llist;
		}
		DoublyLinkedListNode head = llist;
		DoublyLinkedListNode temp = llist;

		while (temp != null) {
			if (data <= temp.data) {
				newNode.next = temp;
				newNode.prev = temp.prev;
				// if its first node prev is null
				if (temp.prev != null)
					temp.prev.next = newNode;
				temp.prev = newNode;
				if (newNode.prev == null) {
					head = newNode;
				}
				break;
			}
			if (temp.next == null) {
				// insert at last
				temp.next = newNode;
				newNode.prev = temp;
				break;
			}
			temp = temp.next;
		}

		return head;
	}

	public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
		if(llist ==null || llist.next == null)
			return llist;
		
		DoublyLinkedListNode current = llist;
		DoublyLinkedListNode prev = null;
		while(current !=null) {
			prev = current.prev;
			current.prev = current.next;
			current.next = prev;
			current = current.prev;
		}
		return prev.prev;
	}

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertFirst(10);
		list.insertFirst(20);
		list.insertFirst(30);
		list.print();
		DoublyLinkedListNode node = DoublyLinkedList.reverse(list.head);
		System.out.println("After reverse");
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
		
		/*DoublyLinkedListNode node = DoublyLinkedList.sortedInsert(null, 10);
		node = DoublyLinkedList.sortedInsert(node, 5);

		node = DoublyLinkedList.sortedInsert(node, 25);
		node = DoublyLinkedList.sortedInsert(node, 20);

		node = DoublyLinkedList.sortedInsert(node, 20);

		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}*/

		/*
		 * DoublyLinkedList list = new DoublyLinkedList(); list.insertFirst(30);
		 * list.insertFirst(20); list.insertFirst(10);
		 * 
		 * list.print(); System.out.println("inserting at End"); list.insertAtLast(40);
		 * list.insertAtLast(50); list.insertAtLast(60);
		 * 
		 * list.printBackward();
		 * 
		 * list.print();
		 * 
		 * list.insertFirst(5);
		 * 
		 * list.print();
		 * 
		 * System.out.println(list.findData(51));
		 * 
		 * System.out.println("Deleting node"); list.deleteAnother(5); list.print();
		 * 
		 * list.deleteAnother(60); list.print();
		 */

		// list.deleteAnother(30);
		/*
		 * list.delete(30); list.print();
		 * 
		 * System.out.println("insert at first after delete"); list.insertFirst(5);
		 * 
		 * list.print();
		 * 
		 * System.out.println("insert at last after delete"); list.insertAtLast(100);
		 * 
		 * list.print();
		 */
	}

}
