package Data_Structures.Stack.Using_array;
import Data_Structures.Stack.StackInterface;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<T> implements StackInterface<T> {

    private static final int DEFAULT_CAPACITY = 5;
    private final int maxSize;
    private final T[] stackArray;
    private int top;

    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        maxSize = size;
        stackArray = (T[]) new Object[maxSize];;
        top = -1;
    }

    @Override
    public void push(T element) {
        if(isFull()){
            throw new StackOverflowError("Stack Overflow");
        }
        stackArray[++top] = element;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        T element = stackArray[top];

        stackArray[top--] = null;

        return element;
    }

    @Override
    public T peek() {
        if(isEmpty()) return null;
        return stackArray[top];
    }

    public T element(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stackArray[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack {\n");
        sb.append("  Top: ").append(top != -1 ? stackArray[top] : "null").append("\n");
        sb.append("  Elements: ").append(Arrays.toString(stackArray));
        sb.append("\n");
        sb.append("  Size: ").append(top + 1).append("\n}");
        return sb.toString();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Testing push method
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Stack after push operations:");
        System.out.println(stack);

        // Testing pop method
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack after pop operation:");
        System.out.println(stack);

        // Testing peek method
        System.out.println("Top element (peek): " + stack.peek());

        // Testing isEmpty method
        System.out.println("Is stack empty? " + stack.isEmpty());

        // Testing isFull method
        System.out.println("Is stack full? " + stack.isFull());

        // Testing element method
        System.out.println("Top element (element): " + stack.element());

        // Testing clear
        while (!stack.isEmpty()) {
            stack.pop();
        }
        System.out.println("Stack after clearing:");
        System.out.println(stack);

        // Testing Stack Overflow
        try {
            stack.push(6);
            stack.push(7);
            stack.push(8);
            stack.push(9);
            stack.push(10);
            stack.push(11); // This will cause Stack Overflow
        } catch (StackOverflowError e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Testing Stack Underflow
        try {
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop(); // This will cause Stack Underflow
        } catch (EmptyStackException e) {
            System.out.println("Error: " + e);
        }
    }
}
