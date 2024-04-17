//Matthew Frankowski
//CUS1168
//Assignment 13
//Write a C++ program for the specification of Programming Exercise 2.

#include <iostream>
#include <vector>
#include <limits>

int main() {
    std::vector<int> values; // Vector to store input values
    int sumOfSquares = 0; // Variable to store the sum of squares
    int value; // Variable to store each input value

    try {
        // Input loop
        while (true) {
            std::cout << "Enter an integer (-100 to 100) or any other key to finish: ";
            std::cin >> value;
            
            // Check if end-of-file detected
            if (std::cin.fail()) {
                std::cin.clear(); // Clear error flags
                std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n'); // Ignore remaining input
                break; // Exit the loop
            }

            // Validate input range
            if (value < -100 || value > 100) {
                std::cout << "Error: Value must be in the range of -100 to 100." << std::endl;
                continue; // Skip to next iteration
            }

            // Add value to vector and calculate sum of squares
            values.push_back(value);
            sumOfSquares += value * value;
        }
    } catch (std::overflow_error& e) {
        // Integer overflow
        std::cerr << "Error: Integer overflow occurred while calculating the sum of squares." << std::endl;
        return 1; // Exit with error code
    }

    // Output result
    std::cout << "Sum of squares: " << sumOfSquares << std::endl;

    return 0; // Exit successfully
}
