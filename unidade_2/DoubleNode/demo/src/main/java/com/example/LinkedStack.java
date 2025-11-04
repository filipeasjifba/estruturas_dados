// FIlipe Alves Sousa Julio
package com.example;
import java.util.NoSuchElementException;

/**
 * Implementação de uma pilha usando nós duplamente encadeados.
 * @param <T> tipo genérico dos dados armazenados na pilha
 */
public class LinkedStack<T> implements Stackable<T> {
    
    // Topo da pilha
    private DoubleNode<T> topPointer;
    
    // Quantidade atual de elementos 
    private int numberElements;
    
    // Máximo de elementos que a pilha pode ter
    private int maxElements;
    
    /**
     * Construtor que define a capacidade máxima da pilha
     * @param maxElements número máximo de elementos
     */
    
    public LinkedStack(int maxElements) {
        this.topPointer = null;
        this.numberElements = 0;
        this.maxElements = maxElements;
    }
    
    /**
     * Verifica se a pilha está vazia
     * @return true se estiver vazia, false caso contrário
     */
    public boolean isEmpty() {
        return numberElements == 0;
    }

    /**
     * Verifica se a pilha está cheia
     * @return true se estiver cheia, false caso contrário
     */
    public boolean isFull() {
        return numberElements == maxElements;
    }
    
    /**
     * Retorna o elemento do topo da pilha sem removê-lo
     * @return elemento do topo
     * @throws noSuchElementException
     */
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Pilha está vazia");
        }
        return topPointer.getData();
    }

    /**
     * Remove e retorna o elemento do topo da pilha
     * @return elemento removido
     */
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Pilha vazia");
        }
        numberElements--;
        T auxData = topPointer.getData();
        topPointer.getPrevious();
        topPointer.setNext(null);
        return auxData;
    }

    /**
     * Insere um novo elemento no topo da pilha
     * @param data o dado a ser inserido
     * throws noSuchElementException
     */
    @Override
    public void push(T data) {
        if (isFull()){
            throw new NoSuchElementException("Pilha cheia");
        }
        DoubleNode<T> newNode= new DoubleNode<>();
        newNode.setData(data);
        topPointer.setNext(newNode);
        newNode.setPrevious(topPointer);
        topPointer = newNode;
        numberElements++;
    }

    /**
     * Atualiza o valor do elemento no topo da pilha
     * @param newData novo valor a ser colocado no topo
     * throws noSuchElementExcpetion
     */
    public void update(T newData) {
        pop();
        push(newData);
    }


    /**
     * Retorna uma representação em string da pilha
     * @return string contendo os elementos da pilha
     */
    public String print() {
        StringBuilder result = new StringBuilder("[");
        DoubleNode<T> auxPointer = topPointer;

        while (auxPointer != null) {
            result.append(auxPointer.getData());

            // Adiciona vírgula se houver próximo elemento
            if (auxPointer.getPrevious() != null) {
                result.append(", ");
            }

            auxPointer = auxPointer.getPrevious(); // anda para trás na pilha
        }

        result.append("]");
        return result.toString();
    }


}
