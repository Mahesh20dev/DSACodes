//Kruskal's algo in GFG
class Solution {
    static class Edge implements Comparable<Edge>{
        int src; 
        int des;
        int wt;
        public Edge(int src, int des, int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt; 
        }
        
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        } 
    }
    
    static int par[];
    static int rank[];
    
    static void init(int V) {
        par = new int[V];
        rank = new int[V];
        
        for(int i=0; i<par.length; i++) {
            par[i] = i;
        }
    }
    
    static int find(int x) {
        if(x == par[x]) return x;
        
        return par[x] = find(par[x]);
    }
    
    static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        
        if(rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if(rank[parA] > rank[parB]) {
            par[parB] = parA;
        } else {
            par[parA] = parB;
        }
    }
    
    static int kruskalsMST(int V, int[][] edges) {
        ArrayList<Edge> edgelist = new ArrayList<>();
        
        for(int nbr[]: edges) {
            int s = nbr[0];
            int d = nbr[1];
            int w = nbr[2];
            
            edgelist.add(new Edge(s, d, w));
        }
        
        init(V);
       
        
        // Kruskals 
        Collections.sort(edgelist);
        int mstCost = 0;
        int count = 0;
        
        for(int i=0; count<V-1; i++) {
            Edge e = edgelist.get(i);
            int parA = find(e.src);
            int parB = find(e.des);
            
            if(parA != parB) {
                union(e.src, e.des);
                mstCost += e.wt;
                count++;
            }
        }
        
        return mstCost;
    }
}
