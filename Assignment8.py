# Assigning values to variables k and j
k = int(5)
j = int(3)

# Checking conditions for variable k
if k == 1 or k == 2:
    # If k is 1 or 2, calculate j using the formula 2 * k - 1
    j = 2 * k - 1
elif k == 3 or k == 5:
    # If k is 3 or 5, calculate j using the formula 3 * k + 1
    j = 3 * k + 1
elif k == 4:
    # If k is 4, calculate j using the formula 4 * k - 1
    j = 4 * k - 1
elif k == 6 or k == 7 or k == 8:
    # If k is 6, 7, or 8, calculate j using the formula k - 2
    j = k - 2

# Print the final value of j after the conditions are checked
print(j)

# Merits: Python unlike Java does not have a switch case, meaning we have to use if and elif statements. 
# Python is very readable and easy to understand this can be seen in the elif statements. It is however interpreted meaning
# it may compile slower.
