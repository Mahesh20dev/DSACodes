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
    HashMap<Integer,Integer> inordermap=new HashMap<>();
    int preordercount=0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0;i<inorder.length;i++){
            inordermap.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1);
    }
    
    public TreeNode helper(int[]preorder,int left,int right){
        if(left>right){
            return null;
        }
        int rootnum=preorder[preordercount];
        preordercount++;
        TreeNode root=new TreeNode(rootnum);
        root.left=helper(preorder,left,inordermap.get(rootnum)-1);
        root.right=helper(preorder,inordermap.get(rootnum)+1,right);
        return root;
    }
}