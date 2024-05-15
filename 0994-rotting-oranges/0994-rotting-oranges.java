class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
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
                int[] curr = q.poll();
                for(int [] dir: dirs)
                {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1)
                    {
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr,nc});
                        fresh--;
                    }
                }
            }
            time++;
        }
        
        if(fresh == 0)
        {
            return time - 1;
        }
        return -1;
    }
}