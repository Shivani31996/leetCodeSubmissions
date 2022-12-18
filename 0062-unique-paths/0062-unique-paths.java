class Solution {
    int memo[][];
    public int uniquePaths(int m, int n) {
        memo = new int[m+1][n+1];
        return helper(0,0,m,n);
    }
    private int helper(int i, int j, int m, int n)
    {
        //base
        if(i == m-1 && j == n-1)
            return 1;
        if(i == m || j == n)
            return 0;
        //logic
        int right = 0;
        if(memo[i][j+1] == 0)
        {
            memo[i][j+1] = helper(i,j+1,m,n);
        }
        right = memo[i][j+1];
        
        int bottom = 0;
        if(memo[i+1][j] == 0)
        {
            memo[i+1][j] = helper(i+1,j,m,n);
        }
        bottom = memo[i+1][j];
        return right + bottom;
    }
}