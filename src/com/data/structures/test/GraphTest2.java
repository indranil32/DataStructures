package com.data.structures.test;

public class GraphTest2 {

	public static void main(String[] args) {
		int numberOfNodes = 5;
		/*int[][] adjancyMatrix = {
							  1 2 3 4 5
							1{0,1,0,1,0},
							2{0,0,1,0,1},
							3{0,0,0,0,0},
							4{0,0,0,0,0},
							5{0,0,1,0,0},
								};
		*/
		int[][] adjancyMatrix = {
				//	  1 2 3 4 5
				/*1*/{0,0,1,1,0},
				/*2*/{0,0,1,0,1},
				/*3*/{0,0,0,1,1},
				/*4*/{0,0,0,0,1},
				/*5*/{0,0,0,1,0},
					};

		int pathLen = 4;
		int[][] path = new int[numberOfNodes][numberOfNodes];
		int[][] newProd = new int[numberOfNodes][numberOfNodes];
		int[][] adjcProd = new int[numberOfNodes][numberOfNodes];
		for (int i = 0 ; i < numberOfNodes ; i++) {
			for (int j = 0; j < numberOfNodes ; j++) {
				adjcProd[i][j] = adjancyMatrix[i][j];
				//path[i][j] = adjancyMatrix[i][j];//prodMatrix[i][j] =
				//newProd[i][j] = 0;
			}
		}
		for (int i = 1 ; i < pathLen ; i++) {
			prod(adjcProd, adjancyMatrix, newProd,numberOfNodes);

			for (int k = 0 ; k < numberOfNodes ; k++) {
				for (int j = 0; j < numberOfNodes ; j++) {
					adjcProd[k][j] = newProd[k][j];
					newProd[k][j] = 0;
				}
			}
		}	
		for (int i = 0 ; i < numberOfNodes ; i++) {
			for (int j = 0; j < numberOfNodes ; j++) {
				System.out.print(adjcProd[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	private static void prod(int[][] adjcProd, int[][] adjancyMatrix, int[][] newProd, int length) {
		for (int i = 0 ; i < length ; i++) { // rows
			for (int j = 0 ; j < length; j++) { // columns
				int sum = 0;
				for (int k = 0 ; k < length ; k++) { // column|row
					sum = (sum |  (adjcProd[i][k] & adjancyMatrix[k][j]));
				}
				newProd[i][j] = sum;
			}
		}
	}

}
