package com.rudiak.structures.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeStack<E> implements Stack<E> {
    private final Deque<E> deque = new ArrayDeque<>();

    @Override
    public void push(E element) {
        deque.addFirst(element);
    }

    @Override
    public E pop() {
        return deque.removeFirst();
    }

    @Override
    public E peek() {
        return deque.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return deque.isEmpty();
    }
}
