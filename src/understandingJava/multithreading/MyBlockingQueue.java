package understandingJava.multithreading;
;
import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueue<E> {

    private Queue<E> blockingQueue;
    private int maxSize;

    MyBlockingQueue(int size){
        this.maxSize = size;
        blockingQueue = new LinkedList<>();
    }


    public synchronized boolean add(E e) {

        while(blockingQueue.size() == maxSize){
            System.out.println(">>>>Queue full:"+blockingQueue.size()+"<<<<<---> Thread "+Thread.currentThread().getId()+" is waiting to add: "+e);
            try {
                this.wait();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
                return false;
            }
        }
        blockingQueue.add(e);
        this.notifyAll();
        return true;
    }


    public synchronized E remove() {

        while(blockingQueue.size() == 0){
            System.out.println(">>>>Queue empty:"+blockingQueue.size()+"<<<<<---> Thread "+Thread.currentThread().getId()+" is waiting to remove element");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }
        E element = blockingQueue.remove();
        this.notifyAll();



        return element;
    }


}
