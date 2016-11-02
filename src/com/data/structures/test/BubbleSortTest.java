package com.data.structures.test;

import com.data.structures.utils.Utilities;

public class BubbleSortTest {

	public static void main(String[] args) {
		int [] array = {9,8,7,6,5,4,3,2,1};//{1,2,3,4,5,6,7,8,9};
		Utilities.printIntArray(array);
		for (int i = 0 ; i < array.length; i++) {
			for (int j = i+1;j < array.length ; j++) {
				if (array[i] > array[j]) {
					int tmp = array[j];
					array[j] = array[i];
					array[i] = tmp;
				}
				Utilities.printIntArray(array);
			}
		}
	}

}
