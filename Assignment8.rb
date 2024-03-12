# Assigning values to variables k and j
k = 5
j = 3

# Checking conditions for variable k using a case statement
case k
when 1, 2
  # If k is 1 or 2, calculate j using the formula 2 * k - 1
  j = 2 * k - 1
when 3, 5
  # If k is 3 or 5, calculate j using the formula 3 * k + 1
  j = 3 * k + 1
when 4
  # If k is 4, calculate j using the formula 4 * k - 1
  j = 4 * k - 1
when 6, 7, 8
  # If k is 6, 7, or 8, calculate j using the formula k - 2
  j = k - 2
end

# Print the final value of j after the conditions are checked
puts "j= #{j}"