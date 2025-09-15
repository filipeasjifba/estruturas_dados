//Aluno: Filipe Alves sousa Julio

public class Questao12 {
    public static void main(String[] args) {
        double[] altura = {1.65, 1.67, 1.67, 1.71, 1.60, 1.68, 1.64, 1.69, 1.73, 1.72, 1.65, 1.67, 1.67, 1.61, 1.70, 1.68, 1.64, 1.79, 1.73, 1.72, 1.65, 1.67, 1.67, 1.61, 1.70, 1.68, 1.64, 1.79, 1.73, 1.72};
        int[] idade = {12,12,13,14,12,10,11,15,16,14,11,13,15,16,17,14,10,16,17,11,14,13,12,15,14,14,14,15,14,15};
        double soma = 0;
        int alunosBaixos = 0;

        for (double numero : altura){
            soma += numero;
        }

        double media = soma/altura.length;

        for (int i=0; i<30; i++){
            if (idade[i]>13 && altura[i]<media){
                alunosBaixos++;
            }
        }
        System.out.printf("%d alunos possuem mais de 13 anos e altura inferior a média (%.2f m)", alunosBaixos, media);
    }
}
