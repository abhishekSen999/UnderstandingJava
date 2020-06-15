package understandingJava.anonymousClasses;

public class MyClass {
	int parentclassInstanceVariable;
	
	MyClass(){
		parentclassInstanceVariable = 1;
	}
	
	void show() {
		System.out.println("We are in parent class.");
	}
	
	void parentClassFunctionNotOverriden() {
		System.out.println("Hello there we are in the parent class function which is not overriden.");
	}

}
