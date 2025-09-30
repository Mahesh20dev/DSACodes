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
        public static void bfsUtil(ArrayList<Edge>[] ed, boolean[] visited){ //O(n)  O(E+V)  ed->graph
        Queue<Integer> q=new LinkedList<>();
        q.add(0); //source
        while ((!q.isEmpty())) {
            int curr=q.remove();
            while (!visited[curr]) {
                System.out.print(curr+" ");
                visited[curr]=true;
                for (int i = 0; i < ed[curr].size(); i++) {
                    Edge e=ed[curr].get(i);
                    q.add(e.dest);
                }

            }
        }
    }
    public static void bfs(ArrayList<Edge>[] ed){
        boolean[] visited=new boolean[ed.length];
        for (int i = 0; i < ed.length; i++) {
            bfsUtil(ed, visited);
        }

    }

     public static void main(String[] args) {
        int V = 6;


         boolean[] visited=new boolean[V]; //used for dfs


        //ArrayList<Edge>[] graph =  new ArrayList[V];  its not working in present ide but it is the correct way


        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        

        //     // finding neighbours of node 2
        //     for (int i = 0; i < graph[2].size(); i++) {
        //         Edge e = graph[2].get(i);
        //         System.out.println(e.dest);
        //     }
        // System.out.println("_>");
            bfs(graph);

    }
}
