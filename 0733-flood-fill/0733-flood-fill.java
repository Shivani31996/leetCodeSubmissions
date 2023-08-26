class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color)
            return image;
        int m = image.length;
        int n = image[0].length;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        int o_color = image[sr][sc];
        Queue<Integer> q = new LinkedList<>();
        q.add(sr);
        q.add(sc);
        image[sr][sc] = color;
        while(!q.isEmpty())
        {
            int cr = q.poll();
            int cc = q.poll();
            
            for(int[] dir: dirs)
            {
                int nr = cr + dir[0];
                int nc = cc + dir[1];
            
                if(nr >=0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == o_color)
                {
                    image[nr][nc] = color;
                    q.add(nr);
                    q.add(nc);
                }
            }
        }
        return image;
    }
}