package com.rudiak.structures.stack;

import java.util.NoSuchElementException;

public class BoundedArrayStack<E> implements Stack<E> {

    private final Object[] elements;
    private int numberOfElements;

    public BoundedArrayStack(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity should be 1 or more");
        }
        elements = new Object[capacity];
    }

    @Override
    public void push(E element) {
        if (numberOfElements == elements.length) {
            throw new IllegalArgumentException("Stack is full");
        }
        elements[numberOfElements] = element;
        numberOfElements++;
    }

    @Override
    public E pop() {
        E element = getElementAtTop();
        elements[numberOfElements - 1] = null;
        numberOfElements--;
        return element;
    }

    private E getElementAtTop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (E) elements[numberOfElements - 1];
    }

    @Override
    public E peek() {
        return getElementAtTop();
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }
}
