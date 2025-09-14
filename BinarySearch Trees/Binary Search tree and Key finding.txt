// Binary tree and Key finding
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

    // key
    public static boolean search(Node root, int key) {
        if(root == null) {
            return false;
        }
        if(root.data > key) {
            return search(root.left, key);
        }
        else if (root.data == key){
            return true;
        } else {
            return search(root.right, key);
        }
    }

    public static void main(String[] args) {
        int val[] = {5, 1, 3, 4, 2, 7};
        Node root = null;

        for(int i=0; i< val.length; i++) {
            root = insert(root, val[i]);
        }
        inOrder(root);
        System.out.println();

        if(search(root, 1)) {
            System.out.println("Key is found");
        } else {
            System.out.println("Key is not found");
        }
    }
}

Output:

1 2 3 4 5 7 
Key is found