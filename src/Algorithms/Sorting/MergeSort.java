package Algorithms.Sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<T>> {

  public List<T> mergeSort(List<T> array){
    if(array.size() == 1){
      return array;
    }

    List<T> left = array.subList(0, array.size() / 2);
    List<T> right = array.subList( array.size() / 2, array.size());

    return merge(mergeSort(left), mergeSort(right));

  }

  private List<T> merge(List<T> left, List<T> right){
    ArrayList<T> result = new ArrayList<>();
    int leftIndex = 0;
    int rightIndex = 0;

    while (leftIndex < left.size() && rightIndex < right.size()) {
      if(left.get(leftIndex).compareTo(right.get(rightIndex))< 0){
        result.add(left.get(leftIndex));
        leftIndex++;
      }else{
        result.add(right.get(rightIndex));
        rightIndex++;
      }
    }

    List<T> leftRemaining = left.subList(leftIndex, left.size());
    List<T> rightRemaining = right.subList(rightIndex, right.size());

    result.addAll(leftRemaining);
    result.addAll(rightRemaining);
   
    return result;
  }
   public static void main(String[] args) {
        MergeSort<Integer> sort = new MergeSort<>();
        ArrayList<Integer> numbers = new ArrayList<>(List.of(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0));
        System.out.println(sort.mergeSort(numbers));
    }
}
