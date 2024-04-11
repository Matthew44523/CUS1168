//Matthew Frankowski
//CUS 1168
//Assignment 12: Task 3
//Define semaphores in Ada or C and use them to provide both cooperation and competition synchronization in the shared-buffer example.

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>

#define BUFFER_SIZE 5

typedef struct {
    int data[BUFFER_SIZE];       // Array to hold the items in the buffer
    int count;                   // Number of items currently in the buffer
    pthread_mutex_t mutex;       // Mutex to protect buffer access
    sem_t empty_slots;           // Semaphore to track empty slots in the buffer
    sem_t filled_slots;          // Semaphore to track filled slots in the buffer
} shared_buffer_t;

shared_buffer_t buffer;          // Shared buffer

// Function to initialize the shared buffer
void initialize_buffer(shared_buffer_t *buffer) {
    buffer->count = 0;
    pthread_mutex_init(&buffer->mutex, NULL);  // Initialize mutex
    sem_init(&buffer->empty_slots, 0, BUFFER_SIZE); // Initialize semaphore for empty slots with buffer size
    sem_init(&buffer->filled_slots, 0, 0); // Initialize semaphore for filled slots with 0
}

// Function to produce an item and add it to the buffer
void produce_item(shared_buffer_t *buffer, int item) {
    sem_wait(&buffer->empty_slots);     // Wait for an empty slot to become available
    pthread_mutex_lock(&buffer->mutex); // Lock the mutex to ensure exclusive access to the buffer
    
    buffer->data[buffer->count] = item; // Add the item to the buffer
    buffer->count++;                    // Increment the count of items in the buffer
    printf("Produced item: %d\n", item); // Print the produced item
    
    pthread_mutex_unlock(&buffer->mutex);   // Unlock the mutex
    sem_post(&buffer->filled_slots);        // Signal that a slot has been filled
}

// Function to consume an item from the buffer
int consume_item(shared_buffer_t *buffer) {
    sem_wait(&buffer->filled_slots);    // Wait for a filled slot to become available
    pthread_mutex_lock(&buffer->mutex); // Lock the mutex
    
    int item = buffer->data[buffer->count - 1]; // Get the last item from the buffer
    buffer->count--; // Decrement the count of items in the buffer
    printf("Consumed item: %d\n", item); // Print the consumed item
    
    pthread_mutex_unlock(&buffer->mutex);   // Unlock the mutex
    sem_post(&buffer->empty_slots);         // Signal that a slot has been emptied
    
    return item;
}

// Producer thread function
void *producer_thread(void *arg) {
    int i;
    for (i = 0; i < 10; i++) {
        produce_item(&buffer, i); // Produce items and add them to the buffer
        sleep(1); // Simulate some work
    }
    return NULL;
}

// Consumer thread function
void *consumer_thread(void *arg) {
    int i;
    for (i = 0; i < 10; i++) {
        int item = consume_item(&buffer); // Consume items from the buffer
        sleep(1); // Simulate some work
    }
    return NULL;
}

// Main function
int main() {
    pthread_t producer_tid, consumer_tid;

    initialize_buffer(&buffer); // Initialize the shared buffer

    // Create producer and consumer threads
    pthread_create(&producer_tid, NULL, producer_thread, NULL);
    pthread_create(&consumer_tid, NULL, consumer_thread, NULL);

    // Wait for producer and consumer threads to finish
    pthread_join(producer_tid, NULL);
    pthread_join(consumer_tid, NULL);

    // Destroy semaphores and mutex
    pthread_mutex_destroy(&buffer.mutex);
    sem_destroy(&buffer.empty_slots);
    sem_destroy(&buffer.filled_slots);

    return 0;
}
