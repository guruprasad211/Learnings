package com.trees.binarysearchtrees;

import com.trees.TreeNode;

public class BinarySearchTree {
	TreeNode root = null;

	public TreeNode insert(TreeNode root, int data) {
		if (root == null) {
			return new TreeNode(data);
		}
		if(data < root.getData()) {
			root.setLeft(insert(root.getLeft(),data));
		}
		if(data > root.getData()) {
			root.setRight(insert(root.getRight(),data));
		}
		return root;
	}

	public static void main(String[] args) {
		BinarySearchTree b = new BinarySearchTree();
		b.root = b.insert(b.root, 100);
		b.root = b.insert(b.root, 50);
		b.root = b.insert(b.root, 150);
		b.root = b.insert(b.root, 125);
		b.root = b.insert(b.root, 50);
		b.root = b.insert(b.root, 60);
		b.root = b.insert(b.root, 70);
		
		System.out.println(b.root);

	}

}
