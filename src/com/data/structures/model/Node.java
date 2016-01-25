package com.data.structures.model;

import java.util.List;

public class Node<T> {
	
	public T data;
	public List<Node<T>> nodes;
	
	public Node(T data) {
		this.data = data;
	}
}
