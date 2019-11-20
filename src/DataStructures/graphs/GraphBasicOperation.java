package DataStructures.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    String data;
    boolean visited;
    List<Node> adjacentNodes;
}
public class GraphBasicOperation {

    public boolean breadthFirstSearch(Node rootNode, String data){
        if(data == null || rootNode == null)
            return false;

        Queue<Node> q = new LinkedList<Node>();
        q.add(rootNode);
        rootNode.visited = true;

        while (!q.isEmpty()){
            Node n = q.poll();
            if(n.data != null && n.data.equals(data)) {
                return true;
            }
            for(Node adj : n.adjacentNodes){
                if(!adj.visited){
                    adj.visited = true;
                    q.add(adj);
                }
            }
        }
        return false;
    }

    public static void main(String a[]) {


    }
}
