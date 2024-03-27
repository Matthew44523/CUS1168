# Matthew Frankowski
# Assignment 10 Part 2
# CUS1168

class Queue:
    def __init__(self):
        """Initialize an empty queue."""
        self.items = []  # Initialize an empty list to store queue elements

    def enqueue(self, item):
        """Add an element to the end of the queue."""
        self.items.append(item)  # Add the new element to the end of the list

    def dequeue(self):
        """Remove and return the element at the front of the queue."""
        if self.is_empty():  # Check if the queue is empty
            raise IndexError("Cannot dequeue from an empty queue")  # Raise an error if trying to dequeue from an empty queue
        return self.items.pop(0)  # Remove and return the first element of the list

    def is_empty(self):
        """Check if the queue is empty."""
        return len(self.items) == 0  # Return True if the list is empty, False otherwise

# Example usage:
if __name__ == "__main__":
    queue = Queue()
    
    # Enqueue some float elements
    queue.enqueue(2.91)
    queue.enqueue(6.972)
    queue.enqueue(1.1111)
    
    # Dequeue elements and print them
    while not queue.is_empty():
        print("Dequeued element:", queue.dequeue())
