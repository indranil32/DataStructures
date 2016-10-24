package com.data.structures.test;


public class ArraySearch {

	private static int[] array = {10,11,1,5,4,2,9};
	
	public static void main(String[] args) {
		int to_search = 1;
		// sequential search
		sequentialSearch(to_search, array);
		// binary search
		print(array);
		bubbleSort(array);
		print(array);
		binarySearch(to_search, array, 0 , array.length-1);
	}

	private static void binarySearch(int to_search, int[] array2, int lb, int ub) {
				if (lb > ub) {
					System.out.println("binarySearch - Not Found!");
					return;
				}
				int m = (lb + ub)/2;
				if (array2[m] == to_search) {
					System.out.println("binarySearch - Found "+to_search+" at positon- "+m);
					return;
				} else	if (array2[m] < to_search) {
					lb = m+1;
					binarySearch(to_search, array2, lb, ub);
				} else {
					ub = m-1;
					binarySearch(to_search, array2, lb, ub);
				}
	}

	private static void sequentialSearch(int to_search, int[] array1) {
		boolean found = false;
		// sequential search
		for (int i = 0 ; i < array1.length ; i ++) {
			if (to_search == array1[i]) {
				System.out.println("sequentialSearch - Found "+to_search+" at positon- "+(i+1));
				found = true;
				break;
			}
		}
		if (!found)
			System.out.println("sequentialSearch - Not found!");
	}

	private static void bubbleSort(int[] array3) {
		boolean swapped = true;
		while(swapped) {
			swapped = false;
			for (int j = 0 ; j <array3.length -1 ; j ++) {
				if (array3[j] > array3[j+1]) {
					int temp = array3[j+1];
					array3[j+1] = array3[j];
					array3[j] = temp;
					swapped = true;
				}
			}
		}
	}

	private static void print (int[] array4) {
		for (int i : array4) {
			System.out.print(i+",");
		}
		System.out.println();
	}
}
