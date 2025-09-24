import java.util.*;

public class ConnectedComponents {

    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (x==parent[x] ) {
                return x; 
            }
            return parent[x] = find(parent[x]); // path compression
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return;

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }

        int countComponents() {
            Set<Integer> uniqueParents = new HashSet<>();
            for (int i = 0; i < parent.length; i++) {
                uniqueParents.add(find(i));
            }
            return uniqueParents.size();
        }
    }

    public static void main(String[] args) {
        int V = 6;

        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 2},
            {3, 4}
        };

        UnionFind uf = new UnionFind(V);

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        System.out.println("Number of Connected Components: " + uf.countComponents());
    }
}
// Time: O(α(n)) per union/find operation (α is the inverse Ackermann function, very slow growing, effectively constant)
// Space: O(n) (for the parent and rank arrays)
// Example:
// Input: V = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
// Output: 3
// Explanation: There are three connected components: {0,1,2}, {3,4}, and {5}.

