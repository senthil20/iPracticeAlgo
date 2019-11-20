package Revise.graphs;

import java.util.*;

class Node1 {

    String vertexName;
    List<Node1> adjList;
    boolean isVisited = false;

    Node1 (String vertex) {
        this.vertexName = vertex;
        this.adjList = new ArrayList<>();
    }
}

public class GraphList {

    /*     40      50
        CA --  NY --- CO
        |     /        |
     60 |   / 70    60 |
        | /            | 40
        NJ            PA -- CM

     */
    public static List<Node1> cloneGraphDFS(List<Node1> Node1) {
        if (Node1 == null || Node1.size() == 0) return null;
        Map<String, Node1> visited = new HashMap<>();
        List<Node1> result = new ArrayList<>();
        for (Node1 n : Node1) {
            if (!visited.containsKey(n.vertexName)) {
                Node1 clone = dfs(n, visited);
                result.add(clone);
            }
        }
        return result;
    }

    public static Node1 dfs(Node1 n, Map<String, Node1> visited) {
        if (n == null) return n;
        if (visited.containsKey(n.vertexName)) return visited.get(n);
        Node1 clone = new Node1(n.vertexName);
        visited.put(n.vertexName, clone);
        for (Node1 child : n.adjList) {
            Node1 subGraph = dfs(child, visited);
            clone.adjList.add(subGraph);
        }
        return clone;
    }

    public static List<Node1> cloneGraphBFS(List<Node1> Node1) {
        if (Node1 == null || Node1.size() == 0) return null;
        List<Node1> result = new ArrayList<>();
        Map<String, Node1> visited = new HashMap<>();
        Queue<Node1> queue = new LinkedList<>();

        for (Node1 n : Node1) {
            if (visited.containsKey(n.vertexName)) {
                return result;
            }
            Node1 clone = new Node1(n.vertexName);
            queue.add(n);
            visited.put(n.vertexName, clone);
            while (!queue.isEmpty()) {
                Node1 temp = queue.poll();
                for (Node1 child : temp.adjList) {
                    if (!visited.containsKey(child.vertexName)) {
                        Node1 c = new Node1(child.vertexName);
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

    public static Map<Node1, Integer> getIndegreeCount(List<Node1> Node1s) {
        Map<Node1, Integer> result = new HashMap<>();
        if (Node1s == null || Node1s.size() == 0) return result;
        for (Node1 Node1 : Node1s) {
            for (Node1 child : Node1.adjList) {
                result.put(child, result.getOrDefault(child, 0) + 1);
            }
        }
        return result;
    }


    /*
    acyclic
           40      50
        CA --> NY --->CO
        ^     >       |
     60 |   / 70   60 |
        | /           >  40
        NJ            PA --> CM
     */

    /*
    cylic
            40      50
        CA --> NY --->CO
        ^    /        |
     60 |   /      60 |
        |  <          > 40
        NJ            PA --> CM
     */

    public static boolean isCyclic(List<Node1> Node1s) {
        if (Node1s == null || Node1s.size() == 0) return false;
        Map<Node1, Integer> indegreeMap = getIndegreeCount(Node1s);
        for (Node1 n : Node1s) {
            if (!indegreeMap.containsKey(n))
                dfsforCyclicCheck(n, indegreeMap);
        }
        for (Map.Entry<Node1, Integer> entrySet : indegreeMap.entrySet()) {
            if (entrySet.getValue() > 0) {
                return true;
            }
        }
        return false;
    }

    public static void dfsforCyclicCheck(Node1 n, Map<Node1, Integer> indegree) {
        if (indegree.get(n) != 0)
            return;
        indegree.put(n, -1);
        for (Node1 child : n.adjList) {
            indegree.put(child, indegree.get(child) - 1);
            dfsforCyclicCheck(child, indegree);
        }
    }


    public static void main(String[] args) throws Exception {

        List<Node1> list = new ArrayList<>();
        Node1 ca = new Node1("CA");
        Node1 ny = new Node1("NY");
        Node1 nj = new Node1("NJ");
        Node1 co = new Node1("CO");
        Node1 pa = new Node1("PA");
        Node1 cm = new Node1("CM");

        list.add(ca);list.add(ny);list.add(nj);list.add(co);list.add(pa);list.add(cm);

        //undirected
        ca.adjList.add(ny); ny.adjList.add(ca);
        ca.adjList.add(nj); nj.adjList.add(ca);
        nj.adjList.add(ny); ny.adjList.add(nj);
        ny.adjList.add(co); co.adjList.add(ny);
        co.adjList.add(pa); pa.adjList.add(co);
        pa.adjList.add(cm); cm.adjList.add(pa);

        /*//directed
        ca.adjList.add(ny);
        //ny.adjList.add(nj); //cylic
        nj.adjList.add(ny); //acyclic
        nj.adjList.add(ca);
        ny.adjList.add(co);
        co.adjList.add(pa);
        pa.adjList.add(cm);*/

        List<Node1> result = cloneGraphDFS(list);
        System.out.println(result);

        /*List<Node1> result = cloneGraphBFS(list);
        System.out.println(result);*/

        /*Map<Node1, Integer> result = getIndegreeCount(list);
        System.out.println(result);*/

        boolean isCyclic = isCyclic(list);
        System.out.println(isCyclic);
    }
}
