package Revise.graphs;

abstract class Graph {

    public int vertices;
    public int edges;

    Graph() {
        vertices = 0;
        edges = 0;
    }

    public void addVertices(int v) {
        implementVertices(v);
        vertices++;
    }

    public void addEdges(int v) {
        implementVertices(v);
        edges++;
    }

    public abstract int getNeighbours();

    public abstract void implementVertices(int v);

    public abstract void implementEdges(int v, int e);


}
