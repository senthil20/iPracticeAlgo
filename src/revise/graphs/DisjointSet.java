package revise.graphs;

import java.util.HashMap;
import java.util.Map;

class UnionFindNode {
    int rank;
    String vertexName;
    UnionFindNode parent;

    UnionFindNode(String vertex) {
        this.parent = this;
        this.vertexName = vertex;
        this.rank = 0;
    }
}

public class DisjointSet {
    static Map<String, UnionFindNode> unionMap = new HashMap<>();

    //make set
    public static void initializeSet(String[] vertexName) {
        if (vertexName == null || vertexName.length == 0) return;
        for (String vertex : vertexName)
            unionMap.put(vertex, new UnionFindNode(vertex));
    }

    //union - find set
    public static void unionFind(String[] edgeSet) {
        UnionFindNode parent1 = find(unionMap.get(edgeSet[0]));
        UnionFindNode parent2 = find(unionMap.get(edgeSet[1]));

        if (parent1 == parent2) return;

        if (parent1.rank > parent2.rank) {
            parent2.parent = parent1;
        }
        else if (parent2.rank > parent1.rank){
            parent1.parent = parent2;
        }
        else {
            parent1.rank += 1;
            parent2.parent = parent1;
        }
    }

    public static UnionFindNode findRepresentative(String vertexName) {
        return unionMap.get(vertexName);
    }

    public static UnionFindNode find(UnionFindNode node) {
        UnionFindNode parent = node.parent;
        if (node == parent) return node;
        node.parent = find(node.parent); //(setting top parent to all sub child)path compression
        return node.parent;
    }

    //eg:1
    /*
           40      50
        CA --> NY --->CO
        ^    /        |
     60 |   /      60 |
        |  <          > 40
        NJ            PA --> CM

        CA --> NY
        NY --> NJ
        NJ --> CA
        NY --> CO
        CO --> PA
        PA --> CM

        CA  NY  NJ  CO  PA

        CA(1)
        /                   CA --> NY
       NY(0)

        CA(1)
       /   \                NY --> NJ
     NY(0)  NJ(0)

        CA(1)
       /   \                NJ --> CA
     NY(0)  NJ(0)

           CA(1)
       /    \     \         NY --> CO
     NY(0)  NJ(0)  CO(0)

              CA(1)
       /    \     \     \         CO --> PA
     NY(0)  NJ(0)  CO(0) PA(0)

     */


    //eg:2
    /**
     *     CA --> NJ
     *     CA --> PA
     *     PA --> CO
     *     CO --> NY
     *     NY --> VI
     *
     *     CA  NJ  PA  CO  NY  VI
     *
     * a).    CA(1)             CA --> PA
     *       /
     *      NJ(0)
     *
     *
     * b).   CA(1)              PA --> CO
     *      /   \
     *  NJ(0)   PA(0)
     *
     *
     * c).     CA(1)            CO --> NY
     *      /    \   \
     *  NJ(0)  PA(0)  CO(0)
     *
     *
     * d).        CA(1)         NY --> VI
     *      /    \   \     \
     *  NJ(0)  PA(0)  CO(0)  NY(0)
     *
     *
     * e).        CA(1)
     *      /    \   \     \        \
     *  NJ(0)  PA(0)  CO(0)  NY(0)   VI(0)
     *
     */

    public static void main(String a[]) {
        initializeSet(new String[]{"CA", "NJ", "PA", "CO", "NY", "VI"});//states
        unionFind(new String[]{});
        unionFind(new String[]{});
        unionFind(new String[]{});
        unionFind(new String[]{});
    }
}
