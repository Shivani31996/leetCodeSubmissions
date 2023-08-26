class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dirs[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int []> q= new LinkedList<>();
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(matrix[i][j] == 0)
                {
                    q.add(new int[]{i,j});
                }
                else if(matrix[i][j] == 1)
                {
                    matrix[i][j] = -1;
                }
            }
        }
        
        int distance = 0;
        
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
                    if(nr >= 0 && nc >= 0 && nr < m && nc < n && matrix[nr][nc] == -1)
                    {
                    matrix[nr][nc] = distance + 1;
                    q.add(new int[] {nr,nc});
                    }

                }
            }
            distance++;
        }
        
        return matrix;
    }
}