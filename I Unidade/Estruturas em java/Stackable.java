public interface Stackable {
    void push(Object valor);
    Object peek();
    Object pop();
    boolean isEmpty();
    int size();
}
