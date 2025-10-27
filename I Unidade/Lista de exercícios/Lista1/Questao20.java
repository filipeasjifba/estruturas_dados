//Aluno: Filipe Alves sousa Julio

import java.util.Scanner;
import java.util.ArrayList;

public class Questao20 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> salarios = new ArrayList<>();
        
        double totalGastoAbonos = 0;
        double maiorAbono = 0;
        
        double menorAbono = Double.MAX_VALUE; 
        
        int countAbonoMinimo = 0;

        System.out.println("Projeção de gastos com abono");
        System.out.println("============================");

        while (true) { 
            System.out.print("Digite o salário (0 para encerrar): ");
            
            if (!scanner.hasNextDouble()) {
                 System.out.println("Entrada inválida. Por favor, digite um número.");
                 scanner.next();
                 continue;
            }
            
            double salarioAtual = scanner.nextDouble();
            
            if (salarioAtual == 0) {
                break;
            } else if (salarioAtual < 0) {
                System.out.println("Valor inválido (salário negativo), tente novamente.");
                continue;
            } else {
                salarios.add(salarioAtual);
            }
        }
            if (salarios.isEmpty()) {
            System.out.println("Nenhum salário válido foi inserido. Encerrando.");
            return;
        }

        System.out.println("\nSalário - Abono");
        System.out.println("--------------------");

        for (double s : salarios) {
            double abono = s * 0.2;
            
            if (abono < 100.0) {
                abono = 100.0;
                countAbonoMinimo++;
            }
            
            System.out.printf("R$ %.2f - R$ %.2f\n", s, abono);

            totalGastoAbonos += abono;
            if (abono > maiorAbono) {
                maiorAbono = abono;
            }
            if (abono < menorAbono) {
                menorAbono = abono;
            }
        }

        System.out.println("\n=============================================");
        System.out.println("Foram processados " + salarios.size() + " colaboradores");
        
        System.out.printf("Total gasto com abonos: R$ %.2f\n", totalGastoAbonos);
        
        System.out.printf("Valor mínimo pago a %d colaboradores: R$ %.2f\n", countAbonoMinimo, menorAbono);
        
        System.out.printf("Maior valor de abono pago: R$ %.2f\n", maiorAbono);
    }
}