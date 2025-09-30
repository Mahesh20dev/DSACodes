// Binary Seach Tree (part-1)
import java.util.*;
public class DSA {
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

    public static Node insert(Node root, int val) {
        if(root == null) {
            return root = new Node(val);
            // return root;
        }
        if(root.data > val) {
            // left subtree
            root.left = insert(root.left, val);
        } else {
            // right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inOrder(Node root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // search in BST , Time = O(Height)
    public static boolean search(Node root, int key) {
        if(root == null) return false;

        if(root.data == key) {
            return true;
        } else if(root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    // Delete the Node 
    public static Node delete(Node root, int val) {
        if(root == null) return null;
        // search
        if(root.data > val) {
            root.left = delete(root.left, val);
        }else if(root.data < val) {
            root.right = delete(root.right, val);
        } else {
            // case 1 leaf node
            if(root.left == null && root.right == null) {
                return null;
            }
            // case 2 = node has only one child
            if(root.left == null) {
                return root.right;
            } else if(root.right == null){
                return root.left;
            }
            // case 3 - Node has both the children
            Node IS = findInorderSuccesor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInorderSuccesor(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Print In Range
    public static void printInRange(Node root, int k1, int k2) {
        if(root == null) return;
        if(root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if(root.data <k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    // Root to Leaf Path
    public static void printPath(ArrayList<Integer> path) {
        for(int i=0; i<path.size(); i++) {
            System.out.print(path.get(i) + " -> ");
        }
        System.out.println("Null");
    }
    public static void rootToLeafPath(Node root, ArrayList<Integer> path) {
        if(root == null) return;
        path.add(root.data);

        if(root.left == null && root.right == null) {
            printPath(path);
        }

        rootToLeafPath(root.left, path);
        rootToLeafPath(root.right, path);
        path.remove(path.size()-1);
    }

    // isValid
    public static boolean isValid(Node root, Node min, Node max) {
        if(root == null) return true;

        if(min != null && root.data <= min.data) {
            return false;
        } else if(max != null && root.data >= max.data) {
            return false;
        }

        // then check for subtrees
        return isValid(root.left, min, root) && isValid(root.right, root, max);
    }

    // Mirror Image in BST
    public static Node createMirror(Node root) {
        if(root == null) return null;
        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;
        return root;
    }
    public static void main(String[] args) {
        int values[] = {8, 5, 3, 6, 10, 11, 14};
        Node root = null;

        for(int i=0; i<values.length; i++) {
            root = insert(root, values[i]);
        }

        // inOrder(root);
        // System.out.println();

        // delete(root, 6);
        // inOrder(root);
        // printInRange(root, 4, 6);
        // rootToLeafPath(root, new ArrayList<>());
        // System.out.println(isValid(root, null, null));
        root = createMirror(root);
        inOrder(root);
    }
}