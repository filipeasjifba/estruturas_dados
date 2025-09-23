package Lista2;

import java.util.Scanner;

public class Questao16 {
    public static void main(String[] args) {
        int[] array = {12,23,78,12,56,91,43,62,43,21};
        Scanner scanner = new Scanner(System.in);
        int index = -1;

        System.out.print("Digite um valor: ");
        int valor = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < array.length; i++) {
            if (valor == array[i]){
                index = i;
            }            
        }
        System.out.print("Índice: " + index);
    }
}
