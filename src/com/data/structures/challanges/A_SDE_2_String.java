package com.data.structures.challanges;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;


public class A_SDE_2_String {

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
				//System.out.println(numberOfTestCases);
				String [] strArray = new String[numberOfTestCases];
				int count = 0;
				while(scan.hasNext()) {
						strArray[count] = scan.next();
						//System.out.println(strArray[count]);
						count++;
						if (count >= numberOfTestCases)
							break;
				}
				
				for (String str: strArray) {
					/*if (checkIfSame(str)) 
						System.out.println(1);
					else {*/
						String reverse=str;
						Set<String> set = new HashSet<String>(str.length());
						set.add(str);
						for (int i = 0  ; i < str.length()  ; i++) {
							//System.out.println(reverse.charAt(str.length() - 1) + reverse.substring(0, reverse.length()-1) +" <--> "+str);
							reverse = reverse.charAt(str.length() - 1)+reverse.substring(0, reverse.length()-1);
							set.add(reverse);
						}
						System.out.println(set.size());

					}
				//}
				
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

	/*private static boolean checkIfSame(String str) {
		char c = str.charAt(0);
		boolean same = true;
		for (int i = 1 ; i < str.length() ; i++){
			if (c != str.charAt(i))
				same = false;
		}
		return same;
	}*/

}
