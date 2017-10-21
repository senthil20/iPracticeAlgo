package revise.graphs;

import java.util.*;

class Node {
    String vertexName;
    List<Node> adjList;
    boolean isVisited = false;

    Node (String vertex) {
        this.vertexName = vertex;
        this.adjList = new ArrayList<>();
    }
}

public class GraphList {

    public static List<Node> cloneGraphDFS(List<Node> node) {
        if (node == null || node.size() == 0) return null;
        Map<String, Node> visited = new HashMap<>();
        List<Node> result = new ArrayList<>();
        for (Node n : node) {
            if (!visited.containsKey(n)) {
                Node clone = dfs(n, visited);
                result.add(clone);
            }
        }
        return result;
    }

    public static Node dfs(Node n, Map<String, Node> visited) {
        if (n == null) return n;
        if (visited.containsKey(n)) return visited.get(n);
        Node clone = new Node(n.vertexName);
        visited.put(n.vertexName, clone);
        for (Node child : n.adjList) {
            Node subGraph = dfs(child, visited);
            clone.adjList.add(subGraph);
        }
        return clone;
    }

    public static List<Node> cloneGraphBFS(List<Node> node) {
        if (node == null || node.size() == 0) return null;
        List<Node> result = new ArrayList<>();
        Map<String, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        for (Node n : node) {
            if (visited.containsKey(n.vertexName)) {
                return result;
            }
            Node clone = new Node(n.vertexName);
            queue.add(n);
            visited.put(n.vertexName, clone);
            while (!queue.isEmpty()) {
                Node temp = queue.poll();
                for (Node child : temp.adjList) {
                    if (!visited.containsKey(child.vertexName)) {
                        Node c = new Node(child.vertexName);
                        queue.offer(child);
                        visited.put(child.vertexName, c);
                        visited.get(temp.vertexName).adjList.add(c);
                    }
                    else {
                        visited.get(temp.vertexName).adjList.add(visited.get(child.vertexName));
                    }
                }
            }
            result.add(clone);
        }
        return result;
    }

    /*     40      50
        CA --  NY --- CO
        |     /        |
     60 |   / 70    60 |
        | /            | 40
        NJ            PA -- CM

     */
    public static void main(String[] args) throws Exception {

        List<Node> list = new ArrayList<>();
        Node ca = new Node("CA");
        Node ny = new Node("NY");
        Node nj = new Node("NJ");
        Node co = new Node("CO");
        Node pa = new Node("PA");
        Node cm = new Node("CM");

        list.add(ca);list.add(ny);list.add(nj);list.add(co);list.add(pa);list.add(cm);

        ca.adjList.add(ny); ny.adjList.add(ca);
        ca.adjList.add(nj); nj.adjList.add(ca);
        nj.adjList.add(ny); ny.adjList.add(nj);
        ny.adjList.add(co); co.adjList.add(ny);
        co.adjList.add(pa); pa.adjList.add(co);
        pa.adjList.add(cm); cm.adjList.add(pa);

        /*List<Node> result = cloneGraphDFS(list);
        System.out.println(result);*/

        List<Node> result = cloneGraphBFS(list);
        System.out.println(result);
    }
}
