package understandingJava.multithreading;

import java.util.Arrays;

public class MultithreadingDemoMainUsingLambda {

	private static int [] numbers = {0,1,2,3,4,5,6,7,8,9};
	private static int sumOfFirstHalf = 0;
	private static int sumOfSecondHalf = 0;
	
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int[] firstHalf = Arrays.copyOfRange(numbers, 0 , 5);
		int[] secondHalf = Arrays.copyOfRange(numbers, 5 , 10);
		
		
		// Thread to sum first half
		Thread t1 = new Thread(()->{
			for( int num : firstHalf ) {
				System.out.println("Thread 1 is adding: "+ num);
				sumOfFirstHalf += num;
			}
			System.out.println("thread 1 captured Sum: "+ sumOfFirstHalf);
		});
		
		
		Thread t2 = new Thread(()->{
			for( int num : secondHalf ) {
				System.out.println("Thread 2 is adding: "+ num);
				sumOfSecondHalf += num;
			}
			System.out.println("thread 2 captured Sum: "+ sumOfSecondHalf);
		});
		
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Sum is: "+ (sumOfFirstHalf+sumOfSecondHalf));
		
		
		
		
	}

}
