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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       if(root==null){
           return new ArrayList<>();
       } 
         List<List<Integer>> result=new ArrayList<>();
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);
        boolean leftToRight=true;
        
        while(!que.isEmpty()){
            int level=que.size();
            List<Integer> nested=new LinkedList<>();
            
            
            for(int i=0;i<level;i++){
                TreeNode curr=que.remove();
            
                if(curr.left!=null){
                que.add(curr.left);
                }
                
                if(curr.right!=null){
                    que.add(curr.right);
                }
                
                if(leftToRight){
                    nested.add(curr.val);
                }else{
                    nested.add(0,curr.val);
                }   
            }
            result.add(nested);  
            leftToRight=!leftToRight;
            
        }
        return result;
    }
}