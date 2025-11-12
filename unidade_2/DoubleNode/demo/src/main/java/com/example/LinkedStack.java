package com.example;

import java.util.NoSuchElementException;

public class LinkedStack<T> implements Stackable<T> {

    private DoubleNode<T> topPointer;
    private int numberElements;
    private int maxElements;

    public LinkedStack(int maxElements) {
        this.topPointer = null;
        this.numberElements = 0;
        this.maxElements = maxElements;
    }

    public boolean isEmpty() {
        return numberElements == 0;
    }

    public boolean isFull() {
        return numberElements == maxElements;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Pilha está vazia");
        }
        return topPointer.getData();
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Pilha vazia");
        }
        T auxData = topPointer.getData();
        topPointer = topPointer.getPrevious();
        if (topPointer != null) {
            topPointer.setNext(null);
        }
        numberElements--;
        return auxData;
    }

    @Override
    public void push(T data) {
        if (isFull()) {
            throw new NoSuchElementException("Pilha cheia");
        }
        DoubleNode<T> newNode = new DoubleNode<>(data);
        if (topPointer != null) {
            topPointer.setNext(newNode);
            newNode.setPrevious(topPointer);
        }
        topPointer = newNode;
        numberElements++;
    }

    public void update(T newData) {
        if (isEmpty()) {
            throw new NoSuchElementException("Pilha vazia");
        }
        pop();
        push(newData);
    }

    public String print() {
        StringBuilder result = new StringBuilder("[");
        DoubleNode<T> auxPointer = topPointer;
        while (auxPointer != null) {
            result.append(auxPointer.getData());
            if (auxPointer.getPrevious() != null) {
                result.append(", ");
            }
            auxPointer = auxPointer.getPrevious();
        }
        result.append("]");
        return result.toString();
    }

    public int size(){
        return numberElements;
    }
}
