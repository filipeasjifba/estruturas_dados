package com.example;

public interface DEQueable<T> {
    void beginEnqueue(T data);  //C
    void enqueue(T data);       //C
    T front();                  //R
    T rear();                   //R
    void beginUpdate(T data);   //U
    void endUpdate(T data);     //U
    T dequeue();                //D
    T endDequeue();             //D


    boolean isEmpty();
    boolean isFull();
    String print();
    String printEndToBegin();
    int amount();
}