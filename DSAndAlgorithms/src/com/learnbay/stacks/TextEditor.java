package com.learnbay.stacks;

import java.util.Scanner;

public class TextEditor {
	public static void main(String[] args) {
		//its used to store previous string to perform delete and undo operations
		java.util.Stack<String> st = new java.util.Stack<>();
		Scanner sc = new Scanner(System.in);
		int limit = sc.nextInt();
		String s = ""; //initial string
		for(int i=0; i < limit; i++) {
			int op = sc.nextInt();
			switch (op) {
			case 1:
				// apend to stack
				st.push(s);//stores previous string value
				String append = sc.next();
				s += append;
				break;
			case 2:
				// delete last n chars
				st.push(s);//push prev String
				int k = sc.nextInt();
				s = s.substring(0, s.length() - k);
				break;
			case 3:
				// print kth char
				int pos = sc.nextInt();
				System.out.println(s.charAt(pos - 1));
				break;
			case 4:
				// undo last operations of 1 or 2
				s = st.pop();
				break;
			default:
				break;
			}
		}
		sc.close();
	}

}
