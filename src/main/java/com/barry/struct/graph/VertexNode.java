package com.barry.struct.graph;

public class VertexNode {
    private int in;

    public int getIn() {
        return in;
    }

    public void setIn(int in) {
        this.in = in;
    }

    private String data;
    private EdgeNode firstEdge;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public EdgeNode getFirstEdge() {
        return firstEdge;
    }

    public void setFirstEdge(EdgeNode firstEdge) {
        this.firstEdge = firstEdge;
    }
}
