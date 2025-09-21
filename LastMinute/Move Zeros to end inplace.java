import java.util.*;
public class Solution {
    public void moveZeroes(int[] nums) {
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0 ){
                int temp=nums[i];
                nums[i]=nums[k];
                nums[k]=temp;
                k++;
            } 
    }
}
}

// Time: O(n) (single pass through the array)
// Space: O(1) (in-place, no extra array needed)