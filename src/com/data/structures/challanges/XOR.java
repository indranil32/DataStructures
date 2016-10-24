package com.data.structures.challanges;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class XOR {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (true) {
			try {
				// number of test cases
				int numberOfTestCases = scan.nextInt();
				if (numberOfTestCases < 1) {
					System.out.println("Invalid number of test cases!");
					System.out.println("Please try typing the input again....");
					continue;
				}
				int arraySize = 0;
				int subArraySize = 0;
				int [] array;
				for (int i = 1; i <= numberOfTestCases; i++) {
					int count = 1;
					// reading the values
					while (scan.hasNextInt()) {
						int tmp = scan.nextInt();
						if (count == 1){
							arraySize =  tmp;
							array = new int[arraySize];
						} else if (count == 2) {
							subArraySize = tmp;
						} else {
							
						}
						count++;
						if (count > (arraySize + 2)) break;
					}
					
				}
				
				
				for (int i = 0 ; i < arraySize; i ++) {
					//int [] sub = new int
					for (int j = 0 ; j < subArraySize ; j++) {
						
					}
				}

				break;
			} catch (NoSuchElementException | IllegalStateException e) {
				// e.printStackTrace();
				System.out.println("ERROR - " + e.getMessage());
				System.out.println("Please try typing the input again....");
			}
		}
		scan.close();
		System.exit(0);

	}

}
