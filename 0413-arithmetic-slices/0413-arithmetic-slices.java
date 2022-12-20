class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length == 0 || nums == null)
            return 0;
        
        int n = nums.length;
        int count = 0;
        int[] dp = new int[n];
        
        for(int i = 2; i<n; i++)
        {
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2])
            {
                dp[i] = dp[i-1] + 1;
                count += dp[i];
            }
        }
        return count;
    }
}