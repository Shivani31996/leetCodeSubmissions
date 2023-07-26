class Solution {
    int m,n;
    int dirs[][] = {{0,1},{0,-1},{1,0},{-1,0}};
    Queue<int[]> q;
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        m = grid.length;
        n = grid[0].length;
        q = new LinkedList<>();
            
        int fresh = 0;
        for(int i = 0;i < m; i++)
        {
            for(int j = 0;j < n;j++)
            {
                if(grid[i][j] == 1)
                {
                    fresh++;
                }
                else if(grid[i][j] == 2)
                {
                    q.add(new int[]{i,j});
                }
            }
        }
        
        if(fresh == 0)
        {
            return 0;
        }
        
        int time = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i<size;i++)
            {
                int curr[] = q.poll();
                
                for(int dir[]:dirs)
                {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    
                    if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1)
                    {
                        grid[nr][nc] = 2;
                        fresh--;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            time++;
        }
        
        if(fresh != 0)
            return -1;
        return time - 1;
            
    }
}