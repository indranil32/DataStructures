package com.data.structures.test;


public class MatrixMultiplication {

	public static void main(String[] args) {
		//int first[][] = {{1,2,3},{1,2,3},{1,2,3}};
		int[][] first = {
				//	  1 2 3 4 5
				/*1*/{0,0,1,1,0},
				/*2*/{0,0,1,0,1},
				/*3*/{0,0,0,1,1},
				/*4*/{0,0,0,0,1},
				/*5*/{0,0,0,1,0},
					};
		int[][] second = {
				//	  1 2 3 4 5
				/*1*/{0,0,1,1,0},
				/*2*/{0,0,1,0,1},
				/*3*/{0,0,0,1,1},
				/*4*/{0,0,0,0,1},
				/*5*/{0,0,0,1,0},
					};
		//int second[][] = {{1,2},{1,2},{1,2}}; 
		int mulitply[][] = new int [5][5];
		//Scanner scan = new Scanner(System.in);
		int firstNumOfRow = 5;//scan.nextInt();
		int firstNumOfColumn = 5;//scan.nextInt();
		int secondNumOfRow = 5;//scan.nextInt();
		int secondNumOfColumn = 5;//scan.nextInt();
		if (firstNumOfColumn != secondNumOfRow) {
			System.out.println("Not possible!");
		} else {
			for (int i = 0; i < firstNumOfRow ; i++) {
				
				for (int j = 0; j < secondNumOfColumn ; j++) {
					int sum = 0;
					for (int k = 0 ; k < secondNumOfRow ; k++) {
						sum +=first[i][k]*second[k][j];
					}
					mulitply[i][j] = sum;
				}
			}
			for (int i =0 ; i < firstNumOfRow ; i++) {
				for (int j = 0 ; j < secondNumOfColumn ; j ++) {
					System.out.print(mulitply[i][j]);
					System.out.print(" ");
				}
				System.out.println();
			}
		}

	}

}
