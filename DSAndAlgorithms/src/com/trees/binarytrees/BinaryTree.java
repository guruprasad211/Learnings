package com.trees.binarytrees;

import com.trees.Tree;
import com.trees.TreeNode;

public class BinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		Tree tree = new Tree(root);

		tree.getRoot().setLeft(new TreeNode(20));
		tree.getRoot().setRight(new TreeNode(30));

		tree.getRoot().getLeft().setLeft(new TreeNode(40));
		tree.getRoot().getLeft().setRight(new TreeNode(50));

		tree.getRoot().getRight().setLeft(new TreeNode(60));
		tree.getRoot().getRight().setRight(new TreeNode(70));

		/*System.out.println("tree:" + tree.toString());
		
		System.out.println("Pre order traversal");
		tree.preOrderTraversal(root);
		
		System.out.println("Pre order traversal non recursive");
		tree.preOrderTraversalNonRecursive(root);
		
		System.out.println("in order traversal");
		tree.inOrderTraversal(root);
		
		System.out.println("in order traversal non recursive");
		tree.inOrderTraversalNonRecursive(root);
		
		System.out.println("post order traversal");*/
		
		tree.postOrderTraversal(root);
	}

}
