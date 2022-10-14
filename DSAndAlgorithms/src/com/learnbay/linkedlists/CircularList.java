package com.learnbay.linkedlists;
public class CircularList {

	Node tail;
	public CircularList() {
		// TODO Auto-generated constructor stub
		this.tail = null;
	}
	
	public void insertAtBegining(int data){
		
		Node temp = new Node(data);
		if( null == tail){
			tail=temp;
			tail.next=tail;
		}else{
			Node next = tail.next;
			temp.next=next;
			tail.next=temp;
			
		}
	}
	
	public void deleteFromStart(){
		if(tail.next == tail){
			tail = null;
		}else{
			tail.next=tail.next.next;
		}
	}
	
	public void printList(){
		Node current = tail.next;
		while(current!=tail){
			System.out.println(current.data);
			current=current.next;
		}
		System.out.println(current.data);
	}
	
	
	public void deleteSpeciFicNode (int data, CircularList list){
		Node current= list.tail.next;
		if(data == list.tail.data){			
			Node cur = list.tail.next;
			while(cur.next!=tail){
				cur=cur.next;
			}
			cur.next=list.tail.next;
			list.tail = cur.next;
			
		}
		else{
		while(current!=list.tail){
			if(current.next.data == data){
				current.next=current.next.next;
				break;
			}
			current=current.next;
		}
		}
	}
	
	
	public static void main(String args[]){
		CircularList list = new CircularList();
		list.insertAtBegining(30);
		list.insertAtBegining(20);
		list.insertAtBegining(10);
		//list.deleteFromStart();
		
		System.out.println(" Print the list before delete");
		list.printList();
		System.out.println(" Print the list AFTER delete");
		list.deleteSpeciFicNode(30,list);
		list.printList();
	}
}

