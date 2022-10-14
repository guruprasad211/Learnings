package com.learnbay.stacks;

public class ReverseStringUsingStacks {
	static char[] stringrev(char[] str) {
		if(str == null || str.length == 1) {
			return str;
		}
		java.util.Stack<Character> s = new java.util.Stack<>();
		for(char c : str) {
			s.push(c);
		}
		int i = 0;
		while(!s.isEmpty()) {
			str[i++] = s.pop();
		}
		return str;
	}

	public static void main(String[] args) {
		
		System.out.println(ReverseStringUsingStacks.stringrev("Apple".toCharArray()));
	}

}
