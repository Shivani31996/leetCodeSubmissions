class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
        
        q.add(start);
        maze[start[0]][start[1]] = 2;
        
        while(!q.isEmpty())
        {
            int curr[] = q.poll();
            for(int[] dir:dirs)
            {
                int i = curr[0];
                int j = curr[1];
            
                while(i >= 0 && j>=0 && i < m && j < n && maze[i][j] != 1)
                {
                    i = i + dir[0];
                    j = j + dir[1];
                }
                i = i - dir[0];
                j = j - dir[1];
                
                if(maze[i][j] != 2)
                {
                    if(i == destination[0] && j == destination[1])
                    {
                        return true;
                    }
                    q.add(new int[]{i,j});
                    maze[i][j] = 2;
                }
            }
        }
        return false;
    }
}