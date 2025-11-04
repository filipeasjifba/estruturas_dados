// Aluno: Filipe Alves sousa Julio

public class Questao23 {
    public static void main(String[] args) {
        String[] funcionarios = {"Alexandre", "Anderson", "Antônio", "Carlos","César","Rosemary"};
        double[] consumoBytes = {456123789, 1245698456, 123456456, 91257581, 987458, 789456125};
        double totalConsumo = 0;

        for(double c : consumoBytes){
            totalConsumo += c;
        }

        System.out.println("ACME inc. Uso do espaço em disco pelos usuários");
        System.out.println("-------------------------------------------------");

        for (int i=0; i<funcionarios.length; i++){
            System.out.printf("%d %s %.2f MB %.2f%%\n", (i+1), funcionarios[i], conversaoBytesMegabytes(consumoBytes[i]), percentual(consumoBytes[i], totalConsumo));
        }

        System.out.printf("\nEspaço total ocupado: %.2f MB", conversaoBytesMegabytes(totalConsumo));
        System.out.printf("\nEspaço médio ocupado: %.2f MB", conversaoBytesMegabytes(totalConsumo / funcionarios.length));
    
    }
    public static double conversaoBytesMegabytes (double bytes) {
        return bytes / (1024 * 1024);
    }

    public static double percentual(double parte, double total){
        return (parte / total) * 100;
    }
}
