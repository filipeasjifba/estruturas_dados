//Aluno: Filipe Alves Sousa Julio

public class InsertSort {
    public static int[] InsertSort(int[] array) {
        for (int j = 1; j < array.length; j++) {
            int chave = array[j];
            int i;

            for (i = j - 1; i >= 0 && array[i] > chave; i--) {
                array[i + 1] = array[i];
            }

            array[i + 1] = chave;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 7, 2, 9, 10, 4, 3};

        InsertSort(array);

        for (int n : array) {
            System.out.println(n);
        }
    }
}
