package Lista2;

import java.util.Arrays;

public class Questao17 {
    public static void main(String[] args) {
        int[] array2 = {1,25,14,86,37,4};
        int[] array1 = {1,25,14,86,37,4};

        boolean comparation = Arrays.equals(array1, array2);        
        if (comparation == true){
            System.out.println("Sim, ambos os arrays são iguais");
        } else {
            System.out.println("Não, os arrays não são iguais");
        }
        System.out.println("Array 1: " + Arrays.toString(array1));
        System.out.println("Array 2: " + Arrays.toString(array2));

    }
}
