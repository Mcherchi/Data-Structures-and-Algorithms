package Data_Structures.LinkedList.Singly_LinkedList;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public T getHeadValue(){
        if(head != null) return head.getValue();
        return null;
    }

    public T getTailValue(){
        if(tail != null) return tail.getValue();
        return null;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void empty(){
        head = null;
        tail = null;
        size = 0;
    }
    public boolean append(T value){
        Node<T> node = new Node<>(value);
        if(tail == null){
            head = node;
            tail = node;
        }else{
            tail.setNext(node);
            tail = tail.getNext();
        }

        size++;
        return true;
    }

    public boolean prepend(T value){
        Node<T> node = new Node<>(value);
        if(head == null){
            head = node;
            tail = node;
        }else{
            node.setNext(head);
            head = node;
        }
        size++;
        return  true;
    }

    public boolean insert(int index, T value){
        if(index < 0 || index > size) throw new IndexOutOfBoundsException("invalid index");
        if(index == 0) return prepend(value);
        if(index == size) return append(value);

        Node<T> node = new Node<>(value);

        Node<T> leader = getNodeAtIndex(index - 1);

        if (leader == null) {
            throw new IllegalStateException("Failed to find node at index " + (index - 1));
        }
        node.setNext(leader.getNext());

        leader.setNext(node);
        size++;
        return true;
    }

    public T remove(int index){
        if(index < 0 || index > size - 1) throw new IndexOutOfBoundsException("invalid index");
        if(size == 0 || head == null) return null;

        T value = null;

        if(index == 0){
            value = head.getValue();
            head = head.getNext();
        }else{
            Node<T> leader = getNodeAtIndex(index - 1);
            value = leader.getNext().getValue();
            leader.setNext(leader.getNext().getNext());
        }
        size--;
        return value;
    }

    public boolean reverse(){
        if(size < 2 || head == null || tail == null) return false;
        tail = head;
        Node<T> first = head;
        Node<T> second = first.getNext();
        Node<T> tempNode;

        while (second != null){
            tempNode = second.getNext();
            second.setNext(first);
            first = second;
            second = tempNode;
        }

        tail.setNext(null);
        head = first;
        return true;
    }

    public T get(int index){
        if(index > size - 1 || index < 0) throw new IndexOutOfBoundsException("invalid index");
        if (this.size == 0 || this.head == null || this.tail == null) return null;
        if(index == 0) return head.getValue();
        if(index == size - 1) return this.tail.getValue();

        Node<T> targetNode = getNodeAtIndex(index);
        return targetNode != null ? targetNode.getValue() : null;
    }

    private Node<T> getNodeAtIndex(int index){
        if(head == null) return null;
        Node<T> currentNode = head;
        for(int i = 0; i < index; i++){
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }


    @Override
    public String toString() {
        if (this.size == 0 || this.head == null) {
            return "";
        }

        int nodesPerGroup = 6;

        final String LABEL_HEAD = "HEAD";
        final String LABEL_TAIL = "TAIL";

        StringBuilder listAsString = new StringBuilder("--- Node Count: " + this.size + "\n");
        Node<T> currentNode = this.head;

        for (int i = 0; i < this.size; ++i) {
            listAsString.append("\t".repeat(Math.max(0, i % nodesPerGroup)));
            listAsString.append(" ").append(i == 0 ? LABEL_HEAD : i).append(" ").append(currentNode).append(" ")
                    .append(i == this.size - 1 ? LABEL_TAIL : "").append("\n");

            if (currentNode.hasNext()) {
                currentNode = currentNode.getNext();
            }
        }

        return listAsString.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println("LinkedList is empty: " + linkedList.isEmpty());
        System.out.println("LinkedList size: " + linkedList.size());
        System.out.println("Head: " + linkedList.getHeadValue());
        System.out.println("tail: " + linkedList.getTailValue());

        System.out.println("\nAfter append method: \n");

        linkedList.append(10);
        linkedList.append(20);
        linkedList.append(30);
        System.out.println("LinkedList is empty: " + linkedList.isEmpty());
        System.out.println("LinkedList size: " + linkedList.size());
        System.out.println("Head: " + linkedList.getHeadValue());
        System.out.println("Tail: " + linkedList.getTailValue());
        System.out.println(linkedList);

        System.out.println("\nAfter prepend method: \n");
        linkedList.prepend(40);
        System.out.println("Head: " + linkedList.getHeadValue());
        System.out.println(linkedList);

        System.out.println("\nAfter insert method: \n");
        linkedList.insert(1, 15);
        System.out.println("value at index 1: " + linkedList.get(1));
        System.out.println(linkedList);

        System.out.println("\nAfter remove method: \n");
        System.out.println("removed value: " + linkedList.remove(3));
        System.out.println(linkedList);

        System.out.println("\nAfter reverse method: \n");
        linkedList.reverse();
        System.out.println(linkedList);

        System.out.println("\nAfter empty method: \n");
        linkedList.empty();
        System.out.println("LinkedList is empty: " + linkedList.isEmpty());
        System.out.println("LinkedList size: " + linkedList.size());
        System.out.println("Head: " + linkedList.getHeadValue());
        System.out.println("tail: " + linkedList.getTailValue());
    }
}
