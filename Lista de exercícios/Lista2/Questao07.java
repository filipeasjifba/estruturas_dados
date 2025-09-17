package Lista2;

public class Questao07 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int soma = 0;
        for(int i=0; i<array.length ; i++){
            if(i%2==0){
                soma += array[i];
            }
        }
        System.out.println("A soma dos valores em posições pares é " + soma);
    }
    
}
