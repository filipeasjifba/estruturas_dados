import java.util.ArrayDeque;

public class ConversorInteiroBinario {
    public static String convertToBinary (String value){
        int n = Integer.parseInt(value);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while (n > 0){
            stack.push(n%2);
            n /= 2;
        }
        String aux = "";
        while (!stack.isEmpty()){
            aux += stack.pop();
        }
        return aux;
    }
    public static void main(String[] args) {
        System.out.println("Convertendo o valor para binário:");
        System.out.println(convertToBinary("15"));
    }
}