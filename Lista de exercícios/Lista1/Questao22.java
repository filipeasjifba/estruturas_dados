//Aluno: Filipe Alves sousa Julio

import java.util.Scanner;

public class Questao22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = 0;
        int esfera = 0;
        int limpeza = 0;
        int caboConector = 0;
        int quebrado = 0;

        System.out.print("Digite o número de identificação do mouse (0 para encerrar): ");

        while (true) {
            int id = sc.nextInt();
            if (id == 0) {
                break;
            }

            System.out.println("1 - necessita da esfera");
            System.out.println("2 - necessita de limpeza");
            System.out.println("3 - necessita troca do cabo ou conector");
            System.out.println("4 - quebrado ou inutilizado");
            System.out.print("Informe o tipo de defeito:");

            int defeito = sc.nextInt();

            switch (defeito) {
                case 1:
                    esfera++;
                    break;
                case 2:
                    limpeza++;
                    break;
                case 3:
                    caboConector++;
                    break;
                case 4:
                    quebrado++;
                    break;
                default:
                    System.out.println("Defeito inválido, não contabilizado.");
                    continue;
            }

            total++;
            System.out.print("Digite o número de identificação do próximo mouse (0 para encerrar):");
        }

        System.out.println("\nRelatório Final");
        System.out.println("Quantidade de mouses: " + total);
        System.out.println();
        System.out.println("Situação                               Quantidade   Percentual");
        if (total > 0) {
            System.out.printf("1- necessita da esfera                  %d          %.1f%%\n", esfera, (esfera * 100.0 / total));
            System.out.printf("2- necessita de limpeza                 %d          %.1f%%\n", limpeza, (limpeza * 100.0 / total));
            System.out.printf("3- necessita troca do cabo ou conector  %d          %.1f%%\n", caboConector, (caboConector * 100.0 / total));
            System.out.printf("4- quebrado ou inutilizado              %d          %.1f%%\n", quebrado, (quebrado * 100.0 / total));
        } else {
            System.out.println("Nenhum mouse foi registrado.");
        }
    }
}
