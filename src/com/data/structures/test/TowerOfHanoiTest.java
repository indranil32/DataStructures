package com.data.structures.test;


public class TowerOfHanoiTest {

	public static void main(String[] args) {
		int disks = 3;
		move(disks,1,3,2);

	} 
	
	private static void move(int disks, int... tower) {
		if (disks >= 1) { 
			move(disks-1, tower[0], tower[2], tower[1]);
			System.out.println("Move top disk from tower - " + tower[0] +" to tower- " +tower[1]);
			move(disks-1, tower[2], tower[1], tower[0]);
		}
	}

}
