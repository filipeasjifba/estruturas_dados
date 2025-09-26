package Lista2;

import java.util.Arrays;

public class Questao31 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int temp = array[0];
        
        System.out.println("Array antigo: " + Arrays.toString(array));
        for (int i = 0; i < array.length-1; i++) {
            array[i] = array[i+1];        
        }
        array[array.length-1] = temp;
        System.out.println("Array rotacionado: " + Arrays.toString(array));
    }
}