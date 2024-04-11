package Algorithms.Sorting;

import java.util.Arrays;

public class SelectionSort {
  public static <T extends Comparable<T>> T[] selectionSort(T[] arr){
    int length = arr.length;
    for(int i = 0; i < length - 1; i++){
      int minIndex = i;
      T temp = arr[i];
      for(int j = i + 1; j < length; j++){
        if(arr[j].compareTo(arr[minIndex]) < 0){
         minIndex = j;
        }
      }
     
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    
    }
    return arr;
  }

  public static void main(String[] args) {
     Integer[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
     System.out.println(Arrays.toString(selectionSort(numbers)));
   }
}
