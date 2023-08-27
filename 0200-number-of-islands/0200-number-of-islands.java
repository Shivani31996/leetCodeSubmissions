class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int count = 0;
        
        for(int i = 0; i < m; i++)
        {
            for(int j  = 0; j < n; j++)
            {
                if(grid[i][j] == '1')
                {
                    count++;
                    dfs(grid,i,j,m,n,dirs);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j, int m, int n, int[][] dirs)
    {
        //base
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0')
            return;
        //logic
        for(int[] dir: dirs)
        {
            grid[i][j] = '0';
            int nr = dir[0] + i;
            int nc = dir[1] + j;
            dfs(grid,nr,nc,m,n,dirs);
        }
    }
}