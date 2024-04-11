package Algorithms.Sorting;

import java.util.Arrays;

public class QuickSort<T extends Comparable<T>> {

  public T[] quickSort(T[] array, int left, int right) {
    int pivot;
    int partitionIndex;

    if (left < right) {
        pivot = right;
        System.out.println("Part: " + Arrays.asList(array).subList(left, right + 1) + " by " + array[pivot]);
        partitionIndex = partition(array, pivot, left, right);
        System.out.println("Result: " + Arrays.asList(array).subList(left, right + 1));

        // sort left and right
        quickSort(array, left, partitionIndex - 1);
        quickSort(array, partitionIndex + 1, right);
    }
    return array;
}

  private int partition(T[] array, int pivot, int left, int right){
    T pivotValue = array[pivot];
    int partitionIndex = left;
    for(int i = left; i < right; i++){
      if(array[i].compareTo(pivotValue) < 0){
        swap(array, partitionIndex, i);
        partitionIndex++;
      }
    }
    swap(array, right, partitionIndex);
    return partitionIndex;
  }

  private void swap(T[] array, int i, int j){
    T temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public static void main(String[] args) {
      Integer[] array = {1, 9, 54, 8, 65, 1, 100, 0, 45, 50, 0, 90, 30, 46};
      QuickSort<Integer> sorter = new QuickSort<>();
      System.out.println(Arrays.asList(sorter.quickSort(array, 0 , array.length - 1)));
  }
}
