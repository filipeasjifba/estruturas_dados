//Aluno: Filipe Alves sousa Julio

import java.util.Scanner;

public class Questao09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));
        int[] a = new int[10];
        int soma = 0;
        for(int i=0;i<10;i++){
            System.out.print("Digite o " + (i+1) + "º valor: ");
            a[i] = scanner.nextInt();
            a[i] *=a [i];
        }
        for (int i = 0; i < 10; i++) {
            soma += a[i];
        }
        System.out.print("A soma dos quadrados é: " + soma);
    }
}
