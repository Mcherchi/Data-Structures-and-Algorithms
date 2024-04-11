package Big_O;

public class Exercise_2 {
    @SuppressWarnings("unused")
    public static void anotherFunChallenge(int input) {
        int a = 5; // O(1)
        int b = 10; // O(1)
        int c = 50; // O(1)

        for (int i = 0; i < input; i++) {
            // Loop runs 'input' times
            int x = i + 1; // O(n)
            int y = i + 2; // O(n)
            int z = i + 3; // O(n)
        }

        for (int j = 0; j < input; j++) {
            // Loop runs 'input' times
            int p = j * 2; // O(n)
            int q = j * 2; // O(n)
        }

        String whoAmI = "I don't know"; // O(1)
    }

    public static void main(String[] args) {
        anotherFunChallenge(7); // Time Complexity: O(4 + 7n) ~ O(n)
    }
}