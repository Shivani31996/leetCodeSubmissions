class Solution {
    public int orangesRotting(int[][] grid) {
        
        if(grid.length == 0 || grid == null)
            return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int dirs[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        int fresh = 0;
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 2)
                {
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1)
                {
                    fresh++;
                }
            }
        }
        
        if(fresh == 0)
            return 0;
        
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                int curr[] = q.poll();
                for(int dir[]: dirs)
                {
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
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
        {
            return -1;
        }
        else
            return time -1;
    }
}