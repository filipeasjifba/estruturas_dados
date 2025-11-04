package Lista2;

public class Questao11 {
    public static void main(String[] args) {
        double[] array = {1,2,3,4,5,6,7,8,9,11};
        double soma = 0;
        for (int i = 0; i < array.length; i++) {
            soma += array[i];
        }
        System.out.println("Média dos elementos do array= " + soma/array.length);
    }
}
