package com.example;

// Aluno: Filipe Alves Sousa Julio
public class LinkedList<T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int capacity;
    private int amount;

    public LinkedList() {
        this(10);
    }

    public LinkedList(int capacity) {
        this.head = null;
        this.tail = null;
        this.capacity = capacity;
        this.amount = 0;
    }

    public int size() {
        return amount;
    }

    public boolean isEmpty() {
        return amount == 0;
    }

    public boolean isFull() {
        return amount == capacity;
    }

    public String print() {
        String result = "";
        DoubleNode<T> aux = head;
        for (int i = 0; i < amount; i++) {
            result += aux.getData();
            if (i != amount - 1) {
                result += ", ";
            }
            aux = aux.getNext();
        }
        return "[" + result + "]";
    }

    public void clear() {
        head = null;
        tail = null;
        amount = 0;
    }

    @SuppressWarnings("unchecked")
    public T[] selectAll() {
        T[] temp = (T[]) new Object[size()];
        DoubleNode<T> aux = head;
        for (int i = 0; i < amount; i++) {
            temp[i] = aux.getData();
            aux = aux.getNext();
        }
        return temp;
    }

    public void append(T data) {
        if (isFull()) {
            throw new RuntimeException("Lista cheia");
        }   
        DoubleNode<T> newData = new DoubleNode<>(data);
        if (!isEmpty()) {
            tail.setNext(newData);
            newData.setPrevious(tail);
            tail = newData;
        } else {
            head = tail = newData;
        }
        amount++;
    }

    public void update(int index, T data) {
        if (isEmpty()) {
            throw new RuntimeException("Fila vazia");
        }
        if (index < 0 || index >= amount) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        DoubleNode<T> aux;
        if (index > amount / 2) {
            aux = tail;
            for (int i = amount - 1; i > index; i--) {
                aux = aux.getPrevious();
            }
        } else {
            aux = head;
            for (int i = 0; i < index; i++) {
                aux = aux.getNext();
            }
        }
        aux.setData(data);
    }

    public T select(int index) {
        if (isEmpty()) {
            throw new RuntimeException("Lista vazia");
        }
        if (index < 0 || index >= amount) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        DoubleNode<T> aux;
        if (index > amount / 2) {
            aux = tail;
            for (int i = amount - 1; i > index; i--) {
                aux = aux.getPrevious();
            }
        } else {
            aux = head;
            for (int i = 0; i < index; i++) {
                aux = aux.getNext();
            }
        }
        return aux.getData();
    }

    public void delete(int index) {
        if (isEmpty()) {
            throw new RuntimeException("Fila vazia");
        }
        if (index < 0 || index >= amount) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        DoubleNode<T> aux;
        if (index > amount / 2) {
            aux = tail;
            for (int i = amount - 1; i > index; i--) {
                aux = aux.getPrevious();
            }
        } else {
            aux = head;
            for (int i = 0; i < index; i++) {
                aux = aux.getNext();
            }
        }

        DoubleNode<T> anterior = aux.getPrevious();
        DoubleNode<T> proximo = aux.getNext();

        if (anterior != null) {
            anterior.setNext(proximo);
        } else {
            head = proximo;
        }

        if (proximo != null) {
            proximo.setPrevious(anterior);
        } else {
            tail = anterior;
        }

        amount--;
    }

    public int getMaxCapacity(){
        return capacity;
    }
}
// Aluno: Filipe Alves Sousa Julio
