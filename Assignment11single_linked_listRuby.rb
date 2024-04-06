# Matthew Frankowski
# Assignment 11
# CUS 1168

class SingleLinkedListNode
    attr_accessor :value, :next
  
    # Initialize a single linked list node with a value and a reference to the next node
    def initialize(value, next_node)
      @value = value  # Value stored in the node
      @next = next_node  # Reference to the next node
    end
  end
  
  class LinkedList
    # Initialize the linked list with a head node containing the given value
    def initialize(value)
      @link_list_head = SingleLinkedListNode.new(value, nil)
    end
  
    # Add a new node with the given value to the end of the linked list
    def add_link_list_node(value)
      current_node = @link_list_head
      while current_node.next != nil
        current_node = current_node.next
      end
      current_node.next = SingleLinkedListNode.new(value, nil)
    end
  
    # Delete the node with the given value from the linked list
    def delete_link_list_node(value)
      current_node = @link_list_head
      if current_node.value == value  # If the head node matches the value
        @link_list_head = current_node.next  # Update the head node
      else
        while (current_node.next != nil) && (current_node.next.value != value)
          current_node = current_node.next
        end
        unless current_node.next == nil
          current_node.next = current_node.next.next  # Skip over the node to delete
        end
      end
    end
  
    # Return an array containing all the values in the linked list
    def return_link_list
      elements = []
      current_node = @link_list_head
      while current_node != nil
        elements << current_node.value
        current_node = current_node.next
      end
      elements
    end
  end
  