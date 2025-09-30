
import java.util.*;

public class bellmon {
    static class Edge {
        int src, dest, wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    //Bellmon ford algorithm O(V*E)
    public static void bellman(ArrayList<Edge>[] ed,int src){
        int[] dist=new int[ed.length];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        int V=ed.length-1;
        // O(V)
        for(int i=0;i<V;i++){
            // O(E)
            for(int j=0;j<ed.length;j++){
                for(int k=0;k<ed[j].size();k++){
                    Edge e=ed[j].get(k);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    // relaxation
                    if(dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v]){
                        dist[v]=dist[u]+wt;
                    }
                }
            }
        }

        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i] +" ");
        }
        System.out.println();

    }
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[5];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // Add edges to the graph
        graph[0].add(new Edge(0, 1, 1));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 4, 1));

        System.out.println("Shortest paths from source:");
        bellman(graph, 0);
    }
}
