package Data_Structures.Stack.Using_linkedList;
import Data_Structures.Stack.StackInterface;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Stack<T> implements StackInterface<T> {

    private Node<T> top;
    private Node<T> bottom;
    private int size;

    public Stack(){
        top = null;
        bottom = null;
        size = 0;
    }
    @Override
    public void push(T element) {
        Node<T> node = new Node<>(element);
        if (isEmpty()) {
            top = node;
            bottom = node;
        } else {
            node.setNext(top);
            top = node;
        }
        size++;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        if(top == bottom) {
            bottom = null;
        }
        T element = top.getValue();
        top = top.getNext();
        size--;
        return element;
    }

    @Override
    public T peek() {
        if(isEmpty()) return null;
        return top.getValue();
    }

    @Override
    public T element() {
        if(isEmpty()){
            throw new NoSuchElementException("Stack is Empty");
        }
        return top.getValue();
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack {\n");
        sb.append("  Top: ").append(top != null ? top.getValue() : "null").append("\n");
//        sb.append("  Bottom: ").append(bottom != null ? bottom.getValue() : "null").append("\n");
        sb.append("  Elements: [");

        Node<T> current = top;
        while (current != null) {
            sb.append(current.getValue());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]\n");
        sb.append("  Size: ").append(size).append("\n}");
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

        // Testing element method
        System.out.println("Top element (element): " + stack.element());

        // Testing clear
        while (!stack.isEmpty()) {
            stack.pop();
        }
        System.out.println("Stack after clearing:");
        System.out.println(stack);

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
