// Top and Bottom view of a tree(sigma)
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
                if(!map.containsKey(curr.hd)) { // For Bottom view dont check just check delete this line 
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
