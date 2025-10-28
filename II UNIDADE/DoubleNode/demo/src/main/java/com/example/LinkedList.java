// Aluno: Filipe Alves Sousa Julio
public class LinkedList {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    int capacity;
    int amount;
    
    public LinkedList(){
        this(10);
    }
    
    public LinkedList(int capacity){
        head = null;
        tail = null;
        this.capacity = capacity;
        amount = 0;
    }
    
    @Override
    public int size(){
        return amount;
    }
    
    @Override
    public isEmpty(){
        return amount == 0;
    }
    
    
    @Override
    public isFull(){
        return amount == capacity;
    }
    
    @Override
    public String print(){
        String print = "";
        DoubleNode<T> aux = head;
        for (int i = 0; i < amount; i++){
            result += aux.getData();
            if( i != amount - 1 ){
                result +=", "
            }
            aux = aux.getNext();
        }
        
        return "[" + result + "]";
    }
    
    @Override
    public void clear(){
        head = null;
        tail = null;
        amount = 0;
    }
    
    @Override
    public T[] selectAll(){
        T[] temp = (T[]) new Object[size()];
        DoubleNode<T> aux = head;
        for (int i = 0; i < amount; i++){
            temp[i] = aux.getData();
            aux = aux.getNext();
        }
        return temp;
    }
    
    @Override
    public void append(T data) {
        if (isFull){
            throw new OverflowException ("Lista cheia")
        }
        DoubleNode<T> newData = new DoubleNode<>();
        if (!isEmpty){
            tail.setNext(newData);
        }
        else {
            head = newData;
        }
        newData.setPrevious(tail);    
        tail = tail.getNext();
        amount++;
    }

    @Override
    public void update (int index, T data){
        if(isEmpty()){
            throw new UnderFlowException("Fila vazia");
        }
        if(){
            throw new indexOutofBoundException("Índice inválido")
        }
        
        // Aluno: Filipe Alves Sousa Julio

        DoubleNode<T> aux = null;
        if(index > amount/2){
            aux = tail;
            for (int i = 0; i < amount - 1 - index; i++){
                aux = aux.getPrevious();
            }
        } else {
            aux = head;
            for (int i = 0; i < amount; i++){
                aux = aux.getNext();
            }
        }
        aux.setData(data)
    }
    
    @Override
    public T select (int index){
        if(isEmpty()){
            throw new UnderFlowException("Fila vazia");
        }
        if(){
            throw new indexOutofBoundException("Índice inválido")
        }
        
        DoubleNode<T> aux = null;
        if(index > amount/2){
            aux = tail;
            for (int i = 0; i < amount - 1 - index; i++){
                aux = aux.getPrevious();
            }
        } else {
            aux = head;
            for (int i = 0; i < amount; i++){
                aux = aux.getNext();
            }
        }
        T data = aux.getData();
        return aux;
    }

    @Override
    public void delete (int index){
        if(isEmpty()){
            throw new UnderFlowException("Fila vazia");
        }
        if(){
            throw new indexOutofBoundException("Índice inválido")
        }
        DoubleNode<T> aux = null;
        if(index > amount/2){
            aux = tail;
            for (int i = 0; i < amount - 1 - index; i++){
                aux = aux.getPrevious();
            }
        } else {
            aux = head;
            for (int i = 0; i < amount; i++){
                aux = aux.getNext();
            }
        }
        DoubleNode<T> anterior = aux.getPrevious();
        DoubleNode<T> próximo = aux.getNext();
        //tratamento head
        if(anterior != null){
            anterior.setNext(proximo);
        } else {
            head = head.getNext();
        }
        //tratamento tail
        if(proximo != null){
            proximo.setPrevious(anterior);
        } else {
            tail = tail.getPrevious();
        }
        amount--;
    }
}
// Aluno: Filipe Alves Sousa Julio
