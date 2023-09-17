class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        if(maze.length == 0 || maze == null)
        {
            return -1;
        }
        
        int m = maze.length;
        int n = maze[0].length;
        int dirs[][] = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        int time = 0;
        Queue<int []> q = new LinkedList<>();
        
        q.add(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                int[] curr = q.poll();
                for(int[] dir: dirs)
                {
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
                    if(nr >=0 && nc >= 0 && nr < m && nc < n && maze[nr][nc] == '.')
                    {
                        if(nr == 0 ||
                          nr == m - 1 ||
                          nc == 0 ||
                          nc == n-1)
                        {
                            return time + 1;
                        }
                        q.add(new int[]{nr,nc});
                        maze[nr][nc] = '+';
                    }
                    
                }
            }
            time++;
        }
        
        return -1;
    }
}