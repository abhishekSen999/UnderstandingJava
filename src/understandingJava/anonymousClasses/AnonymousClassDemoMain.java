package understandingJava.anonymousClasses;

import java.io.IOException;

class AnonymousClassDemo {
	private int privateInstanceVariable;
	int defaultInstancevariable; // accessible within package
	protected int protectedInstanceVariable;// accessible to only subclasses
	public int publicInstanceVarable;// well, you know it
	
	
	public AnonymousClassDemo() {
		privateInstanceVariable = 0;
		defaultInstancevariable = 1;
		protectedInstanceVariable = 2;
		publicInstanceVarable = 3;		
	}
	
	

	public void functionWithAnonymousClass() {
		
		//variables will be used to test scope
		final int finalLocalVariable = 10;
		int localVariable = 20; 
		
		

		/*
		 * adding additional functionalities to anonymous classes does not make sense
		 * as, if the interface is unaware of the added functionalities , one will never
		 * be able to use them using the Interface reference type see following example.
		 * 
		 * 
		 * can also be used to extend class.
		 * 
		 */
		Paralellogram square = new Paralellogram() {
			private int side;

			@Override
			public int area() {
				return side * side;
			}

			@Override
			public Paralellogram setLength(int length) {
				this.side = length;
				return this;
			}

			@Override
			public Paralellogram setWidth(int width) {
				this.side = width;
				return this;
			}

			@Override
			public void testAccessToVariablesOfEnclosingScopes() {
				
				System.out.println("Inside Square Public Instance Variable: " + publicInstanceVarable);
				System.out.println("Inside Square Default Instance Variable: " + defaultInstancevariable);
				System.out.println("Inside Square Protected Instance Variable: " + protectedInstanceVariable);
				System.out.println("Inside Square Private Instance Variable: " + privateInstanceVariable);;
				System.out.println("Inside Square Final Local Variable: " + finalLocalVariable);
				System.out.println("Inside Square Local Variable: " + localVariable );
//				Paralellogram.length = 10;
//				any variable declared within a interface is automatically static final.
				
				
				System.out.println("accessing Inteface variables: " + Paralellogram.length); 


			}
			
			
			
			
			
			
			

/*			incase multiple interfaces are implemented by a class then either clashing default methods needs to be 
*			overridden or if any particular interface's default menthod needs to called it has to
*			be done in the following manner
*/			
			public void showAreaDefault() {
				
				Paralellogram.super.showAreaDefault();
				
			}
			
			
			
		};
		Paralellogram rectangle = new Paralellogram() {
			private int length;
			private int width;

			public Paralellogram setLength(int length) {
				this.length = length;
				return this;
			}

			@Override
			public int area() {
				return length * width;
			}

			@Override
			public Paralellogram setWidth(int width) {
				this.width = width;
				return this;
			}

			@Override
			public void testAccessToVariablesOfEnclosingScopes() {
				// TODO Auto-generated method stub

			}
		};

		System.out.println("Square area: " + square.setWidth(10).area());
		System.out.println("Rectange area: " + rectangle.setLength(5).setWidth(10).area());
		square.testAccessToVariablesOfEnclosingScopes();
		
	}

}

public class AnonymousClassDemoMain {

	public static void main(String[] args) throws IOException {

		AnonymousClassDemo anonymousClassDemo = new AnonymousClassDemo();
		anonymousClassDemo.functionWithAnonymousClass();
		
	}

}
