//Aluno: Filipe Alves sousa Julio

import java.util.ArrayList;
import java.util.Scanner;

public class Questao16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> Venda = new ArrayList<>();
        int[] contador = new int[9];

        while (true) { 
            System.out.print("Digite o valor da venda de um funcionário (ou -1 para encerrar): ");
            double valor = scanner.nextInt();
            scanner.nextLine();
            if(valor == -1){
                break;
            }
            Venda.add(valor);
        }

        for (int i=0; i<Venda.size();i++){
            double salario = 200 + (Venda.get(i) * 0.09);
            int indice = (int)(salario/100)-2;

            if(indice >=0 && indice <= 7){
                contador[indice]++;
            } else if (indice >= 8){
                contador[8]++;
            }
        }
        System.out.println("\nRelatório de salários:");
        System.out.printf("$200 - $299: %d vendedores%n", contador[0]);
        System.out.printf("$300 - $399: %d vendedores%n", contador[1]);
        System.out.printf("$400 - $499: %d vendedores%n", contador[2]);
        System.out.printf("$500 - $599: %d vendedores%n", contador[3]);
        System.out.printf("$600 - $699: %d vendedores%n", contador[4]);
        System.out.printf("$700 - $799: %d vendedores%n", contador[5]);
        System.out.printf("$800 - $899: %d vendedores%n", contador[6]);
        System.out.printf("$900 - $999: %d vendedores%n", contador[7]);
        System.out.printf("$1000 em diante: %d vendedores%n", contador[8]);

    }
    }    
