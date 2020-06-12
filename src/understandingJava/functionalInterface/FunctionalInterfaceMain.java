package understandingJava.functionalInterface;


/*
 * functional interface is an interface which has only one unimplemented (abstract)method, 
 * can have as any number of default functions 
 */

@FunctionalInterface
interface MyFunctionalInterface{
	int calculateSum(int x , int y);
}



public class FunctionalInterfaceMain {
	
	public static void main(String[] args) {
		
		/*
		 * functional interface can be implemented in 3 ways
		 * 1)The present class implementing the interface like normal interface and overriding the unimplemented method 
		 * 2)Using Anonymous Class
		 * 3)Using lambda expression to provide functionality to the unimplemented method
		 */
		
//		2) Anonymous class. this created object of an anonymous class.
		MyFunctionalInterface objectOfAnonymousClass = new MyFunctionalInterface() {
			
			@Override
			public int calculateSum(int x, int y) {
				
				return x+y;
				
			}
		};
		
		System.out.println("impementation using anonymous class: "+ objectOfAnonymousClass.calculateSum(10, 15));

//		3) Lambda Expression - this is a short form for writing and creating anonymous class objects
		
		MyFunctionalInterface objectOfAnonymousClassLambdaExpression1 = (int x , int y)->{
			return x+y;
		};
		
		MyFunctionalInterface objectOfAnonymousClassLambdaExpression2 = (int x , int y)-> x+y;
		
		System.out.println("implementation using Lambda Expression 1 : "+ objectOfAnonymousClassLambdaExpression1.calculateSum(11, 16));
		
		System.out.println("implementation using lambda expression 2 : "+ objectOfAnonymousClassLambdaExpression2.calculateSum(12, 17));
		
		
		
		
		
	} 
	
}
