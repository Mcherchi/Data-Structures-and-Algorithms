package Data_Structures.Arrays.Exercises;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedArrays {

    public static <T extends Comparable<? super T>> List<T> mergeSortedArrays(List<T> arr1, List<T> arr2)
    {
      int i = 0; // index for first list
      int j = 0; // index for second list
      List<T> mergedList = new ArrayList<>();

      if(arr1.isEmpty()) return arr2;
      if(arr2.isEmpty()) return arr1;

      while (i < arr1.size() && j < arr2.size()) {
        if(arr1.get(i).compareTo(arr2.get(j)) < 0){
          mergedList.add(arr1.get(i));
          i++;
        }else{
          mergedList.add(arr2.get(j));
          j++;
        }
      }

      while (i < arr1.size()) {
        mergedList.add(arr1.get(i));
        i++;
      }

      while (j < arr2.size()) {
        mergedList.add(arr2.get(j));
        j++;
      }

      return mergedList;
    }

     public static void main(String[] args) {
        List<Integer> numbers1 = List.of(0, 3, 4,31);
        List<Integer> numbers2 = List.of(4, 6,30);

        List<Integer> mergedNumbers = mergeSortedArrays(numbers1, numbers2);
        System.out.println(mergedNumbers); // Output: [0, 3, 4, 4, 6, 30, 31]

        List<String> strings1 = List.of("apple", "banana","lime", "orange");
        List<String> strings2 = List.of("grape", "kiwi", "melon");

        List<String> mergedStrings = mergeSortedArrays(strings1, strings2);
        System.out.println(mergedStrings); // Output:  [ 'apple', 'banana', 'grape', 'kiwi', 'lime', 'melon', 'orange']
    }
}
