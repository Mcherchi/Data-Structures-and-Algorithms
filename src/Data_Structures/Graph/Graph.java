package Data_Structures.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Graph<T> {
    private final Map<T, List<T>> adjacentList;
    private int numberOfNodes;

    public Graph() {
        this.adjacentList = new HashMap<>();
        this.numberOfNodes = 0;
    }

    public void addNode(T value){
        if(!adjacentList.containsKey(value)){
            adjacentList.put(value, new ArrayList<>());
            numberOfNodes++;
        }else{
            System.out.println("Node: " + value + " already exists");
        }
    }

    public void removeNode(T value){
        if(adjacentList.containsKey(value)){
            List<T>neighbors = adjacentList.get(value);
            for(T neighbor: neighbors){
                adjacentList.get(neighbor).remove(value);
            }
            adjacentList.remove(value);
            numberOfNodes--;
          } else {
            System.out.println("The node " + value + " is not present in the graph.");
        }
    }

    public void addEdge(T value1, T value2){
        if(adjacentList.containsKey(value1) && adjacentList.containsKey(value2)){
            adjacentList.get(value1).add(value2);
            adjacentList.get(value2).add(value1);
        }else{
            System.out.println("One or both nodes are missing from the graph.");
        }
    }

    public void removeEdge(T value1, T value2){
        if(adjacentList.containsKey(value1) && adjacentList.containsKey(value2)){
            adjacentList.get(value1).remove(value2);
            adjacentList.get(value2).remove(value1);

            if(adjacentList.get(value1).isEmpty()){
                adjacentList.remove(value1);
                numberOfNodes--;
            }
            
            if(adjacentList.get(value2).isEmpty()){
                adjacentList.remove(value2);
                numberOfNodes--;
            }
        }else{
            System.out.println("One or both nodes are missing from the graph.");
        }
    }

    public int getNumberOfNodes(){
        return numberOfNodes;
    }

    public int getNumberOfEdges(){
        int numberOfEdges = 0;
        for(List<T> edges: adjacentList.values()){
            numberOfEdges += edges.size();
        }
        return numberOfEdges / 2;
    }

    public Set<T> getNodes() {
        return adjacentList.keySet();
    }


    public void showConnections() {
        Object[] keys = adjacentList.keySet().toArray();
        for (Object key : keys) {
            System.out.println(key + " ---> " + adjacentList.get(key));
        }
    }

    public static void main(String[] args) {
      Graph<Integer> graph = new Graph<Integer>();

        // Add some nodes to the graph
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addNode(6);

        // Add some edges to the graph
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(4, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(6, 5);

        // Show the connections in the graph
        System.out.println("Connections in the graph:");
        graph.showConnections();

        // Remove a node and show the updated connections
        System.out.println("\nRemoving node 4:");
        graph.removeNode(4);
        System.out.println("Connections after removal:");
        graph.showConnections();

        // Add a duplicate node and show the warning message
        System.out.println("\nAdding node 0 (duplicate):");
        graph.addNode(0);

        // Remove an edge and show the updated connections
        System.out.println("\nRemoving the edge between 1 and 3:");
        graph.removeEdge(2, 4);
        System.out.println("Connections after edge removal:");
        graph.showConnections();

    }
}
