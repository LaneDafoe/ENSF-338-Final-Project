package src.main.java.mylib.graphalgo;

import java.util.*;

public class BFS {
    public static void bfs(Graph graph, int start) {
        boolean[] visited = new boolean[graph.getVertices()];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");

            List<Edge> edges = graph.getEdges(u);
            for (Edge edge : edges) {
                int v = edge.getDestination();
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }
}
