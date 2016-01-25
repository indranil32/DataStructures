package com.data.structures.test;

import java.util.Comparator;

import com.data.structures.exception.InvalidOperationException;
import com.data.structures.stack.Stack;
import com.data.structures.traverse.BinaryTraverse;
import com.data.structures.tree.BinaryTree;

public class DataStructureTest {

	public static void main(String[] args) {
		testStack();
		testBinaryTree();
	}

	public static void testStack() {
		Stack<Integer> stack = new Stack<Integer>(10);
		try {
				for (int i = 0 ; i < 10 ; i ++)
					stack.push(i);
				for (int i = 0 ; i < 10 ; i ++)
					System.out.println(stack.pop());
				
				for (int i = 0 ; i < 20 ; i ++)
					stack.push(i);
				for (int i = 0 ; i < 9 ; i ++)
					System.out.println(stack.pop());
				
		} catch (InvalidOperationException e) {
			e.printStackTrace();
		}
	}
	
	public static void testBinaryTree() {
		Comparator<Integer> comparator =  new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 < o2)
					return -1;
				else if (o1 == o2)
					return 0;
				else //if (o1 > o2)
					return 1;
			}
		};
		BinaryTree<Integer> bt = new BinaryTree<>(comparator);
		bt.insert(10);
		bt.insert(20);
		bt.insert(30);
		BinaryTraverse<Integer> t = new BinaryTraverse<Integer>();
		t.inorder(bt.getRoot());
		t.preorder(bt.getRoot());
		t.postorder(bt.getRoot());
	}
}
