package understandingJava.astaticInterfaceMethods;

public class StaticDefaultMethodOverridingDemo extends ParalellogramClass implements Paralellogram{
	
	
	
	

	
	@Override
	public int area() {
		System.out.println("we are in overriden abstract method ");
		return 0;
	}
	
	@Override
	public void showAreaDefault()
	{
		System.out.println("we are in overriden default method ");
	}
	
	
	static void showAreaStatic() {
		System.out.println("We are in Subclass's overriden static method");
	}
	
	
//  force overriding method of Paralellogram class
// will not achieve run time polymorphism	
	
	
	static void show()
	{
		System.out.println("Within show method of subclass ");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		System.out.println("------------- Functions called using Object of Implementing class type --------------");
		
		StaticDefaultMethodOverridingDemo objectWithClassReference = new StaticDefaultMethodOverridingDemo();
		objectWithClassReference.area();
		objectWithClassReference.showAreaDefault();
		// should not refer static method like this(not possible if subclass does not force override static method )
		// although force overriding does not achieve the desired run time polymorphism
		objectWithClassReference.showAreaStatic();
		
		objectWithClassReference.show();
		
		objectWithClassReference.showAreaDefaultNotOverriden();
		
		
		System.out.println("------------- Functions called using Object of Implementing class type --------------");
		
		Paralellogram objectWithInterfaceReference = new StaticDefaultMethodOverridingDemo();
		objectWithInterfaceReference.area();
		objectWithInterfaceReference.showAreaDefault();
//		objectWithInterfaceReference.showAreaStatic(); // not possible to refer static method of interface with object referance
		
		
		System.out.println("------------- Functions called using Object of Parent class type ---------------------");
		
		ParalellogramClass objectWithPartentClassReferance = new StaticDefaultMethodOverridingDemo();
		//should not refer static function with object reference
		objectWithPartentClassReferance.show();
		
		
		

	}

	
	
	
	
}
