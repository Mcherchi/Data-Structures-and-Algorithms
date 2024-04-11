package Data_Structures.Stack;

public interface StackInterface<T> {
    void push(T element);
    T pop();
    T peek();
    T element();
    boolean isEmpty();
     default boolean isFull() {
        return false;
    }
}
