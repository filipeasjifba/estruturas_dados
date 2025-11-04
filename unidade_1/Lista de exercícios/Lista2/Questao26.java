package Lista2;

import java.util.Arrays;
import java.util.Scanner;

public class Questao26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma quantidade n de números primos: ");
        int n = scanner.nextInt();
        int count = 0;
        int num = 2;
        int[] primos = new int[n];

        while(count<n){
            if (isPrimo(num)){
                primos[count] = num;
                count++;
            }
            num++;
        }

        System.out.println("Array de números primos:" + Arrays.toString(primos));
    }

    public static boolean isPrimo(int num){
        if (num<=1){
            return false;
        }
        for (int i=2; i <= Math.sqrt(num);i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
    
}
