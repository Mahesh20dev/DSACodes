class Solution {
    //similar to flood fill
    public void dfs(int i,int j,char[][] grid,boolean[][] vis){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||vis[i][j] || grid[i][j]=='0'){
            return;
        }
        vis[i][j]=true;
        dfs(i+1,j,grid,vis);
        dfs(i-1,j,grid,vis);
        dfs(i,j+1,grid,vis);
        dfs(i,j-1,grid,vis);

    }
    public int numIslands(char[][] grid) {
       int m=grid.length;
        int n=grid[0].length;
        int count=0;
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    dfs(i,j,grid,vis);
                    count++;
                }
            }
        }
        return count;
    }
}