package Lista2;

import java.util.Arrays;

public class Questao23 {
    public static void main(String[] args) {
        int[] array1 = {1,2,3};
        int[] array2 = {4,5,6};
        int[] array3 = new int[array1.length + array2.length];

        System.arraycopy(array1, 0, array3, 0, array1.length);
        System.arraycopy(array2, 0, array3, array1.length, array2.length);

        System.out.println("Array 1: " + Arrays.toString(array1));
        System.out.println("Array 2: " + Arrays.toString(array2));
        System.out.println("Novo array: " + Arrays.toString(array3));
    }
}
