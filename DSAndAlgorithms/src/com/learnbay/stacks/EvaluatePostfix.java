package com.learnbay.stacks;

public class EvaluatePostfix {
	
	static int postfixEval(String str) {
		java.util.Stack<Integer> s = new java.util.Stack<>();
		for(char c : str.toCharArray()) {
			if(c == '*' || c == '/' || c == '+' || c == '-') {
				int x = s.pop();
				int y = s.pop();
				switch (c) {
				case '+':
					s.push(x + y);
					break;
				case '-':
					s.push(y - x);
					break;
				case '*':
					s.push(x * y);
					break;
				case '/':
					s.push(y / x);
					break;
				default:
					break;
				}
				
			}else {
				s.push(c - '0');
			}
		}
		return s.pop();
	}

	public static void main(String[] args) {
		System.out.println(postfixEval("82+"));

	}

}
