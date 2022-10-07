class Solution {
    
    int dirs[][] = {{0,1},{-1,0}, {1,0},{0,-1}};
    int m, n;
    public int orangesRotting(int[][] grid) {
        if(grid.length == 0 || grid == null)
            return 0;
        
         m = grid.length;
         n = grid[0].length;

        
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 2)
                {
                    dfs(grid,i,j,2);
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < m; i ++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1)
                {
                    return -1;
                }
                else if (grid[i][j] != 0 )
                {
                    max = Math.max(max,grid[i][j] - 2);
                }

            }
        }
        return max;
    }
    
    private void dfs(int[][] grid,int i, int j, int time)
    {
        //base
        if(i < 0 || j < 0 || i == m || j == n)
            return;
        
        if(grid[i][j] != 1 && grid[i][j] < time)
            return;
        
        
        //logic
        grid[i][j] = time;
        for(int[] dir: dirs)
        {
            int nr = i + dir[0];
            int nc = j + dir[1];
            dfs(grid,nr,nc,time + 1);
        }
    }
}