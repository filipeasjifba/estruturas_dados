//Aluno: Filipe Alves sousa Julio

import java.util.Scanner;

public class Questao19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sistemas = {"Windows Server", "Unix", "Linux", "Netware", "Mac OS", "Outro"};
        int[] votos = new int[6];
        int totalVotos = 0;

        while (true) {
            for (int i = 0; i < sistemas.length; i++) {
                System.out.println((i + 1) + "- " + sistemas[i]);
            }
            System.out.print("Qual é o melhor sistema operacional para uso em servidores (0 para encerrar)? ");
            int voto = scanner.nextInt();
            if (voto == 0) {
                break;
            } else if (voto < 0 || voto > 6) {
                System.out.println("Número inválido, tente novamente.");
                continue;
            } else {
                votos[voto - 1]++;
                totalVotos++;
            }
        }

        System.out.println("Sistema Operacional     Votos   %");
        System.out.println("-------------------");
        for (int i =0; i<votos.length; i++){
            if(votos[i]>0){
                System.out.printf("%-22s %3d   %.2f%%\n", sistemas[i], votos[i], (votos[i]*100.0/totalVotos));
            }
        }
        System.out.println("-------------------");
        System.out.println("Total de votos: " + totalVotos);

    }
    
}
