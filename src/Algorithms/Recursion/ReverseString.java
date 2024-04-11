package Algorithms.Recursion;

public class ReverseString {

    public static String reverseStringRecursive(String string){
        if(string.length() == 0) {
            return "";
        }
        return reverseStringRecursive(string.substring(1)) + string.charAt(0);
    }
    public static String reverseStringIterative(String string){
        StringBuilder result = new StringBuilder();
        for(int i = string.length() - 1; i >= 0; i--){
            result.append(string.charAt(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseStringIterative("123456"));
        System.out.println(reverseStringRecursive("123456"));
    }
}
