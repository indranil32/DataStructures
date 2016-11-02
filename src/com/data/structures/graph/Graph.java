package com.data.structures.graph;

import com.data.structures.model.Node;
import com.data.structures.model.NodeAdjacencyMatrix;

public class Graph<T> {
	
	private Node<T> root;
	private NodeAdjacencyMatrix matrix;
	
	public Graph(Node<T> root, NodeAdjacencyMatrix matrix) {
		this.root = root;
		this.matrix = matrix;
	}
	
	public Node<T> getRoot() {
		return root;
	}
}
