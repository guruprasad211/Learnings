package com.linkedlist;

class CircularNode {
	int data;
	CircularNode next;

	public CircularNode(int data) {
		this.data = data;
	}

}

public class CircularLinkedList {
	CircularNode head;

	public void addAtFirt(int data) {
		CircularNode newNode = new CircularNode(data);
		if (head == null) {
			newNode.next = newNode;
			head = newNode;
		} else {
			CircularNode last = head;
			// find last node, as last.next points to head node, get last node only
			while (last.next != head) {
				last = last.next;
			}

			last.next = newNode;
			newNode.next = head;
			head = newNode;
		}
	}

	public void addAtLast(int data) {
		CircularNode newNode = new CircularNode(data);
		if (head == null) {
			newNode.next = newNode;
			head = newNode;
		} else {
			CircularNode last = head;
			// find last node, as last.next points to head node, get last node only
			while (last.next != head) {
				last = last.next;
			}

			last.next = newNode;
			newNode.next = head;
		}
	}

	public boolean search(int data) {
		if (head == null) {
			return false;
		}

		CircularNode temp = head;

		do {
			if (temp.data == data) {
				return true;
			}
			temp = temp.next;
		} while (temp != head);
		return false;
	}

	public void delete(int data) {
		if (head == null) {
			return;
		}
		// delete head node //if only one node
		if (head.data == data && head.next == head) {
			head = null;
		} // delete head node, if more than one node present
		else if (head.data == data) {
			CircularNode last = head;
			// find last node, as last.next points to head node, get last node only
			while (last.next != head) {
				last = last.next;
			}
			last.next = head.next;
			head = head.next;
			
		} else {
			// delete last node
			CircularNode current = head;
			// find last node, as last.next points to head node, get last node only
			while (current.next != head) {
				if(current.next.data == data) {
					current.next = current.next.next;
					break;
				}
				current = current.next;
			}
		}

	}

	public void distplay() {
		if (head == null) {
			return;
		}

		CircularNode temp = head;

		do {
			System.out.println(temp.data);
			temp = temp.next;
		} while (temp != head);
	}
	
	/*
	 * If there are 6 persons and killPosition is 2 means, 0 can kill next means 1, and 0 handles knife to 2,
	 * 2 can kill 3 and handles to 4, 4 kills 5 and handles to 0.
	 * 
	 * Again 0 kills 2 and handles to 4, 4 kills 0 and 4 is saved as its the last person
	 */
	public int whichPersonIsSaved(int noOfPersons, int killPosition) throws InterruptedException {
		/*if(killPosition > noOfPersons) {
			System.out.println("Kill position must be less then the persons");
			return null;
		}*/
		if(noOfPersons == 1) {
			return 1;
		}
		CircularNode curr = this.head;
		
		while (curr != curr.next) {
			//if 2 means he can kill next person
			int movePositions = killPosition;
			CircularNode next = curr;
			while(movePositions > 0) {
				movePositions--;
				next = next.next;
			}
			System.out.println("curr:"+curr.data + " next data:" + next.data);
			Thread.sleep(2000);
			//removing the head node
			if(curr == next.next) {
				next.next = next;
			}else {
				//point this next to
				curr.next = next;
			}
			
			curr = next;
		}
		
		return curr.data;
	}

	public static void main(String[] args) throws InterruptedException {
		CircularLinkedList list = new CircularLinkedList();
		//list.addAtLast(0);
		list.addAtLast(1);
		list.addAtLast(2);
		list.addAtLast(3);
		list.addAtLast(4);
		list.addAtLast(5);
		//list.addAtLast(6);
		
		list.distplay();
		
		int data = list.whichPersonIsSaved(6, 2);
		System.out.println("Person saved:" + data);

		/*list.addAtFirt(30);
		list.addAtFirt(20);
		list.addAtFirt(10);

		list.distplay();

		list.addAtLast(50);
		list.addAtLast(60);
		list.addAtLast(70);

		list.addAtFirt(5);

		list.distplay();

		System.out.println("element found:" + list.search(5));

		System.out.println("Deleting node:");
		list.delete(5);
		list.distplay();

		list.delete(50);
		list.distplay();

		list.delete(70);
		list.distplay(); */
	}

}
