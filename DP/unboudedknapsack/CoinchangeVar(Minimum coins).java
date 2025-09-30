class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<amount+1;j++){
            dp[0][j]=amount+1;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<amount+1;j++){
                int v=coins[i-1];
                if(v<=j){//valid
                    //include
                    int way1=dp[i][j-v]+1;
                    //exclude
                    int way2=dp[i-1][j];
                    //total ways
                    dp[i][j]=Math.min(way1,way2);
                }else{//invalid
                dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][amount]>amount?-1:dp[n][amount];
    }
}