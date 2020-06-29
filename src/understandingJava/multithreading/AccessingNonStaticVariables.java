package understandingJava.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

class MyClass {
    private int testVariable;

    private static int staticTestVariable;

    private volatile int volatileTestVariable;

    private static volatile int staticVolatileTestVariable;

    private AtomicInteger atomicInteger;

    /*
    *volatile keyword is not meant to maintain mutual exclusion or atomicity of operation like increment
    *volatile keyword is meant to maintain visibility across threads by preventing cashing of data thus maintaining write order
    *prevent reading before completing write operation (like after first 32 bits are written , another thread would not read until complete 64 bits are written to memory)
    *prevent reordering of code involving this variable during compile time optimization.
    **/

    MyClass() {
        staticTestVariable = 0;
        testVariable = 0;
        volatileTestVariable = 0;
        staticVolatileTestVariable = 0;
        atomicInteger = new AtomicInteger(0);
    }

    public void functionToManipulateField() {

        for (int counter = 0; counter < 10; counter++) {
//            int copyOfTestVariable = testVariable; // -*1
//            int copyOfStaticTestVariable = staticTestVariable; //-*1
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                testVariable += 1;
                staticTestVariable += 1;
                volatileTestVariable += 1;
                staticVolatileTestVariable += 1;
                atomicInteger.getAndIncrement();

//                testVariable = copyOfTestVariable + 1; // -*1
//                staticTestVariable = copyOfStaticTestVariable + 1;  //-*1
                /*
                * all variables show unpredictable results - the final total of each shared variable may or may not reach 10
                * in case ov atomicInteger the final value of one or more than one thread will reach 10, as although increment is atomic display is not.
                **/

                System.out.println("Thread: " + Thread.currentThread().getId() + " - testVariable: " + testVariable + " - staticTestVariable: " + staticTestVariable + " - volatileTestVariable: " + volatileTestVariable + " - staticVolatileTestVariable: "+staticVolatileTestVariable + " - atomicInteger: "+atomicInteger) ;
            });

            thread.start();
        }


    }
}

public class AccessingNonStaticVariables {
    public static void main(String[] args) {

        MyClass myclass = new MyClass();
        myclass.functionToManipulateField();

    }
}
