package src.main.java.mylib.graphalgo;

import java.util.*;

public class Dijkstra {
    public static int[] dijkstra(Graph graph, int start) {
        int[] dist = new int[graph.getVertices()];
        boolean[] visited = new boolean[graph.getVertices()];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, start, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int u = edge.getSource();

            if (visited[u]) {
                continue;
            }

            visited[u] = true;
            dist[u] = edge.getWeight();

            List<Edge> edges = graph.getEdges(u);
            for (Edge e : edges) {
                int v = e.getDestination();
                if (!visited[v]) {
                    pq.offer(new Edge(u, v, e.getWeight() + dist[u]));
                }
            }
        }

        return dist;
    }
}
