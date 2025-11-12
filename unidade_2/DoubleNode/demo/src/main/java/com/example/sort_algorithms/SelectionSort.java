package com.example.sort_algorithms;
// Aluno: Filipe Alves Sousa Julio

public class SelectionSort {
    
    public static int[] SelectionSortEstatico (int[] array){
        
        for(int j = 0; j <array.length-1; j++){
            int minorIndex = j;
            for (int i = 1+j; i < array.length; i++) {
                if(array[minorIndex] > array[i]){
                    minorIndex = i;
                }
            }
            int temp = array[j];
            array[j] = array[minorIndex];
            array[minorIndex] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {1,5,9,12,6,1,7};
        SelectionSortEstatico(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    
}
