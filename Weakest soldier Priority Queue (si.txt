// Weakest soldier Priority Queue (sigma)
// row i is weaker than row j if it satisfies one of the condition below
// The no of soldiers in row i is less than no of soldiers in row j
// if both row have same no of soldiers then i < j (i is weaker than j)

import java.util.PriorityQueue;
public class Practice {
    static class Row implements Comparable<Row> {
        int soldier;
        int idx;
        public Row(int soldier, int idx) {
            this.soldier = soldier;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2) {
            if(this.soldier == r2.soldier) {
                return this.idx - r2.idx;
            } else {
                return this.soldier - r2.soldier;
            }
        }
    }

    public static void main(String[] args) {
        int army[][] = {{1, 0, 0, 0},
                        {1, 1, 1, 1},
                        {1, 0, 0, 0}, 
                        {1, 0, 0, 0}};
                        // 1 = soldier , 0 = civilian
        int k = 2;

        PriorityQueue<Row> pq = new PriorityQueue<>();

        for(int i=0; i<army.length; i++) {
            int count = 0;
            for(int j=0; j<army[0].length; j++) {
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(count, i));
        }

        for(int i=0; i<k; i++) {
            System.out.println("R"+ pq.remove().idx);
        }
    }
}

// output :
// R0
// R2

// Time complexity :
// counting solder = m row and n col  O(m * n)
// Inserting into priority Queue = m rows O(m logm)
// Extracting the weakest row = k rows O(k logm)

//    Time = O(m * n + m logm + k logm)
//    Time = O(m*n + m logm)

// Space complexity :
// Priority Queue = stores up to m row O(m)
//     Space = O(m)