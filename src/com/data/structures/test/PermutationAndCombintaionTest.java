package com.data.structures.test;


/* 		  n!
 * pnr = ---
 * 		(n-r)!
 * 		 pnr     n!
 * cnr = --- = ------
 *        r!   r!(n-r)!
 */

public class PermutationAndCombintaionTest {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int r =4;
		// 5p3
		perm(a, r, 0);
		System.out.println();
		// 5c3
		comb(a, r, 1, 1);
	}

	public static void perm(int[] a, int r, int start) {
		if (start == r) {
			for (int i = 0; i < r; i++)
				System.out.print(a[i] + " ");
			System.out.println();
		} else {
			for (int i = start; i < a.length; i++) {
				if (start != i)swap(a, start, i);
				perm(a, r, start + 1);
				if (start != i)swap(a, start, i); // swap back
			}
		}
	}

	public static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	private static void comb(int a[], int r, int start, int k ) {
		if (k > r) {
			/* insert code here to use combinations as you please */
			for (int i = 1; i <= r; i++)
				System.out.print(a[i] + " ");
			System.out.println();
		} else {
			for (int i = start; i <= a.length; i++) {
				a[k] = i;
				 // recursively generate combinations of integers from i+1..n
				comb(a, r, i + 1,k + 1);
			}
		}
	}

}