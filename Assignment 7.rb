# Matthew Frankowski
# CUS 1168
# Assignment 7

# Initialize variable j with a floating-point value of 1
j = 1.0

# Calculate initial value for k using the formula (j + 13) / 27
k = (j + 13) / 27.0

# Loop while k is less than or equal to 10
while k <= 10
    # Increment k by 1.2 in each iteration
    k += 1.2
    
    # Calculate the value of i using the formula: i = 3 * k - 1
    i = 3 * k - 1
    
    # Print the current values of k and i
    puts "K: #{k}, i: #{i}"
end
