class Solution {
    public int largestIsland(int[][] grid) {
        if(grid == null || grid.length == 0)
        {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int m = grid.length;
        int n = grid[0].length;
        int color = 2;
        int[][] dirs = new int[][]{{0,1}, {-1,0}, {0,-1}, {1,0}};
        boolean flag = true;

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1)
                {
                    int size = dfs(grid, i, j, m, n, color);
                    map.put(color, size);
                    color++;
                }
            }
        }

        int result = 0;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 0)
                {
                    flag = false;
                    Set<Integer> set = new HashSet<>();
                    for(int dir[] : dirs)
                    {
                        int nr = dir[0] + i;
                        int nc = dir[1] + j;
                        if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] != 0)
                        {
                            set.add(grid[nr][nc]);
                        }
                    }

                    int sum = 1;
                    for(int item: set)
                    {
                        sum += map.get(item);
                    }

                    result = Math.max(result, sum);
                }
            }
        }

        if(flag)
        {
            return map.get(2);
        }

        return result;
    }

    private int dfs(int[][]grid, int i, int j, int m, int n, int color)
    {
        //base
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1)
        {
            return 0;
        }

        //logic
        grid[i][j] = color;

        int right = dfs(grid, i, j+1, m, n, color);
        int down = dfs(grid, i-1, j, m, n, color);
        int left = dfs(grid, i, j-1, m, n, color);
        int up = dfs(grid, i+1, j, m, n, color);

        return right+down+left+up+1;
    }
}