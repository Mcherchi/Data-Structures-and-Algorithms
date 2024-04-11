package Data_Structures.Trees;

public class Node<T> {
    private T value;
    private Node<T> left;
    private Node<T> right;

    public Node(T value){
        this.value = value;
        left = null;
        right = null;
    }

    public T getValue(){
        return value;
    }

    public void setLeft(Node<T> node){
        left = node;
    }

    public void setRight(Node<T> node){
        right = node;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
