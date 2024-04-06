# Matthew Frankowski
# Assignment 11
# CUS 1168

class Stack_2
    def initialize
      @stack = [] # Initialize an empty array to act as a stack
    end
  
    def push_element(element)
      @stack.push(element) # Add the element to the top of the stack
      puts "Element #{element} pushed onto stack."
    end
  
    def pop_element
      if @stack.empty?
        puts "Stack is empty, nothing to pop."
      else
        popped_element = @stack.pop # Remove and return the top element of the stack
        puts "Element #{popped_element} popped from stack."
      end
    end
  
    def peek_top_element
      if @stack.empty?
        puts "Stack is empty."
      else
        top_element = @stack.last # Get the top element of the stack without removing it
        puts "Top element of the stack is: #{top_element}"
      end
    end
  
    def check_if_empty
      if @stack.empty? # Check if the stack is empty
        puts "Stack is empty."
      else
        puts "Stack is not empty."
      end
    end
  
    def display_stack
      if @stack.empty?
        puts "Stack is empty."
      else
        puts "Elements in the stack:"
        puts @stack.reverse.join(", ") # Display all elements of the stack in reverse order (top to bottom)
      end
    end
  
    def run
      loop do
        puts "Stack Operations:"
        puts "1. Push element onto stack"
        puts "2. Pop element from stack"
        puts "3. Peek at the top element"
        puts "4. Check if the stack is empty"
        puts "5. Display the stack"
        puts "6. Exit"
        print "Enter your choice: "
        choice = gets.chomp.to_i # Get the user's choice
  
        case choice
        when 1
          print "Enter element to push onto stack: "
          element_to_push = gets.chomp.to_i # Get the element to push from user
          push_element(element_to_push) # Call method to push the element onto stack
        when 2
          pop_element # Call method to pop element from stack
        when 3
          peek_top_element # Call method to peek at the top element of stack
        when 4
          check_if_empty # Call method to check if stack is empty
        when 5
          display_stack # Call method to display all elements of stack
        when 6
          puts "Exiting program."
          break # Exit the loop and program
        else
          puts "Invalid choice. Please enter a number between 1 and 6."
        end
  
        puts
      end
    end
  end
  
  # Create an instance of Stack_2 and run the program
  stack_program = Stack_2.new
  stack_program.run
  