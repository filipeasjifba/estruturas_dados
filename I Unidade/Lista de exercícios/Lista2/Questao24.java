package Lista2;

import java.util.Arrays;
import java.util.Scanner;

public class Questao24 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int valor = scanner.nextInt();
        System.out.print("Digite o indíce de posição em que seu valor será inserido: ");
        int posicao = scanner.nextInt();

        if (posicao >=0 && posicao<=array.length){
            int[] arrayNovo = new int[array.length+1];

            for (int i = 0; i < posicao; i++) {
                arrayNovo[i] = array[i];
            }

            arrayNovo[posicao] = valor;

            for (int i = posicao; i < array.length; i++) {
                arrayNovo[i+1] = array[i];
            }

            System.out.println("Array novo: " + Arrays.toString(arrayNovo));

        } else {
            System.out.println("Posição inválida, pai");
        }
    }
}
