package Lista2;

import java.util.Arrays;
import java.util.Scanner;

public class Questao34 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int[] arrayNovo = new int[array.length+1];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Array: " + Arrays.toString(array));
        System.out.print("Digite o valor que você quer inserir: ");
        int valor = scanner.nextInt();
        System.out.print("Digite a posição em que você quer inserir: ");
        int posicao = scanner.nextInt();
        
        if(posicao>=0 && posicao<=array.length){
            System.arraycopy(array, 0, arrayNovo, 0, posicao);
            arrayNovo[posicao] = valor;
            System.arraycopy(array, posicao, arrayNovo, posicao+1, array.length-posicao);
            System.out.println("Array: " + Arrays.toString(arrayNovo));
        } else {
            System.out.println("Intervalo inválido");
        }
    }
}
