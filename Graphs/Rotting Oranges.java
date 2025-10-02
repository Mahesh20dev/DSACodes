import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Step 1: Add all initial rotten oranges to queue and count fresh
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j, 0}); // (row, col, minute)
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 2: BFS to spread rot minute by minute
        while (!q.isEmpty()) {
            int[] curr = q.remove();
            int i = curr[0], j = curr[1], time = curr[2];
            minutes = Math.max(minutes, time);

            for (int[] d : dirs) { //neighbors
                int ni = i + d[0];
                int nj = j + d[1];

                if (ni >= 0 && nj >= 0 && ni < m && nj < n && grid[ni][nj] == 1) {
                    grid[ni][nj] = 2;
                    fresh--;
                    q.add(new int[]{ni, nj, time + 1});
                }
            }
        }

        // Step 3: If fresh oranges remain, it's impossible
        return (fresh == 0) ? minutes : -1;
    }
}
