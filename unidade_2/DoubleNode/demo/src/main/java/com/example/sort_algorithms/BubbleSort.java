
import java.util.LinkedList;

// Aluno: Filipe Alves Sousa Julio

public class BubbleSort {

    public static int[] BubbleSortEstatico (int[] array){
        for (int j=0 ; j < array.length-1 ; j++){
            for(int i=0; i < array.length-1-j; i++){
                if(array[i]>array[i+1]){
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
        return array;
    }

    public static LinkedList<Integer> BubbleSortLinked(LinkedList<Integer> array){
        for(int j = 0; j < array.size(); j++){
            for(int i = 0; i < array.size()-1-j; i++){
                if (array.get(i) > array.get(i+1)){
                    int temp = array.get(i);
                    array.set(i, i+1);
                    array.set(i+1, temp);
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {1,5,7,2,9,10,4,3};
        LinkedList<Integer> array2 = new LinkedList<>();
        array2.add(1);
        array2.add(10);
        array2.add(3);        
        array2.add(17);

        BubbleSortLinked(array2);
        for (int n : array2)
        System.out.println(n);

        BubbleSortEstatico(array);
        for (int n : array)
        System.out.println(n);
    }
}
