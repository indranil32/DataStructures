package com.data.structures.stack;

import com.data.structures.exception.InvalidOperationException;

public class Stack<T> {

	private int size = 0;
	private Object[] array = null;
	private int top = -1;
	
	public Stack (int size) {
		this.size = size;
		array = new Object[this.size];
		top = -1;
	}
	
	public void push(T data) throws InvalidOperationException {
		if (isFull())
			throw new InvalidOperationException("Stack is full!!");
		top++;
		array[top] = data;
	}
	
	public T pop() throws InvalidOperationException {
		if (isEmpty())
			throw new InvalidOperationException("Stack is empty!!");
		T popItem = (T)array[top];
		array[top] = null;
		top--;
		return popItem;
	}
	
	public boolean isEmpty() {
		return (array == null || array.length == 0 || top == 0) ? true : false;
	}
	
	public boolean isFull() {
		return (array != null && top == size) ? true : false;
	}
}
