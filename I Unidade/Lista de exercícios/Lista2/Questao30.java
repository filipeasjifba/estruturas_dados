package Lista2;

import java.util.Arrays;
import java.util.HashSet;

public class Questao30 {
    public static void main(String[] args) {
        int[] array = {1,1,5,2,3,6,4,1,1};
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            hashSet.add(array[i]);
        }

        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Sem repetir: " + hashSet);
    
    }
}