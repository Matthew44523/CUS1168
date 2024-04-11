//Matthew Frankowski
//CUS 1168
//Assignment 12: Task 2
//Write an Ada or C task to manage a shared buffer such as the one in our example, but use the semaphore task from Programming Exercise 1.

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

#define BUFFER_SIZE 5

typedef struct {
    int items[BUFFER_SIZE];
    int count; // Number of items currently in the buffer
    pthread_mutex_t mutex; // Mutex to protect buffer access
    pthread_cond_t not_full_cond; // Condition variable to signal when buffer is not full
    pthread_cond_t not_empty_cond; // Condition variable to signal when buffer is not empty
} shared_buffer_t;

shared_buffer_t buffer; // Shared buffer

// Function to initialize the shared buffer
void initialize_buffer(shared_buffer_t *buffer) {
    buffer->count = 0;
    pthread_mutex_init(&buffer->mutex, NULL);
    pthread_cond_init(&buffer->not_full_cond, NULL);
    pthread_cond_init(&buffer->not_empty_cond, NULL);
}

// Function to produce an item and add it to the buffer
void produce_item(shared_buffer_t *buffer, int item) {
    pthread_mutex_lock(&buffer->mutex); // Lock the mutex to ensure exclusive access to the buffer
    while (buffer->count >= BUFFER_SIZE) {
        pthread_cond_wait(&buffer->not_full_cond, &buffer->mutex); // Wait until the buffer is not full
    }

    buffer->items[buffer->count] = item; // Add the item to the buffer
    buffer->count++; // Increment the count of items in the buffer
    printf("Produced item: %d\n", item); // Print the produced item

    pthread_cond_signal(&buffer->not_empty_cond); // Signal that the buffer is not empty
    pthread_mutex_unlock(&buffer->mutex); // Unlock the mutex
}

// Function to consume an item from the buffer
int consume_item(shared_buffer_t *buffer) {
    pthread_mutex_lock(&buffer->mutex); // Lock the mutex
    while (buffer->count == 0) {
        pthread_cond_wait(&buffer->not_empty_cond, &buffer->mutex); // Wait until the buffer is not empty
    }

    int item = buffer->items[buffer->count - 1]; // Get the last item from the buffer
    buffer->count--; // Decrement the count of items in the buffer
    printf("Consumed item: %d\n", item); // Print the consumed item

    pthread_cond_signal(&buffer->not_full_cond); // Signal that the buffer is not full
    pthread_mutex_unlock(&buffer->mutex); // Unlock the mutex

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
    pthread_t prod_thread, cons_thread;

    initialize_buffer(&buffer); // Initialize the shared buffer

    // Create producer and consumer threads
    pthread_create(&prod_thread, NULL, producer_thread, NULL);
    pt
