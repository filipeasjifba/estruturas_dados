package Lista2;

import java.util.Arrays;
import java.util.Scanner;

public class Questao29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma quantidade n de números Lucas: ");
        int n = scanner.nextInt();
        int[] lucas = new int[n];

        lucas[0] = 2;
        lucas[1] = 1;

        for (int i = 2; i < n; i++) {
            lucas[i] = lucas[i-2]+lucas[i-1];
        }

        System.out.print("Sequência de Lucas: " + Arrays.toString(lucas));
    }
}
