package com.learnbay.stacks;

import java.util.Stack;

public class SimplifyPath {

	public String simplifyPath(String path) {
		String output = "";
		String[] sPaths = path.split("/");
		Stack<String> s = new Stack<>();
		for (String temp : sPaths) {
			if (!s.isEmpty() && "..".equals(temp)) {
				s.pop();
				continue;
			}
			if (!"".equals(temp) && !"/".equals(temp) && !"..".equals(temp) && !".".equals(temp)) {
				s.push(temp);
			}
		}
		if (s.isEmpty()) {
			return "/";
		}
		while (!s.isEmpty()) {
			output = "/" + s.pop() + output;
		}
		return output;
	}

	public String simplifyPathUsingSB(String path) {
		String[] sPaths = path.split("/");
		Stack<String> s = new Stack<>();
		for (String temp : sPaths) {
			if ("..".equals(temp) && !s.isEmpty()) {
				s.pop();
			} else if (!"".equals(temp) && !"/".equals(temp) && !"..".equals(temp) && !".".equals(temp)) {
				s.push(temp);
			}
		}
		if (s.isEmpty()) {
			return "/";
		}
		StringBuilder output = new StringBuilder();
		while (!s.isEmpty()) {
			//0 means inserts at start of the string always
			output.insert(0, s.pop()).insert(0, "/");
		}
		return output.toString();
	}

	public static void main(String[] args) {
		// String s = "/../home/";
		// String s = "/../";
		String s = "/home//foo/";
		System.out.println("Simplified Path:" + new SimplifyPath().simplifyPath(s));
		System.out.println("Simplified Path:" + new SimplifyPath().simplifyPathUsingSB(s));

	}

}
