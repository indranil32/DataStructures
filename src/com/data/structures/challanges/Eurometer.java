package com.data.structures.challanges;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Eurometer {

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
				
				// xy
				int [][] xy = new int[numberOfTestCases][2];
				for (int i = 1; i <= numberOfTestCases; i++) {
					int noOfElements = 0;
					while (scan.hasNextInt()) {
						int co = scan.nextInt();
						xy[i][noOfElements] = co;
						noOfElements++;
						if (noOfElements > 1)
							break;
					}
				}
				
				// matrix NxN
				int [][] matrix = new int[numberOfTestCases][numberOfTestCases];
				int noOfElements = (2*numberOfTestCases); 
				for (int i = 0; i < numberOfTestCases; i++) {
					for (int j = 0; j < numberOfTestCases; j++) {
						while (scan.hasNextInt()) {
							int co = scan.nextInt();
							matrix[i][i] = co;
							noOfElements--;
							if (noOfElements <= 0)
								break;
						} 
					}
				}

				int maxRoads = 0;
				
				while (maxRoads < (numberOfTestCases-1)) {
					
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
	
	private static boolean possibleToTravel(int[][] matrix, int i, int j) {
		try {
			if (matrix[i][j] == 1)
				return true;
			else
				return false;
		} catch(ArrayIndexOutOfBoundsException a) {
			a.printStackTrace();
			return false;
		}
	}
	
	private static int length(int xi, int xj, int yi, int yj) {
		return (((xi -xj)*(xi -xj)) + ((yi -yj)*(yi -yj)));
	}

}
