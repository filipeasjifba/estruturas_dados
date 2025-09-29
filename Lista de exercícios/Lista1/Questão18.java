//Aluno: Filipe Alves sousa Julio

import java.util.Scanner;
public class Questão18 {
    public static void main(String[] args) {
        System.out.println("Quem foi o melhor jogador? ");
        Scanner scanner = new Scanner(System.in);
        int[] jogador = new int[23];
        int totalVotos = 0;
        while (true){
            System.out.print("Número do jogador (0=fim): ");
            int voto = scanner.nextInt();
            if(voto == 0){
                break;
            }
            if(voto < 1 || voto >23){
                System.out.println("Número inválido, tente novamente.");
                continue;
            } else {
                jogador[voto-1]++;
                totalVotos++;
            }
        }

        System.out.println("Foram computados " + totalVotos + " votos.");
        System.out.println("Jogador   Votos    %");
        for(int i=0; i<jogador.length; i++){
            if(jogador[i]>0){
                System.out.println(i+1 + "         " + jogador[i] + "        " + (jogador[i]*100/totalVotos));
            }
         }

    }
}
