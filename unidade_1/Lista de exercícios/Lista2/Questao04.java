//Aluno: Filipe Alves sousa Julio
package Lista2;

public class Questao04 {
    public static void main(String[] args) {
        int[] array = {5,10,25,33,700,89,41,25,19,1};
        int maior = array[0];
        int menor = array[0];

        for(int i=1 ; i<array.length; i++){
            if (maior<array[i]){
                maior = array[i];
            }
            if (menor>array[i]){
                menor = array[i];
            }
        }
        System.out.println("O maior valor do array é: " + maior);
        System.out.println("O menor valor do array é: " + menor);

    }
}
