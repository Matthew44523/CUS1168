/*
 * Matthew Frankowski
 * Assignment 11: Rewrite queue_2 in Java
 * CUS: 1168
 * */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Assignment11Queue2 {

    public static void main(String[] args) {
        // Create a queue using LinkedList implementation
        Queue<Integer> queue = new LinkedList<>();
        // Create a Scanner object to read user input
        Scanner in = new Scanner(System.in);
        int choice;

        // Display menu and process user's choice until the user chooses to exit
        do {
            System.out.println("Queue Operations:");
            System.out.println("1. Add element to queue");
            System.out.println("2. Delete element from queue");
            System.out.println("3. Peek at the front element");
            System.out.println("4. Check if the queue is empty");
            System.out.println("5. Display the queue");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();

            // Switch statement to perform different operations based on user's choice
            switch (choice) {
                case 1:
                    // Add element to the queue
                    System.out.print("Enter element to add: ");
                    int elementToAdd = in.nextInt();
                    queue.offer(elementToAdd);
                    System.out.println("Element " + elementToAdd + " added to queue.");
                    break;
                case 2:
                    // Delete element from the queue
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty, nothing to delete.");
                    } else {
                        int removedElement = queue.poll();
                        System.out.println("Element " + removedElement + " removed from queue.");
                    }
                    break;
                case 3:
                    // Peek at the front element of the queue
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        int frontElement = queue.peek();
                        System.out.println("Front element of the queue is: " + frontElement);
                    }
                    break;
                case 4:
                    // Check if the queue is empty
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Queue is not empty.");
                    }
                    break;
                case 5:
                    // Display the elements in the queue
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Elements in the queue:");
                        System.out.println(queue);
                    }
                    break;
                case 6:
                    // Exit the program
                    System.out.println("Exiting program.");
                    break;
                default:
                    // Handle invalid input
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
            System.out.println();
        } while (choice != 6);

        // Close the Scanner object to release resources
        in.close();
    }
}

//Compared to C++ the primary differences would be in syntax and the different standard libraries.
//In C++ we use the Standard Template Library instead of LinkedList in Java. Additionally instead of
//System.out we use std::cout in C++.