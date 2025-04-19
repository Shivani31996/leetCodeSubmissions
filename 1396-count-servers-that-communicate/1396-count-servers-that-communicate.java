class Solution {
    int dirs[][] = new int[][]{{0,1}, {-1, 0}, {0,-1}, {1,0}};

    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1)
                {
                    int size = dfs(grid, i, j, m, n);
                    if (size >= 2)
                    {
                        result += size;
                    }
                }
            }
        }

        return result;
    }

    private int dfs(int[][] grid, int i, int j, int m, int n)
    {
        //base
        if(grid[i][j] == 0)
        {
            return 0;
        }

        //logic
        grid[i][j] = 0;
        int count = 1;

        for(int b = 0; b < n; b++)
        {
            count += dfs(grid, i, b, m, n);
        }

        for(int a = 0; a < m; a++)
        {
            count += dfs(grid, a, j, m, n);
        }

        return count;
    }
}