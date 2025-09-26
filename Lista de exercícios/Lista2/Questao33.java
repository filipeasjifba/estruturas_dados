package Lista2;
import java.util.Arrays;
import java.util.Scanner;

public class Questao33 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        int[] array2 = new int[array.length+1];

        System.out.println("Array: " + Arrays.toString(array));
        System.out.print("Digite o valor a ser inserido no final: ");
        Scanner scanner = new Scanner(System.in);

        System.arraycopy(array, 0, array2, 0, array.length);
        array2[array2.length-1] = scanner.nextInt();

        System.out.println(Arrays.toString(array2));
    }
}
