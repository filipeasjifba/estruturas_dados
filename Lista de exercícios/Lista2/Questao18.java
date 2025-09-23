package Lista2;

import java.util.Arrays;

public class Questao18 {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5,6,7,8,9};
        int[] array2 = {1,2,3,4,5,6,7,8,9};
        int[] array3 = new int[array1.length];

        if(array1.length == array2.length){
            for (int i = 0; i < array1.length; i++) {
                array3[i] = array1[i] * array2[i];
            }
            System.out.println("Array 1: " + Arrays.toString(array1));
            System.out.println("Array 2: " + Arrays.toString(array2));
            System.out.println("Array 3: " + Arrays.toString(array3));
        } else {
            System.out.println("Os arrays possuem tamanhos diferentes");
        }
        
    }
}
