class Solution {
    int [][] dirs;
    public int numIslands(char[][] grid) {
        
        if(grid.length == 0 || grid == null)
        {
            return 0;
        }
        
        dirs = new int[][] {{0,1},{-1,0},{0,-1},{1,0}};
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        Queue<Integer> qr = new LinkedList<>();
        Queue<Integer> qc = new LinkedList<>();
        
        for(int i = 0; i<m;i++)
        {
            for(int j = 0; j<n;j++)
            {
                if(grid[i][j] == '1')
                {
                    count++;
                    qr.add(i);
                    qc.add(j);
                    grid[i][j] = '0';
                    while(!qr.isEmpty()){
                        int cr = qr.poll();
                        int cc = qc.poll();
                        
                        for(int dir[]: dirs)
                        {
                            int nr = cr + dir[0];
                            int nc = cc + dir[1];
                            
                            if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1')
                            {
                                qr.add(nr);
                                qc.add(nc);
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