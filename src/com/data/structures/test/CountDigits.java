package com.data.structures.test;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CountDigits {

	private static Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
	static {
		countMap.put(0, 0);
		countMap.put(1, 0);
		countMap.put(2, 0);
		countMap.put(3, 0);
		countMap.put(4, 0);
		countMap.put(5, 0);
		countMap.put(6, 0);
		countMap.put(7, 0);
		countMap.put(8, 0);
		countMap.put(9, 0);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (true) {
			try {
				// number of test cases
				String str = scan.next();
				if (str == null || str.isEmpty()) {
					System.out.println("Invalid string!");
					System.out.println("Please try typing the input again....");
					continue;
				}
				for (String s : str.split("")){
					try {
						int tmp = Integer.parseInt(s);
						int count = countMap.get(tmp);
						countMap.put(tmp, (count+1));
					} catch (NumberFormatException e) {
						//System.out.println(e.getMessage());
					}
				}
				for (int key : countMap.keySet())
					System.out.println(key+" "+countMap.get(key));
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
