package Data_Structures.Queue;

import java.util.NoSuchElementException;

public class Queue<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public Queue(){
        first = null;
        last = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public T peek(){
        if(first == null){
            return null;
        }
        return first.getValue();
    }

    public void enqueue(T element){
        Node<T> node = new Node<>(element);
        if(size == 0){
            first = node;
            last = node;
        }else {
            last.setNext(node);
            last = last.getNext();
        }

        size++;
    }

    public T dequeue(){
        if(first == null){
            throw  new NoSuchElementException();
        }
        if(size == 1){
            last = null;
        }
        T elementDequeued = first.getValue();
        first = first.getNext();
        size--;
        return elementDequeued;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: [");
        Node<T> current = first;
        while (current != null) {
            sb.append(current.getValue());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
       Queue<Integer> queue = new Queue<Integer>();

        // Add elements to the queue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        // Print the queue
        System.out.println("Queue after enqueue: " + queue.toString());

        // Check the first element without removing it
        System.out.println("First element without removing: " + queue.peek());

        // Remove an element from the queue
        int removedElement = queue.dequeue();
        System.out.println("Element removed from the queue: " + removedElement);
        queue.dequeue();

        // Print the queue after removal
        System.out.println("Queue after removal: " + queue.toString());

        // Check if the queue is empty
        System.out.println("Is the queue empty? " + queue.isEmpty());

        // Get the size of the queue
        System.out.println("Size of the queue: " + queue.size());
    }
}
