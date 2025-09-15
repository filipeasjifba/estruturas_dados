//Aluno: Filipe Alves sousa Julio

import java.util.Scanner;

public class Questao8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] idade = new int [5];
        double[] altura = new double [5];

        for (int i = 0; i < 5; i++) {
            System.out.print("digite a idade da " + (i+1) +"º pessoa: ");
            idade[i] = scanner.nextInt();
            System.out.print("digite a altura da " + (i+1) + "º pessoa: ");
            altura[i] = scanner.nextDouble();
        }

        for (int i = 4; i >= 0; i--) {
            System.out.println((i+1) + "º pessoa: " + idade[i] + " anos / " + altura[i]);
        }
    }
}