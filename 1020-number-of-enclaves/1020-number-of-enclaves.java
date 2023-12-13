class Solution {
    public int numEnclaves(int[][] grid) {
        if(grid.length == 0 || grid == null)
            return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(i == 0 || i == (m-1) || j == 0 || j == (n-1))
                {
                    if(grid[i][j] == 1)
                    {
                        q.add(new int[]{i,j});
                        grid[i][j] = -1;
                    }
                }
            }
        }
        
        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            for(int dir[]: dirs) 
            {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
            
                if(nr >= 0 && 
                   nr < m && 
                   nc >= 0 && 
                   nc < n && 
                   grid[nr][nc] == 1 && 
                   grid[nr][nc] != -1)
                    {
                    q.add(new int[]{nr,nc});
                    grid[nr][nc] = -1;
                    }
            }
        }   
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1)
                {
                    count++;
                }
            }
        }
        return count;
    }
}