class Solution {
    public void solve(char[][] board) {

        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean visited[][] = new boolean[m][n];
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if((i == 0 || j == 0 || i == (m - 1) || j == (n -1)) && board[i][j] == 'O')
                {
                    q.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        
        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            
            for(int[] dir: dirs)
            {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == 'O' && visited[nr][nc] != true)
                {
                    q.add(new int[]{nr,nc});
                    visited[nr][nc] = true;
                }
            }
        }
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] == 'O' && visited[i][j] != true)
                {
                    board[i][j] = 'X';
                }
            }
        }
    }
}