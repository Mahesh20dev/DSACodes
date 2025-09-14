// Binary Tree part 2 (sigma)
import java.util.*;
import java.util.LinkedList;
public class Main {
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

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static int sumofNodes(Node root) {
        if(root == null) {
            return 0;
        }
        int ls = sumofNodes(root.left);
        int rs = sumofNodes(root.right);
        return ls + rs + root.data;
    }

    // Time = O(n^2)
    public static int diameter(Node root) {
        if(root == null) {
            return 0;
        }
        int ld = diameter(root.left);
        int lh = height(root.left);
        int rd = diameter(root.right);
        int rh = height(root.right);

        int selfDia = lh + rh + 1; //root is included

        return Math.max(selfDia, Math.max(ld, rd));

    }

    // Time = O(n) optimization of diameter code
    static class Info {
        int diam;
        int ht; 
        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diameter2(Node root) {
        if(root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int dia = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(dia, ht);
    }

    // Subtree of another tree Node
    public static boolean isIdentical(Node node, Node subRoot) {
        if(node == null && subRoot == null) {
            return true;
        }else if(node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        if(!isIdentical(node.left, subRoot.left)) {
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)) {
            return false;
        }
        return true;
    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if(root == null) {
            return false;
        }

        if(root.data == subRoot.data) {
            if(isIdentical(root, subRoot)) {
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Top view of a tree
    static class Info2 {
        Node node;
        int hd;
        public Info2(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        Queue<Info2> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min=0, max=0;
        q.add(new Info2(root, 0));
        q.add(null);

        while(!q.isEmpty()) {
            Info2 curr = q.remove();
            if(curr == null) {
                if(q.isEmpty()) {
                    break;
                }else {
                    q.add(null);
                }
            }else {
                if(!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }
                if(curr.node.left != null) {
                    q.add(new Info2(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if(curr.node.right != null) {
                    q.add(new Info2(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }
        for(int i=min; i<=max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println(); 
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(6);

        // System.out.println(diameter2(root).diam);
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
        /*
         *      2
         *    /   \
         *   4     5
         */
    //     System.out.println(isSubtree(root, subRoot));
    topView(root);
    }
}
