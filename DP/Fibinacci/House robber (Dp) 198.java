//House robber (Dp) 198
import java.util.*;
public class Practice2 {
    // Recursion    O(2^n)
    public static int getMaxAmount(int nums[], int idx) {
        if(nums.length == 0) {
            return 0;
        }
        if(idx == 0) {
            return nums[idx];
        }
        if(idx == 1) {
            return Math.max(nums[1], nums[0]);
        }

        int currRobbed = nums[idx] + getMaxAmount(nums, idx-2);
        int notRobbed = getMaxAmount(nums, idx-1);
        return Math.max(currRobbed, notRobbed);
    }

    // Memoization or Top down  O(n)
    public static int getMaxAmountMemo(int nums[], int idx, int dp[]) {
        if(nums.length == 0) {
            return 0;
        }
        if(idx == 0) {
            return nums[idx];
        }
        if(idx == 1) {
            return Math.max(nums[1], nums[0]);
        }
        if(dp[idx] != -1) {
            return dp[idx];
        }

        int currRobbed = nums[idx] + getMaxAmountMemo(nums, idx-2, dp);
        int notRobbed = getMaxAmountMemo(nums, idx-1, dp);
        dp[idx] = Math.max(currRobbed, notRobbed);
        return dp[idx];

    }

    // Tabulation or bottom up   O(n)
    public static int getMaxAmountTab(int nums[]) {
        int dp[] = new int[nums.length];
        if(nums.length == 1) {
            return nums[1];
        }
         if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);

        for(int i=2; i<dp.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[nums.length-1];
    }
    public static void main(String[] args) {
        int nums[] = {8, 1, 2, 3};
        // System.out.println(getMaxAmount(nums, nums.length-1));

        int dp[] = new int[nums.length+1];
        Arrays.fill(dp, -1);
        // System.out.println(getMaxAmountMemo(nums, nums.length-1, dp));
        System.out.println(getMaxAmountTab(nums));
    }
}
