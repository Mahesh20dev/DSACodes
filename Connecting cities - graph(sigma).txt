//Connecting cities - graph(sigma)
import java.util.PriorityQueue;
public class Main {
    static class Edge implements Comparable<Edge> {
        int v; // vertex
        int cost;
        public Edge(int v, int c) {
            this.v = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.cost - e2.cost;
        }
    }

    public static int connectCities(int cities[][]) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[cities.length];
        pq.add(new Edge(0, 0));
        int finalCost = 0;

        while(!pq.isEmpty()) {
            Edge curr = pq.remove();
            if(!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;

                for(int i=0; i<cities.length; i++) {
                    if(cities[curr.v][i] != 0) {
                        pq.add(new Edge(i, cities[curr.v][i]));
                    }
                }
            }
        }
        return finalCost;
    }
    public static void main(String[] args) {
        int cities[][] = {{0, 1, 2, 3, 4}, 
                          {1, 0, 5, 0, 7},
                          {2, 5, 0, 6, 0},
                          {3, 0, 6, 0, 0},
                          {4, 7, 0, 0, 0}};
                          
        System.out.println(connectCities(cities));
        
    }
}
// Time complexity is equal to prims algorithms 