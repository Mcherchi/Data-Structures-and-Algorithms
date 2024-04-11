package Data_Structures.LinkedList.Doubly_LinkedList;


public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public T getHeadValue() {
        if (head != null) return head.getValue();
        return null;
    }

    public T getTailValue() {
        if (tail != null) return tail.getValue();
        return null;
    }
    public int size(){
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void empty() {
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
            node.setPrevious(tail);
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
            head.setPrevious(node);
            head = node;
        }

        size++;
        return true;
    }

    public boolean insert(int index, T value){
        if(index < 0 || index > size) throw new IndexOutOfBoundsException("invalid index");
        if(index == 0) return prepend(value);
        if(index == size) return append(value);
        
        Node<T> node = new Node<>(value);
        Node<T> leaderNode = getNodeAtIndex(index - 1);
        if (leaderNode == null) {
            throw new IllegalStateException("Failed to find node at index " + (index - 1));
        }
        Node<T> followerNode = leaderNode.getNext();
        node.setPrevious(leaderNode);
        node.setNext(followerNode);
        leaderNode.setNext(node);
        followerNode.setPrevious(node);

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
            head.setPrevious(null);
        }else {
            Node<T> leader = getNodeAtIndex(index - 1);
            value = leader.getNext().getValue();
            leader.setNext(leader.getNext().getNext());
            leader.getNext().setPrevious(leader);
        }

        size--;
        return value;
    }

    public boolean reverse(){
        if(size < 2 || head == null || tail == null) return false;
        Node<T> currentNode = head;
        Node<T> previousNode = null;
        Node<T> nextNode = null;

        while (currentNode != null){
            nextNode = currentNode.getNext();
            currentNode.setNext(previousNode);
            currentNode.setPrevious(nextNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }

        tail = head;
        head = previousNode;
        return true;
    }

    public T get(int index){
        if(index > size - 1 || index < 0) throw new IndexOutOfBoundsException("invalid index");
        if (this.size == 0 || head == null || tail == null) return null;
        if(index == size - 1) return tail.getValue();
        if(index == 0) return head.getValue();

        Node<T> targetNode = getNodeAtIndex(index);
        return targetNode != null ? targetNode.getValue() : null;

    }


    private Node<T> getNodeAtIndex(int index){
        if(head == null || tail == null) return null;
        Node<T> currentNode = null;
        if(index < size / 2){
            currentNode = head;
            for(int i = 0; i < index; i++){
                currentNode = currentNode.getNext();
            }
        }else {
            currentNode = tail;
            for(int i = size - 1; i > index; i--){
                currentNode = currentNode.getPrevious();
            }
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
