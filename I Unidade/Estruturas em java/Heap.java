public class Heap {
    private int[] heap;      // array que armazena os elementos
    private int tamanho;     // quantidade atual de elementos
    private int capacidade;  // tamanho máximo da heap

    // 🔹 CREATE — Construtor
    public Heap(int capacidade) {
        this.capacidade = capacidade;
        this.heap = new int[capacidade];
        this.tamanho = 0;
    }

    // 🔹 CREATE — Inserir um novo elemento (add)
    public void insert(int valor) {
        if (tamanho == capacidade) {
            System.out.println("Heap cheia! Não é possível adicionar " + valor);
            return;
        }

        heap[tamanho] = valor;   // adiciona no final
        tamanho++;
        subir(tamanho - 1);      // ajusta a posição do novo elemento
        System.out.println("Valor " + valor + " inserido na heap.");
    }

    // 🔹 READ — Ver o maior elemento (topo da heap)
    public int peek() {
        if (isEmpty()) {
            System.out.println("⚠️ Heap vazia!");
            return -1;
        }
        return heap[0];
    }

    // 🔹 UPDATE — Atualizar o valor em um índice específico
    public void update(int indice, int novoValor) {
        if (indice < 0 || indice >= tamanho) {
            System.out.println("⚠️ Índice inválido!");
            return;
        }

        int valorAntigo = heap[indice];
        heap[indice] = novoValor;
        System.out.println("🔁 Atualizando valor " + valorAntigo + " para " + novoValor);

        // se o novo valor for maior, sobe; se menor, desce
        if (novoValor > valorAntigo) {
            subir(indice);
        } else {
            descer(indice);
        }
    }

    // 🔹 DELETE — Remover o maior elemento (raiz)
    public int remove() {
        if (isEmpty()) {
            System.out.println("⚠️ Heap vazia! Nada para remover.");
            return -1;
        }

        int removido = heap[0];
        heap[0] = heap[tamanho - 1];  // último elemento vira a raiz
        tamanho--;
        descer(0);                    // ajusta para restaurar a propriedade da heap
        System.out.println("🗑️ Valor " + removido + " removido da heap.");
        return removido;
    }

    // 🔹 READ — Mostrar todos os elementos
    public void mostrarHeap() {
        if (isEmpty()) {
            System.out.println("⚠️ Heap vazia!");
            return;
        }

        System.out.print("📦 Conteúdo da heap: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // 🔹 Métodos auxiliares
    private boolean isEmpty() {
        return tamanho == 0;
    }

    private int pai(int i) {
        return (i - 1) / 2;
    }

    private int filhoEsquerdo(int i) {
        return 2 * i + 1;
    }

    private int filhoDireito(int i) {
        return 2 * i + 2;
    }

    // 🔹 Função para mover o elemento para cima (heapify-up)
    private void subir(int i) {
        while (i > 0 && heap[pai(i)] < heap[i]) {
            trocar(i, pai(i));
            i = pai(i);
        }
    }

    // 🔹 Função para mover o elemento para baixo (heapify-down)
    private void descer(int i) {
        int maior = i;
        int esq = filhoEsquerdo(i);
        int dir = filhoDireito(i);

        if (esq < tamanho && heap[esq] > heap[maior])
            maior = esq;
        if (dir < tamanho && heap[dir] > heap[maior])
            maior = dir;

        if (maior != i) {
            trocar(i, maior);
            descer(maior);
        }
    }

    private void trocar(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
    
    public static void main(String[] args) {
        Heap minhaHeap = new Heap(10);
        
        minhaHeap.insert(20);
        minhaHeap.insert(15);
        minhaHeap.insert(30);
        minhaHeap.mostrarHeap();
        
        System.out.println("Maior elemento (topo): " + minhaHeap.peek());

        minhaHeap.update(1, 35);
        minhaHeap.mostrarHeap();
        
        minhaHeap.remove();
        minhaHeap.mostrarHeap();
    }
}
