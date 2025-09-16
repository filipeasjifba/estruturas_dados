// Aluno: Filipe Alves Sousa Julio

import java.util.Arrays;
import java.util.Scanner;

public class Questao5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] valores = new int[20];
        int[] pares = new int[20];
        int[] impares = new int[20];
        int contadorPares = 0;
        int contadorImpares = 0;

        for(int i=0;i<20;i++){
            System.out.print("Digite o " + (i+1) + "º número inteiro: ");
            valores[i] = scanner.nextInt();
        }

        for (int i= 0; i<20; i++){
            if (valores[i]%2 == 0){
                pares[contadorPares] = valores[i];
                contadorPares++;
            } else {
                impares[contadorImpares] = valores[i];
                contadorImpares++;
            }
        }

        int[] imparesApenas = Arrays.copyOf(impares, contadorImpares);
        int[] paresApenas = Arrays.copyOf(pares, contadorPares);

        System.out.println("Todos: " + Arrays.toString(valores));
        System.out.println("Pares: " + Arrays.toString(paresApenas));
        System.out.println("Ímpares: " + Arrays.toString(imparesApenas));

    }
}
