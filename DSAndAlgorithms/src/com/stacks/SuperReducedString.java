package com.stacks;

import java.util.Stack;

/**
 * 
Input: aabcccdd
Output: “bc”
Explanation:
aabcccdd -> bcccdd -> bcdd -> bc
(we eliminate two same adjacent characters at each step)

 * @author guruprasadchowdaryp
 *
 */

public class SuperReducedString {
	
		public static String superReducedString(String s) {
			// Write your code here
        	Stack<Character> stack = new Stack<>();
            for(char c : s.toCharArray()){
                if(stack.isEmpty() || stack.peek()!=c){
                    stack.push(c);
                    continue;
                }
                while(!stack.isEmpty() && stack.peek()==c){
                    stack.pop();
                }
            }
            String result = "";
            while(!stack.isEmpty()){
                result=stack.pop()+result;
            }
            return result.length()==0?"Empty string":result;
	    }
		//2nd approach
		public static String superReducedString2(String s) {
			// Write your code here
        	Stack<Character> stack = new Stack<>();
            for(char c : s.toCharArray()){
                if(stack.isEmpty() || stack.peek()!=c){
                    stack.push(c);
                }
                else if (stack.peek()==c) {
                	stack.pop();
                }
            }
            String result = "";
            while(!stack.isEmpty()){
                result=stack.pop()+result;
            }
            return result.length()==0?"Empty string":result;
	    }
		
		//3rd approach
		//You start to analyze the string from the beginning, 
		//and as soon as you see a matching adjacent character, 
		//remove both the characters. Start again from the start position and keep on repeating the process.
		public static String bruteForce(String s) {
			// Write your code here
			if(s==null || s.length()==0) {
				return "Empty string";
			}
			char prv=s.charAt(0);
            for(int i=1;i<s.length();i++){
            	if(prv==s.charAt(i)) {
            		s=s.substring(0,i-1)+s.substring(i+1);
            		if(s.length()>0) {
            			prv=s.charAt(0);
            		}
            		i=1;
            	}
            	else {
            		prv=s.charAt(i);
            	}
            }
            
            return s.length()==0?"Empty string":s;
	    }
		
		public static void main(String[] args) {
			System.out.println(SuperReducedString.bruteForce("aaabccddd"));
			System.out.println(SuperReducedString.bruteForce("aa"));
		}
}
