import java.util.ArrayList;
import java.util.PriorityQueue;

public class prims {
    static class Edge {
        int src, dest, wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
     //prims algorithm MST O(E log V)
    public static class pair1 implements Comparable<pair1>{
        int vertex;
        int cost;
        pair1(int vertex,int cost){
            this.vertex=vertex;
            this.cost=cost;
        }

        @Override
        public  int compareTo(pair1 p2){
            return this.cost-p2.cost;
        }
    }

    public static void prims(ArrayList<Edge>[] ed){
        boolean[] visited=new boolean[ed.length];
        PriorityQueue<pair1> pq=new PriorityQueue<>();
        ArrayList<Integer> nodes=new ArrayList<>();
        pq.add(new pair1(0, 0));
        int finalcost=0;
        while(!pq.isEmpty()){
            pair1 curr=pq.remove();
            int v=curr.vertex;
            int co=curr.cost;
            if(!visited[v]){
                visited[v]=true;
                 finalcost+=co;
                nodes.add(v);
                for(int i=0;i<ed[v].size();i++){
                    Edge e=ed[v].get(i);
                    pq.add(new pair1(e.dest, e.wt));
                }
            }
        }

        System.out.println("Min cost is" +" "+ finalcost +" "+ "path"+"->"+" "+ nodes );
    }
}
