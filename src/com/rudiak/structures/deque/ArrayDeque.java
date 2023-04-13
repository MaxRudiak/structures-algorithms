package com.rudiak.structures.deque;

import java.util.NoSuchElementException;

public class ArrayDeque<E> implements Deque<E> {

    private final Object[] elements;
    private int headIndex;
    private int tailIndex;
    private int numOfElements;

    public ArrayDeque(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("capacity should be more than 1");
        }
        elements = new Object[capacity];
    }

    @Override
    public void enqueueFront(E element) {
        if (numOfElements == elements.length) {
            throw new IllegalStateException("Deque is full");
        }
        headIndex = decreaseIndex(headIndex);
        elements[headIndex] = element;
        numOfElements++;
    }

    @Override
    public void enqueueBack(E element) {
        if (numOfElements == elements.length) {
            throw new IllegalStateException("Deque is full");
        }
        elements[tailIndex] = element;
        tailIndex = increaseIndex(tailIndex);
        numOfElements++;
    }

    @Override
    public E dequeueFront() {
        final E element = elementAtHead();
        elements[headIndex] = null;
        headIndex = increaseIndex(headIndex);
        numOfElements--;
        return element;
    }

    @Override
    public E dequeueBack() {
        final E element = elementAtTail();
        tailIndex = decreaseIndex(tailIndex);
        elements[tailIndex] = null;
        numOfElements--;
        return  element;
    }

    @Override
    public E peekFront() {
        return elementAtHead();
    }

    @Override
    public E peekBack() {
        return elementAtTail();
    }

    @Override
    public boolean isEmpty() {
        return numOfElements == 0;
    }


    private int decreaseIndex(int index) {
        index--;
        if (index < 0) {
            index = elements.length - 1;
        }
        return index;
    }

    private int increaseIndex(int index) {
        index++;
        if (index == elements.length) {
            index = 0;
        }
        return index;
    }

    private E elementAtHead() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (E) elements[headIndex];
    }


    private E elementAtTail() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (E) elements[decreaseIndex(tailIndex)];
    }
}
