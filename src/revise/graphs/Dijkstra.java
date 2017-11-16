package revise.graphs;

import java.util.*;

public class Dijkstra {

    static GraphAdjList graphAdjList = null;

    public static void minDistanceDijkstra(String srcVertex, String endVertex) {
        Node srcNode = graphAdjList.graph.get(srcVertex);
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Double.compare(o1.minWeight, o2.minWeight);
            }
        });
        srcNode.minWeight = 0;
        pq.offer(srcNode);
        while (!pq.isEmpty()) {
            Node v = pq.poll();
            for (Edge e : v.neighbours) {
                Node edgeVertex = e.dest;
                double totalWeight = v.minWeight + e.weight;
                if (totalWeight < edgeVertex.minWeight) {
                    edgeVertex.minWeight = totalWeight;
                    edgeVertex.previous = v;
                    pq.offer(edgeVertex);
                }
            }
        }
        List<String> path = new ArrayList<>();
        Node n = graphAdjList.graph.get(endVertex);;
        for (; n != null && !n.equals(srcNode); n = n.previous) {
            path.add(n.label);
        }
        path.add(n.label);
        Collections.reverse(path);
        System.out.println(path);
    }

    public static void main(String[] args) throws Exception {
        graphAdjList = new GraphAdjList(6);

        graphAdjList.addVertex("A");
        graphAdjList.addVertex("B");
        graphAdjList.addVertex("C");
        graphAdjList.addVertex("D");
        graphAdjList.addVertex("E");

        graphAdjList.graph.get("A").addEdge(10, graphAdjList.graph.get("B"));
        graphAdjList.graph.get("A").addEdge(7, graphAdjList.graph.get("C"));
        graphAdjList.graph.get("A").addEdge(3, graphAdjList.graph.get("E"));
        graphAdjList.graph.get("B").addEdge(2, graphAdjList.graph.get("C"));
        graphAdjList.graph.get("C").addEdge(2, graphAdjList.graph.get("D"));
        graphAdjList.graph.get("D").addEdge(1, graphAdjList.graph.get("C"));
        graphAdjList.graph.get("E").addEdge(2, graphAdjList.graph.get("C"));
        graphAdjList.graph.get("E").addEdge(9, graphAdjList.graph.get("D"));

        System.out.println(graphAdjList.graph);
        minDistanceDijkstra("A", "C");
    }
}
