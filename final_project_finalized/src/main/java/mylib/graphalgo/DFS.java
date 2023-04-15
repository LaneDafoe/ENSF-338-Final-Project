package src.main.java.mylib.graphalgo;


import java.util.*;

public class DFS {
    public static void dfs(Graph graph, int start) {
        boolean[] visited = new boolean[graph.getVertices()];
        dfsUtil(graph, start, visited);
    }

    private static void dfsUtil(Graph graph, int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");

        List<Edge> edges = graph.getEdges(start);
        for (Edge edge : edges) {
            int v = edge.getDestination();
            if (!visited[v]) {
                dfsUtil(graph, v, visited);
            }
        }
    }
}

