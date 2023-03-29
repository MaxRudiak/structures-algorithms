package com.rudiak.structures.queue;

import java.util.NoSuchElementException;

public class BoundedArrayQueue<E> implements Queue<E> {

    private final Object[] elements;
    private int headIndex;
    private int tailIndex;
    private int numOfElem;

    public BoundedArrayQueue(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity should be 1 or more!");
        }
        elements = new Object[capacity];
    }

    @Override
    public void enqueue(E element) {
        if (numOfElem == elements.length) {
            throw new IllegalArgumentException("Queue is full!");
        }
        elements[tailIndex] = element;
        tailIndex++;
        if (tailIndex == elements.length) {
            tailIndex = 0;
        }
        numOfElem++;
    }

    @Override
    public E dequeue() {
        E element = getElementFromHead();
        elements[headIndex] = null;
        headIndex++;
        if (headIndex == elements.length) {
            headIndex = 0;
        }
        numOfElem--;
        return element;
    }

    private E getElementFromHead() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E element = (E) elements[headIndex];
        return element;
    }

    @Override
    public E peek() {
        return getElementFromHead();
    }

    @Override
    public boolean isEmpty() {
        return numOfElem == 0;
    }
}
