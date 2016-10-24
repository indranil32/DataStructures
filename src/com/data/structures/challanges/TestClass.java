package com.data.structures.challanges;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author indranilm
 *
 */
public class TestClass {

	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
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
				int [] inputArray = new int[numberOfTestCases];
				int counter = 0;
				// reading the values
				while (scan.hasNextInt()) {
					inputArray[counter] = scan.nextInt();
					counter++;
					if (counter == numberOfTestCases)
						break;
				}
				//System.out.println("Read - "+inputArray.length+ " elements");
				counter = 0;
				int testCaseValue = inputArray[counter];
				for ( int i = 1; i <= testCaseValue; i++ ) {
					boolean mod3 = i % 3 == 0 ;
					boolean mod5 = i % 5 == 0;
					if (mod3 && mod5)
						System.out.println("FizzBuzz");
					else if (mod3)
						System.out.println("Fizz");
					else if (mod5)
						System.out.println("Buzz");
					else
						System.out.println(i);
					if (i == testCaseValue && counter < (numberOfTestCases-1)) {
						testCaseValue = inputArray[++counter];
						i = 0;
					}
				}
				
				break;
			} catch (NoSuchElementException | IllegalStateException e) {
				//e.printStackTrace();
				System.out.println("ERROR - " + e.getMessage());
				System.out.println("Please try typing the input again....");
			}
		}
		scan.close();
		System.exit(0);
	}*/
	
	
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
				for (int i = 1; i <=numberOfTestCases; i++ ) {
					int sum = 0;
					int noOfElements = 2;
					// reading the values
					while (scan.hasNextInt()) {
						sum += scan.nextInt();
						noOfElements--;
						if (noOfElements <= 0)
							break;
					}
					System.out.println(sum);
				}
				
				break;
			} catch (NoSuchElementException | IllegalStateException e) {
				//e.printStackTrace();
				System.out.println("ERROR - " + e.getMessage());
				System.out.println("Please try typing the input again....");
			}
		}
		scan.close();
		System.exit(0);
	}

}
