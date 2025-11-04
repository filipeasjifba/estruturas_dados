package com.example;

public interface Queueable<T> {
    void enqueue(T item);
    T dequeue();
    boolean isEmpty();
}
