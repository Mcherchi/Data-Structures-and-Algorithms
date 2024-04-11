package Big_O;

public class N_squared {
  public static void logAllPairs(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // Outer loop runs 'n' times
            for (int j = 0; j < arr.length; j++) {
                // Inner loop runs 'n' times
                System.out.println(arr[i] + " " + arr[j]); // O(n^2)
            }
        }
    }

    public static void printAllNumbersAndAllPairSums(int[] arr) {
        System.out.println("these are the numbers");
        for (int element : arr) {
            // Loop runs 'n' times
            System.out.println(element);
        }

        System.out.println("and these are their sums");
        for (int first : arr) {
            // Outer loop runs 'n' times
            for (int second : arr) {
                // Inner loop runs 'n' times
                System.out.println(first + second); // O(n^2)
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        logAllPairs(numbers); // Time complexity: O(n^2)
        printAllNumbersAndAllPairSums(numbers); // Time complexity: O(n^2)
    }
}
