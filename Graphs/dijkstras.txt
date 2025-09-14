import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class dijkstras {
    static class Edge {
        int src, dest, wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    //dijkstra's Algorithm  TC= V+Elogn

    public static class pair implements Comparable<pair>{
        int node;
        int path;
        pair(int node,int path){
            this.node=node;
            this.path=path;
        }

        @Override
        public  int compareTo(pair p2){
            return this.path-p2.path;
        }
    }

    public static void djk(ArrayList<Edge>[] ed,int src){
        int[] dist=new int[ed.length];
        boolean[] visited=new boolean[ed.length];
        PriorityQueue<pair> pq=new PriorityQueue<>();

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        pq.add(new pair(src,0));

        while(!pq.isEmpty()){
            pair curr=pq.remove();
            if(!visited[curr.node]){
                visited[curr.node]=true;
                // neighbours
                for(int i=0;i<ed[curr.node].size();i++){
                    Edge e=ed[curr.node].get(i);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    if(dist[u]+wt<dist[v]){  //update dist from src to v
                        dist[v]=dist[u]+wt;
                        pq.add(new pair(v, dist[v]));
                    }
                }
            }

        }
        int min=Integer.MAX_VALUE;
        for (int i = 1; i < dist.length-1; i++) {
            System.out.print(dist[i]+" ");
            if(dist[i]<dist[i+1]){
                min=Math.min(min,dist[i]);
            }
        }
        System.out.println();
        System.out.println("min: " + min);
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

        djk(graph, 0);
    }
}
