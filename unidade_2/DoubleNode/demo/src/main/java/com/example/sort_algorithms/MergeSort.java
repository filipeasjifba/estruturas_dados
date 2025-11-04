import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {

        executarMergeSort(100);
    }

    public static void executarMergeSort(int tamanho) { 
        int[] numeros = new int[tamanho];
        Random random = new Random();

        // Preenche o vetor com números aleatórios entre 1 e 100
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(100) + 1;
        }

        // Exibe o vetor antes da ordenação
        System.out.print("Vetor antes da ordenação: ");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Marca o tempo inicial
        long tempoInicio = System.nanoTime();

        // Ordena usando Merge Sort
        mergeSort(numeros, 0, numeros.length - 1);

        // Marca o tempo final
        long tempoFim = System.nanoTime();

        // Calcula o tempo de execução
        long duracaoNano = tempoFim - tempoInicio;
        double duracaoMili = duracaoNano / 1_000_000.0;

        // Exibe o vetor ordenado
        System.out.print("Vetor ordenado: ");
        for (int num : numeros) {
            System.out.print(num + " ");
        }

        // Exibe o tempo de execução
        System.out.println("\n\nTempo de execução:");
        System.out.println(duracaoNano + " nanossegundos");
        System.out.println(duracaoMili + " milissegundos");
    }

    // ---------- Implementação do Merge Sort ----------
    public static void mergeSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio + 1, fim);
            merge(vetor, inicio, meio, fim);
        }
    }

    public static void merge(int[] vetor, int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        int[] esquerda = new int[n1];
        int[] direita = new int[n2];

        // Copia os elementos para os vetores auxiliares
        for (int i = 0; i < n1; i++)
            esquerda[i] = vetor[inicio + i];
        for (int j = 0; j < n2; j++)
            direita[j] = vetor[meio + 1 + j];

        int i = 0, j = 0, k = inicio;

        // Intercala os vetores
        while (i < n1 && j < n2) {
            if (esquerda[i] <= direita[j]) {
                vetor[k] = esquerda[i];
                i++;
            } else {
                vetor[k] = direita[j];
                j++;
            }
            k++;
        }

        // Copia o restante dos elementos
        while (i < n1) {
            vetor[k] = esquerda[i];
            i++;
            k++;
        }

        while (j < n2) {
            vetor[k] = direita[j];
            j++;
            k++;
        }
    }
}
