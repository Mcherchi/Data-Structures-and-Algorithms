package Algorithms.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    static int operationsCount = 0;

    public static int fibonacciRecursive(int input) {
        operationsCount = 0;
        return fibonacci(input);
    }

    private static int fibonacci(int input) {
        operationsCount++;
        if (input < 0) throw new IllegalArgumentException("invalid input");
        if (input == 0) return 0;
        if (input == 1 || input == 2) return 1;

        return fibonacci(input - 2) + fibonacci(input - 1);
    }

    public static int getOperationsCount() {
        return operationsCount;
    }

    public static int fibonacciIterative(int input) {
        if (input < 0) throw new IllegalArgumentException("invalid input");
        List<Integer> list = new ArrayList<>(List.of(0, 1));
        for (int i = 2; i <= input; i++) {
            list.add(list.get(i - 2) + list.get(i - 1));
        }
        return list.get(input);
    }

    public static void main(String[] args) {
        System.out.println("result: " + fibonacciRecursive(7));
        System.out.println("Total operations: " + getOperationsCount());
        System.out.println(fibonacciIterative(7));
    }
}
