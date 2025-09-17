// Aluno: Filipe Alves Sousa Julio

import java.util.Scanner;

public class Questao06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] mediaList = new double[10];
        int contadorAprovados=0;
        
        for (int i = 0; i < 10; i++) {
            double media=0;
            for (int x = 0; x < 4; x++) {
                System.out.print("Digite a "+(x+1)+"º nota do "+(i+1)+"º aluno:");
                media += scanner.nextDouble();
            }
            media=media/4;
            mediaList[i] = media;
        }
        
        for (int i = 0; i < 10; i++) {
            if (mediaList[i] >= 7){
            contadorAprovados ++;
            }
        }
        System.out.println("Há " + contadorAprovados + " alunos aprovados.");
    }
    
}
