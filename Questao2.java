// Aluno: Filipe Alves Sousa Julio
import java.util.Scanner;

public class Questao2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] v = new double[10];
        
        for (int i=0 ; i<10 ; i++) {
            System.out.print("Digite o "+ (i+1) +"º valor real:");
            v[i] = scanner.nextDouble();
        }
        System.out.println("----------------------");
        System.out.println("Valores invertidos: ");

        for (int i=9; i>=0;i--){
            System.out.printf("%.2f / ", v[i]);
        }
    }
}
