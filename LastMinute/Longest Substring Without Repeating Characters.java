import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> obj=new HashSet<>();
        int left=0;
        int maxlength=0;

        for(int right=0;right<s.length();right++){
            char curr=s.charAt(right);

            while(obj.contains(curr)){
                obj.remove(s.charAt(left));
                left++;
            }
            
            obj.add(curr);
            maxlength=Math.max(maxlength,(right-left)+1);
        }
         
        return maxlength;
    }
}
// Time: O(n) (each character is visited at most twice by left and right pointers)
// Space: O(min(m,n)) (m is the size of the charset, n is the size of the string)
// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.