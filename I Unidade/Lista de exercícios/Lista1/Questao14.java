//Aluno: Filipe Alves sousa Julio

import java.util.Scanner;
public class Questao14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] pergunta = {"Telefonou para a vítima? ", "Esteve no local do crime? ", "Mora perto da vítima? ", "Devia para a vítima? ", "Já trabalhou com a vítima? "};
        String[] resposta = new String[5];
        int contador = 0;

        for (int i = 0; i<5; i++){
            System.out.print(pergunta[i]+"(s/n) ");
            resposta[i] = scanner.nextLine();
            if(resposta[i].equalsIgnoreCase("s")){
                contador++;
            }
        }
        
        if (contador==2){
            System.out.println("interrogado classificado como SUSPEITO");
        } else if (contador == 3 || contador == 4){
            System.out.println("interrogado classificado como CÚMPLICE");
        } else if (contador == 5){
            System.out.println("interrogado classificado como ASSASSINO");
        } else {
            System.out.println("interrogado classificado como INOCENTE");
        }
    }    
}
