// Articulation Point - Tarjan's algorithm (graph)
import java.util.*;
public class DSA {
    static class Edge {
        int src;
        int dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
    
        graph[4].add(new Edge(4, 3));
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], boolean vis[], int time, boolean ap[]) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;
        for(Edge e : graph[curr]) {
            int neigh = e.dest;

            if(neigh == par) {
                continue;
            } else if(vis[neigh]) {
                low[curr] = Math.min(low[curr], dt[neigh]);
            } else {  // !vis[neigh]
                dfs(graph, neigh, curr, dt, low, vis, time, ap);
                low[curr] = Math.min(low[curr], low[neigh]);

                if(par != -1 && dt[curr] <= low[neigh]) {
                    ap[curr] = true;
                }
                children++;
            }
        }
        if(par == -1 && children > 1) {
            ap[curr] = true;
        }
    }

    public static void getAp(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        boolean vis[] = new boolean[V];
        boolean ap[] = new boolean[V];     // to avoid duplication of ans
        int time = 0;

        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                dfs(graph, i, -1, dt, low, vis, time, ap);
            }
        }

        for(int i=0; i<V; i++) {
            if(ap[i]) {
                System.out.println("Ap : " + i);    
            }
        }
    }
    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];  // null --> empty array
        createGraph(graph);
        getAp(graph, V);
    }
}

// Time Complexity:
// DFS Traversal: The main DFS function is called once for each vertex. Within the DFS function, each edge is processed only once.
// Therefore, the time complexity for the DFS traversal is O(V + E), where 
// V is the number of vertices and E is the number of edges.

// Space Complexity:
// Arrays dt[], low[], vis[], and ap[]: Each of these arrays has a size of V, so the space complexity for storing them is O(V).
// Graph Representation: The graph is stored as an adjacency list, requiring O(V + E) space.

// Overall:
// Time Complexity: O(V+E)
// Space Complexity: O(V+E)
