package com.barry.struct.graph;

public class GraphAdjList {
    private VertexNode[] adjList;
    private int numVertexes;
    private int numEdges;

    public VertexNode[] getAdjList() {
        return adjList;
    }

    public void setAdjList(VertexNode[] adjList) {
        this.adjList = adjList;
    }

    public int getNumVertexes() {
        return numVertexes;
    }

    public void setNumVertexes(int numVertexes) {
        this.numVertexes = numVertexes;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public void setNumEdges(int numEdges) {
        this.numEdges = numEdges;
    }
}
