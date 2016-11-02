package com.data.structures.test;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class GraphTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (true) {
			try {
				// number of test cases
				int numberOfCities = 0;/*scan.nextInt();
				if (numberOfCities < 1) {
					System.out.println("Invalid number of cities!");
					System.out.println("Please try typing the input again....");
					continue;
				}*/
				int cityA = 0;
				int cityB = 0;
				int steps = 0;
				int noOfElements = 4;// + numberOfCities;
				// reading the values
				while (scan.hasNextInt()) {
					if (noOfElements == 4) numberOfCities = scan.nextInt();
					else if (noOfElements == 3) cityA = scan.nextInt();
					else if (noOfElements == 2) cityB = scan.nextInt();
					else if (noOfElements == 1) steps = scan.nextInt();
					noOfElements--;
					if (noOfElements < 1)
						break;
				}
				int[][] array = new int[numberOfCities][2];
				while(scan.hasNextInt()) {
					for (int i = 0 ; i < numberOfCities ; i ++) {
						for (int j = 0 ; j < 2 ;j++)
							array[i][j] = scan.nextInt();
					}
					break;
				}
				System.out.println(findPath(steps, cityA, cityB, array, numberOfCities));
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

	private static boolean findPath(int steps, int cityA, int cityB,int[][] array, int numberOfCities) {
		if (steps == 1) 
			return adjacent(cityA, cityB, array);
		else {
			for (int i = 1 ; i <= numberOfCities;i++) {
				if ((i != cityA) && findPath(steps-1, cityA, i ,array, numberOfCities)) {
					return true;
				}
			}
			return false;
		}
		
	}

	private static boolean adjacent(int cityA, int cityB, int[][] array) {
		for (int  i = 0; i < array.length ; i ++) {
			if (array[i][0] == cityA && array[i][1] == cityB)
				return true;
		}
		return false;
	}

}
