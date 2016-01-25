package com.data.structures.traverse;

import com.data.structures.model.BinaryNode;

public class BinaryTraverse<T> {

	public void preorder(BinaryNode<T> root) {
		if (root == null) 
			return;
		System.out.println(root.data);
		preorder(root.left);
		preorder(root.right);
	}
	
	public void inorder(BinaryNode<T> root) {
		if (root == null) 
			return;
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}

	public void postorder(BinaryNode<T> root) {
		if (root == null) 
			return;
		inorder(root.left);
		inorder(root.right);
		System.out.println(root.data);
	}
}
