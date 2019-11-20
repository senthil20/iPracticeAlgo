package DataStructures.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by User on 22-07-2017.
 */

// Some methods and signatures you'll find useful.
// Click 'Hide' to hide me.


class Vertex implements Comparable<Vertex> {
    public final String name;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous; // Previous optimal path node

    public Vertex(String argName) {
        name = argName;
    }

    public String toString() {
        return name;
    }

    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }
}

class Edge {
    public final Vertex target; // Target node of the edge
    public final double weight; // Edge weight

    public Edge(Vertex argTarget, double argWeight) {
        target = argTarget;
        weight = argWeight;
    }
}


public class DjikstraShortestPath {

    public static List<Vertex> getShortestPath(Vertex source, Vertex target) {
        computePaths(source);
        return getShortestPathTo(target);
    }

    public static List<Vertex> getShortestPathTo(Vertex target) {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);
        Collections.reverse(path);
        return path;
    }

    // Helper function to compute shortest path and store in each vertex
    public static void computePaths(Vertex source) {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();
            // Visit each edge exiting u
            for (Edge e : u.adjacencies) {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);
                    v.minDistance = distanceThroughU ;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }
}
