package com.data.structures.test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.TreeMap;
import java.util.Vector;
import java.util.stream.Collectors;
//import java.util.concurrent.atomic.

public class AdvancedJavaDS {

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		for (int i = 0 ; i < 10000; i++)
			ll.add(i);
		Spliterator<Integer> s = ll.spliterator();
		System.out.println(s.characteristics());
		System.out.println(s.estimateSize());
		Spliterator<Integer> s1 = s.trySplit();
		System.out.println(s1.characteristics());
		System.out.println(s1.estimateSize());
		
		ll.stream().filter((m) -> m < 10).collect(Collectors.toList()).forEach((n)->System.out.println(n));;
		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
		Vector<Integer> v = new Vector<Integer>();
		int i = 13;
		int j = i + (i>>1);
		System.out.println(j);
		//Collections.
		Vector<Integer> vec = new Vector<Integer>();
		ListIterator<Integer> li = ll.listIterator();
		//li.
	}

}


class test1 implements Comparable<Integer> {

	@Override
	public int compareTo(Integer o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

class test2 implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
