package com.learnbay.stacks;

public class BalacedString {
	
	public String isStringBalanced(String s) {
		String res = "NO";
		if(s==null) return res;
		//if odd length its not balanced
		if(s.length()%2 !=0 || s.length() == 0) return res;
		//if(!BalacedString.isValid(s)) return false;
		
		java.util.Stack<Character> stack = new java.util.Stack();
		//Stack<Character> stack = new Stack();
		while(!s.isEmpty()) {
			char c = s.charAt(0);
			if(c == '{' || c == '(' || c=='[') {
				stack.push(c);
			}
			else {
				if(stack.isEmpty()) return res;
				if((c == ']' && stack.pop() != '[') || (c == '}' && stack.pop() != '{')
						|| (c == ')' && stack.pop() != '(')) {
					return res;
				}
			}
			s = s.substring(1);
		}
		if(!stack.isEmpty()) return res;
		return "YES";
	}
	
	public boolean isStringBalanced(char[] str) {
		boolean res = false;
		if(str==null) return res;
		//if odd length its not balanced
		if(str.length%2 !=0 || str.length == 0) return res;
		//if(!BalacedString.isValid(s)) return false;
		
		java.util.Stack<Character> stack = new java.util.Stack();
		//Stack<Character> stack = new Stack();
		for(char c : str) {
			if(c == '{' || c == '(' || c=='[') {
				stack.push(c);
			}
			else {
				if(stack.isEmpty()) return res;
				char temp = stack.pop();
				if((c == ']' && temp != '[') || (c == '}' && temp != '{')
						|| (c == ')' && temp != '(')) {
					return res;
				}
			}
		}
		return stack.isEmpty();
	}
	
	public static boolean isAlphaNumeric(String s) {
		return s!=null && s.matches("^[a-zA-Z0-9]*$");
	}
	
	public static boolean isValid(String s) {
		return s!=null && s.matches("^[\\[\\]\\{\\}\\(\\)]*$");
	}

	public static void main(String[] args) {
		BalacedString b = new BalacedString();
		//System.out.println(b.isStringBalanced("{()[]}"));
		//System.out.println(b.isStringBalanced(null));
		//System.out.println(b.isStringBalanced(""));
		//System.out.println(b.isStringBalanced("}}}))]])"));
		System.out.println(b.isStringBalanced("}{[]}".toCharArray()));
		
	}
}
