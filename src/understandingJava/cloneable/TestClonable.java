package understandingJava.cloneable;

import java.util.Arrays;
import java.util.HashSet;

class ReferanceTypeData1{
	int primitiveData1 = 0;
	
}



class A {
	protected int a=0;
	protected int[] arrayA = {0,1,2};
}

class B extends A implements Cloneable{
	
	int b = 9;
	int [] arrayB = {1,2,3,4};
	ReferanceTypeData1 ref1;
	B(){
		ref1 = new ReferanceTypeData1();
		ref1.primitiveData1 = 10;
	}
	
	
	public B clone() throws CloneNotSupportedException {
		
	
		return (B)super.clone();
	
	}


	@Override
	public String toString() {
		return "B [b=" + b + ", arrayB=" + Arrays.toString(arrayB) + ", ref1=" + ref1 + ", a=" + a + ", arrayA="
				+ Arrays.toString(arrayA) + "]";
	}


	

	
	
	 
	
}









public class TestClonable {

	public static void main(String[] args) throws CloneNotSupportedException{
		// TODO Auto-generated method stub

		B b = new B();
		B b2 = b.clone();
		b.arrayB[1] = 100;
		b2.arrayB[1] = 200;
		b.b = 10;
		b2.b = 100;
		
		
		
		
		System.out.println("b: "+b);
		System.out.println("b2: "+b2);
		
		/*
		 * to perform deep copy all the  referanced data type fields (the whole network thus formed )
		 * should also implement cloneable interface and perform deep copy.
		 */
		
	}

}
