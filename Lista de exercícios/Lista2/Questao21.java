package Lista2;

import java.util.Arrays;

public class Questao21 {
    public static void main(String[] args) {
        char[] array = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u'};

        for (int i = 0; i < array.length; i++) {
            if (isVogal(array[i])){
                array[i] = '*';
            }
        }
        System.err.println(Arrays.toString(array));
    }

    public static boolean isVogal (char c){
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c =='u';
    }
}
