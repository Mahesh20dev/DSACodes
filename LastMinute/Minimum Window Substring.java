class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }

        int[] storingTFreq=new int[128];

        for(char ch:t.toCharArray()){
            storingTFreq[ch]++;
        }

        int left=0;
        int right=0;
        int startIndex=0;
        int minwindowlen=Integer.MAX_VALUE;
        int StillrequiredChars=t.length();

        while(right<s.length()){
            char rightchar=s.charAt(right);

            if(storingTFreq[rightchar]>0){
                StillrequiredChars--;
            }
            
            storingTFreq[rightchar]--;
            right++;

            while(StillrequiredChars==0){
                
              if(right-left<minwindowlen){
                minwindowlen=right-left;
                startIndex=left;
              }
                char leftChar = s.charAt(left);
                storingTFreq[leftChar]++;
                if (storingTFreq[leftChar] > 0) {
                    StillrequiredChars++; 
                }
                left++;

            }

        }

        return minwindowlen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minwindowlen);

    }
}
// Time: O(n) (each character is visited at most twice by left and right pointers)
// Space: O(1) (since the size of the frequency array is fixed at 128)
// Example 1:       
// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"