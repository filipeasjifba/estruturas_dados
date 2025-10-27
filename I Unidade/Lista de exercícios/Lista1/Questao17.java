//Aluno: Filipe Alves sousa Julio

import java.util.Scanner;
public class Questao17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome = null;
        double[] salto = new double[5];
        
        while (true){
            double soma = 0;
            System.out.println("-------------------");
            System.out.print("Digite o nome do atleta ('' para encerrar): ");
            nome = scanner.nextLine();
            if (nome.isEmpty()){
                System.out.println("Fechando sistema..");
                break;
            }
            for(int i=0; i<5; i++){
                System.out.print("Digite a distância do " + (i+1) + "º salto: ");
                salto[i]= scanner.nextDouble();
                scanner.nextLine();
                soma += salto[i];
            }

            System.out.println("\nAtleta: " + nome);
            System.out.print("Saltos: " + salto[0] + " - " + salto[1] +  " - " + salto[2] +  " - " + salto[3] +  " - " + salto[4]);
            System.out.printf("\nMédia: %.2f\n", (soma/5));
        }
    }
}
