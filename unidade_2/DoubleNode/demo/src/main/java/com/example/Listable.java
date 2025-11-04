/**
 * Esta interface define as operações genéricas de uma lista dinâmica
 * Esta interface define os métodos que devem ser implementados
 * 
 *
 * @param <T> o tipo dos elementos armazenados na lista
 * @author Filipe Alves Sousa Julio
 * @version 1.0
 * @since 2025-11-03
 */
public interface Listable<T> {
    void append(T data);
    void insert(int index, T data);
    T select(int index);
    T[] selectAll();
    void update(int index, T data);
    T delete(int index);
    void clear();

    int size();
    boolean isEmpty();
    boolean isFull();
    String print();
}