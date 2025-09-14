// 0-1 knapsack (DP)
public class Revision2 {
    // recursion way  O(2^n)
    public static int knapsach(int val[], int wt[], int W, int n) {
        if(W == 0 || n == 0) {
            return 0;
        }

        if(wt[n-1] <= W) {   // valid
            // include
            int ans1 = val[n-1] + knapsach(val, wt, W-wt[n-1], n-1);
            // exclude
            int ans2 = knapsach(val, wt, W, n-1);
            return Math.max(ans1, ans2);
        } else {
            return knapsach(val, wt, W, n-1);
        }
    }

    // Memoization Time = O(n * W) - 2D array
    public static int knapsachMemo(int val[], int wt[], int W, int n, int dp[][]) {
        if(W == 0 || n == 0) {
            return 0;
        }

        if(dp[n][W] != -1) {
            return dp[n][W];
        }

        if(wt[n-1] <= W) {
            // include
            int ans1 = val[n-1] + knapsachMemo(val, wt, W-wt[n-1], n-1, dp);
            // exclude
            int ans2 = knapsachMemo(val, wt, W, n-1, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else {
            dp[n][W] = knapsachMemo(val, wt, W, n-1, dp);
            return dp[n][W];
        }
    }

    public static void print(int dp[][]) {
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Time = O(n * W)  matrix
    public static int knapsachTab(int val[], int wt[], int W) {
        int n = val.length; 
        int dp[][] = new int[n+1][W+1];

        for(int i=0; i<dp.length; i++) {
            dp[i][0] = 0;                  // row
        }
        for(int j=0; j<dp[0].length; j++) {
            dp[0][j] = 0;                      // col
        }

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                int v = val[i-1];
                int w = wt[i-1];
                if(w <= j) {
                    int incProfit = v + dp[i-1][j-w];       // include profit
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        print(dp);
        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        // System.out.println(knapsach(val, wt, W, val.length));
        // memoization
        int dp[][] = new int[val.length+1][W+1]; 
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        // System.out.println(knapsachMemo(val, wt, W, val.length, dp));

        System.out.println(knapsachTab(val, wt, W));
    }
}