package com.rudiak.structures.deque;

public interface Deque<E> {

    void enqueueFront(E element);

    void enqueueBack(E element);

    E dequeueFront();

    E dequeueBack();

    E peekFront();

    E peekBack();

    boolean isEmpty();
}
