// Matthew Frankowski
// CUS1168
// Assignment 13
// Write a skeletal version of this function so that if the first alternative raises any exception,
// the second is tried, and if the second alternative raises any exception, the third is executed.

#include <iostream>
#include <stdexcept>

// Function prototypes
void alt1();
void alt2();
void alt3();

// Main function trying all of the alternatives
void tryAlts() {
    try {
        alt1(); // Trys the first alternative
    } 
    catch (const std::exception& e) 
    {
        std::cerr << "Alternative 1 failed: " << e.what() << std::endl;

        try {
            alt2(); // Try the second alternative if the first fails
        } 
        catch (const std::exception& e) {
            std::cerr << "Alternative 2 failed: " << e.what() << std::endl;
            try {
                alt3(); // Try the third alternative if the second fails
            } catch (const std::exception& e) {
                std::cerr << "Alternative 3 failed: " << e.what() << std::endl;
                // Handle failure of all alternatives here if needed
            }
        }
    }
}

// Implementation of alternative methods

// Alternative 1
void alt1() {
    // Implementation of alternative 1
    throw std::runtime_error("Exception in alternative 1");
}

// Alternative 2
void alt2() {
    // Implementation of alternative 2
    throw std::runtime_error("Exception in alternative 2");
}

// Alternative 3
void alt3() {
    // Implementation of alternative 3
    std::cout << "Executing alternative 3" << std::endl;
}

int main() {
    tryAlts(); // Call the function to try alternatives
    return 0;
}
