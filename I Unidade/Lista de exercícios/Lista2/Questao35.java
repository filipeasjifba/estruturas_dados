package Lista2;

import java.util.Arrays;
import java.util.Scanner;

public class Questao35 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int[] arrayNovo = new int[array.length-1];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Array: " + Arrays.toString(array));
        System.out.print("Digite a posicao do valor a ser removido: ");
        int posicao = scanner.nextInt();

        if(posicao>=0 && posicao<array.length){
            System.arraycopy(array, 0, arrayNovo, 0, posicao);
            System.arraycopy(array, posicao+1, arrayNovo, posicao, arrayNovo.length-posicao);
            System.out.println("Novo array: " + Arrays.toString(arrayNovo));
        } else {
            System.err.println("Posição inválida");
        }
    }
}
