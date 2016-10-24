package com.data.structures.test;


public class FactorialTest {

	public static void main(String[] args) {
		long fac_num = 7;
		System.out.println(fact(fac_num));

	}

	private static long fact(long i) {
		if (i <= 1)
			return 1;
		else return i*fact(i-1);
	}

}
