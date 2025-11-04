package Lista2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Questao20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> array = new ArrayList<>(Arrays.asList("carlos", "fernando", "lucas", "carlos"));

        System.out.print("\nInsira uma palavra para remover: ");
        String palavra = scanner.nextLine();
        for (int i = 0; i < array.size(); i++) {
            if (palavra.equalsIgnoreCase(array.get(i))){
                array.remove(i);
            }
        }
        System.out.println(array);
    }
}
