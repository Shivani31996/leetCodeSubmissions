class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int count = 0;
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        
        for(int i = 0; i < m; i++)
        {
            for(int j  = 0; j < n; j++)
            {
                if(grid[i][j] == '1')
                {
                    count++;
                    rq.add(i);
                    cq.add(j);
                    grid[i][j] = '0';
                    while(!rq.isEmpty() && !cq.isEmpty())
                    {
                        int curr_r = rq.poll();
                        int curr_c = cq.poll();
                        
                        for(int[] dir: dirs)
                        {
                            int nr = curr_r + dir[0];
                            int nc = curr_c + dir[1];
                            if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1')
                            {
                                rq.add(nr);
                                cq.add(nc);
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}