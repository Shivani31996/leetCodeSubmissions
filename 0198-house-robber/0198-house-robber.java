class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        
       return helper(nums,nums.length - 1,dp);
    }
    
    private int helper(int[] nums,int index,int[] dp)
    {
        //base
        if(index == 0)
            return nums[index];
        if(index < 0)
            return 0;
        if(dp[index] != -1)
            return dp[index];
        
        //logic
        int pick = nums[index] + helper(nums,index - 2,dp);
        int not_pick = helper(nums,index - 1,dp);
        System.out.println(pick+"   " +not_pick);
        return dp[index] = Math.max(pick,not_pick);
        
    }
}