class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix=strs[0];

        for(int i=1;i<strs.length;i++){

            if(prefix.length()==0){
                return "";
            }

            StringBuilder temp=new StringBuilder();
            int searchsize=Math.min(prefix.length(),strs[i].length());

            for(int j=0;j<searchsize;j++){
                
                if(prefix.charAt(j)!=strs[i].charAt(j)){
                    break;
                }
                
                temp.append(prefix.charAt(j));
            }

            prefix=temp.toString();
        }

        return prefix;
    }
}
// Time: O(n*m) (n is number of strings, m is length of the shortest string)
// Space: O(1) (no extra space needed except for variables) 