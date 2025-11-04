package Lista2;

import java.util.Arrays;

public class Questao13 {
    public static void main(String[] args) {
        int[]array1 = {1,2,3,4,5,6,7,8,9,0};
        int[]array2 = new int[array1.length];

        System.arraycopy(array1, 0, array2, 0, array1.length);
        System.out.println("Array original: " + Arrays.toString(array1));
        System.out.println("Array copiado: " + Arrays.toString(array2));
    }

}
