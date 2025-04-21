class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dirs = new int[][]{{0,1}, {-1,0}, {0,-1}, {1,0}};
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                boolean[][] visited = new boolean[m][n];
                boolean[] reach = new boolean[2];
                dfs(heights, i, j, m, n, visited, dirs, heights[i][j], reach);
                if(reach[0] && reach[1])
                {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        
        return result;
    }

    private void dfs(int[][] heights, int i, int j, int m, int n, boolean[][] visited, int[][] dirs, int prevHeight, boolean[] reach)
    {
        //base
        if( i < 0 || j < 0)
        {
            reach[0] = true;
            return;
        }

        if(i >= m || j >= n)
        {
            reach[1] = true;
            return;
        }

        if(visited[i][j] || heights[i][j] > prevHeight)
        {
            return;
        }

        //logic
        visited[i][j] = true;
        for(int[] dir: dirs)
        {
            int nr = dir[0] + i;
            int nc = dir[1] + j;

            dfs(heights, nr, nc, m, n, visited, dirs, heights[i][j], reach);
        }
    }
}