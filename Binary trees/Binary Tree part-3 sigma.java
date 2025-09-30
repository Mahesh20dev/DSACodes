// Binary Tree part-3 sigma
import java.util.*;
import java.util.LinkedList;
public class OnceAgain {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Time = O(n)   space = O(n) - using recursion so
    public static void kLevel(Node root, int level, int k) {
        if(root == null) return;
        if(level == k) {
            System.out.print(root.data + " ");
            return;
        }
        kLevel(root.left, level+1, k);
        kLevel(root.right, level+1, k);
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if(root == null) return false;
        path.add(root);

        if(root.data == n) {
            return true;
        }

        boolean leftFound = getPath(root.left, n, path);
        boolean rightFound = getPath(root.right, n, path);

        if(leftFound || rightFound) {
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }

    // Time = O(3n) = 1-ArrayList, 1-getPath, 1-for loop 
    // space = O(n)
    public static Node lowestCommonAncestor(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;
        for( ; i<path1.size() && i< path2.size(); i++) {
            if(path1.get(i) != path2.get(i)) {
                break;
            }
        }

        Node lca = path1.get(i-1);
        return lca;
    }

    // Both time and space complexity is O(N), but better than above code 
    // space is O(1) but using callStack so space became O(n)
    public static Node lowestCommonAncestor2(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftlca = lowestCommonAncestor2(root.left, n1, n2);
        Node rightlca = lowestCommonAncestor2(root.right, n1, n2);

        if(leftlca == null) {
            return rightlca;
        }
        if(rightlca == null) {
            return leftlca;
        }

        return root;    // if(leftlca != null && rightlca != null)
    }

    // Minimum distance bw 2 Nodes
    public static int lcaDistance(Node root, int n) {
        if(root == null) return -1;
        if(root.data == n) return 0;

        int leftDist = lcaDistance(root.left, n);
        int rightDist = lcaDistance(root.right, n);

        if(leftDist == -1 && rightDist == -1) {
            return -1;
        } else if(leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }
    }
    
    public static int minDisBw2Nodes(Node root, int n1, int n2) {
        Node lca = lowestCommonAncestor2(root, n1, n2);
        int dist1 = lcaDistance(lca, n1);
        int dist2 = lcaDistance(lca, n2);
        return dist1 + dist2;
    }

    public static int kAncestor(Node root, int n, int k) {
        if(root == null) return -1;
        if(root.data == n) return 0;

        int leftDist = kAncestor(root.left, n, k);
        int rightDist = kAncestor(root.right, n, k);

        if(leftDist == -1 && rightDist == -1) {
            return -1;
        }
        int max = Math.max(leftDist, rightDist);

        if(max + 1 == k) {
            System.out.println(root.data);
        }
        return max+1;
    }

    // Transform of sum tree
    public static int transform(Node root) {
        if(root == null) return 0;
        int leftChild = transform(root.left);
        int rightChild = transform(root.right);

        int data = root.data;
        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = newLeft + leftChild + newRight + rightChild;
        return data;
    }

    public static void preOrder(Node root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // kLevel(root, 1, 2);
        // System.out.println(lowestCommonAncestor2(root, 4, 5).data);
        // System.out.println(minDisBw2Nodes(root, 4, 5));
        // kAncestor(root, 4, 2);
        
        transform(root);
        preOrder(root);
    }
}