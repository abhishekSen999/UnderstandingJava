package understandingJava.anonymousClasses;

public interface Paralellogram {

	
//	any variable declared within a interface is automatically static final.
	int length = 0;
	int width = 0;
	
	
	public int area();
	public Paralellogram setLength(int length);
	public Paralellogram setWidth(int width);
	public void testAccessToVariablesOfEnclosingScopes();
	default void showAreaDefault() {
		System.out.println("called from default method: "+area());
	}
	static void showAreaStatic() {
		System.out.println("We are in Interface's Static method");
	}
		
}
