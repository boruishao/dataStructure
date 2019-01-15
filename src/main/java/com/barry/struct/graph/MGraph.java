package com.barry.struct.graph;

import java.util.Arrays;

public class MGraph {
    static final Integer MAXVEX= 100;
    static final Integer INFINITY=65535;

    private String[] vexs = new String[MAXVEX];
    private int[][] arc=new int[MAXVEX][MAXVEX];
    private int numVertexes,numEdges;

    public String[] getVexs() {
        return vexs;
    }

    public void setVexs(String[] vexs) {
        this.vexs = vexs;
    }

    public int[][] getArc() {
        return arc;
    }

    public void setArc(int[][] arc) {
        this.arc = arc;
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

    @Override
    public String toString() {
        return "MGraph{" +
                "vexs=" + Arrays.toString(vexs) +
                ", arc=" + Arrays.toString(arc) +
                ", numVertexes=" + numVertexes +
                ", numEdges=" + numEdges +
                '}';
    }
}
