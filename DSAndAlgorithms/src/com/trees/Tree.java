package com.trees;

import java.util.Arrays;
import java.util.Stack;

public class Tree {
	private TreeNode root;

	public Tree(TreeNode root) {
		this.root = root;
	}

	public void preOrderTraversal(TreeNode node) {
		if (node != null) {
			System.out.println("data:" + node.getData());
			preOrderTraversal(node.getLeft());
			preOrderTraversal(node.getRight());
		}
	}

	/*
	 * root,left, right
	 * 
	 * push root element first to stack and check is stack not empty push right and left to stack
	 * 
	 */
	public void preOrderTraversalNonRecursive(TreeNode node) {
		Stack<TreeNode> s = new Stack<>();
		TreeNode temp = node;
		while (temp != null) {
			if (s.isEmpty()) {
				s.push(temp);
			}
			if (!s.isEmpty()) {
				temp = s.pop();
				System.out.println("data:" + temp.getData());

				if (temp.getRight() != null)
					s.push(temp.getRight());

				if (temp.getLeft() != null)
					s.push(temp.getLeft());

				if (s.isEmpty()) {
					temp = null;
				}
			}

		}

	}

	public void inOrderTraversal(TreeNode node) {
		if (node != null) {
			inOrderTraversal(node.getLeft());
			System.out.println("data:" + node.getData());
			inOrderTraversal(node.getRight());
		}
	}

	/*
	 * left, root, right
	 * 
	 * travser to end of the left most node, if left node is null rpop the element from stack
	 * and print and assigh right node to the current node and go on
	 * 
	 */
	public void inOrderTraversalNonRecursive(TreeNode node) {
		Stack<TreeNode> s = new Stack<>();
		TreeNode temp = node;
		boolean done = false;
		while (!done) {
			if(temp !=null) {
				s.push(temp);
				temp = temp.left;
			}
			else {
				if(s.isEmpty()) {
					done=true;
				}
				else {
					temp = s.pop();
					System.out.println(temp.data);
					temp = temp.right;
				}
			}
		}
	}

	public void postOrderTraversal(TreeNode node) {
		if (node != null) {
			postOrderTraversal(node.getLeft());
			postOrderTraversal(node.getRight());
			System.out.println("data:" + node.getData());
		}
	}
	
	/* left, right, root
	 * 
	 * Maintain 2 stacks. s1 and s2.
	 * 
	 * store root element to s1 and repeat the process until s1 is empty
	 * 
	 * pop s1 element and add left and right to s1 and pop element to s2 and repeat until s1 is empty
	 */
	public void postOrderTraversalNonRecursive(TreeNode node) {
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		TreeNode temp = node;
		s1.push(temp);
		while (!s1.isEmpty()) {
			TreeNode popedElem = s1.pop();
			
			if(popedElem.left !=null) {
				s1.push(popedElem.left);
			}
			if(popedElem.right !=null) {
				s1.push(popedElem.right);
			}
			s2.push(popedElem);
		}
		System.out.println(s2);
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	@Override
	public String toString() {
		return "Tree [root=" + root + "]";
	}

}
