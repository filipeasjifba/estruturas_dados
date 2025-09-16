// Aluno: Filipe Alves Sousa Julio

import java.util.Scanner;

public class Questao3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] notas = new double [4];
        double media = 0;
        
        for (int i=0; i<4; i++){
            System.out.print("Digite a " + (i+1) + "° nota: ");
            notas[i] = scanner.nextDouble();
            media += notas[i];
        }
        System.out.println("----------------------------------");
        for (int i=0; i<4; i++){
            System.out.println((i+1) + "° nota = " + notas[i]);
        }
        System.out.println("A média das notas é igual a " + (media/4));
    }
}
