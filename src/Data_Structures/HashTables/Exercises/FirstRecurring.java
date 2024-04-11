package Data_Structures.HashTables.Exercises;

// ---------- Interview Question ----------
//Given an array = [2,5,1,2,3,5,1,2,4]: It should return 2
//Given an array = [2,1,1,2,3,5,1,2,4]: It should return 1
//Given an array = [2,3,4,5]: It should return undefined
//Given an array = [2,5,5,2,3,5,1,2,4]: return 5 because the pairs are before 2,2

import java.util.HashSet;

public class FirstRecurring {

  private static Integer findFirstRecurring(int[] arr) {
    HashSet<Integer> seen = new HashSet<>();

    for(int item : arr){
      if(seen.contains(item)){
        return item;
      }else{
        seen.add(item);
      }
    }

    return null;
  }

  public static void main(String[] args) {
    int[] arr1 = {2, 5, 1, 2, 3, 5, 1, 2, 4};
    int[] arr2 = {2, 1, 1, 2, 3, 5, 1, 2, 4};
    int[] arr3 = {2, 3, 4, 5};
    int[] arr4 = {2, 5, 5, 2, 3, 5, 1, 2, 4};
    
    System.out.println(findFirstRecurring(arr1));
    System.out.println(findFirstRecurring(arr2)); 
    System.out.println(findFirstRecurring(arr3)); 
    System.out.println(findFirstRecurring(arr4)); 
  }
}
