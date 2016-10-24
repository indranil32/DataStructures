package com.data.structures.test;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class LuckyNumber {

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
				for (int i = 1; i <= numberOfTestCases; i++) {
					int number = scan.nextInt();
					int sum = 0;
					for (int j = 1 ; j <=number;j++ ){
						if (count(j)) {
							sum += j;
						}
					}
					System.out.println(sum);
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
	
	private static boolean count (int n)
    {
		int count = 0;
        while(n > 0 && count < 3)
        {
            n = n & (n-1);
            count++;
        }
        return count == 2 ? true : false;
    }
}
