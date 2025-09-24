import java.util.ArrayList;

public class detectcycledirected {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
     //cycle detection in directed graph using modified dfs
    public static boolean directedcycle(ArrayList<Edge>[] ed){ // O(E+V)
        boolean[] visited=new boolean[ed.length];
        boolean[] stack=new boolean[ed.length];

        for (int i = 0; i < ed.length; i++) {
            if(!visited[i]){
                if(directedcycleUtil(ed,visited,stack,i)){
                    return true;
                }
            }

        }
        return false;

    }

    public static boolean directedcycleUtil(ArrayList<Edge>[] ed,boolean[] visited,boolean[] stack,int curr){ // O(E+V)
        visited[curr]=true;
        stack[curr]=true;

        for (int i = 0; i < ed[curr].size(); i++) {
            Edge e=ed[curr].get(i);
            if(stack[e.dest]){
                return true; //cycle exists
            }
            if(!visited[e.dest] && directedcycleUtil(ed, visited, stack, e.dest)){
                return true;
            }
        }
        stack[curr]=false;
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[5];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // Add edges to the graph
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 0));
        graph[3].add(new Edge(3, 4));

        System.out.println("Does the directed graph contain a cycle? " + directedcycle(graph));
    }
}
