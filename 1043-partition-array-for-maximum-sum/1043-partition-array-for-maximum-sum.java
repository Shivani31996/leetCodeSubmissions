class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        int max = 0;
        
        for(int i = 0; i < n; i++)
        {
            max = arr[i];
            for(int j = 1;j <= k && i-j + 1 >= 0;j++)
            {
                max = Math.max(max,arr[i - j + 1]);
                int sum = 0;
                if(i - j >= 0)
                {
                    sum = j*max + dp[i - j];
                }
                else
                {
                    sum = j*max;
                }
                dp[i] = Math.max(dp[i],sum);
            }
        }
        return dp[n - 1];
    }
}