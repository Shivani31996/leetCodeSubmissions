class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] path = new int[n][n];
        
        for(int i=n-2; i>=0; i--)
        {
            for(int j=0; j<triangle.get(i).size(); j++)
            {
                int min = triangle.get(i+1).get(j);
                path[i][j] = j;
                if(triangle.get(i+1).get(j) > triangle.get(i+1).get(j+1))
                {
                    min = triangle.get(i+1).get(j+1);
                    path[i][j] = j+1;
                }
                triangle.get(i).set(j,triangle.get(i).get(j) + min);
            }
        }
        System.out.println(Arrays.deepToString(path));
        return triangle.get(0).get(0);
    }
}