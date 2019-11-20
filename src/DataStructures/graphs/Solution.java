package DataStructures.graphs;

import java.util.*;

public class Solution {

    static class Node {
        int id;
        Queue<Node> adjacentList = new LinkedList<>();
        Node(int id) {
            this.id = id;
        }
    }

    public static class Graph {
        Map<Integer, Node> lookupMap = null;
        public Graph(int size) {
            lookupMap = new HashMap<>(size);
            for (int i = 0; i < size; i++) {
                lookupMap.put(i, new Node(i));
            }
        }

        public void addEdge(int first, int second) {
            Node src = getNode(first - 1);
            Node dest = getNode(second - 1);
            src.adjacentList.add(dest);
            dest.adjacentList.add(src);
        }

        public Node getNode(int nodeId) {
            if (!lookupMap.containsKey(nodeId)) {
                lookupMap.put(nodeId, new Node(nodeId));
            }
            return lookupMap.get(nodeId);
        }

        public int[] shortestReach(int startId) { // 0 indexed
            startId = startId - 1;
            int[] dist = new int[lookupMap.size()];
            Arrays.fill(dist, -1);
            Queue<Node> queue = new LinkedList<>();
            queue.add(lookupMap.get(startId));
            dist[lookupMap.get(startId).id] = 0;
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                for (Node neighbour: node.adjacentList) {
                    if (dist[neighbour.id] == -1) {
                        dist[neighbour.id] = dist[node.id] + 6;
                        queue.add(neighbour);
                    }
                }
            }
            return dist;
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(2, 5);
        int[] res = g.shortestReach(2);
        System.out.println(res);
    }
}