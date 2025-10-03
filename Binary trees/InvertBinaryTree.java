/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
       TreeNode curr=root;
        if(curr==null){
            return null;
        }
        invertTree(curr.left);
        invertTree(curr.right);
        TreeNode temp=curr.left;
        curr.left=curr.right;
         curr.right=temp;  
         return curr;
    }
}
   
