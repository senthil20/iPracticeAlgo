package revise.graphs;

import java.util.ArrayList;
import java.util.List;

class Node {
    int value;
    List<Integer> adjList = new ArrayList<>();
    Node(int val) {
        this.value = val;
    }
    Node (int val, int[] edges) {
        this.value = val;
        for (int value : edges) {
            this.adjList.add(value);
        }
    }
}

public class GraphBasics {
      // 0  1  2  3  4  5
    /*0 {0, 1, 0, 0, 0, 0}*/
    /*1 {0, 0, 0, 0, 0, 0}*/
    /*2 {0, 0, 0, 1, 0, 0}*/
    /*3 {0, 0, 0, 0, 0, 0}*/
    /*4 {0, 0, 0, 1, 0, 0}*/
    /*5 {0, 0, 0, 1, 1, 0}}*/
    /**
     1 > 2
     2
       >
        3
       >  <
      4  <  5
     * */

    public static List<Integer> getNeighboursInAdjMatrix(int[][] A, int v) {
        if (A == null || A.length == 0 || v >= A.length) return null;
        List<Integer> neighbours = new ArrayList<>();
        for (int i = 0; i < A.length; i++) { //A.length = no. of vertices
            if (A[v][i] != 0) {
                neighbours.add(i);
            }
        }
        return neighbours;
        /*List<Integer> neighbors = new ArrayList<Integer>();
        for (int i = 0; i < A.length; i ++) {
            for (int j=0; j < A[v][i]; j ++) {
                neighbors.add(i);
            }
        }
        return neighbors;*/
    }


    public int getIndegreeCountInAdjMatrix(List<Node> adjListNodes, int key) {
        return 0;
    }

    public static void main(String a[]) {
        int A[][] = new int[][] {
             //  0  1  2  3  4  5
           /*0*/{0, 1, 0, 0, 0, 0},
           /*1*/{0, 0, 0, 0, 0, 0},
           /*2*/{0, 0, 0, 3, 0, 0},
           /*3*/{0, 0, 0, 0, 0, 0},
           /*4*/{0, 0, 0, 1, 0, 0},
           /*5*/{0, 0, 0, 1, 1, 0}};
        List<Integer> adjList = getNeighboursInAdjMatrix(A, 2);
        System.out.println(adjList);
    }
}
