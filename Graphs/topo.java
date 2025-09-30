import java.util.ArrayList;
import java.util.Stack;

public class topo {
    static class Edge {
        int src, dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
     //Topological sorting using modified dfs
    public static void topologicalSort(ArrayList<Edge>[] ed){ // O(E+V)
        boolean[] visited=new boolean[ed.length];
        Stack<Integer> stack=new Stack<>();

        for (int i = 0; i < ed.length; i++) {
            if(!visited[i]){
                topologicalSortUtil(ed,visited,stack,i);
            }

        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop()+" ");
        }

    }

    public static void topologicalSortUtil(ArrayList<Edge>[] ed,boolean[] visited,Stack<Integer> stack,int curr){ // O(E+V)
        visited[curr]=true;
        for (int i = 0; i < ed[curr].size(); i++) {
            Edge e=ed[curr].get(i);
            if(!visited[e.dest]){
                topologicalSortUtil(ed, visited, stack, e.dest);
            }
        }
        stack.push(curr);

    }
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[5];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // Add edges to the graph
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 4));

        System.out.println("Topological Sort of the graph:");
        topologicalSort(graph);
    }
}
