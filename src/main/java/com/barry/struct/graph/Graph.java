package com.barry.struct.graph;

import com.barry.struct.ElementType;
import com.barry.struct.SqQueue;

import java.util.Scanner;

public class Graph {
    public static void main(String[] args) {
        Graph graph = new Graph();
        MGraph mGraph = graph.createMgraph(3, 3);
        System.out.println(mGraph);

    }

    public MGraph createMgraph(int numVertexes, int numEdges) {
        MGraph mGraph = new MGraph();
        String[] vexs = new String[numVertexes];
        int[][] arc = new int[numVertexes][numVertexes];

        for (int i = 0; i < numVertexes; i++) {
            vexs[i] = "v" + i;
        }
        mGraph.setVexs(vexs);

        for (int i = 0; i < numVertexes; i++) {
            for (int j = 0; j < numVertexes; j++) {
                arc[i][j] = MGraph.INFINITY;
            }
            arc[i][i] = 0;
        }
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < numEdges; i++) {
            System.out.println("请输入边（vi,vj）的下标，和权值w，以空格分隔 如 ：‘2 3 5’ 即是 （v2,v3） w =5 ");
            String[] split = scan.nextLine().split(" ");
            try {
                Integer m = Integer.valueOf(split[0]);
                Integer n = Integer.valueOf(split[1]);
                Integer w = Integer.valueOf(split[2]);
                arc[m][n] = w;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        mGraph.setArc(arc);
        return mGraph;
    }

    public GraphAdjList createALGraph(int numVertexes, int numEdges) {
        GraphAdjList graphAdjList = new GraphAdjList();
        VertexNode[] adjList = new VertexNode[numVertexes];
        for (int i = 0; i < numVertexes; i++) {
            adjList[i].setFirstEdge(null);
            adjList[i].setData("data" + i);
        }
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < numEdges; i++) {
            System.out.println("请输入边（vi,vj）的下标，和权值w，以空格分隔 如 ：‘2 3 5’ 即是 （v2,v3） w =5 ");
            String[] split = scan.nextLine().split(" ");
            EdgeNode edgeNode = new EdgeNode();
            Integer m = Integer.valueOf(split[0]);
            Integer n = Integer.valueOf(split[1]);
            Integer w = Integer.valueOf(split[2]);

            edgeNode.setAdjvex(n);
            edgeNode.setWeight(w);
            edgeNode.setNext(adjList[m].getFirstEdge());
            adjList[m].setFirstEdge(edgeNode);

            /*********无向图需要对称*************/
            EdgeNode edgeNode2 = new EdgeNode();
            edgeNode2.setAdjvex(m);
            edgeNode2.setWeight(w);
            edgeNode2.setNext(adjList[n].getFirstEdge());
            adjList[n].setFirstEdge(edgeNode2);
        }
        graphAdjList.setAdjList(adjList);
        return graphAdjList;
    }

    //deep first search
    private boolean[] visit = new boolean[100];

    private void dfs(MGraph g, int i) {
        visit[i] = true;
        System.out.println(g.getVexs()[i]);
        for (int k = 0; k < g.getNumVertexes(); k++) {
            if (g.getArc()[i][k] != MGraph.INFINITY
                    && g.getArc()[i][k] != 0
                    && !visit[k]) {
                dfs(g, k);
            }
        }
    }

    public void dfsTraverse(MGraph g) {
        for (int i = 0; i < g.getNumVertexes(); i++) {
            visit[i] = false;
        }

        for (int i = 0; i < g.getNumVertexes(); i++) {
            if (!visit[i]) {
                dfs(g, i);
            }
        }

    }

    //breadth first search
    public void bfsTraverse(MGraph g) {
        SqQueue queue = new SqQueue().initQueue();
        for (int i = 0; i < g.getNumVertexes(); i++) {
            visit[i] = false;
        }
        for (int i = 0; i < g.getNumVertexes(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                System.out.println(g.getVexs()[i]);
                queue.enQueue(new ElementType(i));
                while (!queue.emptyQueue()) {
                    ElementType data = new ElementType();
                    queue.deQueue(data);
                    for (int j = 0; j < g.getNumVertexes(); j++) {
                        if (g.getArc()[data.getNum()][j] != 0
                                && g.getArc()[data.getNum()][j] != MGraph.INFINITY
                                && !visit[j]) {
                            visit[j] = true;
                            System.out.println(g.getVexs()[j]);
                            queue.enQueue(new ElementType(j));
                        }
                    }
                }
            }
        }

    }

    int MAXVEX = 9;

