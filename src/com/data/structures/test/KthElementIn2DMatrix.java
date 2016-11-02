package com.data.structures.test;

public class KthElementIn2DMatrix {

	public static void main(String[] args) {
		int[][] array = {{16,28,60,64},{22,41,63,91},{27,50,87,93},{36,78,87,94}};
		int pos = 3;
		int smallest = array[0][pos-1];
		System.out.println(smallest);
		for (int i = 1 ; i < 4; i++) {
			if (smallest > array[i][0]) {
				smallest = array[i][0];
				for (int j = 0 ; j < 4 ; j++) {
					if (smallest > array[i][j]) {
						smallest = array[i][0]; 
					}
				}
			}
		}
		System.out.println(smallest);
	}

}
