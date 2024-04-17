// Matthew Frankowski
// CUS1168
// Assignment 13
//Write a Java program that inputs a list of integer values in the range of -100 to 100 from
// the keyboard and computes the sum of the squares of the input values.

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Assignment13Part2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> values = new ArrayList<>();
        int sum = 0;

        while (true) {
            try {
                // Ask the user to enter an integer value
                System.out.print("Enter an integer value (-100 to 100, EOF to end): ");
                int value = sc.nextInt();

                // Check if the value is within the range of -100 to 100
                if (value < -100 || value > 100) {
                    System.out.println("Value must be in the range of -100 to 100.");
                    continue;
                }

                // Calculate the square of the value and check for sum overflow
                long squaredValue = (long) value * value;
                if (sum + squaredValue > Integer.MAX_VALUE) {
                    System.out.println("Error: Sum of squares exceeds Integer.MAX_VALUE. Exiting.");
                    System.exit(1);
                }

                // Add the squared value to the sum and store the value
                sum += squaredValue;
                values.add(value);
            } catch (InputMismatchException e) {
                // Handle non-integer input
                System.out.println("Invalid input. Please enter an integer.");
                sc.next(); // clear the invalid input
            } catch (Exception e) {
                // Handle other exceptions
                System.out.println("Error reading input. Exiting.");
                System.exit(1);
            }
        }
    }
}
