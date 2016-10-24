package com.data.structures.test;

public class ThreadTest {//implements Runnable {
	/*public static void main(String args[]) throws InterruptedException{
		Thread t = new Thread(new ThreadTest());
		t.start();
		System.out.println("before 20");
		//t.join();
		System.out.println("after 20");
	}

	@Override
	public void run() {
		try {
			System.out.println("sleeping for 20");
			Thread.sleep(20);
			System.out.println("slept for 20");
		} catch(InterruptedException i) {
			i.printStackTrace();
		}
	}

	public static void main(String args[]) throws InterruptedException{
			System.out.println("sync test");
			ThreadTest tt = new ThreadTest();
			Thread t = new  Thread(tt);
			t.start();
			System.out.println("sync test in progress");
			tt.test1();
			System.out.println("sync test done");
	}

	@Override
	public void run() {
		test1();
	}

	public synchronized void  test1() {
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("test1");
	}

	public void test2() {
		System.out.println("test2");
	}



	public static void main(String args[]) throws InterruptedException{
		Object lock1 = new Object();
    	Object lock2 = new Object();
		runnable1 r1 = new runnable1(lock1,lock2);
		runnable2 r2 = new runnable2(lock1,lock2);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		System.out.println("before starting threads");
		t1.start();
		System.out.println("thread 1 started");
		t2.start();
		System.out.println("thread 2 started");
	}*/

	private static boolean ok = true;

	public static void main(String args[]) throws InterruptedException{

		runnable3 r3 = new runnable3(ok);
		Thread t = new Thread(r3);
		System.out.println("ok 1 " + ok);
		t.start();
		runnable4 r4= new runnable4();
		Thread t2 = new Thread(r4);
		t2.start();
		ok = false;
		System.out.println("ok 4 " + ok);
	}


}
class runnable4 implements Runnable {
@Override
		public void run () {
			notifyAll();
		}
}
class runnable3 implements Runnable {

	private boolean ok;

	public runnable3(boolean ok) {
		this.ok = ok;
	}

	@Override
		public void run () {
			System.out.println("ok 2 " + ok);
			while(ok) {
				System.out.println("ok 3 " + ok);
			try {
					System.out.println("waiting");
				            wait();

	        } catch (Exception e) {e.printStackTrace();}
			System.out.println("done");
		}
	}
}

class runnable1 implements Runnable {

	private Object lock1;
    private Object lock2;

    public runnable1(Object lock1, Object lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}

	@Override
	public void run() {
		synchronized(lock1) {
		          try {
				  			Thread.sleep(10000);
				  		} catch (Exception e) {
				  			e.printStackTrace();
		}
        	synchronized(lock2) {
								           System.out.println("test1 complete");
        	}
        }
	}

}
class runnable2 implements Runnable {

	private Object lock1;
    private Object lock2;

	public runnable2(Object lock1,Object lock2) {
			this.lock1 = lock1;
			this.lock2 = lock2;
	}

	@Override
	public void run() {
		synchronized(lock2) {
				           try {
						   			Thread.sleep(10000);
						   		} catch (Exception e) {
						   			e.printStackTrace();
		}
        	synchronized(lock1) {
					           System.out.println("test2 complete");
        	}
        }
	}
}