class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] re=new int[nums.length];

        for(int i=0;i<re.length;i++){
            re[i]=1;
        }
        int left=1;
        for(int i=0;i<nums.length;i++){
            re[i]=re[i]*left;
            left=left*nums[i];
        }

        int right=1;
        for(int i=nums.length-1;i>=0;i--){
            re[i]=re[i]*right;
            right=right*nums[i];
        }

        return re;
    }
}
// Time: O(n) (two passes through the array)
// Space: O(1) (output array does not count as extra space)

// Example 1:
// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]