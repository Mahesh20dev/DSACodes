/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
     public String serialize(TreeNode root) {
        if (root == null) return "";

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        sb.append(root.val);

        while (!q.isEmpty()) {
            TreeNode node = q.remove();

            if (node.left != null) {
                q.add(node.left);
                sb.append(",").append(node.left.val);
            } else {
                sb.append(",null");
            }

            if (node.right != null) {
                q.add(node.right);
                sb.append(",").append(node.right.val);
            } else {
                sb.append(",null");
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;

        while (!q.isEmpty() && i < nodes.length) {
            TreeNode current = q.remove();

            if (!nodes[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(nodes[i]));
                q.add(current.left);
            }
            i++;

            if (i < nodes.length && !nodes[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(nodes[i]));
                q.add(current.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));