# Matthew Frankowski
# Assignment 11
# CUS 1168

class QueueExample
  def initialize
    @queue = [] # Initialize an empty array to act as a queue
  end

  def add_element(element)
    @queue.push(element) # Add the element to the end of the queue
    puts "Element #{element} added to the queue."
  end

  def delete_element
    if @queue.empty?
      puts "Queue is empty, nothing to delete."
    else
      removed_element = @queue.shift # Remove the first element from the queue
      puts "Element #{removed_element} removed from the queue."
    end
  end

  def peek_front_element
    if @queue.empty?
      puts "Queue is empty."
    else
      front_element = @queue.first # Get the first element of the queue without removing it
      puts "Front element of the queue is: #{front_element}"
    end
  end

  def check_if_empty
    if @queue.empty? # Check if the queue is empty
      puts "Queue is empty."
    else
      puts "Queue is not empty."
    end
  end

  def display_queue
    if @queue.empty?
      puts "Queue is empty."
    else
      puts "Elements in the queue:"
      puts @queue.join(", ") # Display all elements of the queue separated by comma
    end
  end

  def run
    loop do
      puts "Queue Operations:"
      puts "1. Add element to queue"
      puts "2. Delete element from queue"
      puts "3. Peek at the front element"
      puts "4. Check if the queue is empty"
      puts "5. Display the queue"
      puts "6. Exit"
      print "Enter your choice: "
      choice = gets.chomp.to_i # Get the user's choice

      case choice
      when 1
        print "Enter element to add: "
        element_to_add = gets.chomp.to_i # Get the element to add from user
        add_element(element_to_add) # Call method to add the element to queue
      when 2
        delete_element # Call method to delete element from queue
      when 3
        peek_front_element # Call method to peek at the front element of queue
      when 4
        check_if_empty # Call method to check if queue is empty
      when 5
        display_queue # Call method to display all elements of queue
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

# Create an instance of QueueExample and run the program
queue_program = QueueExample.new
queue_program.run
