package Data_Structures.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;
    

    public BinarySearchTree(){
        root = null;
    }

    public void insert(T value){
        root = insertRec(root, value);
    }

    public boolean lookup(T value){
        return searchRec(root, value);
    }

    public boolean remove(T value){
        Node<T> parentNode = null;
        Node<T> currentNode = root;

        if(currentNode == null) return false;

        // Find the node to remove
        while (currentNode != null && currentNode.getValue() != value){
            parentNode = currentNode;
            if(value.compareTo(currentNode.getValue()) < 0){
                currentNode = currentNode.getLeft();
            }else{
                currentNode = currentNode.getRight();
            }
        }

        // If the node to remove is not found, return false
        if(currentNode == null) return false;

        // Case 1: Leaf Node
        if(currentNode.getLeft() == null && currentNode.getRight() == null){
            if(parentNode == null){
                root = null;
            } else if (parentNode.getLeft() == currentNode) {
                parentNode.setLeft(null);
            }else{
                parentNode.setRight(null);
            }
        }
        // Case 2 : Node with only one child
        else if (currentNode.getLeft() == null || currentNode.getRight() == null) {
            Node<T> childNode = (currentNode.getLeft() != null) ? currentNode.getLeft() : currentNode.getRight();
            if(parentNode == null){
                root = childNode;
            } else if (parentNode.getLeft() == currentNode) {
                parentNode.setLeft(childNode);
            }else{
                parentNode.setRight(childNode);
            }
        }
        // Case 3: Node whit two children
        else{
            Node<T> successorParent = currentNode;
            Node<T> successor = currentNode.getRight();

            while (successor.getLeft() != null){
                successorParent = successor;
                successor = successor.getLeft();
            }

            if(successorParent != currentNode){
                successorParent.setLeft(successor.getRight());
                successor.setRight(currentNode.getRight());
            }

            if(parentNode == null){
                root = successor;
            } else if (parentNode.getLeft() == currentNode) {
                parentNode.setLeft(successor);
            }else{
                parentNode.setRight(successor);
            }

            successor.setLeft(currentNode.getLeft());
        }

        return true;
    }

    public void printTree() {
        printTreeRec(root, 0);
    }

    private Node<T> insertRec(Node<T> root, T value){
        if(root == null){
            root = new Node<T>(value);
            return root;
        }
        if(value.compareTo(root.getValue()) < 0){
            root.setLeft(insertRec(root.getLeft(), value));
        }else if(value.compareTo(root.getValue()) > 0){
            root.setRight(insertRec(root.getRight(),value));
        }

        return root;
    }

    private boolean searchRec(Node<T> root , T value){
        if(root == null) return false;
        if(value.compareTo(root.getValue()) == 0) return true;

        if(value.compareTo(root.getValue()) < 0){
            return searchRec(root.getLeft(), value);
        }

        return searchRec(root.getRight(), value);
    }

    ///////////////////////////////////////////////////////
    //                breadth first traversal            //
    //   note: {this method is from algorithms section}  //
    ///////////////////////////////////////////////////////
    public ArrayList<T> breadthFirstTraversal(){
        ArrayList<T> resultArray = new ArrayList<>();
        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
        
            Node<T> currentNode = queue.poll();
            resultArray.add(currentNode.getValue());
            if(currentNode.getLeft() != null){
                queue.offer(currentNode.getLeft());
            }
            if(currentNode.getRight() != null){
                queue.offer(currentNode.getRight());
            }
        }

        return resultArray;
    }

    ///////////////////////////////////////////////////////
    //          breadth first traversal recursive        //
    //   note: {this method is from algorithms section}  //
    ///////////////////////////////////////////////////////
    public ArrayList<T>breadthFirstTraversalRecursive(Queue<Node<T>> queue, ArrayList<T> resultArray){
        if(queue.isEmpty()){
            return resultArray;
        }
        Node<T> currentNode = queue.poll();
        resultArray.add(currentNode.getValue());
        if(currentNode.getLeft() != null){
            queue.offer(currentNode.getLeft());
        }
        if(currentNode.getRight() != null){
            queue.offer(currentNode.getRight());
        }

        return breadthFirstTraversalRecursive(queue, resultArray);
    }

    ///////////////////////////////////////////////////////
    //////////              DFS               /////////////
    ///////////////////////////////////////////////////////
    public ArrayList<T>DFSInOrder(){
        ArrayList<T> array = new ArrayList<>();
        return traverseInOrder(this.root, array);
    }

    public ArrayList<T>DFSPreOrder(){
        ArrayList<T> array = new ArrayList<>();
        return traversePreOrder(this.root, array);
    }

    public ArrayList<T>DFSPostOrder(){
        ArrayList<T> array = new ArrayList<>();
        return traversePostOrder(this.root, array);
    }

    private ArrayList<T> traverseInOrder(Node<T> node, ArrayList<T> array){
        if(node.getLeft() != null){
            traverseInOrder(node.getLeft(), array);
        }
        array.add(node.getValue());
        if(node.getRight() != null){
            traverseInOrder(node.getRight(), array);
        }
        return array;
    }

    private ArrayList<T> traversePreOrder(Node<T> node, ArrayList<T> array){
        array.add(node.getValue());

        if(node.getLeft() != null){
            traversePreOrder(node.getLeft(), array);
        }

        if(node.getRight() != null){
            traversePreOrder(node.getRight(), array);
        }
        return array;
    }

    private ArrayList<T> traversePostOrder(Node<T> node, ArrayList<T> array){

        if(node.getLeft() != null){
            traversePostOrder(node.getLeft(), array);
        }

        if(node.getRight() != null){
            traversePostOrder(node.getRight(), array);
        }
        array.add(node.getValue());
        return array;
    }

    private void printTreeRec(Node<T> root, int level) {
        if (root != null) {
            printTreeRec(root.getRight(), level + 1);
            for (int i = 0; i < level; i++)
                System.out.print("\t");
            System.out.println(root.getValue());
            printTreeRec(root.getLeft(), level + 1);
        }
    }

    public static void main(String[] args) {
       BinarySearchTree<Integer> bst = new BinarySearchTree<>();

       // Inserting elements into the tree
       bst.insert(9);
       bst.insert(4);
       bst.insert(6);
       bst.insert(20);
       bst.insert(99);
       bst.insert(15);
       bst.insert(1);
//       bst.insert(95);
//       bst.insert(98);
//       bst.insert(94);
//       bst.insert(5);
       
        // Call the breadth-first traversal method
       System.out.println("BFS: " + bst.breadthFirstTraversal());

        // Create an empty queue and ArrayList
        Queue<Node<Integer>> queue = new LinkedList<>();

        // Add the root node to the queue
        queue.offer(bst.root);

        // Call the recursive breadth-first traversal method
        System.out.println("Recursive BFS: " + bst.breadthFirstTraversalRecursive(queue, new ArrayList<>()));

        System.out.println("dfs inOrder: " + bst.DFSInOrder());
        System.out.println("dfs preOrder: " + bst.DFSPreOrder());
        System.out.println("dfs postOrder: " + bst.DFSPostOrder());


//        Printing the tree
        System.out.println("Binary Search Tree before removal:");
        bst.printTree();
//        System.out.println();

    //    // Searching for an element in the tree
    //    int elementToSearch = 20;
    //    System.out.println("Searching for " + elementToSearch + ": " + bst.lookup(elementToSearch));
    //    System.out.println();

    //    // Removing an element from the tree
    //    int elementToRemove = 4;
    //    System.out.println("Removing " + elementToRemove + ": " + bst.remove(elementToRemove));
    //    System.out.println();

    //    // Printing the tree after removal
    //    System.out.println("Binary Search Tree after removal:");
    //    bst.printTree();

    }
}
