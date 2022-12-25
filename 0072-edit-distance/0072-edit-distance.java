class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.equals(word2))
            return 0;
        
        int n = word1.length();
        int m = word2.length();
        int dp[] = new int[n+1];
        
        for(int j=0; j<=n; j++)
        {
            dp[j] = j;
        }
        
        for(int i=1; i<=m; i++)
        {
            int diagUp = dp[0];
            dp[0] = i;
            for(int j=1; j<=n; j++)
            {
                int temp = dp[j];
                if(word1.charAt(j-1) == word2.charAt(i-1))
                {
                    dp[j] = diagUp;
                }
                else
                {
                    dp[j] = 1 + Math.min(diagUp,Math.min(dp[j-1],dp[j]));
                }
                diagUp = temp;
            }
        }
        return dp[n];
    }
}