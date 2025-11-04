package Lista2;

import java.util.Scanner;
public class Questao12 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,1};
        try (Scanner scanner = new Scanner(System.in)) {
            boolean verificacao = false;
            
            System.out.print("Digite o valor a ser procurado: ");
            int valor = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < array.length; i++){ 
                if(valor == array[i]){
                    verificacao = true;
                }
            }
            if(verificacao){
                System.out.println("Sim, o valor " + valor + " existe no array");
            } else {
                System.out.println("Não, o valor " + valor + " não existe no array");
            }
        }
    }
}
