package Algorithms.Sorting;

import java.util.Arrays;

public class InsertionSort {
  public static <T extends Comparable<T>> T[] insertionSort(T[] arr){
    int length = arr.length;
    for(int i = 1; i < length; i++){
      T key = arr[i];
      int j = i - 1;
      while(j >= 0 && arr[j].compareTo(key) > 0){
        arr[j + 1] = arr[j];
        j = j - 1;
      }
      arr[j + 1] = key;
    }
    return arr;
  }

  public static void main(String[] args) {
     Integer[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
     System.out.println(Arrays.toString(insertionSort(numbers)));
   }
}
