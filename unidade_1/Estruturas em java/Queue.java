// Exemplo de fila circular em java

public class Queue {
    private Object[] elementos;
    private int tamanho;
    private int capacidade;
    private int frente;
    private int tras;

    public Queue(int capacidade){
        this.capacidade = capacidade;
        this.elementos = new Object[capacidade];
        this.tamanho = 0;
        this.frente = 0;
        this.tras = -1;
    }

    public void enqueue(Object valor){
        if(isFull()){
            throw new IllegalStateException("Queue cheia");
        }
        tras = (tras + 1) % capacidade;
        elementos[tras] = valor;
        tamanho++;
        System.out.println("Valor "+valor+" enfileirado!");
    }

    public Object dequeue(){
        if(isEmpty()){
            throw new IllegalStateException("Queue vazia");
        }
        Object valor = elementos[frente];
        frente = (frente + 1) % capacidade;
        tamanho--;
        System.out.println("Valor "+valor+" desenfileirado!");
        return valor;
    }

    public void mostrarFila(){
        if(isEmpty()){
            System.out.println("Queue vazia");
            return;
        }
        for(int i=0; i < tamanho; i++){
            int indice = (frente + i) % capacidade;
            System.out.println("Elemento na posição " + i + ": " + elementos[indice]);
        }
    }

    public boolean isFull(){
        return tamanho == capacidade;
    }

    public boolean isEmpty(){
        return tamanho == 0;
    }

    public int size(){
        return tamanho;
    }
    
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.mostrarFila();
        System.out.println("Tamanho atual da queue: " + queue.size());
        while (!queue.isEmpty()) {
            queue.dequeue();
        }
    }
}