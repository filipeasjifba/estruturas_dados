package Lista2;

import java.util.Arrays;
import java.util.Scanner;

public class Questao28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma quantidade n de números Fibonacci: ");
        int n = scanner.nextInt();
        int[] fibonacci = new int[n];

        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i-2] + fibonacci[i-1];            
        }

        System.out.print("Fibonacci: " + Arrays.toString(fibonacci));

    }
}