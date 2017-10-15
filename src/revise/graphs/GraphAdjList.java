package revise.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphAdjList extends Graph {

    Map<Integer, List<Integer>> adjMap = new HashMap<>();
    GraphAdjList() {
    }

    @Override
    public void implementVertices(int v) {
        List<Integer> adjList = new ArrayList<>();
        adjMap.put(v, adjList);
    }

    @Override
    public void implementEdges(int v, int e) {
        adjMap.get(v).add(e);
    }

    @Override
    public int getNeighbours() {
        return 0;
    }

}
