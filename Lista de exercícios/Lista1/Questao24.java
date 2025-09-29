// Aluno: Filipe Alves sousa Julio

public class Questao24 {
    public static void main(String[] args) {
        int[] resultados = new int[6];

        for(int i=0; i<100; i++){
            int n = (int) (Math.random() * 6) +1;
            resultados[n-1]++;
        }

        System.out.println("Simulação de lançamento de dados");
        System.out.println("----------------------------");
        for(int i=0; i<resultados.length; i++){
            System.out.println("Face " + (i+1) + ": " + resultados[i] + " vezes");
        }
        System.out.println("----------------------------");
        System.out.printf("Total: %d vezes\n", 100);
    }
    
}
