package Algorithms.Searching;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
  public static<T extends Comparable<T>> String binarySearch(List<T> list, T item){
    int low = 0;
    int high = list.size() - 1;
    while (low <= high) {
      int mid = (low + high) / 2;

      if(list.get(mid).compareTo(item) == 0){
        return "Element: " + item + " Found At Index " + mid;
      } else if(list.get(mid).compareTo(item) < 0){
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return "Element not found";
  }

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(List.of(10,25,32,45,55,68));
    System.out.println(binarySearch(list,55));
  }
}
