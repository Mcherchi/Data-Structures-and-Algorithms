package Big_O;

public class Exercise_1 {
   // Function to simulate an unknown runtime
    public static void anotherFunction() {
        // unknown runtime
    }

    // Function to perform operations on an array and measure time complexity
    @SuppressWarnings("unused")
    public static int funChallenge(int[] input) {
        int a = 10; // O(1)
        a = 50 + 3; // O(1)

        for (int i = 0; i < input.length; i++) {
            // Loop runs 'n' times, where 'n' is the length of the input array
            anotherFunction(); // O(n)
            boolean stranger = true; // O(n)
            a++; // O(n)
        }

        return a; // O(1)
    }

    public static void main(String[] args) {
        int[] numbersArr = {1, 2, 3, 4, 5};

        funChallenge(numbersArr); // Time Complexity: O(3 + 4n) ~ O(n)

        // Summing up these complexities, we get O(1) + O(1) + O(n) + O(n) + O(n) + O(n) + O(1),
        // which simplifies to O(3 + 4n).
        // Since the constant term doesn't significantly contribute to the big O analysis,
        // we consider this to be O(n).
    }
}
