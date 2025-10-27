//Aluno: Filipe Alves sousa Julio

public class Questao21 {
    public static void main(String[] args) {
        String[] modelos = {"fusca", "gol", "uno", "vectra", "peugeout"};
        double[] consumo = {7.0, 10.0, 12.5, 9.0, 14.5};

        double precoCombustivel = 2.25;
        double distancia = 1000.0;

        System.out.println("Comparativo de Consumo de Combustível");

        for (int i = 0; i < modelos.length; i++) {
            System.out.println("Veículo " + (i + 1));
            System.out.println("Nome: " + modelos[i]);
            System.out.println("Km por litro: " + consumo[i]);
        }

        System.out.println("\nRelatório Final");

        int indiceMaisEconomico = 0;

        for (int i = 0; i < modelos.length; i++) {
            double litrosNecessarios = distancia / consumo[i];
            double custo = litrosNecessarios * precoCombustivel;

            System.out.printf("%d - %s - %.1f - %.1f litros - R$ %.2f%n",
                    (i + 1), modelos[i], consumo[i], litrosNecessarios, custo);

            if (consumo[i] > consumo[indiceMaisEconomico]) {
                indiceMaisEconomico = i;
            }
        }

        System.out.println("\nO menor consumo é do " + modelos[indiceMaisEconomico] + ".");
    }
}
