// Aluno: Filipe Alves Sousa Julio

import java.util.Scanner;

public class Questao04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] caracteres = new char[10];

        for(int i=0;i<10;i++){
            System.out.print("Digite o " + (i+1) + "º caractere: ");
            caracteres[i] = scanner.next().charAt(0);
        }

        System.out.println("----------------------");
        System.out.println("AS consoantes são: ");
        for (int i=0;i<10;i++){
            if (caracteres[i]!='a' && caracteres[i] != 'e' && caracteres[i] != 'i' && caracteres[i] != 'o' && caracteres[i] != 'u'){
                System.out.println(caracteres[i]);
            }
        }
    }
    
}
