class Solution {
    int m,n = 0;
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};  
    
    public int orangesRotting(int[][] grid) {
        
        if(grid == null || grid.length == 0)
            return 0;
        
        int max = 0;
        m = grid.length;
        n = grid[0].length;     
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 2)
                {
                    dfs(grid,i,j,2);
                }
            }
        }
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1)
                    return -1;
                else if(grid[i][j] != 0)
                    max = Math.max(max,grid[i][j] - 2);
            }
        }
        return max;
    }
    
    private void dfs(int[][] grid, int i, int j, int time)
    {
        //base
        
        if(i < 0 || i == m || j < 0 || j == n)
            return;
        if(grid[i][j] != 1 && grid[i][j] < time)
            return;
        
        //logic
        
        grid[i][j] = time;
        for(int[] dir : dirs)
        {
            int nr = dir[0] + i;
            int nc = dir[1] + j;
            
            dfs(grid,nr,nc,time+1);
        }
    }
}