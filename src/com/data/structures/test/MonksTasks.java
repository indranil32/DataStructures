package com.data.structures.test;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MonksTasks {

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
					int[] array = {};
					int numberOfDays = 0;
					int count = 0;
					// reading the values
					while (scan.hasNextInt()) {
						if (count == 0) {
							numberOfDays = scan.nextInt();
							array = new int[numberOfDays];
						} else {
							array[count-1] = scan.nextInt();
						}
						count++;
						if (count > numberOfDays)
							break;
					}
					
					int [] arrayCopy = new int[array.length];
					System.arraycopy(array, 0, arrayCopy, 0, array.length);

					for (int j = 0 ; j < arrayCopy.length ; j++) {
						int smallest = count(arrayCopy[j]);
						for (int k = j+1; k < arrayCopy.length ; k++) {
							int check = count(arrayCopy[k]);
							if (smallest > check) {
								smallest = check;
								int tmp = arrayCopy[k];
								arrayCopy[k] = arrayCopy[j];
								arrayCopy[j] = tmp;
							} else if (smallest == check) {
								if (pos(arrayCopy[j], array) > pos(arrayCopy[k], array)) {
									int tmp = arrayCopy[k];
									arrayCopy[k] = arrayCopy[j];
									arrayCopy[j] = tmp;
								}
							}
						}
					}
					for (int m = 0 ; m <arrayCopy.length ; m++) {
						System.out.print(arrayCopy[m]);
						System.out.print(" ");
					}
					System.out.println();
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

	/*private static int count(int digit, int sum) {
		if (digit>0) {
			sum += count(digit/2, digit%2);
		}
		return sum;
	}*/
	
	private static int pos(int i, int[] array) {
		int foundAt = 0;
		for (int j = 0 ; j < array.length ; j++ ) {
			if (i==array[j]) {
				foundAt = j;
				break;
			}
		}
		return foundAt;
	}
	
	private static int count (int n)
    {
		int count = 0;
        while(n > 0)
        {
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
