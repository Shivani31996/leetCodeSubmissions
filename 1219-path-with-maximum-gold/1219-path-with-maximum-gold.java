class Solution {
    int m;
    int n;
    int[][] dirs;
    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int max = 0;
        
        dirs = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] > 0)
                {
                    max = Math.max(dfs(grid,i,j,dirs),max);
                }
            }
        }
        return max;
    }
    
    private int dfs(int[][] grid,int i, int j,int[][] dirs)
    {
        //base
        if(i >= m || j >= n || i < 0 || j < 0 || 
          grid[i][j] == 0)
        {
            return 0;
        }
        
        //logic
        int gold = grid[i][j];
        grid[i][j] = 0;
        
        int maxGold = 0;
        
        for(int[] dir: dirs)
        {
            int nr = dir[0] + i;
            int nc = dir[1] + j;
            maxGold = Math.max(maxGold,dfs(grid,nr, nc, dirs));
        }
        
        grid[i][j] = gold;
        
        return gold+maxGold;
    }
}
