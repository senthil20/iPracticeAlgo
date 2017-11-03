package revise.graphs;

import java.util.*;

class Node1 {
    public static int edgeCount = 0;
    public final String label;
    Node1 previous;
    List<Edge> neighbours;

    Node1(String label) {
        this.label = label;
        this.neighbours = new LinkedList<>();
    }

    public void addEdge(double weight, Node1 dest) {
        this.neighbours.add(new Edge(weight, this, dest));
        //dest.neighbours.add(new Edge(weight, dest, this)); //undirected
        edgeCount++;
    }

    public void removeEdge(Node1 dest) {
        this.neighbours.remove(dest);
        //dest.neighbours.remove(this); //undirected
        edgeCount--;
    }
}

class Edge {
    double weight;
    Node1 src;
    Node1 dest;

    Edge(Node1 src, Node1 dest) {
        this.weight = 0.0;
        this.src = src;
        this.dest = dest;
    }

    Edge(double weight, Node1 src, Node1 dest) {
        this.weight = weight;
        this.src = src;
        this.dest = dest;
    }

    @Override
    //Used to get the right Edge object using src and dest vertex.
    //Haven't included weight here. Is it fine? Thought we can get the right edge using src and dest vertex. Also we have unique vertex.
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (!src.equals(edge.src)) return false;
        return dest.equals(edge.dest);
    }

    @Override
    public int hashCode() {
        int result = src.hashCode();
        result = 31 * result + dest.hashCode();
        return result;
    }
}

public class GraphAdjList {

    public int vertexCount = 0;
    private final static Map<String, Node1> graph = new HashMap<>();

    GraphAdjList(int vertex) {
        this.vertexCount = vertex;
    }

    public static Node1 addVertex(String vertexName) throws Exception {
        Node1 Node1 = null;
        if (!graph.containsKey(vertexName)) {
            Node1 = new Node1(vertexName);
            graph.put(vertexName, Node1);
        }
        else {
            throw new Exception("Vertex exists already!");
        }
        return Node1;
    }

    public static void addEdge(double weight, String srcVertex, String destVertex) throws Exception {
        if (graph.containsKey(srcVertex)) {
            Node1 src = graph.get(srcVertex);
            Node1 dest = null;
            if (graph.containsKey(destVertex)) {
                dest = graph.get(destVertex);
            }
            else {
                dest = addVertex(destVertex);
            }
            src.addEdge(weight, dest);
            //dest.addEdge(weight, src); //undirected
        }
        else {
            throw new Exception("Source vertex not available!");
        }
    }

    public static boolean hasEdge(String src, String dest) {
        Node1 srcNode1 = graph.get(src);
        Node1 destNode1 = graph.get(dest);
        return srcNode1.neighbours.contains(new Edge(srcNode1, destNode1));
    }

    public static Edge getEdge(String src, String dest) {
        Node1 srcNode1 = graph.get(src);
        Node1 destNode1 = graph.get(dest);
        int index = srcNode1.neighbours.indexOf(new Edge(srcNode1, destNode1));
        if (index != -1) {
            return srcNode1.neighbours.get(index);
        }
        return null;
    }

    public static int getNumberOfEdges() {
        int count = 0;
        if (!graph.isEmpty()) {
            List<Node1> Node1s = new ArrayList<>(graph.values());
            for (Node1 n : Node1s) {
                count += n.neighbours.size();
            }
        }
        return count;
    }

    public Map<String, Node1> cloneGraph(Map<String, Node1> graph) {
        for (Map.Entry<String, Node1> entry : graph.entrySet()) {


        }
        return null;
    }


    /*     40      50
        CA --  NY --- CO
        |     /        |
     60 |   / 70    60 |
        | /            | 40
        NJ            PA -- CM

     */
    public static void main(String[] args) throws Exception {
        GraphAdjList graphAdjList = new GraphAdjList(6);
        addVertex("CA");
        addVertex("NY");
        addVertex("CO");
        addVertex("NJ");
        addVertex("PA");
        addVertex("CM");

        GraphAdjList.graph.get("CA").addEdge(40, GraphAdjList.graph.get("NY"));
        GraphAdjList.graph.get("CA").addEdge(60, GraphAdjList.graph.get("NJ"));
        GraphAdjList.graph.get("NJ").addEdge(60, GraphAdjList.graph.get("NY"));
        GraphAdjList.graph.get("NY").addEdge(50, GraphAdjList.graph.get("CO"));
        GraphAdjList.graph.get("CO").addEdge(60, GraphAdjList.graph.get("PA"));
        GraphAdjList.graph.get("PA").addEdge(40, GraphAdjList.graph.get("CM"));

        //System.out.println(GraphAdjList.graph);

        //boolean isEdgeAvailable = GraphAdjList.hasEdge("CA", "NJ");
        //System.out.println(isEdgeAvailable);

        //int edgeCount = GraphAdjList.getNumberOfEdges();
        //System.out.println(edgeCount);

        Edge edge = GraphAdjList.getEdge("NJ", "NY");
        System.out.println(edge);
    }
}
