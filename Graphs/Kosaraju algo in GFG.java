// Kosaraju algo in GFG
class Solution {
    
   public void topSort(ArrayList<ArrayList<Integer>> adj, int curr, boolean vis[],  Stack<Integer> s) {
       vis[curr] = true;
       
       for(int nbr: adj.get(curr)) {
           if(!vis[nbr]) {
               topSort(adj, nbr, vis, s);
           }
       }
       s.push(curr);
   }
   
   public void dfs(ArrayList<ArrayList<Integer>> transpose, int curr, boolean vis[]) {
       vis[curr] = true;
       
       for(int nbr: transpose.get(curr)) {
           if(!vis[nbr]) {
               dfs(transpose, nbr, vis);
           }
       }
   }
   
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        // step 1
        boolean vis[] = new boolean[V];
        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                topSort(adj, i, vis, s);
            }
        }
        
        // step 2
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for(int i=0; i<V; i++) {
            transpose.add(new ArrayList<>());
            vis[i] = false;
        }
        
        for(int u=0; u<V; u++) {
            for(int v: adj.get(u)) {
                transpose.get(v).add(u);
            }
        }
        
        int count = 0;
        // step 3
        while(!s.isEmpty()) {
            int curr = s.pop();
            if(!vis[curr]) {
                dfs(transpose, curr, vis);
                count++;
            }
        }
        return count;
        
    }
}