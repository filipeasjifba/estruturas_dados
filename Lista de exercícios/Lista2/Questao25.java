package Lista2;

import java.util.Arrays;

public class Questao25 {
    public static void main(String[] args) {
        int[] array = {1,2,3,2,1};
        boolean palindromo = true;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != array[array.length - 1 - i]){
                palindromo = false;
                break;
            }
        }

        if(palindromo == true){
            System.out.println("É um palíndromo: " + Arrays.toString(array));
        } else {
            System.out.println("Não é um palíndromo: " + Arrays.toString(array));
        }

    }
}
