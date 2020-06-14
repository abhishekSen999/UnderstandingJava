package understandingJava.serialization;

import java.io.*;

class Car implements Externalizable {
	int age;
	String name;
	int year;

	public Car() {
		System.out.println("Default Constructor called");
	}

	Car(String n, int y,int age) {
		this.name = n;
		this.year = y;
		this.age = age;
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeInt(age);
		out.writeInt(year);
		
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		name = (String) in.readObject();
		age = in.readInt();
		year = in.readInt();

	}

	public String toString() {
		return ("Name: " + name + "\n" + "Year: " + year + "\n" + "Age: " + age);
	}
}

public class ExternExample {
	public static void main(String[] args) {
		Car car = new Car("Shubham", 1995,10);
		Car newcar = null;
		String serializedObject = "";
		// Serialize the car
		try {
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			ObjectOutputStream so = new ObjectOutputStream(bo);
			so.writeObject(car);
			so.flush();
			serializedObject = bo.toString();
		} catch (Exception e) {
			System.out.println(e);
		}

		// deserialize the object
		try {
			byte b[] = serializedObject.getBytes();
			ByteArrayInputStream bi = new ByteArrayInputStream(b);
			ObjectInputStream si = new ObjectInputStream(bi);
			newcar = (Car) si.readObject();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("The original car is:\n" + car);
		System.out.println("The new car is:\n" + newcar);
	}
}