    //最小连通子树
    //Prim
    public void miniSpanTreePrim(MGraph g) {
        int[] adjvex = new int[MAXVEX];
        int[] lowcost = new int[MAXVEX];
        lowcost[0] = 0;
        adjvex[0] = 0;
        for (int i = 0; i < g.getNumVertexes(); i++) {
            lowcost[i] = g.getArc()[0][i];
            adjvex[i] = 0;
        }

        for (int i = 0; i < g.getNumVertexes(); i++) {
            int min = MGraph.INFINITY;
            int j = 1;
            int k = 0;
            while (j < g.getNumVertexes()) {
                if (lowcost[j] < min && lowcost[j] != 0) {
                    min = lowcost[j];
                    k = j;
                }
                j++;
            }
            System.out.println("(" + adjvex[k] + "," + k + ")");
            lowcost[k] = 0;
            for (int l = 0; l < g.getNumVertexes(); l++) {
                if (lowcost[l] != 0 && g.getArc()[k][l] < lowcost[l]) {
                    lowcost[l] = g.getArc()[k][l];
                    adjvex[j] = k;
                }
            }
        }
    }

    //两点最佳路径
    //Floyd
    public void ShortestPathFloyd(MGraph g) {
        int[][] pathMatirx = new int[MAXVEX][MAXVEX];
        int[][] sortPathTable = new int[MAXVEX][MAXVEX];
        for (int i = 0; i < g.getNumVertexes(); i++) {
            for (int j = 0; j < g.getNumVertexes(); j++) {
                sortPathTable[i][j] = g.getArc()[i][j];//权值
                pathMatirx[i][j] = j; //路径
            }
        }

        for (int k = 0; k < g.getNumVertexes(); k++) {
            for (int v = 0; v < g.getNumVertexes(); v++) {
                for (int w = 0; w < g.getNumVertexes(); w++) {
                    if (sortPathTable[v][w] > sortPathTable[v][k] + sortPathTable[k][w]) {
                        sortPathTable[v][w] = sortPathTable[v][k] + sortPathTable[k][w];
                        pathMatirx[v][w] = pathMatirx[v][k];
                    }
                }
            }
        }
    }

    //根据floyd结果，输出需要的路径
    public void showPathFloyd(int[][] sortPathTable, int[][] pathMatirx, int start, int end) {

        System.out.println("从" + start + " -> " + end + "需要的总权重是 " + sortPathTable[start][end]);

        System.out.println(start + " -> ");
        int k = pathMatirx[start][end]; // 下一个定点的坐标
        while (k != end) {
            System.out.println(k + " -> ");
            k = pathMatirx[k][end];
        }

        System.out.println(end);

    }

    //拓扑排序 && 关键路径
    int[] etv;
    int[] ltv;
    int[] stack2;
    int top2;

    public boolean topologicalSort(GraphAdjList gl) {
        int top = 0;
        int count = 0;
        int[] statck = new int[gl.getNumVertexes()];
        for (int i = 0; i < gl.getNumVertexes(); i++) {
            if (gl.getAdjList()[i].getIn() == 0) {
                statck[top++] = i;
            }
        }
        /*******************for critical path******************************/
        top2 = 0;
        etv = new int[gl.getNumVertexes()];
        stack2 = new int[gl.getNumVertexes()];
        /*************************************************/

        while (top != 0) {
            int gettop = statck[top--];
            System.out.println(gl.getAdjList()[gettop].getData() + " -> ");
            count++;
            /**************/
            stack2[top2++] = gettop;
            /**************/

            for (EdgeNode e = gl.getAdjList()[gettop].getFirstEdge(); e != null; e = e.getNext()) {
                int k = e.getAdjvex();
                gl.getAdjList()[gettop].setIn(gl.getAdjList()[gettop].getIn() - 1);
                if ((gl.getAdjList()[gettop].getIn() != 0)) {
                    statck[top++] = k;
                    /**************/
                    if (etv[gettop] + e.getWeight() > etv[k]) {
                        etv[k] = etv[gettop] + e.getWeight();
                    }
                    /**************/
                }
            }
        }
        if (count < gl.getNumVertexes()) {
            return false;
        } else return true;
    }

    public void criticalPath(GraphAdjList gl) {
        int ete, lte;
        boolean b = topologicalSort(gl);
        ltv = new int[gl.getNumVertexes()];
        for (int i = 0; i < gl.getNumVertexes(); i++) {
            ltv[i] = etv[gl.getNumVertexes() - 1];
        }
        while (top2 != 0) {
            int gettop = stack2[top2--];
            for (EdgeNode e = gl.getAdjList()[gettop].getFirstEdge();
                 e != null; e = e.getNext()) {
                int k = e.getAdjvex();
                if (ltv[k] - e.getWeight() < ltv[gettop]) {
                    ltv[gettop] = ltv[k] - e.getWeight();
                }
            }
        }
        for (int i = 0; i < gl.getNumVertexes(); i++) {
            for (EdgeNode e = gl.getAdjList()[i].getFirstEdge();
                 e != null; e = e.getNext()) {
                int k = e.getAdjvex();
                ete = etv[i];
                lte = ltv[k] - e.getWeight();
                if (ete == lte){
                    System.out.println(" < " + gl.getAdjList()[i].getData()
                            +","+gl.getAdjList()[k].getData()
                            +" > length:" + e.getWeight());
                }
            }
        }

    }


}
