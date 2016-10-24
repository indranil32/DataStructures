package com.data.structures.test;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class CountBits {

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
					while (scan.hasNextInt()) {
						int digit = scan.nextInt();
						int sum = count(digit, 0);
						System.out.println(sum);
						break;
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

	}

	private static int count(int digit, int sum) {
		if (digit>0) {
			sum += count(digit/2, digit%2);
		}
		return sum;
	}

}
