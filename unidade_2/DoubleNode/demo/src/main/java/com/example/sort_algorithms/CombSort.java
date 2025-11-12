package com.example.sort_algorithms;

import java.util.Random;

public class CombSort {
    public static void main(String[] args) {
       
        executarCombSort(100000);
    }

    public static void executarCombSort(int tamanho) {
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

        // Ordena usando Comb Sort
        combSort(numeros);

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

    // Implementação do Comb Sort
    public static void combSort(int[] arr) {
        int tamanho = arr.length;
        int gap = tamanho; // distância inicial entre elementos
        boolean trocado = true;

        while (gap > 1 || trocado) {
            // Reduz o gap usando fator 1.3
            gap = (int) (gap / 1.3);
            if (gap < 1) gap = 1;

            trocado = false;

            for (int i = 0; i + gap < tamanho; i++) {
                if (arr[i] > arr[i + gap]) {
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    trocado = true;
                }
            }
        }
    }
}