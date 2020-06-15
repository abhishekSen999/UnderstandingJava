package understandingJava.anonymousClasses;

public class ChildClassOverrideMyClassAsAnonymousClass {

	public static void main(String[] args) {

		System.out.println("----------------------MyClass------------------------");

		MyClass myClass = new MyClass();
		myClass.show();
		myClass.parentClassFunctionNotOverriden();

		// Anonymous Class - which extends MyClass
		MyClass myClassExtension = new MyClass() {

			@Override
			void show() {
				System.out.println("We are in anonymous child class");
			}
		};

		System.out.println("----------------------Anonymous class extend MyClass------------------------");

		myClassExtension.show();
		myClassExtension.parentClassFunctionNotOverriden();

	}

}