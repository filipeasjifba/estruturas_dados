package Lista2;

import java.util.Arrays;

public class Questao10{
    public static void main(String[] args) {
        int[] array = {-1,-2,3,4,-5,-6,-7,8,-9,10, 7, -1};
        for (int i = 0; i < array.length; i++) {
            if (array[i]<0){
                array[i]=0;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
