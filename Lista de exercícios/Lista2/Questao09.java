package Lista2;

public class Questao09 {
    public static void main(String[] args) {
        int[] array = {1,22,3,4,78,6,7,8,12};
        int contador = 0;

        for (int i = 0; i < array.length; i++) {
            if(array[i]%2==0){
                contador++;
            }
        }
        System.out.println("Número de elementos pares no array: " + contador);
    }
}
