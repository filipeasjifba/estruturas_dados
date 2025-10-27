//Aluno: Filipe Alves sousa Julio
package Lista2;

import java.util.Arrays;
public class Questao03 {
    public static void main(String[] args) {
        int[] valores = {5,10,12,7,23,17, 25};
        int[] ordemInversa = new int[valores.length];
        for (int i=0; i<valores.length ; i++){
            ordemInversa[i] = valores[valores.length - 1 - i];
        }
        System.out.println("Array inicial: " + Arrays.toString(valores));
        System.out.println("Array invertido: " + Arrays.toString(ordemInversa));
    }
}