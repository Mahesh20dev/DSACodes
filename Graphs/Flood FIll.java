class Solution {

    public void helper(int[][] image, int sr, int sc, int color,boolean[][] vis,int originalcolor) {
        if(sr<0||sc<0||sr>=image.length||sc>=image[0].length||image[sr][sc]!=originalcolor||vis[sr][sc]){
            return;
        }
        vis[sr][sc] = true;
        image[sr][sc] = color;
        //LEFT
        helper(image,sr,sc-1,color,vis,originalcolor);
        //right
        helper(image,sr,sc+1,color,vis,originalcolor);
        //up
        helper(image,sr-1,sc,color,vis,originalcolor);
        //down
        helper(image,sr+1,sc,color,vis,originalcolor);
      
    }
    // TC-> O(m*n)
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {   
        boolean[][] visited=new boolean[image.length][image[0].length];
        helper(image,sr,sc,color,visited,image[sr][sc]);
        return image;
    }
}


// Get the original color at the starting pixel image[sr][sc].

// If originalColor == newColor, return the image (no change needed).

// Create a 2D boolean array visited to keep track of pixels already filled.

// Define a recursive helper function:

// Base Case: Return if out of bounds, already visited, or color doesn't match originalColor.

// Mark pixel visited

// Change pixel color to newColor

// Call helper recursively in 4 directions: up, down, left, right.

// Call the helper function from (sr, sc).

// Return the modified image.

