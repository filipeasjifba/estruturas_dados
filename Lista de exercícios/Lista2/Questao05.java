//Aluno: Filipe Alves sousa Julio
package Lista2;

public class Questao05 {
    public static void main(String[] args) {
        int[] array = {1,25,120,78,95,23,150,86,96,121,};
        int maior = array[0];
        int segundoMaior = array[0];

        for (int i = 1; i < array.length; i++) {
            if(maior<array[i]){
                maior=array[i];
            }
        }
        for (int i = 1; i < array.length; i++) {
            if(array[i]<maior && segundoMaior<array[i]){
                segundoMaior = array[i];
            }
        }
        System.out.printf("o maior número é %d e o segundo maior é %d", maior, segundoMaior);
    }
    
}
