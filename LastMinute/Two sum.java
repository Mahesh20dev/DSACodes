class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> result=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            result.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int diff=target-nums[i];
            if(result.containsKey(diff) &&result.get(diff)!=i){
                return new int[]{i,result.get(diff)};
            }
        }
        return new int[]{};
       
      
    }
}
// Time: O(n) (single pass through the array)
// Space: O(n) (hashmap to store elements)
