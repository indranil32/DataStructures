package com.data.structures.test;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class CastleGate {

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
				for (int i = 0; i < numberOfTestCases; i++) {
					int number = scan.nextInt();
					int count = 0;
					for (int j = 1 ; j <= number ; j++) {
						for (int k = j+1 ; k <= number ; k++) {
							int xor = (j^k);
							//System.out.println(xor);
							if (xor <= number)
								count++;
						}
					}
					System.out.println(count);
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
