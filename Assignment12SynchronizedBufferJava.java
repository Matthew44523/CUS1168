//Matthew Frankowski
//CUS 1168
//Assignment 12: Task 4
//Write Programming Exercise 3 using Java

import java.util.concurrent.Semaphore;

class Assignment12SynchronizedBufferJava {
    private static final int BUFFER_SIZE = 5;
    private int[] buffer = new int[BUFFER_SIZE];
    private int count = 0;
    private Semaphore mutex = new Semaphore(1);
    private Semaphore emptySlots = new Semaphore(BUFFER_SIZE);
    private Semaphore filledSlots = new Semaphore(0);

    //Producer method to produce items and add them to the buffer
    public void produce(int item) throws InterruptedException {
        emptySlots.acquire(); //Wait for an empty slot
        mutex.acquire(); //Lock the buffer

        //Add item to the buffer
        buffer[count] = item;
        count++;
        System.out.println("Produced item: " + item);

        mutex.release(); //Unlock the buffer
        filledSlots.release(); //Signal that a slot is filled
    }

    //Consumer method to consume items from the buffer
    public int consume() throws InterruptedException {
        filledSlots.acquire(); //Wait for a filled slot
        mutex.acquire(); //Lock the buffer

        //Remove item from the buffer
        int item = buffer[count - 1];
        count--;
        System.out.println("Consumed item: " + item);

        mutex.release(); //Unlock the buffer
        emptySlots.release(); //Signal that a slot is empty

        return item;
    }
}