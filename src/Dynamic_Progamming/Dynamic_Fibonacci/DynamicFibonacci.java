package Dynamic_Progamming.Dynamic_Fibonacci;

import java.util.HashMap;

public class DynamicFibonacci {
    public static final HashMap<Integer, Integer> cache = new HashMap<>();
    public static int fibonacci(int n){
        if(cache.containsKey(n)){
            return cache.get(n);
        }
        if(n < 0) throw new IllegalArgumentException("invalid input");
        if(n == 0) return 0;
        if(n < 2){
            return n;
        }
        cache.put(n, fibonacci(n - 1) + fibonacci(n - 2));
        return cache.get(n);
    }
    public static void main(String[] args) {
        System.out.println(fibonacci(1000));
    }
}
