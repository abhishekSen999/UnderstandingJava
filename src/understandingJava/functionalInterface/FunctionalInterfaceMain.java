package understandingJava.functionalInterface;


/*
 * functional interface is an interface which has only one unimplemented (abstract)method, 
 * can have as any number of default functions 
 */

@FunctionalInterface
interface MyFunctionalInterface{
	int calculateSum(int x , int y);
	default void show() {
		System.out.println("hello i am the default method");
	}
}


// method 4 **
class TempClassToBypassStatic{
	int myCalculateSum(int x , int y)
	{
		return x+y;
	}
	
	static int myStaticCalculateSum(int x , int y)
	{
		return x+y;
	}
	
	void checkAssignmentOfStaticAndNonstaticMethodsToFunctionalInterface() {
////		 not possible as particular function not static hence can't be referenced by class
//		MyFunctionalInterface objectOfAnonymousClass = TempClassToBypassStatic::myCalculateSum;    

		
		
//	assigning non static method to functional interface using object reference
		MyFunctionalInterface objectOfAnonymousClassNonStaticMethodReferance = new TempClassToBypassStatic()::myCalculateSum;

//	assigning static method reference to functional interface using class reference
		MyFunctionalInterface objectOfAnonymousClassStaticMethodReferance = TempClassToBypassStatic::myStaticCalculateSum;
		
		
		System.out.println("Implementation using non static method referance: "+objectOfAnonymousClassNonStaticMethodReferance.calculateSum(13, 18));
		
		System.out.println("Implementation using static method referance: "+objectOfAnonymousClassStaticMethodReferance.calculateSum(14, 19));
		
		// testing default function in a functional interface
		objectOfAnonymousClassNonStaticMethodReferance.show();
	}
	
	
	
	
}






public class FunctionalInterfaceMain {
	
	
	static int myCalculateSum(int x , int y)
	{
		return x+y;
	}
	
	
	public static void main(String[] args) {
		
		/*
		 * functional interface can be implemented in 4 ways
		 * 1)The present class implementing the interface like normal interface and overriding the unimplemented method 
		 * 2)Using Anonymous Class
		 * 3)Using lambda expression to provide functionality to the unimplemented method
		 * 4)Assign a method reference to the interface 
		 */
		
//		2) Anonymous class. this created object of an anonymous class.
		MyFunctionalInterface objectOfAnonymousClass = new MyFunctionalInterface() {
			
			@Override
			public int calculateSum(int x, int y) {
				
				return x+y;
				
			}
		};
		
		System.out.println("impementation using anonymous class: "+ objectOfAnonymousClass.calculateSum(10, 15));

//		3) Lambda Expression - this is a short form for writing and creating anonymous class objects by directly 
//		providing implementation of unimplemented function
		
		MyFunctionalInterface objectOfAnonymousClassLambdaExpression1 = (int x , int y)->{
			return x+y;
		};
		
		MyFunctionalInterface objectOfAnonymousClassLambdaExpression2 = (int x , int y)-> x+y;
		
		System.out.println("implementation using Lambda Expression 1 : "+ objectOfAnonymousClassLambdaExpression1.calculateSum(11, 16));
		
		System.out.println("implementation using lambda expression 2 : "+ objectOfAnonymousClassLambdaExpression2.calculateSum(12, 17));
		
		
//		4) check in the above class for details**
		new TempClassToBypassStatic().checkAssignmentOfStaticAndNonstaticMethodsToFunctionalInterface();
		
		
		
		
	} 
	
}




