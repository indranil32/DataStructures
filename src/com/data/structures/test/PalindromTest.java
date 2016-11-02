package com.data.structures.test;

import java.util.HashMap;
import java.util.Map;

public class PalindromTest {

	public static void main(String[] args) {
		String str = "forgeeksskeegfor";
		String[] array = str.split("");
		int largest = 0; 
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (int  i = 0 ; i < str.length() ; i ++) {
			int check = str.indexOf(array[i], i+1);
			while (check > i) {
				String pal = checkPalindrome(str.substring(i, (check + 1)));
				if (pal != null && pal.length() > largest) {
					largest = pal.length();
					map.put(largest, pal);
				}
				check = str.indexOf(array[i], check+1);
			}
		}
		System.out.println(map.get(largest));
	}

	private static String checkPalindrome(String substring) {
		String reverse = "";
		String [] array = substring.split("");
		for (int  i = substring.length() -1 ; i >= 0  ; i --) {
			reverse += array[i];
		}
		if (reverse.equals(substring)) 
			return substring;
		else
			return null;
	}

}
