// Connect N ropes in Order to get Min cost (sigma)
import java.util.PriorityQueue;
public class DSA {
    public static void main(String[] args) {
        int ropes[] = {2, 3, 3, 4, 6};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<ropes.length; i++) {
            pq.add(ropes[i]);
        }

        int cost = 0;
        while(pq.size() > 1) {
            int min = pq.remove();
            int min2 = pq.remove();
            cost += min + min2;
            pq.add(min + min2);
        }

        System.out.println("Cost of connectiong n ropes = " + cost);
    }
}

// output 
// 29 

// Time Complexity: O(NlogN)
// Space Complexity: O(N)