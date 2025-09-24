import java.util.*;

class Solution {
    public int longestSubarrayKDistinct(int[] nums, int k) {
        if (k == 0) return 0;

        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0, right = 0;
        int maxLen = 0;

        while (right < nums.length) {
            // Add current element
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);
            right++;

            // If distinct elements exceed k, shrink window
            while (freqMap.size() > k) {
                int leftNum = nums[left];
                freqMap.put(leftNum, freqMap.get(leftNum) - 1);
                if (freqMap.get(leftNum) == 0) {
                    freqMap.remove(leftNum);
                }
                left++;
            }

            // Update max length when valid window found
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }
}
// Time: O(n) (each element is visited at most twice by left and right pointers)
// Space: O(k) (the size of the frequency map can grow up to k) 
// Example 1:
// Input: nums = [1,2,1,2,3], k = 2
// Output: 4
// Explanation: The longest subarray with at most 2 distinct integers is [1,2,1,2] with length 4.
// Example 2:
// Input: nums = [1,2,1,3,4], k = 3
// Output: 4
// Explanation: The longest subarray with at most 3 distinct integers is [1,2,1,3] with length 4.