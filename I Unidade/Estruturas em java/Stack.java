public class Stack {
    private Object[] elementos;
    private int topo;
    private int capacidade;

    public Stack(int capacidade){
        this.capacidade = capacidade;
        this.elementos = new Object[capacidade];
        this.topo = -1; // está vazia
    }
    
    public void push(Object valor){
        if (topo == capacidade -1){
            throw new StackOverflowError("Stack cheia");
        }
        elementos[topo+1] = valor;
        topo++;
        System.out.println("Valor "+valor+" empilhado!");
    }

    public Object peek (){
        if (topo == -1){
            throw new IllegalStateException("Stack vazia");
        }
        return elementos[topo];
    }

    public Object pop (){
        if (topo == -1){
            throw new IllegalStateException("Stack vazia");
        }
        Object valor = elementos[topo];
        topo--;
        System.out.println("Valor "+valor+" desempilhado!");
        return valor;
    }

    public boolean isEmpty (){
        return topo == -1;
    }

    public int size (){
        return topo + 1;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Topo da stack: " + stack.peek());
        System.out.println("Tamanho atual da stack: " + stack.size());
        while (!stack.isEmpty()) {
            stack.pop();
        }
    }

}
