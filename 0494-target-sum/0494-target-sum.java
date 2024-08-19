class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums,target,0,0);  
    }
    
    private int dfs(int[] nums, int target, int index,int currSum)
    {
        //base
        if(index == nums.length)
        {
            if(currSum == target)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        
        //logic
        int left = dfs(nums,target,index+1,currSum+nums[index]);
        int right = dfs(nums,target,index+1,currSum-nums[index]);
        return left+right;
    }
}