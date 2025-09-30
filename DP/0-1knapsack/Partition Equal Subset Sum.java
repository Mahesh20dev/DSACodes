class Solution {
    static boolean equalPartition(int[] arr) {
        int sum = 0;
        for (int num : arr) sum += num;

        if (sum % 2 != 0) return false; // odd sum can't be divided equally

        int target = sum / 2;
        int n = arr.length;

        boolean[][] dp = new boolean[n + 1][target + 1];

        // Initialize: Sum 0 is always possible with empty subset
        for (int i = 0; i <= n; i++) dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            int curr = arr[i - 1];
            for (int j = 1; j <= target; j++) {
                if (curr <= j && dp[i - 1][j - curr] == true) {
                    // include the current number
                     dp[i][j] = true;
                } else if( dp[i - 1][j]==true) {
                // exclude the current number
                 dp[i][j] = true;  // <-- FIXED
                }

            }
        }

        return dp[n][target];
    }
}
