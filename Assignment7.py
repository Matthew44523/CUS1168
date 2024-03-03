# Matthew Frankowski
# CUS 1168
# Assignment 7

# Initialize variable j with a floating-point value of 1
j = float(1)

# Calculate initial value for k using the formula (j + 13) / 27
k = (j + 13) / 27

while k <= 10:
    # Increment k by 1.2 in each iteration
    k += 1.2
    # Calculate the value of i using the formula: i = 3 * k - 1
    i = 3 * k - 1
    # Print the current values of k and i
    print(f"K: {k}, i: {i}")