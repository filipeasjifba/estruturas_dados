//Aluno: Filipe Alves sousa Julio

import java.util.Scanner;

public class Questao13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] temperatura = new double[12];
        String[] mes = {"Janeiro", "Fevereiro","Março","Abril","Maio", "Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
        double soma=0;

        for (int i=0; i<12; i++){
            System.out.printf("Digite o valor da temperatura em °C de %s: ", mes[i]);
            temperatura[i]=scanner.nextDouble();
            soma += temperatura[i];
        }

        double media = soma/temperatura.length;

        System.out.println("Meses com temperatura maior que a média:");
        for (int i = 0; i < 12; i++) {
            if(temperatura[i]>media){
                System.out.printf ("%d - %s (%.2f°C > %.2f°C)\n", i, mes[i], temperatura[i], media);
            }
        }
    }
}
