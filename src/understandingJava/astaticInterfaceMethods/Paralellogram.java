package understandingJava.astaticInterfaceMethods;

public interface Paralellogram {

	
//	any variable declared within a interface is automatically static final.
	int length = 0;
	int width = 0;
	
	
	public int area();
	
	default void showAreaDefault() {
		System.out.println("We are in interface's Default method ");
	}
	
	default void showAreaDefaultNotOverriden() {
		System.out.println("We are in interface's Default method which is not overriden ");
	}
	
	static void showAreaStatic()
	{
		System.out.println("We are in Interface's Static method");
	}

}
