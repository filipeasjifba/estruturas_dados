// Aluno: Filipe Alves Sousa Julio

import java.util.Scanner;

public class Questao01{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] v = new int[5];

        for(int i=0;i<5;i++){
            System.out.print("Digite o " + (i+1) + "º valor: ");
            v[i] = scanner.nextInt();
        }

        System.out.println("-------------------------------");

        for(int i=0;i<5;i++){
            System.out.print((i+1) + "º valor: " + v[i] + " / ");
        }
        scanner.close();
    }
}
