import java.util.ArrayList;

public class detectcycleundirected {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    //cycle detection in undirected graph
    public static boolean detectcycle(ArrayList<Edge>[] ed){   // O(E+V)
        boolean[] visited=new boolean[ed.length];
        for (int i = 0; i < ed.length; i++) {
            if(!visited[i]){
                if(detectcycleUtil(ed, visited, i, -1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectcycleUtil(ArrayList<Edge>[] ed,boolean[] visited,int curr ,int par){
        visited[curr]=true;

        for (int i = 0; i < ed[curr].size(); i++) {
            Edge e=ed[curr].get(i);
            if(!visited[e.dest]){
                // case 3
                if(detectcycleUtil(ed, visited, e.dest, curr)){
                    return true;
                }
            }
            else if(visited[e.dest] && e.dest!=par){ //case 1
                return true;
            }

            //case 2 -> do nothing

        }

        return false;

    }
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[5];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // Add edges to the graph
        graph[0].add(new Edge(0, 1, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 2, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[4].add(new Edge(4, 3, 1));

        System.out.println("Does the graph contain a cycle? " + detectcycle(graph));
    }
}
