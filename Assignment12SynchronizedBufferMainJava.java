//Matthew Frankowski
//CUS 1168
//Assignment 12: Task 4
//Write Programming Exercise 3 using Java

public class Assignment12SynchronizedBufferMainJava
{
    public static void main(String[] args) {
        Assignment12SynchronizedBufferJava synchronizedBuffer = new Assignment12SynchronizedBufferJava();

        //Producer thread
        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    synchronizedBuffer.produce(i);
                    Thread.sleep(1000); // Simulate production time
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //Consumer thread
        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    synchronizedBuffer.consume();
                    Thread.sleep(1000); //Simulate processing time
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
