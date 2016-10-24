package com.data.structures.test;


public class ArrayInsert {

	private static int[] array = new int[10];//{10,11,1,5,4,2,9};
	
	public static void main(String[] args) {
		array[0]=10;
		array[1]=11;
		array[2]=1;
		array[3]=5;
		array[4]=4;
		array[5]=2;
		array[6]=9;
		for (int i : array) {
			System.out.print(i +" , ");
		}
		
		int ele = 17;
		int pos = 3;
		int temp = 0;
		for (int i = pos-1; i < array.length ; i++ ) {
			temp = array[i];
			array[i] = ele;
			if (i+1 < array.length) {
				ele = array[i+1];
				array[i+1] = temp;
			}
		}
		System.out.println();
		for (int i : array) {
			System.out.print(i +" , ");
		}
	}

}
