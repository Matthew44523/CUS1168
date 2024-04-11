//Matthew Frankowski
//CUS 1168
//Assignment 12: Part 1
//Write an Ada or C task to implement general semaphores.

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

#define BUFFER_SIZE 5

// Structure representing the shared buffer
typedef struct {
    int items[BUFFER_SIZE];     //Array to store items
    int count;                  //Number of items in the buffer
    semaphore_t lock;           //Protect buffer access
    semaphore_t empty_slots;    //Track empty slots in the buffer
    semaphore_t filled_slots;   //Store filled slots in the buffer
} buffer_t;

buffer_t buffer;    

// Initialize the shared buffer
void initialize_buffer(buffer_t *buffer) {
    buffer->count = 0;
    sem_init(&buffer->lock, 1);           
    sem_init(&buffer->empty_slots, BUFFER_SIZE);
    sem_init(&buffer->filled_slots, 0);    //Initialize filled_slots
}

//Produce items and add them to the buffer
void produce_item(buffer_t *buffer, int item) {
    sem_wait(&buffer->empty_slots);     //Wait for an empty slot
    sem_wait(&buffer->lock);            //Then lock the buffer
    
    // Add item to the buffer
    buffer->items[buffer->count] = item;
    buffer->count++;
    printf("Produced item: %d\n", item);
    
    sem_post(&buffer->lock);            //Unlock the buffer
    sem_post(&buffer->filled_slots);    //Signal that a slot is filled
}

//Consume items from the buffer
int consume_item(buffer_t *buffer) {
    sem_wait(&buffer->filled_slots);    //Wait for a filled slot
    sem_wait(&buffer->lock);            //Lock the buffer
    
    // Remove item from the buffer
    int item = buffer->items[buffer->count - 1];
    buffer->count--;
    printf("Consumed item: %d\n", item);
    
    sem_post(&buffer->lock);            //Unlock the buffer
    sem_post(&buffer->empty_slots);     //Signal that a slot is empty
    
    return item;
}

//Producer thread function
void *producer_thread(void *arg) {
    int i;
    for (i = 0; i < 10; i++) {
        produce_item(&buffer, i);
        sleep(1); //Simulate production time
    }
    return NULL;
}

//Consumer thread function
void *consumer_thread(void *arg) {
    int i;
    for (i = 0; i < 10; i++) {
        int item = consume_item(&buffer);
        //Process consumed item
        sleep(1); //Simulate processing time
    }
    return NULL;
}

int main() {
    pthread_t producer, consumer;

    initialize_buffer(&buffer);

    pthread_create(&producer, NULL, producer_thread, NULL);
    pthread_create(&consumer, NULL, consumer_thread, NULL);

    pthread_join(producer, NULL);
    pthread_join(consumer, NULL);

    sem_destroy(&buffer.lock);
    sem_destroy(&buffer.empty_slots);
    sem_destroy(&buffer.filled_slots);

    return 0;
}