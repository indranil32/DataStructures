package com.data.structures.test;

import com.data.structures.utils.Utilities;

public class SortingTest {

	public static void main(String[] args) {
		int [] array = {29, 20, 73, 34, 64 };//{1,8,2,3,5,4,6,7,9};//////{1,2,3,4,5,6,7,8,9};
		Utilities.printIntArray(array);
		//int [] copyArray = new int[array.length];
		//System.arraycopy(array, 0, copyArray, 0, array.length);
		//bubbleSort(copyArray);
		//System.arraycopy(array, 0, copyArray, 0, array.length);
		//selectionSort(copyArray);
		//insertionSort(array);
		mergeSort(array);
	}
	// compare between two elements and swap if necessary
	// largest element bubbles up
	public static void bubbleSort(int[] array) {
		int count = 0;
		for (int i = array.length-1 ; i >= 0; i--) {
			//for (int i = 0 ; i <   array.length; i++) {
			for (int j = 0;j < i ; j++) {
				//for (int j = 0;j < array.length-1 ; j++) {
				if (array[j] > array[j+1]) {
					int tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
					Utilities.printIntArray(array);
				}
				count++;
			}
		}
		System.out.println(count);
	}
	// move the minimum to the correct position
	public static void selectionSort(int[] array) {
		int count = 0;
		for (int i = 0 ; i < array.length; i++) {
			int smallest = i;
			for (int j = i+1;j < array.length ; j++) {
				if (array[smallest] > array[j]) 
					smallest = j;
				count++;
			}
			if (smallest != i) {
				int tmp = array[i];
				array[i] = array[smallest];
				array[smallest] = tmp;
				Utilities.printIntArray(array);
			}
		}
		System.out.println(count);
	}
	
	public static void insertionSort(int[] array) {
		int count = 0;
		for (int i = 1 ; i < array.length ; i ++) {
			int sortedIndex = i-1;
			if (array[sortedIndex] > array[i]) {
				int pos = -1;
				boolean inserted = false;
				for (int j = 0;j <= i; j++) { 
					count++;
					if (array[j] < array[i] && !inserted)
						continue;
					else {
						// move
						if (!inserted) {
							pos = array[j];
							array[j] = array[i];
							inserted = true;
						} else {
							int tmp = array[j];
							array[j] = pos;
							pos = tmp;
							//Utilities.printIntArray(array);
						}
					}
				}
				Utilities.printIntArray(array);
			}
		}
		System.out.println(count);
	}
	
	public static void mergeSort(int[] array) {
		int [] tmp = {array[0]};
		for (int i = 1 ; i < array.length;i++) {
			int[] a = {array[i]};
			tmp = merge(tmp,a);
		}
		Utilities.printIntArray(tmp);
	}
	
	/*private static void sort(int start, int end, int[] array, int[][] tmp) {
		if (array.length > 0){
			sort();
		}
	}*/
	
	private static int[] merge(int[] ar1, int[] ar2) {
		int  i = 0 , j =0; 
		int[] tmp = new int[(ar1.length > ar2.length) ? ar1.length : ar2.length];
		for ( ;(i < ar1.length && j < ar2.length); ) {
			if (ar1[i] > ar2[j]){
				tmp[(ar2.length-1)-j]=ar2[j];
				j++;
			} else {
				tmp[(ar1.length-1)-i]=ar1[i];
				i++;
			}
		}
		while(i < ar1.length) {
			tmp[(ar1.length-1)-i]=ar1[i];
			i++;
		}
		
		while(j < ar2.length) {
			tmp[(ar2.length-1)-j]=ar2[j];
			j++;
		}
		return tmp;
	}
	
	public static void bucketSort() {
		
	}
}
