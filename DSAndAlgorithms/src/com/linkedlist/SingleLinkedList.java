package com.linkedlist;

class Node {
	int data;
	Node next;

	public Node() {

	}

	public Node(int data) {
		this.data = data;
	}

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}

public class SingleLinkedList {
	Node head;

	public void addFirst(int data) {
		Node first = new Node(data);
		first.next = head;
		head = first;
	}

	public void addLast(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node lastNode = head;
			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}
			lastNode.next = newNode;
		}
		/*
		 * Node temp = head; //fetch last Node to insert data at last while(temp !=
		 * null) { if(temp.next == null) { temp.next = new Node(data); return; } temp =
		 * temp.next; }
		 */
	}

	public void deleteNode(int data) {
		Node temp = head;
		if (temp == null)
			return;
		// if first node matches
		else if (temp.data == data) {
			head = temp.next;
			temp.next = null;
		} else {
			Node current = temp.next;
			while (current != null) {
				if (current.data == data) {
					temp.next = current.next;
					// current.next = null;
					break;
				}
				temp = current;
				current = current.next;
			}
		}
	}

	public boolean findNode(int data) {
		Node temp = head;
		while (temp != null) {
			if (temp.data == data) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	public void print() {
		Node temp = head;
		// fetch last Node to insert data at last
		while (temp != null) {
			System.out.println("data:" + temp.data);
			temp = temp.next;
		}
	}

	public static void print(Node head) {
		Node temp = head;
		// fetch last Node to insert data at last
		while (temp != null) {
			System.out.println("data:" + temp.data);
			temp = temp.next;
		}
	}

	// using recursion we can easily traverse the list until last node and print the
	// node values from the last
	public void reversePrint(Node llist) {
		if (llist == null)
			return;
		reversePrint(llist.next);
		System.out.println(llist.data);

	}

	/*
	 * Change the next reference of the nodes to previous node reference
	 */
	private Node reverseIterative() {
		Node curr = head;
		Node prev = null;
		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		return head;
	}

	/*
	 * elements: 1 2 3 4 null reverseRecursive(1) reverseRecursive(2)
	 * reverseRecursive(3) reverseRecursive(4)
	 * 
	 * O/P reverseRecursive(4) -> head points to Last node reverseRecursive(3) ->
	 * executes from 129 to 131 3rd node next points to last and then last.next
	 * points to previous ie 3rd node and 3rd node next is null and executes for all
	 * nodes
	 */
	private void reverseRecursive(Node node) {
		// returns head/last node
		if (node == null || node.next == null) {
			head = node;
			return;
		}

		reverseRecursive(node.next);
		Node temp = node.next;
		temp.next = node;
		node.next = null;
	}

	static Node mergeListsWithSpace(Node head1, Node head2) {
		Node newList = null;
		if (head1 == null && head2 == null) {
			return null;
		} else if (head1 == null) {
			newList = head2;
		} else if (head2 == null) {
			newList = head1;
		} else {
			Node next = null;
			while (head1 != null && head2 != null) {
				Node temp = null;
				if (head1.data < head2.data) {
					temp = head1;
					head1 = head1.next;
				} else {
					temp = head2;
					head2 = head2.next;
				}

				Node newNode = new Node(temp.data);
				if (newList == null) {
					newList = newNode;
				} else {
					next.next = newNode;
				}

				next = newNode;
			} // while
			if (head1 == null) {
				next.next = head2;
			}
			if (head2 == null) {
				next.next = head1;
			}
		}
		return newList;
	}

	static Node mergeListsInPlace(Node head1, Node head2) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		// this is fixed for the head position
		Node newHead = null;
		// next will be pointed to the newly added node in the list
		Node next = null;
		while (head1 != null && head2 != null) {
			Node temp = null;
			if (head1.data < head2.data) {
				temp = head1;
				head1 = head1.next;
			} else {
				temp = head2;
				head2 = head2.next;
			}

			if (newHead == null) {
				newHead = temp;
			} else {
				next.next = temp;
			}

			next = temp;
		} // while
		if (head1 == null) {
			next.next = head2;
		}
		if (head2 == null) {
			next.next = head1;
		}
		return newHead;
	}

	/*
	 * Node from last = size - positionFromTail -1 (positionFromTail starts at 0, so
	 * -1) 2nd approach:
	 * 
	 * Take 2 pointers pointing to head, move pointer1 to positionFromTail +1 and
	 * then start one by one and if pointer1 reaches null at the last node, other
	 * pointer reaches at the desired position
	 */
	public Node getNodeUsingPointers(Node llist, int positionFromTail) {
		Node p1 = llist;
		Node p2 = llist;
		while (p2 != null && positionFromTail > -1) {
			p2 = p2.next;
			positionFromTail--;
		}

		while (p2 != null) {
			p2 = p2.next;
			p1 = p1.next;
		}
		return p1;
	}

	public Node getNode(Node llist, int positionFromTail) {
		Node temp = llist;
		int size = 0;
		while (temp != null) {
			size++;
			temp = temp.next;
		}
		System.out.println("Size:" + size);
		System.out.println("positionFromTail:" + positionFromTail);
		// no such element
		if (positionFromTail > size) {
			return null;
		}
		int pos = 0;
		temp = llist;
		while (temp != null) {
			// from tail position = size-tailPos-1 = fromHead position
			if (size - positionFromTail - 1 == pos++) {
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}

	public boolean hasCycle(Node head) {
		if (head == null) {
			return false;
		}

		if (head.next == head) {
			return true;
		}
		Node slow = head;
		Node fast = head;
		// Checl if loop exists
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

	public Node detectCycle(Node head) {
		if (head == null) {
			return null;
		}

		if (head.next == head) {
			return head;
		}
		Node slow = head;
		Node fast = head;
		// Checl if loop exists
		boolean isLoopExists = false;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				isLoopExists = true;
				break;
			}
		}

		if (!isLoopExists) {
			return null;
		}

		// to find the number of nodes in the circle
		// move the fast one by one and increament the nodes count until both are not
		// same
		int count = 0;
		fast = fast.next;
		count++;
		while (slow != fast) {
			count++;
			fast = fast.next;
		}
		System.out.println("Number of nodes in the circle:" + count);

		fast = head;
		// if both meets again then its starting point
		// slow will be at the end of the loop, start fast again from head
		// move the both pointer one by one to check the start point of the loop
		while (slow != fast) {
			fast = fast.next;
			slow = slow.next;
		}

		return fast;
	}

	public void createCycle() {
		if (head == null) {
			return;
		}
		Node temp = head;
		Node loopStart = null;
		if (temp.next != null && temp.next.next != null) {
			loopStart = temp.next.next;
		}

		while (temp.next != null) {
			temp = temp.next;
		}
		// last node
		temp.next = loopStart;
	}

	public void removeCycle() {
		Node temp = head;
		if (temp == null) {
			return;
		}
		Node slow = temp;
		Node fast = temp;
		Node prevFast = null;
		// Checl if loop exists
		while (fast != null && fast.next != null) {
			prevFast = fast.next;
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				prevFast.next = null;
				break;
			}
		}
	}

	/*
	 * Another approach with size of the list %2 == 0 Even, else odd
	 */
	public boolean isListEven() {
		Node fast = head;
		if (fast == null || fast.next == null)
			return false;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			if (fast == null)
				return true;
		}
		return false;
	}

	/*
	 * Identify the length of the lists and start the bigger list pointer from
	 * sizeOflist1 - sizeOdlist2
	 */
	public Node intersectionPoint(SingleLinkedList list1, SingleLinkedList list2) {
		int size1 = this.size(list1);
		int size2 = this.size(list2);

		Node node1 = list1.head;
		Node node2 = list2.head;
		if (size1 > size2) {
			int diff = size1 - size2;
			node1 = findStartNode(node1, diff);
		}

		if (size2 > size1) {
			int diff = size2 - size1;
			node2 = findStartNode(node2, diff);
		}

		while (node1 != null && node2 != null) {
			if (node1 == node2) {
				return node1;
			}

			node1 = node1.next;
			node2 = node2.next;
		}

		return null;
	}

	private Node findStartNode(Node node, int diff) {
		while (diff > 0) {
			node = node.next;
			diff--;
		}
		return node;
	}

	private int size(SingleLinkedList list1) {
		int count = 0;
		Node temp = list1.head;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}

	public static Node removeDuplicates(Node llist) {
		if (llist == null)
			return llist;
		Node prev = llist;
		Node next = llist.next;
		Node head = prev;
		while (next != null) {
			if (prev.data == next.data) {
				prev.next = next.next;
			} else {
				prev = next;
			}

			next = next.next;
		}
		return head;
	}

	public static Node removeAllDuplicates(Node llist) {
		if (llist == null || llist.next == null)
			return llist;
		Node current = llist;
		Node next = llist.next;
		Node head = current;
		Node uniqueNode = null;
		boolean isHeadDuplicate = false;
		while (next != null) {
			if (current.data == next.data) {
				current.next = next.next;
				// if first nodes are equal
				if (current == head) {
					isHeadDuplicate = true;
				}
			} else {
				if (uniqueNode != null) {
					uniqueNode.next = next;
					uniqueNode = next;
					current = next;
				} else {
					uniqueNode = next;
					if (isHeadDuplicate) {
						head = next;
						isHeadDuplicate = false;
					}
					current = next;

				}
			}
			next = next.next;
		}

		if (isHeadDuplicate)
			return null;
		if (uniqueNode != null) {
			uniqueNode.next = null;
		}
		return head;
	}

	// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/solution/
	public static Node removeAllDuplicatesValues(Node head) {
		// sentinel
		Node sentinel = new Node(0, head);

		// predecessor = the last node
		// before the sublist of duplicates
		Node pred = sentinel;

		while (head != null) {
			// if it's a beginning of duplicates sublist
			// skip all duplicates
			if (head.next != null && head.data == head.next.data) {
				// move till the end of duplicates sublist
				while (head.next != null && head.data == head.next.data) {
					head = head.next;
				}
				// skip all duplicates
				pred.next = head.next;
				// otherwise, move predecessor
			} else {
				pred = pred.next;
			}

			// move forward
			head = head.next;
		}
		return sentinel.next;
	}

	public static Node addTwoNumbersFromLeft(Node l1, Node l2) {
		if (l1 == null && l2 == null)
			return null;
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		int carry = 0;
		Node res = null;
		Node head = null;
		while (l1 != null || l2 != null) {
			int x = l1 != null ? l1.data : 0;
			int y = l2 != null ? l2.data : 0;

			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;

			int sum = x + y + carry;
			carry = sum / 10;
			int nodeVal = l1 == null && l2 == null ? sum : sum % 10;
			Node node = new Node(nodeVal);
			if (res == null) {
				res = node;
				head = node;
			} else {
				res.next = node;
				// to add nodes at the end store last node ref in res
				res = res.next;
			}

		}
		return head;
	}

	public static void main(String[] args) {
		/*
		 * SingleLinkedList list = new SingleLinkedList(); list.addFirst(6);
		 * list.addFirst(7); list.addFirst(1); list.addFirst(0);
		 * 
		 * SingleLinkedList list2 = new SingleLinkedList(); list2.addFirst(6);
		 * list2.addFirst(5); list2.addFirst(1); list2.addFirst(3); list.print();
		 * System.out.println("--------"); list2.print(); System.out.println("o/p");
		 * Node res = SingleLinkedList.addTwoNumbersFromLeft(list.head, list2.head);
		 * SingleLinkedList.print(res);
		 */

		/*
		 * SingleLinkedList list = new SingleLinkedList(); list.addLast(10);
		 * list.addLast(15); list.addLast(16); list.addLast(20); list.addLast(30);
		 * list.addLast(50); list.addLast(60);
		 * 
		 * list.print(); // removeDuplicates(list.head);
		 * System.out.println("after remove duplicates");
		 * SingleLinkedList.print(SingleLinkedList.removeAllDuplicatesValues(list.head))
		 * ;
		 */

		// System.out.println("Node:" + list.getNodeUsingPointers(list.head,4).data);

		/*
		 * SingleLinkedList list1 = new SingleLinkedList(); list1.addLast(50);
		 * list1.addLast(70); list1.addLast(80);
		 * System.out.println("list:"+list.getNode(list.head, 1).data);
		 * System.out.println("list:"+list.getNode(list1.head, 0).data);
		 * list.getNode(list1.head, 0).next = list1.getNode(list.head, 1);
		 * System.out.println("Intersection node data:"+list.intersectionPoint(list,
		 * list1).data);
		 */

		// System.out.println("List is Even:" + list.isListEven());

		SingleLinkedList list1 = new SingleLinkedList();
		list1.addLast(10);
		list1.addLast(20);
		list1.addLast(30);
		list1.addLast(40);
		list1.addLast(50);
		list1.createCycle();
		Node startPoint = list1.detectCycle(list1.head);
		System.out.println("cycle starting point:" + startPoint.data);
		// list.print();
		// list.removeCycle();
		// list.print();
		/*
		 * SingleLinkedList list2 = new SingleLinkedList(); list2.addLast(10);
		 * list2.addLast(20); list2.addLast(30); list2.addLast(40);
		 * 
		 * Node newNodes = SingleLinkedList.mergeListsWithSpace(list.head, list2.head);
		 * System.out.println("----------new nodes after merge"); while (newNodes !=
		 * null) { System.out.println(newNodes.data); newNodes = newNodes.next;
		 * 
		 * }
		 */
		// list.print();
		// list.reverseIterative();
		// list.reverseRecursive(list.head);
		// System.out.println("Reverse Order");
		// list.print();

		/*
		 * System.out.println("Node found:" + list.findNode(30)); list.deleteNode(10);
		 * list.deleteNode(30); list.deleteNode(30); System.out.println("Node found:" +
		 * list.findNode(30));
		 * 
		 * list.print();
		 * 
		 * list.addFirst(5); System.out.println("Adding data at first node");
		 * list.print();
		 * 
		 * list.addLast(50); System.out.println("Adding data at last node");
		 * System.out.println("Node found:" + list.findNode(50)); list.print();
		 * 
		 * list.reversePrint(list.head);
		 */
		// list.deleteNode(50);
		// list.print();
	}

}
