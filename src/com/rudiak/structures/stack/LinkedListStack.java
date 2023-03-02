package com.rudiak.structures.stack;

import java.util.NoSuchElementException;

public class LinkedListStack<E> implements Stack<E> {

    private Node<E> top;

    @Override
    public void push(E element) {
        top = new Node<>(element, top);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E element = top.element;
        top = top.next;
        return element;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return top.element;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    private static class Node<E> {
        final E element;
        final Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}
