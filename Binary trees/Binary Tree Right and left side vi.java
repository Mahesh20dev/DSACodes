// Binary Tree Right and left side view - recursive solution
class Solution {
    public void rightView(TreeNode curr, ArrayList<Integer> res, int currDepth) {
        if(curr == null) {
            return;
        }

        if(currDepth == res.size()) {
            res.add(curr.val);
        }
        rightView(curr.right, res, currDepth+1);
        rightView(curr.left, res, currDepth+1);

	// FOR LEFT SIDE VIEW
	rightView(curr.left, res, currDepth+1);
	rightView(curr.right, res, currDepth+1);

    }

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        rightView(root, res, 0);
        return res;
    }
}