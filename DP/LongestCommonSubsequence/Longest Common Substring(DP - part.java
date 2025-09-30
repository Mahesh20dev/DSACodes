// Longest Common Substring(DP - part 4)   similar to longest common subsequence
public class DSA {
    // Recursion
    public static int lcsRec(String str1, String str2, int n, int m, int count) {
        if (n == 0 || m == 0) return count;

        int currCount = count;
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return currCount = Math.max(currCount, lcsRec(str1, str2, n - 1, m - 1, count+1));
        } else {
            int ans1 = lcsRec(str1, str2, n-1, m, 0);
            int ans2 = lcsRec(str1, str2, n, m-1, 0);
            return Math.max(currCount , Math.max(ans1, ans2));
        }
        // return curr;
        // return Math.max(count, Math.max(lcsRec(str1, str2, n - 1, m, 0), lcsRec(str1, str2, n, m - 1, 0)));
    }

    public static int lcsMemo(String str1, String str2, int n, int m, int count, int dp[][]) {
        if(n == 0 || m == 0) return count;

        if(dp[n][m] != 0) {
            return dp[n][m];
        }

        int currCount = count;
        if(str1.charAt(n-1) == str2.charAt(m-1)) {
            currCount = Math.max(currCount, lcsMemo(str1, str2, n-1, m-1, count+1, dp));
        } else {
            int ans1 = lcsMemo(str1, str2, n-1, m, 0, dp);
            int ans2 = lcsMemo(str1, str2, n, m-1, 0, dp);
            return dp[n][m] = Math.max(currCount, Math.max(ans1, ans2));
        }
        return currCount;
    }

    // Tabulation 
    public static int lcs(String str1, String str2) {
        int n = str1.length(); 
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        int ans = 0;

        for(int i=0; i<dp.length; i++) {
            dp[i][0] = 0;
        }
        for(int i=0; i<dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String str1 = "ABCDE";
        String str2 = "ABGCE";    // ans = 2 "AB"
        int n = str1.length(); 
        int m = str2.length();
        // System.out.println(lcs(str1, str2));

        // recursion
        System.out.println(lcsRec(str1, str2, n, m, 0));

        // memoization
        int dp[][] = new int[n+1][m+1];
        System.out.println(lcsMemo(str1, str2, n, m, 0, dp));

        // System.out.println(lcs1(str1, str2, n, m));
    }   
}
