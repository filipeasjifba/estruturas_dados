package Lista2;

import java.util.Scanner;

public class Questao32 {
    public static void main(String[] args) {
        int[] array = {11,2,3,10,36,92};
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o valor que você quer encontrar: ");
        int n = scanner.nextInt();
        int resultado = buscaBinaria(array, n);

        if(resultado != -1){
            System.out.print("O valor " + n + " está no indíce " + resultado);
        } else {
            System.out.println("O valor não foi encontrado");
        }
    }

    public static int buscaBinaria (int[] array, int n){
        int esquerda = 0;
        int direita = array.length-1;

        while (esquerda <= direita){
            int meio = (esquerda+direita)/2;

            if(array[meio] == n){
                return meio;
            } else if (array[meio] < n){
                esquerda = meio +1;
            } else {
                direita = meio - 1;
            }
        }
        return -1;
    }
}
