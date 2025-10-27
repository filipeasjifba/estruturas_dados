//Aluno: Filipe Alves sousa Julio

import java.util.Arrays;
import java.util.Scanner;

public class Questao11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] v1 = new int [10];
        int[] v2 = new int [10];
        int[] v3 = new int [10];
        int[] v4 = new int [30];

        for (int i = 0; i < 10; i++) {
            System.out.println("Digite o " + (1+i) + "° valor do primeiro vetor: ");
            v1[i]=scanner.nextInt();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Digite o " + (1+i) + "° valor do segundo vetor: ");
            v2[i]=scanner.nextInt();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Digite o " + (1+i) + "° valor do terceiro vetor: ");
            v3[i]=scanner.nextInt();
        }

        for (int i=0; i<10; i++){
            v4[3*i] = v1[i];
            v4[3*i+1] = v2[i];
            v4[3*i+2] = v3[i];
        }

        System.out.print("Os valores intercalados são:\n");
        System.out.print(Arrays.toString(v4));
    }
}
