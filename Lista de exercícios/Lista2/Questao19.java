package Lista2;

import java.util.Arrays;

public class Questao19 {
    public static void main(String[] args) {
        int[] array1 = {1,56,23,49,77,23};
        int[] array2 = new int[array1.length];

        for (int i = 0; i < array1.length; i++) {
            array2[i] = array1[array1.length - 1 - i];
        }
        System.out.println("\nArray antes: " + Arrays.toString(array1));
        System.out.println("Array depois: " + Arrays.toString(array2));

        }
}