//Matthew Frankowski
//Assignment 9
//1168

using System;

class Program
{
    // Define a method that attempts to change the parameter passed by reference
    static void ChangeParameter(ref string param)
    {
        param = "Changed"; // Modify the value passed by reference
    }

    static void Main(string[] args)
    {
        string literal = "Original"; // Define a string variable holding a literal string

        ChangeParameter(ref literal); // Pass a reference to the variable 'literal' to the method

        Console.WriteLine("Modified value: " + literal); // Print the modified value of the literal
    }
}

//The output will display "Modified value: Changed" because the string variable literal is passed by reference to the ChangeParameter method, which modifies its value to "Changed", and then the modified value is printed.