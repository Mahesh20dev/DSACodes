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
import java.util.*;
class Solution {
    public void inorder(TreeNode root,List<Integer> re){
        if(root==null){
            return ;
        }
        inorder(root.left,re);
        re.add(root.val);
        inorder(root.right,re);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> re=new ArrayList<>();
        if(root==null){
            return re;
        }
        // re.addAll(inorderTraversal(root.left));
        // re.add(root.val);
        // re.addAll(inorderTraversal(root.right));
        inorder(root,re);
        return re;
    }
}