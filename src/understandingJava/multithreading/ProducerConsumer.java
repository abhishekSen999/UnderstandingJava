package understandingJava.multithreading;

public class ProducerConsumer {

    private MyBlockingQueue<Integer> blockingQueue;
    int queueSize;

    int minSleepTime = 0;
    int maxDifferenceInSleepTime = 10000;

    // Bias  - higher the value slower it performs its task
    float consumerInverseBias = 0.5f;
    float producerInverseBias = 0.1f;


    //calculates a random sleep time using above parameters and the bias received
    private int sleepTime(float bias){
        return  minSleepTime+ (int)(Math.random()* (maxDifferenceInSleepTime * bias) );
    }


    ProducerConsumer(int queueSize){
        this.queueSize = queueSize;
        blockingQueue = new MyBlockingQueue<Integer>(queueSize);
    }

    public ProducerConsumer(int queueSize, int minSleepTime, int maxDifferenceInSleepTime, float consumerInverseBias, float producerBias) {
        this.queueSize = queueSize;
        this.minSleepTime = minSleepTime;
        this.maxDifferenceInSleepTime = maxDifferenceInSleepTime;
        this.consumerInverseBias = consumerInverseBias;
        this.producerInverseBias = producerBias;
    }

    // adds 100 object to queue after random sleeptimes
    public void producer(int numberOfElements) {

        for(int i=0 ; i<numberOfElements ; i++ ) {


            int element = i ;  //(int) Math.random() * 100;
            blockingQueue.add(element);
            System.out.println("Thread " + Thread.currentThread().getId() + " added element: " + element);

            try {
                Thread.sleep(sleepTime(producerInverseBias));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //removes 100 objects from queue
    public void consumer(int numberOfElements){
        for(int i = 0 ; i<numberOfElements ; i++)
        {
            int element = blockingQueue.remove();
            System.out.println("Thread " + Thread.currentThread().getId() + " removed  element: " + element);
            try {
                Thread.sleep(sleepTime(consumerInverseBias));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) throws InterruptedException {
        int numberOfElements = 20;
        int queueSize = 5;

        ProducerConsumer pcp = new ProducerConsumer(queueSize);

        Thread producerThread = new Thread(()-> pcp.producer(numberOfElements));

        Thread consumerThread = new Thread(()-> pcp.consumer(numberOfElements));

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

    }
}
