package com.rudiak.structures.queue;

public interface Queue<E> {

    /**
     * Insert the element at the tail of the queue.
     * @param element to insert
     */
    void enqueue(E element);

    /**
     * Remove the element from the head of the queue.
     * @return removed element
     */
    E dequeue();

    /**
     * Return the element from the head of the queue without removal.
     * @return the element from the head
     */
    E peek();

    boolean isEmpty();
}
