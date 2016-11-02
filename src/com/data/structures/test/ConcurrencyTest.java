package com.data.structures.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ConcurrencyTest {

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
	//	pool.

	}

}

class action extends RecursiveAction {

	@Override
	protected void compute() {
		// TODO Auto-generated method stub
	//	invokeAll(tasks)
	}
	
}

class action1 implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}

class action2 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
