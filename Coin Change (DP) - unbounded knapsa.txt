//Coin Change (DP) - unbounded knapsack
public class OnceAgain {
    // recursion
    public static int coinChangeRec(int coins[], int sum, int n) {
        if(n == 0) return 0;
        if(sum == 0) return 1;

        if(coins[n-1] <= sum) {
            return coinChangeRec(coins, sum-coins[n-1], n) + coinChangeRec(coins, sum, n-1);
        } else {
            return coinChangeRec(coins, sum, n-1);
        }
    }

    // memoization
    public static int coinChangeMemo(int coins[], int sum, int n, int dp[][]) {
        if(n == 0) return 0;
        if(sum == 0) return 1;

        if(dp[n][sum] != 0) {
            return dp[n][sum];
        }

        if(coins[n-1] <= sum) {
            dp[n][sum] = coinChangeMemo(coins, sum-coins[n-1], n, dp) + coinChangeMemo(coins, sum, n-1, dp);
            return dp[n][sum];
        } else {
            dp[n][sum] = coinChangeMemo(coins, sum, n-1, dp);
            return dp[n][sum];
        }

    }

    // Tabulation     
    public static int coinChange(int coins[], int sum) {
        int n = coins.length; 
        int dp[][] = new int[n+1][sum+1];

        for(int i=0; i<dp.length; i++) {
            dp[i][0] = 1;
            dp[0][i] = 0;
        }

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                if(coins[i-1] <= j) {
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                    //           include             exclude
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int coins[] = {2, 5, 3, 6};
        int sum = 10;
        // System.out.println(coinChange(coins, sum));   
        // System.out.println(coinChangeRec(coins, sum, coins.length));

        // memoization
        int dp[][] = new int[coins.length+1][sum+1];
        System.out.println(coinChangeMemo(coins, sum, coins.length, dp));
    }
}