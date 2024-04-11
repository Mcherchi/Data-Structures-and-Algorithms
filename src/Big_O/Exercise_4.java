package Big_O;

import java.util.HashMap;
import java.util.Map;

public class Exercise_4 {
    public static void main(String[] args) {
        String[] arr1 = {"a", "b", "c", "x"};
        String[] arr2 = {"z", "y", "a"};

        boolean result = containsCommonItem(arr1, arr2);
        System.out.println(result);
    }

    public static boolean containsCommonItem(String[] arr1, String[] arr2) {
        Map<String, Boolean> map = new HashMap<>();

        // Populating map with elements of arr1
        for (String item : arr1) {
            if(!map.containsKey(item)){
                map.put(item, true); 
            }
        }

        // Checking if elements of arr2 exist in the map
        for (String item : arr2) {
            if (map.containsKey(item)) {
                return true;
            }
        }
        return false;
    }
}
