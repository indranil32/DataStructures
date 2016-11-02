package com.data.structures.test;

import java.util.LinkedList;

public class MergeLL {

	/*public static void main(String[] args) {
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
				for (int i = 1; i <= numberOfTestCases; i++) {
					int numberOfLL = 0;
					int noOfElements = 0;
					List<Integer> ll = new LinkedList<Integer>();
					Set<Integer> set = new TreeSet<Integer>();
					// reading the values
					while (scan.hasNextInt()) {
						numberOfLL = scan.nextInt();
						break;
					}
					while (scan.hasNextInt()) {
						noOfElements = scan.nextInt();
						for (int j = 0 ; j < noOfElements ; j++)
							set.add(scan.nextInt());
							//ll.add(scan.nextInt());
						numberOfLL--;
						if (numberOfLL < 1)break;
					}
					for (Integer intg : set) {
						System.out.print(intg+" ");
					}
				}

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
*/
	
	public static void main(String args[]) {
		LinkedList<Integer> ll1 = new LinkedList<Integer>();
		ll1.add(1);
		ll1.add(3);
		ll1.add(5);
		ll1.add(7);
		LinkedList<Integer> ll2 = new LinkedList<Integer>();
		ll2.add(2);
		ll2.add(4);
		ll2.add(6);
		ll2.add(10);
		LinkedList<Integer> ll3 = new LinkedList<Integer>();
		ll3.add(8);
		ll3.add(11);
		ll3.add(12);
		ll3.add(13);
		ll3.add(14);
		ll3.add(15);
		LinkedList<Integer> ll4 = new LinkedList<Integer>();
		ll4.add(9);
		ll4.add(16);
		LinkedList<Integer> llTmp = merge(ll1,ll2);
		llTmp = merge(llTmp, ll3);
		llTmp = merge(llTmp, ll4);
		llTmp.forEach((i) -> System.out.println(i));
	}

	private static LinkedList<Integer> merge(LinkedList<Integer> ll1,
			LinkedList<Integer> ll2) {
		LinkedList<Integer> llTmp = new LinkedList<Integer>();
		int  i = 0 , j =0; 
		for ( ;(i < ll1.size() && j < ll2.size()); ) {
			if (ll1.get(i) > ll2.get(j)){
				llTmp.addLast(ll2.get(j));
				j++;
			} else {
				llTmp.addLast(ll1.get(i));
				i++;
			}
		}
		while(i < ll1.size()) {
			llTmp.addLast(ll1.get(i));
			i++;
		}
		
		while(j < ll2.size()) {
			llTmp.addLast(ll2.get(j));
			j++;
		}
		
		/*Iterator<Integer> itr1 = ll1.iterator();
		Iterator<Integer> itr2 = ll2.iterator();
		while(itr1.hasNext() && itr2.hasNext()) {
			int int1 = itr1.next();
			int int2 = itr2.next();
			if (int1 > int2) {
				llTmp.addLast(int2);
			} else {
				llTmp.addLast(int1);
			}
		}*/
		
		/*while(itr1.hasNext()) {
			int tmp = itr1.next();
			llTmp.addLast(tmp);
			ll1.remove(tmp);
		}
		
		while(itr2.hasNext()) {
			int tmp = itr2.next();
			llTmp.addLast(tmp);
			ll2.remove(tmp);
		}*/
		return llTmp;
	}
	
	
}
