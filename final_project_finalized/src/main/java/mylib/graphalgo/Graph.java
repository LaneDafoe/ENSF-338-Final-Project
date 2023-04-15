package src.main.java.mylib.graphalgo;

import java.util.*;

public class Graph {
    private int V; // number of vertices
    private ArrayList<ArrayList<Edge>> adj; // adjacency List

    public Graph() {
        V = 0;
        adj = new ArrayList<>(0);
    }

    public Graph(int V, int size) {
        this.V = V;
        adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < size; j++) {
                adj.add(j, new ArrayList<Edge>());
            }
        }
    }

    public void addEdge(int u, int v, int weight) {
        Edge edge = new Edge(u, v, weight);
        adj.get(u).add(edge);
    }

    public int getVertices() {
        return V;
    }

    public ArrayList<Edge> getEdges(int u) {
        return adj.get(u);
    }
}
