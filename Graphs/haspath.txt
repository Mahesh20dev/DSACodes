import java.util.ArrayList;

public class haspath {
    static class Edge {
        int src, dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    //has path
    public static boolean haspath(ArrayList<Edge>[] graph,boolean[] visited,int src,int dest ){
        if(src==dest){
            return true;
        }
        visited[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            if(!visited[e.dest] && haspath(graph, visited, e.dest, dest)){
                return true;
            }
        }
        return false;
    }

    //All path from src to dest in directed graph  TC=exponential
    public static void haspath1(ArrayList<Edge>[] graph,String path,int src,int dest,boolean[] visited ){
        if(src==dest){
            System.out.println(path+dest);
            return;
        }
        visited[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            if(!visited[e.dest]){
            haspath1(graph,path+src, e.dest, dest,visited);  
            }
        }
        visited[src] = false;
        
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

        boolean[] visited = new boolean[5];
        System.out.println("Path exists: " + haspath(graph, visited, 0, 4));
        System.out.println("All paths from 0 to 4:");
        haspath1(graph, "", 0, 4, visited);
    }
}
