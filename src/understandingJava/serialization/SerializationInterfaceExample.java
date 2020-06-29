package understandingJava.serialization;

import java.io.*;

class SerializableFields implements Serializable {
    int field1;
    int field2;

    public SerializableFields(int field1, int field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    @Override
    public String toString() {
        return "SerializableFields{" +
                "field1=" + field1 +
                ", field2=" + field2 +
                '}';
    }
}

class NonSerializableFields {
    int field;

    public NonSerializableFields(int field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "NonSerializableFields{" +
                "field=" + field +
                '}';
    }
}







public class SerializationInterfaceExample implements Serializable{

    SerializableFields serializableFields;

    transient NonSerializableFields nonSerializableFields;

    public SerializationInterfaceExample(SerializableFields serializableFields, NonSerializableFields nonSerializableFields) {
        this.serializableFields = serializableFields;
        this.nonSerializableFields = nonSerializableFields;
    }

    @Override
    public String toString() {
        return "SerializationInterfaceExample{" +
                "serializableFields=" + serializableFields +
                ", nonSerializableFields=" + nonSerializableFields +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        SerializableFields serializableFields = new SerializableFields(1,2);
        NonSerializableFields nonSerializableFields = new NonSerializableFields(3);
        SerializationInterfaceExample object = new SerializationInterfaceExample(serializableFields,nonSerializableFields);

        FileOutputStream fileOutputStream = new FileOutputStream("object.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(object);

        System.out.println(object);
        System.out.println("Object has been serialized ");


        FileInputStream fileInputStream = new FileInputStream("object.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        SerializationInterfaceExample object1 = (SerializationInterfaceExample) objectInputStream.readObject();

        System.out.println("--------------------------------------------------------");
        System.out.println("Object has been deserialized");
        System.out.println(object1);









    }
}
