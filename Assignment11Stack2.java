/*
 * Matthew Frankowski
 * Assignment 11: Rewrite stack_2 in Java
 * CUS: 1168
 * */

import java.util.Stack;
import java.util.Scanner;

public class Assignment11Stack2 {

    public static void main(String[] args) {
        // Creating a stack to hold integers
        Stack<Integer> stack = new Stack<>();
        // Creating a Scanner object to read user input
        Scanner in = new Scanner(System.in);
        int choice;

        // Displaying menu and processing user's choice until the user chooses to exit
        do {
            System.out.println("Stack Operations:");
            System.out.println("1. Push element onto stack");
            System.out.println("2. Pop element from stack");
            System.out.println("3. Peek at the top element");
            System.out.println("4. Check if the stack is empty");
            System.out.println("5. Display the stack");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();

            // Switch statement to perform different operations based on user's choice
            switch (choice) {
                case 1:
                    // Pushing an element onto the stack
                    System.out.print("Enter element to push onto stack: ");
                    int elementToPush = in.nextInt();
                    stack.push(elementToPush);
                    System.out.println("Element " + elementToPush + " pushed onto stack.");
                    break;
                case 2:
                    // Popping an element from the stack
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty, nothing to pop.");
                    } else {
                        int poppedElement = stack.pop();
                        System.out.println("Element " + poppedElement + " popped from stack.");
                    }
                    break;
                case 3:
                    // Peeking at the top element of the stack
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        int topElement = stack.peek();
                        System.out.println("Top element of the stack is: " + topElement);
                    }
                    break;
                case 4:
                    // Checking if the stack is empty
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Stack is not empty.");
                    }
                    break;
                case 5:
                    // Displaying the elements in the stack
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Elements in the stack:");
                        System.out.println(stack);
                    }
                    break;
                case 6:
                    // Exiting the program
                    System.out.println("Exiting program.");
                    break;
                default:
                    // Handling invalid input
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
            System.out.println();
        } while (choice != 6);

        // Closing the Scanner object to release resources
        in.close();
    }
}


//Compared to C++ the primary differences would be in syntax and the different standard libraries.
//Both would use a switch case and stack data structure but in C++ you would have to incorporate
//pointers and memory management.