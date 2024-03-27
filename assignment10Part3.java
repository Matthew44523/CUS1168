// Matthew Frankowski
// Assignment 10 Part 3
// CUS1168

import java.util.LinkedList;

public class assignment10Part3<T> {
    // Internal LinkedList to store the elements of the queue
    private LinkedList<T> items;

    // Constructor to initialize an empty queue
    public assignment10Part3() {
        items = new LinkedList<>();
    }

    // Method to add an element to the end of the queue
    public void enqueue(T item) {
        items.add(item);
    }

    // Method to remove and return the element at the front of the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot dequeue from an empty queue.");
        }
        return items.removeFirst();
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Method to return the number of elements in the queue
    public int size() {
        return items.size();
    }

    // Method to return the element at the front of the queue without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot peek into an empty queue.");
        }
        return items.getFirst();
    }

    // Main method for testing the Queue implementation
    public static void main(String[] args) {
        // Create a Queue of Integers
        assignment10Part3<Integer> intQueue = new assignment10Part3<>();
        intQueue.enqueue(1);
        intQueue.enqueue(2);
        intQueue.enqueue(3);

        // Dequeue an element and peek at the front element
        System.out.println("Dequeue: " + intQueue.dequeue()); // Outputs: Dequeue: 1
        System.out.println("Peek: " + intQueue.peek()); // Outputs: Peek: 2

        // Create a Queue of Strings
        assignment10Part3<String> stringQueue = new assignment10Part3<>();
        stringQueue.enqueue("Matthew");
        stringQueue.enqueue("Frankowski");

        // Dequeue an element and peek at the front element
        System.out.println("Dequeue: " + stringQueue.dequeue()); // Outputs: Dequeue: Hello
        System.out.println("Peek: " + stringQueue.peek()); // Outputs: Peek: World
    }
}
