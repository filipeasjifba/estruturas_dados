package Lista2;

import java.util.Scanner;

public class Questao08 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite um valor específico para a multiplicação: ");
            int valor = scanner.nextInt();
            scanner.nextLine();
            for (int i=0; i<array.length; i++){
                System.out.println(array[i] + " x " + valor + " = " + array[i]*valor);
            }
        }
    }
}
