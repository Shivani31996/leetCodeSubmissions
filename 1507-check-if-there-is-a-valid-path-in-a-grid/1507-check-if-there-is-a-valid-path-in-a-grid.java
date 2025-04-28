class Solution {
    boolean isEnd = false;
    public boolean hasValidPath(int[][] grid) {
        Map<Integer, int[][]> map = new HashMap<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        map.put(1, new int[][]{{0,-1}, {0,1}});
        map.put(2, new int[][]{{-1,0}, {1,0}});
        map.put(3, new int[][]{{0,-1}, {1,0}});
        map.put(4, new int[][]{{0,1}, {1,0}});
        map.put(5, new int[][]{{0,-1}, {-1,0}});
        map.put(6, new int[][]{{-1,0}, {0,1}});

        dfs(grid, 0, 0, m, n, map, visited);

        return isEnd;
    }

    private void dfs(int[][] grid, int i, int j, int m, int n, Map<Integer, int[][]> map, boolean[][] visited)
    {
        //base
        if(i == (m-1) && j == (n-1))
        {
            isEnd = true;
        }

        //logic
        visited[i][j] = true;
        int street = grid[i][j];
        for(int[] path: map.get(street))
        {
            int nr = path[0] + i;
            int nc = path[1] + j;
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc])
            {
                int newStreet = grid[nr][nc];
                for(int[] road: map.get(newStreet))
                {
                    if(nr + road[0] == i && nc + road[1] == j)
                    {
                        dfs(grid, nr, nc, m, n, map, visited);
                    }
                }
            }
        }
    }
}