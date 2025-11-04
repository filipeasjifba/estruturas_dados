//Aluno: Filipe Alves sousa Julio

import java.util.ArrayList;
import java.util.Scanner;

public class Questao15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> notas = new ArrayList<>();
        double soma = 0;
        int maioresMedia = 0;
        int MenoresSete = 0;

        while (true) { 
            System.out.print("Digite as notas (-1 para encerrar): ");
            int numero = scanner.nextInt();
            scanner.nextLine();
            if (numero == -1){
                break;
            }
            notas.add(numero);
            soma+=numero;
        }

        System.out.println("\nQuantidade de notas informadas: " + notas.size());
        System.out.println("Notas informadas: " + notas.toString());
        System.out.print("Notas na ordem inversa: [");
        for (int i = notas.size()-1; i>=0;i--){
            if(i==0){
                System.out.print(notas.get(i)+"]\n");
                break;
            }
            System.out.print(notas.get(i)+", ");
        }
        System.out.println("Soma das notas: " + soma);
        double media = soma/notas.size();
        System.out.printf("Média das notas: %.2f\n", media);
        for (int i = notas.size()-1;i>=0;i--){
            if (notas.get(i)>media){
                maioresMedia++;
            }
            if (notas.get(i) < 7){
                MenoresSete++;
            }
        }
        System.out.printf("Quantidade de notas acima da média = %d\n", maioresMedia);
        System.out.printf("Quantidade de notas abaixo de 7 = %d\n", MenoresSete);
        System.out.println("\n--- Programa encerrado com sucesso! ---\n");
    }    
}
