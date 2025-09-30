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
    public List<List<Integer>> levelOrder(TreeNode root) {
      if(root==null){
          return new ArrayList<>();
      }
        List<List<Integer>> result=new ArrayList<>();
        
        Queue<TreeNode> que=new LinkedList<>();
        
        que.add(root);
        que.add(null);
        while(!que.isEmpty()){
            int size=que.size();
            List<Integer> nested=new ArrayList();
            
            for(int i=0;i<size;i++){
               TreeNode curr=que.remove(); 
               if(curr==null){

                if(que.isEmpty()){
                    break;
                }else{
                    que.add(curr);
                }

               }else{

                nested.add(curr.val);
                
                if(curr.left!=null){
                que.add(curr.left);
                }

                if(curr.right!=null){
                que.add(curr.right);
                }

               }
                
            }
            
            result.add(nested);
            
        }
        return result;
    }
}