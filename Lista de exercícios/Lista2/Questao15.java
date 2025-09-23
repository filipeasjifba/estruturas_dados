package Lista2;

import java.util.Arrays;

public class Questao15 {
    public static void main(String[] args) {
        int[] array = {22,31,10,55,12,100,69};

        System.out.print("Ordem decrescente: ");
        Arrays.sort(array);
        for (int i = array.length-1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }
    
}
