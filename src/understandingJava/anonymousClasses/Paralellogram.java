package understandingJava.anonymousClasses;

public interface Paralellogram {

	
//	any variable declared within a interface is automatically static final.
	int length = 0;
	int width = 0;
	
	
	public int area();
	public Paralellogram setLength(int length);
	public Paralellogram setWidth(int width);
	public void testAccessToVariablesOfEnclosingScopes();
	default void showArea() {
		System.out.println(area());
	}
		
}
