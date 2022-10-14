package com.linkedlist.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	// Complete the printLinkedList function below.

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
	 *
	 */
	static void printLinkedList(SinglyLinkedListNode head) {
		if (head == null) {
			System.out.println("No elements found");
		} else {
			SinglyLinkedListNode temp = head;
			while (temp != null) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
	}

	static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {

		SinglyLinkedListNode node = new SinglyLinkedListNode(data);
		if (head == null) {
			head = node;
			return node;
		}
		SinglyLinkedListNode temp = head;
		// if last node temp.next is null and temp is the last node
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = node;
		return node;
	}

	public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
		SinglyLinkedListNode node = new SinglyLinkedListNode(data);
		if (llist == null) {
			llist = node;
			return llist;
		} else {
			SinglyLinkedListNode temp = llist;
			int count = 0;
			while (temp != null) {
				count++;
				if (count == position) {
					node.next = temp.next;
					temp.next = node;
				}
				temp = temp.next;
			}
		}
		return llist;
	}

	public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
		if (llist == null) {
			return null;
		} else if (position == 0) {
			return llist.next;
		}

		SinglyLinkedListNode temp = llist;
		int count = 0;
		while (temp != null) {
			count++;
			if (count == position) {
				temp.next = temp.next.next;
				break;
			}
			temp = temp.next;
		}

		return llist;
	}

	// using recursion we can easily traverse the list until last node and print the
	// node values from the last
	public static void reversePrint(SinglyLinkedListNode llist) {
		if (llist == null)
			return;
		reversePrint(llist.next);
		System.out.println(llist.data);

	}

	public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
		SinglyLinkedListNode curr = llist;
		SinglyLinkedListNode prev = null;
		while (curr != null) {
			SinglyLinkedListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		llist = prev;
		return llist;
	}

	/*
	 * You’re given the pointer to the head nodes of two linked lists. Compare the
	 * data in the nodes of the linked lists to check if they are equal. If all data
	 * attributes are equal and the lists are the same length, return . Otherwise,
	 * return .
	 */
	static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		SinglyLinkedListNode temp = head1;
		SinglyLinkedListNode temp1 = head2;
		while (temp != null && temp1 != null) {
			if (temp.data == temp1.data) {
				temp = temp.next;
				temp1 = temp1.next;
				continue;
			} else {
				return false;
			}
		}
		// if both are at last return true
		return temp == null && temp1 == null;
	}

	static SinglyLinkedListNode mergeListsWithSpace(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		SinglyLinkedListNode newList = null;
		if (head1 == null && head2 == null) {
			return null;
		} else if (head1 == null) {
			newList = head2;
		} else if (head2 == null) {
			newList = head1;
		} else {
			while (head1 != null && head2 != null) {
				if (newList == null) {
					if (head1.data < head2.data) {
						newList = head1;
						head1 = head1.next;
					} else {
						newList = head2;
						head2 = head2.next;
					}
				} else {
					if (head1.data < head2.data) {
						newList.next = head1;
						head1 = head1.next;
					} else {
						newList.next = head2;
						head2 = head2.next;
					}
				}
			} // while
			if (head1 == null) {
				newList.next = head2;
			}
			if (head2 == null) {
				newList.next = head1;
			}
		}
		return newList;
	}

	public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
		SinglyLinkedListNode temp = llist;
		int size = 0;
		while (temp != null) {
			size++;
			temp = temp.next;
		}
		System.out.println("Size:" + size);
		System.out.println("positionFromTail:" + positionFromTail);
		// no such element
		if (positionFromTail > size) {
			return -1;
		}
		int pos = 0;
		temp = llist;
		while (temp != null) {
			// from tail position = size-tailPos-1 = fromHead position
			if (size - positionFromTail - 1 == pos++) {
				return temp.data;
			}
			temp = temp.next;
		}
		return -1;
	}

	static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		SinglyLinkedListNode sortedListHead = null;
		if (head1 == null && head2 == null) {
			return null;
		} else if (head1 == null) {
			sortedListHead = head2;
		} else if (head2 == null) {
			sortedListHead = head1;
		} else {
			SinglyLinkedListNode temp = head1;
			SinglyLinkedListNode temp1 = head2;

			SinglyLinkedListNode prev = null;

			while (temp != null && temp1 != null) {
				if (sortedListHead == null && prev != null) {
					sortedListHead = prev;
				}
				if (temp.data <= temp1.data) {
					prev = temp;
					temp = temp.next;
				} else {
					if (prev == null) {
						prev = temp1;
						prev.next = temp;
						temp1 = temp1.next;
						continue;
					}
					// apend to prev node of the list1
					prev.next = temp1;
					prev.next.next = temp;
					prev = prev.next;
					temp1 = temp1.next;
				}
			}
			// if temp is not null find last element
			while (temp != null) {
				prev = temp;
				temp = temp.next;
			}
			if (temp1 != null) {
				prev.next = temp1;
			}
		}

		return sortedListHead;

	}

	public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist) {
		SinglyLinkedListNode prev = llist;
		SinglyLinkedListNode next = llist.next;
		SinglyLinkedListNode head = prev;
		while(next !=null) {
			if(prev.data == next.data) {
				prev.next = next.next;
				prev = next;
				next = next.next;
			}
		}
		return head;
	}

}