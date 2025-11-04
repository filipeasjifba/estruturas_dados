package Lista2;

import java.util.ArrayList;
import java.util.Scanner;

public class Questao27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma quantidade n de números perfeitos: ");
        int n = scanner.nextInt();
        ArrayList<Integer> numPerfeito = new ArrayList<>();

        for(int i=1; i<n; i++){
            if(isPerfeito(i)){
                numPerfeito.add(i);
            }
        }
        System.out.println("Números perfeitos: " + numPerfeito);
    }

    public static boolean isPerfeito(int num){
        int soma = 0;
        for (int i=1; i<num; i++){
            if(num % i==0){
                soma += i;
            }
        }
        return soma == num;
    }
    
}
