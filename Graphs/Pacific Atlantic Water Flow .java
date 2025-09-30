class Solution {
    public void dfs(int i,int j,int[][] heights,boolean[][] vis,int prevheight){
        if(i<0||j<0||i>=heights.length||j>=heights[0].length||vis[i][j]||heights[i][j]<prevheight){
            return;
        }
        vis[i][j]=true;
        dfs(i + 1, j, heights, vis, heights[i][j]); // down
        dfs(i - 1, j, heights, vis, heights[i][j]); // up
        dfs(i, j + 1, heights, vis, heights[i][j]); // right
        dfs(i, j - 1, heights, vis, heights[i][j]); // left
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;    
        int n = heights[0].length; 
        List<List<Integer>> re=new ArrayList<>();
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++){
            dfs(i, 0, heights, pacific, heights[i][0]); // Left column
            dfs(i,n-1,heights,atlantic,heights[i][n-1]);//right column
        }

        for (int j = 0; j < n; j++){
            dfs(0, j, heights, pacific, heights[0][j]); // Top row
            dfs(m-1, j, heights, atlantic, heights[m-1][j]); //bottom row
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    re.add(Arrays.asList(i,j));
                }
            }
        }

        return re;
    }
}


// Instead of starting from every cell and checking whether water can reach both oceans,
// we reverse the problem:

// Start DFS from the Pacific border → mark all cells that can reach the Pacific.

// Start DFS from the Atlantic border → mark all cells that can reach the Atlantic.

// The intersection of both → cells that can reach both oceans.