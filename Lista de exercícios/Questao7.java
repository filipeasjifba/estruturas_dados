//Aluno: Filipe Alves sousa Julio

import java.util.Arrays;
import java.util.Scanner;

public class Questao7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] v = new int [5];
        int soma = 0;
        int produto = 1;

        for (int i = 0; i < 5; i++) {
            System.out.print("Insira o " + (i+1) + "º valor: ");
            v[i] = scanner.nextInt();
            soma += v[i];
            produto *= v[i];
        }

        System.out.println("Soma: "+soma);
        System.out.println("Produto: "+produto);
        System.out.println("Valores:" + Arrays.toString(v));
    }
    
}
