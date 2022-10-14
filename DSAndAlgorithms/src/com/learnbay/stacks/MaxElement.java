package com.learnbay.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MaxElement {

	/*
	 * Complete the 'getMax' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * STRING_ARRAY operations as parameter.
	 */

	public static List<Integer> getMax(List<String> operations) {
		java.util.Stack<Integer> s = new java.util.Stack<>();
		//max stack is used to store max element at the time of push element,
		//if elem added is >= max top then add the elem into max stack.
		//if pop the elem and if its equal to max stack then remove in both
		java.util.Stack<Integer> max = new java.util.Stack<>();
		
		List<Integer> listMax = new ArrayList<>();
		for (String s1 : operations) {
			String[] sArr = s1.split(" ");
			if(sArr == null || sArr.length != 3) continue;
			
			if ("1".equals(sArr[0])) {
				int ele = Integer.parseInt(sArr[1]);
				s.push(ele);
				if(max.isEmpty() || ele >= max.peek())  {
					max.push(ele);
				}
			} else if ("2".equals(sArr[0])) {
				if(!s.isEmpty() && !max.isEmpty() && s.peek().equals(max.peek())) {
					max.pop();
				}
				if(!s.isEmpty()) {
					s.pop();
				}
			} else if ("3".equals(sArr[0])) {
				// find max element
				//listMax.add(findMaxElement(s));
				listMax.add(max.peek());
			}
		}
		return listMax;
	}

	private static int findMaxElement(Stack<Integer> s) {
		int max = Integer.MIN_VALUE;
		java.util.Stack<Integer> temp = s;
		while (!temp.isEmpty()) {
			if (temp.peek() > max) {
				max = temp.peek();
			}
			temp.pop();
		}
		return max;
	}

	public static void main(String[] args) {
		String[] input = {"1 97", "2", "1 20", "2", "1 26", "1 20","2","3","1 91", "3"};
		List<String> operations = Arrays.asList(input);
		List<Integer> res = MaxElement.getMax(operations);
		System.out.println("res:" + res);
		
		int[] a = {5,10,20,40,50,100};
		java.util.Stack<Integer> temp = new Stack<>();
		temp.push(5);
		temp.push(10);
		temp.push(30);
		temp.push(25);
		temp.push(100);
		System.out.println(findMaxElement(temp));
	}

}
