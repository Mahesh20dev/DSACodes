import java.util.*;

class Solution {

    class Edge{
        int src;
        int dest;
        Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    List<List<Integer>> res;    // to store the bridges
    int time;                   // discovery time counter

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // Build adjacency list
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i]=new ArrayList<>();
        }


        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph[u].add(new Edge(u,v));
            graph[v].add(new Edge(v,u)); // since it's undirected
        }

        // Initialize arrays
        int[] disc = new int[n];
        int[] low = new int[n];
        boolean[] vis = new boolean[n];
        time = 0;
        res = new ArrayList<>();

        // DFS for each component
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(graph, vis, i, -1, disc, low);
            }
        }

        return res;
    }

    private void dfs(ArrayList<Edge>[] graph, boolean[] vis, int curr, int parent, int[] disc, int[] low) {
        vis[curr] = true;
        disc[curr] = low[curr] = ++time;
       

        for (int i=0 ;i< graph[curr].size();i++) {
            Edge e=graph[curr].get(i);
            int neigh=e.dest;
            if (neigh == parent) continue;
            if (!vis[neigh]) {
                dfs(graph, vis, neigh, curr, disc, low);
                low[curr] = Math.min(low[curr], low[neigh]);

                // Bridge condition
                if (low[neigh] > disc[curr]) {
                    res.add(Arrays.asList(curr, neigh));
                }
            } else {
                // Back edge
                low[curr] = Math.min(low[curr], disc[neigh]);
            }
        }
    }
}
