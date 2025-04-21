class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dirs = new int[][]{{0,1}, {-1,0}, {0,-1}, {1,0}};
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int i = 0; i < m; i++)
        {
            dfs(heights, i, 0, m, n, pacific, dirs, heights[i][0]); // pacific
            dfs(heights, i, n-1, m, n, atlantic, dirs, heights[i][n-1]); //atlantic
        }

        for(int j = 0; j < n; j++)
        {
            dfs(heights, 0, j, m, n, pacific, dirs, heights[0][j]); // pacific
            dfs(heights, m-1, j, m, n, atlantic, dirs, heights[m-1][j]); //atlantic
        }

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(pacific[i][j] == true && atlantic[i][j] == true)
                {
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        
        return result;
    }

    private void dfs(int[][] heights, int i, int j, int m, int n, boolean[][] visited, int[][] dirs, int prevHeight)
    {
        //base
        if(i < 0 || j < 0 || i >= m || j >= n)
        {
            return;
        }

        if(prevHeight > heights[i][j])
        {
            return;
        }

        if(visited[i][j])
        {
            return;
        }

        //logic
        visited[i][j] = true;
        for(int dir[]: dirs)
        {
            int nr = dir[0] + i;
            int nc = dir[1] + j;
            dfs(heights, nr, nc, m, n, visited, dirs, heights[i][j]);
        }
    }
}