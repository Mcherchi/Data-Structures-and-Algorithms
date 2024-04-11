package Data_Structures.LinkedList.Doubly_LinkedList;

public class Node<T> {
    private T value;
    private Node<T> next;
    private Node<T> previous;

    public Node(T value) {
        this.value = value;
        next = null;
        previous = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public boolean hasNext() {
        return next != null;
    }

    public boolean hasPrevious() {
        return previous != null;
    }

    @Override
    public String toString() {
        return "{value: " + this.value.toString() +
                ", previous: " + (this.hasPrevious() ? "true" : "false") +
                ", next: " + (this.hasNext() ? "true" : "false") +
                "}";
    }
}
