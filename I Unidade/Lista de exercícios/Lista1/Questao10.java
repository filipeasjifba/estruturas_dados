//Aluno: Filipe Alves sousa Julio

import java.util.Arrays;
import java.util.Scanner;

public class Questao10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));
        int [] v1 = new int [10];
        int [] v2 = new int [10];
        int [] v3 = new int [20];

        for(int i=0; i<10;i++){
            System.out.println("Digite o "+(i+1)+"º valor do primeiro vetor: ");
            v1[i] = scanner.nextInt();
        }

        for(int i=0; i<10;i++){
            System.out.println("Digite o "+(i+1)+"º valor do segundo vetor: ");
            v2[i] = scanner.nextInt();
        }

        for (int i = 0; i < 10; i++) {
            v3[2*i] = v1[i];
            v3[2*i+1] = v2[i];
        }
        System.out.println("Os valores intercalados são: \n");
        System.out.println(Arrays.toString(v3));
    }
}
