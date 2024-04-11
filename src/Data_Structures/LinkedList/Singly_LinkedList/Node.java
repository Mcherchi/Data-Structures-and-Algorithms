package Data_Structures.LinkedList.Singly_LinkedList;

public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value){
        this.value = value;
        this.next = null;
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

    public boolean hasNext(){
        return this.next != null;
    }

    @Override
    public String toString() {
        return "{value: " + this.value.toString() + ", next: " + (this.hasNext() ? "true" : "false") + "}";
    }
}
