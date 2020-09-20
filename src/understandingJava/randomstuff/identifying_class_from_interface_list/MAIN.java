package understandingJava.randomstuff.identifying_class_from_interface_list;

public class MAIN {
    public static void main(String[] args) {
        MyInterface objClass1 = new MyClass1();
        MyInterface objClass2 = new MyClass2();

        System.out.println("class name of object from class1-> "+(objClass1.getClass()==MyClass1.class));
        System.out.println("class name of object from class2-> "+objClass2.getClass());
    }
}
