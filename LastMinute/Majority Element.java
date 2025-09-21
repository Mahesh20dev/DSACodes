class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int majority=Integer.MIN_VALUE;

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>nums.length/2){
                majority=entry.getKey();
                break;
            }
        }
         return majority;
    }
}// Time: O(n) (single pass through the array)
// Space: O(n) (hashmap to store elements)  


// Code using Boyer–Moore Voting Algorithm:
class Solution {
    public int majorityElement(int[] nums) {
        // Phase 1: Find the candidate
        int candidate = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        
        // Phase 2: Verify the candidate (optional for this problem)
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        
        return (count > nums.length / 2) ? candidate : -1; // -1 if no majority element
    }
}
// Time: O(n) (two passes through the array)
// Space: O(1) (no extra space needed)