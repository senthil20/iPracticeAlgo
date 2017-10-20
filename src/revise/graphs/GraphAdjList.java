package revise.graphs;

import java.util.*;

class Node {
    public static int edgeCount = 0;
    public final String label;
    Node previous;
    List<Edge> neighbours;

    Node(String label) {
        this.label = label;
    }

    public void addEdge(double weight, Node dest) {
        this.neighbours.add(new Edge(weight, this, dest));
        edgeCount++;
    }

    public void removeEdge(Node dest) {
        this.neighbours.remove(dest);
        edgeCount--;
    }
}

class Edge {
    double weight;
    Node src;
    Node dest;

    Edge(double weight, Node src, Node dest) {
        this.weight = weight;
        this.src = src;
        this.dest = dest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        if (Double.compare(edge.weight, weight) != 0) return false;
        return dest.equals(edge.dest);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(weight);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + dest.hashCode();
        return result;
    }
}

public class GraphAdjList {

    public int vertexCount = 0;
    private Map<String, Node> graph = new HashMap<>();

    GraphAdjList(int vertex) {
        this.vertexCount = vertex;
    }

    public Node addVertex(String vertexName) throws Exception {
        Node node = null;
        if (!graph.containsKey(vertexName)) {
            node = new Node(vertexName);
            graph.put(vertexName, node);
        }
        else {
            throw new Exception("Vertex exists already!");
        }
        return node;
    }

    public void addEdge(double weight, String srcVertex, String destVertex) throws Exception {
        if (graph.containsKey(srcVertex)) {
            Node src = graph.get(srcVertex);
            Node dest = null;
            if (graph.containsKey(destVertex)) {
                dest = graph.get(destVertex);
            }
            else {
                dest = addVertex(destVertex);
            }
            src.addEdge(weight, dest);
        }
        else {
            throw new Exception("Source vertex not available!");
        }
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
        graphAdjList.addVertex("CA");
        graphAdjList.addVertex("NY");
        graphAdjList.addVertex("CO");
        graphAdjList.addVertex("NJ");
        graphAdjList.addVertex("PA");
        graphAdjList.addVertex("CM");

        graphAdjList.graph.get("CA").addEdge(40, graphAdjList.graph.get("NY"));
        graphAdjList.graph.get("CA").addEdge(60, graphAdjList.graph.get("NJ"));
        graphAdjList.graph.get("NY").addEdge(50, graphAdjList.graph.get("CO"));
        graphAdjList.graph.get("CO").addEdge(60, graphAdjList.graph.get("PA"));
        graphAdjList.graph.get("PA").addEdge(40, graphAdjList.graph.get("CM"));

        System.out.println(graphAdjList.graph);
    }
}
