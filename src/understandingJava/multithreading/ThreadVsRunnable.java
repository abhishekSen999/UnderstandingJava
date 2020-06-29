package understandingJava.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class ImplementsRunnable implements Runnable {

	private int counter = 0;
	List<Integer> list;

	public ImplementsRunnable(List<Integer> list) {
		this.list = list;
	}

	public void run() {
		counter++;
		list.add(1);
		System.out.println("ImplementsRunnable : Counter : " + counter+ " , Id: "+Thread.currentThread().getId()+" shared list: "+list);
	}
}

class ExtendsThread extends Thread {

	private int counter = 0;

	public void run() {
		counter++;
		
		
		System.out.println("ExtendsThread : Counter : " + counter + " , Id: "+this.getId());
	}
}

public class ThreadVsRunnable {

	public static void main(String args[]) throws Exception {
//Multiple threads share the same object.
		List<Integer> list= new ArrayList<Integer>();
		ImplementsRunnable rc = new ImplementsRunnable(list);
		Thread t1 = new Thread(rc);
		t1.start();
		Thread.sleep(1000); // Waiting for 1 second before starting next thread
		Thread t2 = new Thread(rc);
		t2.start();
		Thread.sleep(1000); // Waiting for 1 second before starting next thread
		Thread t3 = new Thread(rc);
		t3.start();

//Creating new instance for every thread access.
		ExtendsThread tc1 = new ExtendsThread();
		tc1.start();
		Thread.sleep(1000); // Waiting for 1 second before starting next thread
		ExtendsThread tc2 = new ExtendsThread();
		tc2.start();
		Thread.sleep(1000); // Waiting for 1 second before starting next thread
		ExtendsThread tc3 = new ExtendsThread();
		tc3.start();
		
		
	}
}