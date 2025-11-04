package Lista2;

public class Questao22 {
    public static void main(String[] args) {
        char[] array = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u'};
        int vogais = 0;

        for (int i = 0; i < array.length; i++) {
            if(isVogal(array[i])){
                vogais++;
            }
        }
        System.out.println("Quantidade de vogais: " + vogais);
    }

    public static boolean isVogal (char c){
        c = Character.toLowerCase(c);
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
}
