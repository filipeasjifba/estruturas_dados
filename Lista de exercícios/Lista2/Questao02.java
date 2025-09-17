//Aluno: Filipe Alves sousa Julio
package Lista2;

import java.util.Scanner;
public class Questao02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\ninforme até que número devo calcular o quadrado: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        double[] quadrado = new double[numero];

        for (int i=0; i<numero; i++){
            quadrado[i] = Math.pow((i+1), 2);
        }
        for (int i=0; i<numero;i++){
            System.out.println((i+1) + "² = " + quadrado[i]);
        }
    }
}
