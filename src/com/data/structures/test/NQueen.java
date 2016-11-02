package com.data.structures.test;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class NQueen {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (true) {
			try {
				// number of test cases
				int N = scan.nextInt();
				if (N < 1) {
					System.out.println("Invalid number of test cases!");
					System.out.println("Please try typing the input again....");
					continue;
				}
				int[][] board = new int[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0 ; j < N ; j++) // all un-attacked
						board[i][j] = 0;
				}
				// place all queens
				int numberOfUnattackedCells = (board.length * board.length);
				for (int i =0 ; i < N ; i++)
					findCell(N, 0, 0, board, numberOfUnattackedCells);
				print(board);
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

	private static void findCell(int queen, int x, int y, int[][] board,int numberOfUnattackedCells) {
		if (numberOfUnattackedCells < 1 && queen > 0) {
			System.out.println("Not possible");
			return;
		} else if (board[x][y] == 0){
			board[x][y] = queen;
			queen--;
			// horizontally and vertically
			for (int i = 0 ; i < board.length; i++ ) {
					if (i!=y){board[x][i] = 1;numberOfUnattackedCells--;}
					if (i!=x){board[i][y] = 1;numberOfUnattackedCells--;}
				// diagonally
				for (int j = 0 ; j < board.length; j++ ) {
					if ((i != x && j != y) && (Math.abs(x-i) == Math.abs(y-j)) && (board[i][j] == 0))//{
						board[i][j] = 1;numberOfUnattackedCells--;
				}
			}
			//print(board);
		} else {
			for (int m = 0 ; m < board.length ; m++) {
				for (int n = 0 ; n < board.length ; n++) {
					if (board[m][n] == 0) 
						findCell(queen, m, n, board, numberOfUnattackedCells);
				}
			}
		}
	}

	private static void print(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0 ; j < board.length ; j++)
				System.out.print((board[i][j] == 9 ? "1" : "0"));
			System.out.println();
			//System.out.println("=============================");
		}
		//System.out.println();
		//System.out.println();
	}
	
	/*private static int isAttacked(int x, int y , int[][] board) {
		int numberOfAttackedCells = 0;
		// horizontally and vertically
		for (int i = 0 ; i < board.length; i++ ) {
			if (board[x][i] > 0)
				numberOfAttackedCells++;
			if(board[i][y] > 0)
				numberOfAttackedCells++;
			// diagonally
			for (int j = 0 ; j < board.length; j++ ) {
				if ((i < x && j < y) && (x-i == y-j) && (board[i][j] > 0)){
						numberOfAttackedCells++;
				} else if ((i > x && j > y) && (x+i == y+j) && (board[i][j] > 0)) {
						numberOfAttackedCells++;
				}
			}
		}
		return numberOfAttackedCells;
	}*/

}
