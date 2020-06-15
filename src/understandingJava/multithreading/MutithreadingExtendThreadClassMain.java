package understandingJava.multithreading;

/*
 * Exploring anonymous class implementations of Runnable to instantiate Thread Object
 */


public class MutithreadingExtendThreadClassMain {

	public static void main(String[] args) {
		
		
		
		
		
		
		/*
		 * Type1 implementation of Runnable(functional interface) and passing it to Thread object
		 */
		// anonymous class of runnable
		Runnable runnable1 = new Runnable() {
			public void run() {
				System.out.println("Hello Multithreading World type1");
			}
			
		};
		
		Thread thread1 = new Thread(runnable1);
//		thread1.start();

		
		
		
		
		/*
		 * Type2 Implementation(using lambda function - with braces - can have multiple lines) of Runnable(functional interface) and passing it to Thread object
		 */		
		// anonymous class of runnable
		Runnable runnable2 = ()->{
			System.out.println("Hello Multithreading world type2");
			};
		Thread thread2 = new Thread(runnable2);
//		thread2.start();
		
		
		
		
		/*
		 * Type3 Implementation(using lambda - no braces - single statement) of Runnable(functional interface) and passing it to Thread object
		 */
		// anonymous class of runnable
		Runnable runnable3 = ()->System.out.println("Hello Multithreading world type3");
		Thread thread3 = new Thread(runnable3);
//		thread3.start();
		
		/*
		 * Type4 - Directly passing lambda implementation of runnable to thread object.(with braces - can have multiple lines)
		 */
		
		Thread thread4 = new Thread(()->{
			System.out.println("Hello Multithreading world type4");
			});
//		thread4.start();
		
		/*
		 * Type5 - Directly passing lambda implementation of runnable to thread object.(without braces - can have single statement)
		 */
		Thread thread5 = new Thread (()->System.out.println("Hello Multithreading world type5"));
//		thread5.start();
		
		
		
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		
		
		
		//waiting for threads to join
		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
			thread5.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("the threads have died");
//		thread5.sle
		
		
		
		
		
	}

}
