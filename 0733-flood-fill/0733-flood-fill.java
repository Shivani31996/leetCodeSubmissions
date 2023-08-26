class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color)
            return image;
        int m = image.length;
        int n = image[0].length;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        int o_color = image[sr][sc];
        dfs(image,sr,sc,color,o_color,dirs,m,n);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int color, int o_color, int[][]dirs,int m, int n)
    {
        //base
        if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != o_color)
            return;
        
        //logic
        image[sr][sc] = color;
        for(int[] dir: dirs)
        {
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image,nr,nc,color,o_color,dirs,m,n);
        }
    }
}