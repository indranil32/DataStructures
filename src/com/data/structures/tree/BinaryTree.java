package com.data.structures.tree;

import java.util.Comparator;

import com.data.structures.model.BinaryNode;

public class BinaryTree<T> extends Tree<T>{

	private BinaryNode<T> root;
	private Comparator<T> comparator;
	
	public BinaryTree (Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
	@Override
	public BinaryNode<T> getRoot() {
		return this.root;
	}
	
	public void insert(T data) {
		BinaryNode<T> node = new BinaryNode<T>(data);
		if (root == null) {
			root = node;
		} else {
			if (node.left != null) {
			} else { //node.right !=null
				
			}
			
		}
	}
}
