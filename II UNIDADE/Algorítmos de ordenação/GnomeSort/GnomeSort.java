import java.util.Random;

public class GnomeSort {
    public static void main(String[] args) {
        // Chama o método que gera, ordena e mede o tempo do vetor
        executarGnomeSort(1000000);
    }

     /**
     * Método para testar a ordenação:
     * - criação do vetor aleatório
     * - ordenação com Gnome Sort
     * - exibição do vetor antes e depois
     * - medição do tempo de execução
     * @param tamanho tamanho do vetor a ser gerado
     */
    public static void executarGnomeSort(int tamanho) {
        int[] numeros = new int[tamanho]; // Cria o vetor
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

        // Ordena usando Gnome Sort
        gnomeSort(numeros);

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

    // Implementação do Gnome Sort
    public static void gnomeSort(int[] arr) {
        int indice = 0;

        while (indice < arr.length) {
            if (indice == 0 || arr[indice] >= arr[indice - 1]) {
                indice++;
            } else {
                int temp = arr[indice];
                arr[indice] = arr[indice - 1];
                arr[indice - 1] = temp;
                indice--;
            }
        }
    }
}

