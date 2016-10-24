package com.data.structures.utils;

import java.util.Scanner;

public class Utilities {
	
	Scanner scan ;
	
	private Utilities () {
		scan = new Scanner(System.in);
	}
	
	private static final Utilities _INSTANCE = new Utilities();
	
	public static Utilities _getInstance() {
		return _INSTANCE;
	}
	
	public int readNumberOfTestCases() {
		int numberOfTestCases = 0;
		while(true) {
			numberOfTestCases = scan.nextInt();
			if (numberOfTestCases < 1) {
				System.out.println("Invalid number of test cases!");
				System.out.println("Please try typing the input again....");
				continue;
			}
			break;
		}
		return numberOfTestCases;
	}
	
	/*public String[] readStringArray (int numberOfTestCases) {
		
		for (int i = 0; i < numberOfTestCases ; i++) {
			
		}
	}
	
	public int[] readIntegerArray (int numberOfTestCases) {
		for (int i = 0; i < numberOfTestCases ; i++) {
			
		}
	}*/
	
	public void closeScanner() {
		if (scan != null)
			scan.close();
	}
	
}
