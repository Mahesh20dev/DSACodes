Binary Tree part-2
import java.util.*;

public class Practice {
    public static class Node {
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
            root = new Node(val);
            return root;
        }
        if(root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }


    // delete Node
    public static Node delete(Node root, int val) {
        if(root.data > val) {
            root.left = delete(root.left, val);
        } else if(root.data < val) {
            root.right = delete(root.right, val);
        } else {
            // root.data == val
            // case 1
            if(root.left == null && root.right == null) {
                return null;
            }
            // case 2
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }
            //case 3
            Node Is = inOrderSuccesor(root.right);
            root.data = Is.data;
            root.right = delete(root.right, Is.data);
        }
        return root;
    }

    public static Node inOrderSuccesor(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;

    }

    // print In Range
    public static void printInRange(Node root, int x, int y){
        if(root == null) {
            return;
        }
        if(x <= root.data && root.data <= y) {
            printInRange(root.left, x, y);
            System.out.print(root.data + " ");
            printInRange(root.right, x, y);
        }
        else if(x >= root.data) {
            printInRange(root.right, x, y);
        }
        // y <= root.data
        else {
            printInRange(root.left, x, y);
        }
    }

    // printPath
    public static void printPath(ArrayList<Integer> path) {
        for(int i=0; i<path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

    // printRoot2Leaf
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if(root == null) {
            return;
        }
        path.add(root.data);

        //leaf
        if(root.left == null && root.right == null) {
            printPath(path);
        } // not leaf
        else {
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
        }
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        int val[] = {5, 1, 3, 4, 2, 7};
        Node root = null;

        for(int i=0; i< val.length; i++) {
            root = insert(root, val[i]);
        }
        inOrder(root);
        System.out.println();



        delete(root, 2);
        inOrder(root);

        printRoot2Leaf(root, new ArrayList<>());

    }
}

Output:
delete node -- 
1 2 3 4 5 7 
1 3 4 5 7 


printInRange :
1 2 3 4 5 7 
3 4 5 

printPath :
1 2 3 4 5 7 
5 1 3 2 
5 1 3 4 
5 7 
