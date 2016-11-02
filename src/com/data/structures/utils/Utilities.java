package com.data.structures.utils;

import java.util.Scanner;

public final class Utilities {
	
	private Scanner scan ;
	
	private synchronized Scanner getScanner() {
		if (scan == null)
			scan = new Scanner(System.in);
		return scan;
	}
	
	public int readNumberOfTestCases() {
		int numberOfTestCases = 0;
		while(true) {
			numberOfTestCases = getScanner().nextInt();
			if (numberOfTestCases < 1) {
				System.out.println("Invalid number of test cases!");
				System.out.println("Please try typing the input again....");
				continue;
			}
			break;
		}
		return numberOfTestCases;
	}
	
	public void closeScanner() {
		if (scan != null)
			scan.close();
	}
	
	public static void printIntArray(int[] array) {
		for (int i = 0 ; i < array.length ; i++) {
			System.out.print(array[i]);
			System.out.print(" ");
		}
		System.out.println();
	}
	
	public static void printStrArray(String[] array) {
		for (int i = 0 ; i < array.length ; i++) {
			System.out.print(array[i]);
			System.out.print(" ");
		}
		System.out.println();
	}
	
	public static void printInt2DArray(int[][] array) {
		for (int i = 0 ; i < array.length ; i++) {
			for (int j = 0 ; j < array.length ; j++) {
				System.out.print(array[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
