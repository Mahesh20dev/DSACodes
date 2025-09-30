import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bipartite {
    static class Edge {
        int src, dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    //Bipartite graph detection  O(V+E)

    public static boolean isbipartite(ArrayList<Edge>[] ed){
        int[] color=new int[ed.length];
        for (int i = 0; i < color.length; i++) {
            color[i]=-1;
        }
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < ed.length; i++) {

            if(color[i]==-1){
                q.add(i);
                color[i]=0;

                while (!q.isEmpty()) {
                    int curr =q.remove();
                    for (int j = 0; j < ed[curr].size(); j++) {
                        Edge e=ed[curr].get(j);

                        if(color[e.dest]==color[curr]){ //case 1
                            return false;
                        }else if(color[e.dest]==-1){   //case 3 no color
                            color[e.dest]=1-color[curr];
                            q.add(e.dest);
                        }

                    }
                }
                
            }

        }
        return true;
    }
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[5];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // Add edges to the graph
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));

        System.out.println("Is the graph bipartite? " + isbipartite(graph));
    }
}
