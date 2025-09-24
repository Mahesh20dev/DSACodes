import java.util.*;

public class bfs {
    public static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    // BFS to find the shortest path from source to destination
    public static List<Integer> shortestPath(ArrayList<Edge>[] graph, int source, int dest) {
        boolean[] visited = new boolean[graph.length];
        int[] parent = new int[graph.length]; // To reconstruct path
        Arrays.fill(parent, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (curr == dest) {
                break; // Destination reached
            }

            for (Edge e : graph[curr]) {
                if (!visited[e.dest]) {
                    visited[e.dest] = true;
                    parent[e.dest] = curr;
                    q.add(e.dest);
                }
            }
        }

        // Reconstruct path
        List<Integer> path = new ArrayList<>();
        if (!visited[dest]) {
            return path; // No path found
        }

        int node = dest;
        while (node != -1) {
            path.add(node);
            node = parent[node];
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding edges (unweighted graph)
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        // Shortest path from 0 → 5
        List<Integer> path = shortestPath(graph, 0, 5);
        if (path.isEmpty()) {
            System.out.println("No path exists.");
        } else {
            System.out.println("Shortest Path: " + path);
        }
    }
}
// Time: O(V + E) (each vertex and edge is processed once)
// Space: O(V) (for the visited array, parent array, and queue)
