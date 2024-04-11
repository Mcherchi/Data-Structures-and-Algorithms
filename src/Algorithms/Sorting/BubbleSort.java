package Algorithms.Sorting;

import java.util.Arrays;

public class BubbleSort {
   public static <T extends Comparable<T>> T[] bubbleSort(T[] arr) {
    int length = arr.length;
    for(int i = 0; i < length; i++){
      for(int j = 0; j < length - 1 - i; j++){
        if(arr[j].compareTo(arr[j + 1 ]) > 0){
          T temp = arr[j];
          arr[j] = arr[j + 1 ];
          arr[j + 1] = temp;
        }
      }
    }
    return arr;
   }

   public static void main(String[] args) {
     Integer[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
     System.out.println(Arrays.toString(bubbleSort(numbers)));
   }
}

