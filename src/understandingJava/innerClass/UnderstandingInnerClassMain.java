package understandingJava.innerClass;

import java.io.IOException;

class UnderstandingInnerClass {
	private int privateInstanceVariable;
	int defaultInstancevariable; // accessible within package
	protected int protectedInstanceVariable;// accessible to only subclasses
	public int publicInstanceVariable;// well you know it
	
	
	
	
	
	public UnderstandingInnerClass() {
		privateInstanceVariable = 0;
		defaultInstancevariable = 1;
		protectedInstanceVariable = 2;
		publicInstanceVariable = 3;
		
		
	}
	
	
	public void functionWithInnerClass()
	{
		final int finalLocalVariable = 10;
		int localVariable = 20; 
		
		
		class InnerClassWithinFunction{
			
			void testAccess()
			{	
				
				/*
				 * Here we see that in JAVA 8 onwards all local and instance variables are accessible within the inner class
				 */
				
				System.out.println("Public Instance Variable: " + publicInstanceVariable);
				System.out.println("Default Instance Variable: " + defaultInstancevariable);
				System.out.println("Protected Instance Variable: " + protectedInstanceVariable);
				System.out.println("Private Instance Variable: " + privateInstanceVariable);;
				System.out.println("Final Local Variable: " + finalLocalVariable);
				System.out.println("Local Variable: " + localVariable );
				
			}
			
		}
		
		
		InnerClassWithinFunction innerClassWithinFunction = new InnerClassWithinFunction();
		innerClassWithinFunction.testAccess();
		
		
		
		
	}
	
	
	
}





public class UnderstandingInnerClassMain {
	
	public static void main(String args[]) throws IOException
	{
		UnderstandingInnerClass understandingInnerClass = new UnderstandingInnerClass();
		understandingInnerClass.functionWithInnerClass();
		
		
	}
	
	

}
