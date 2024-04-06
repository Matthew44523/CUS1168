#!C:/Strawberry/perl/bin/perl.exe

#Matthew Frankowski
#Assignment 9
#CUS1168


use strict;     # Enable strict mode for better coding practices
use warnings;       # Enable warnings to help catch common errors

# Define a subroutine that attempts to change the parameter passed by reference
sub change_parameter {
    my $param_ref = shift;      # Get the reference to the parameter passed to the subroutine

    $$param_ref = "Changed";    # Modify the value pointed to by the reference
}

my $literal = "Original";       # Define a scalar variable holding a literal string

change_parameter(\$literal);        # Pass a reference to the variable $literal to the subroutine

print "Modified value: $literal\n";     # Print the modified value of the literal

# Explination: The script passes a reference to a scalar variable to a subroutine, which modifies the variable's value to "Changed" through dereferencing, resulting in the final print statement displaying the updated value.