package Algorithms.Recursion;

public class Factorial {
    public static int findFactorialRecursive(int input){
        if(input <= 1) return 1;

        return input * findFactorialRecursive(input-1);
    }

    public static int findFactorialIterative(int input){
        if(input < 0) throw new IllegalArgumentException("invalid input");
        int factorial = 1;
        for(int i = 2; i <= input; i++){
            factorial *= i;
        }

        return factorial;
    }


    public static void main(String[] args) {

        System.out.println(findFactorialRecursive(5));
        System.out.println(findFactorialIterative(5));

    }
}
