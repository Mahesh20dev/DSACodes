class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BalancedBST {

    // Function to insert nodes in BST
    public Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data)
            root.left = insert(root.left, data);
        else if (data > root.data)
            root.right = insert(root.right, data);
        return root;
    }

    // Function to check if BST is balanced
    public boolean isBalanced(Node root) {
        return checkHeight(root) != -1;
    }

    // Helper function: returns height if balanced, else -1
    private int checkHeight(Node node) {
        if (node == null)
            return 0;

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1)
            return -1;

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Driver code
    public static void main(String[] args) {
        BalancedBST tree = new BalancedBST();
        Node root = null;

        // Creating a sample BST
        root = tree.insert(root, 10);
        root = tree.insert(root, 5);
        root = tree.insert(root, 15);
        root = tree.insert(root, 3);
        root = tree.insert(root, 7);
        root = tree.insert(root, 12);
        root = tree.insert(root, 18);

        if (tree.isBalanced(root))
            System.out.println("The BST is balanced.");
        else
            System.out.println("The BST is NOT balanced.");
    }
}
