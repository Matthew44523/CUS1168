// Matthew Frankowski
// CUS1168
// Assignment 13
//Revise the Java program of Section 14.3.5 to use EOFException to detect the end of the input.

import java.io.*;

class GradeDist {
    int newGrade, index, limit_1, limit_2;
    int[] freq = new int[10];

    void buildDist() {
        // Create a BufferedReader to read input from the console
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Input loop
            while (true) {
                System.out.println("Please input a grade");
                String input = reader.readLine(); // Read a line of input

                // Check if end of input is reached
                if (input == null) {
                    // Throw EOFException to signal end of input
                    throw new EOFException();
                }

                newGrade = Integer.parseInt(input); // Parse input to integer

                // Check if the input is negative, indicating end of input data
                if (newGrade < 0) {
                    throw new NegativeInputException();
                }

                index = newGrade / 10; // Determine the index of the frequency array

                try {
                    freq[index]++; // Increment the frequency at the corresponding index
                } catch (ArrayIndexOutOfBoundsException e) {
                    // Handle out-of-range grades
                    if (newGrade == 100) {
                        freq[9]++;
                    } else {
                        System.out.println("Error - new grade: " + newGrade + " is out of range");
                    }
                }
            }
        } catch (EOFException e) {
            // Handle end of input
            System.out.println("End of input data reached");
        } catch (IOException e) {
            // Handle IOException
            System.err.println("IOException occurred: " + e.getMessage());
        } catch (NegativeInputException e) {
            // Output grade distribution
            System.out.println("\nLimits Frequency\n");
            for (index = 0; index < 10; index++) {
                limit_1 = 10 * index;
                limit_2 = limit_1 + 9;
                if (index == 9) {
                    limit_2 = 100;
                }
                System.out.println("" + limit_1 + " - " + limit_2 + " " + freq[index]);
            }
        }
    }

    public static void main(String[] args) {
        // Create an instance of GradeDist and call buildDist method
        GradeDist gradeDist = new GradeDist();
        gradeDist.buildDist();
    }
}

// Custom exception class for negative input
class NegativeInputException extends Exception {
    public NegativeInputException() {
        // Empty constructor
    }
}
